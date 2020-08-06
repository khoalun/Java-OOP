package sample;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/*
 * Application for handling orders. Features:
 * Read products and prices from specific file
 * Create new order and add order lines to it
 * Show selected order
 * Remove selected order
 * Save orders to file
 * Read orders from file
 */
public class Main extends Application {

    private final ComboBox<String> productCmb = new ComboBox<>();
    //private final ArrayList<Orderline3>products = new ArrayList();
    private final HashMap<String, Double> products = new HashMap<>();
    private final TextField textField1 = new TextField();
    private final TextField textField2 = new TextField();
    private final TextField textField3 = new TextField();
    private final TextArea textArea = new TextArea();
    private final ComboBox<Integer> orderidCmb = new ComboBox<>();
    private final FileChooser fileChooser = new FileChooser();


    //private File currentFile = null;
    private final String productfile = "sample/products.txt";

    private ArrayList<Orderline3>order = new ArrayList<>();

    private Orderline3 current;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            readProducts();
        } catch(Exception ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Problems with the file");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            return;
        }

        BorderPane mainpanel = new BorderPane();

        //Controls for creating new order
        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10); //Horizontal space between columns
        grid1.setVgap(10); //Vertical space between rows
        grid1.setPadding(new Insets(25, 25, 25, 25));
        // Text control for instructions
        Text instrText = new Text("Give OrderID and Customer and create new order");
        // In column 0, row 0, column span 2 and row span 1
        grid1.add(instrText, 0, 0, 2, 1);

        // Label in column 0, row 1
        Label label1 = new Label("OrderID:");
        grid1.add(label1, 0, 1);
        // TextField in column 1, row 1
        grid1.add(textField1, 1, 1);

        Label label2 = new Label("Customer:");
        grid1.add(label2, 0, 2);
        grid1.add(textField2, 1, 2);

        Button createBtn = new Button("Create order");
        grid1.add(createBtn, 1, 3);

        //Controls for adding new orderline to order
        Text instrText2 = new Text("Choose product, give quantity and add to order");
        // In column 0, row 0, column span 2 and row span 1
        grid1.add(instrText2, 0, 4, 2, 1);

        // Label in column 0, row 1
        Label label3 = new Label("Product:");
        grid1.add(label3, 0, 5);
        // ComboBox in column 1, row 1
        grid1.add(productCmb, 1, 5);

        Label label4 = new Label("Quantity:");
        grid1.add(label4, 0, 6);
        grid1.add(textField3, 1, 6);

        Button addBtn = new Button("Add");
        grid1.add(addBtn, 1, 7);

        //Controls to choose and remove order
        Text instrText3 = new Text("Choose order to view it. You can also remove selected order.");
        grid1.add(instrText3, 0, 8, 2, 1);
        Label label5 = new Label("Show order:");
        grid1.add(label5, 0, 9);
        grid1.add(orderidCmb, 1, 9);

        Button removeBtn = new Button("Remove order");
        grid1.add(removeBtn, 1, 10);

        //Grid1 left on borderpane
        mainpanel.setLeft(grid1);

        //TextArea center of borderpane
        textArea.setEditable(false);
        textArea.setFont(Font.font("Courier New", FontWeight.NORMAL, 12));
        mainpanel.setCenter(textArea);

        //Create menubar and File menu
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        menuBar.getMenus().add(menuFile);

        MenuItem startNew = new MenuItem("New");
        MenuItem open = new MenuItem("Open");
        MenuItem saveAs = new MenuItem("Save As");
        MenuItem exit = new MenuItem("Exit");
        menuFile.getItems().addAll(startNew, open, saveAs, new SeparatorMenuItem(),  exit);
        mainpanel.setTop(menuBar);


        Scene scene = new Scene(mainpanel, 800, 500);

        primaryStage.setTitle("Orders");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Event handlers
        createBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                createNewOrder(e);
            }


        });

        addBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                addOrderLine(e);
            }
        });

        orderidCmb.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                showOrder(/*e*/);
            }
        });

        removeBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                removeOrder(e);
            }
        });

        saveAs.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                File file = fileChooser.showSaveDialog(primaryStage);
                if (file != null) {
                    //currentFile= file;
                    saveOrdersToFile(file);
                }

            }
        });

        open.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    //currentFile = file;
                    readOrdersFromFile(file);
                }

            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                //System.exit(0);
                Platform.exit();
            }
        });

        startNew.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                //TODO
                textArea.setText(null);
                //currentFile = null;
                //statusLabel.setText(null);
                textField1.setText(null);
                textField2.setText(null);
                textField3.setText(null);
                orderidCmb.getItems().clear();
               //clearControls();
            }
        });

    } //End of method start


    //Reads products and prices from text file
    public void readProducts() throws Exception{
        ClassLoader cl = this.getClass().getClassLoader();
        URL url = cl.getResource(productfile);

        try(InputStream in = url.openStream(); BufferedReader input = new BufferedReader(new InputStreamReader(in))){
            String line;
            while((line = input.readLine()) != null) {
                double price = new Double(input.readLine());
                products.put(line,  price);
            }
            List<String> names = products.keySet().stream().sorted().collect(Collectors.toList());
            productCmb.setItems(FXCollections.observableArrayList(names));
        }
    }

    //Creates new order and adds it to collection. Variable current order refers to
    //new order.
    private void createNewOrder(ActionEvent e) {
        //TODO
        int orderID = Integer.parseInt(textField1.getText());
        String customerName = textField2.getText();

         current = new Orderline3(orderID,customerName, new date());
         textArea.setText(current.toString());
         order.add(current);

         orderidCmb.getItems().add(orderID);
    }

    //Adds new orderline to current order.
    private void addOrderLine(ActionEvent e) {
        //TODO
        String productName = productCmb.getValue();
        double price = products.get(productCmb.getValue());
        int quantity =  Integer.parseInt(textField3.getText());
        Orderline o = new Orderline(productName, price, quantity);
        /*o.setName(productCmb.getValue());
        o.setPrice(products.get(productCmb.getValue()));
        o.setQuantity(Integer.parseInt(textField3.getText()));*/
        current.addNewOrderline(o);
        textArea.setText(current.toString());

    }

    //Shows selected order
    private void showOrder(/*ActionEvent e*/) {
        //TODO
        if(orderidCmb.getSelectionModel().getSelectedIndex() != -1 ) {
            int id = orderidCmb.getSelectionModel().getSelectedIndex();
            current = order.get(id);
            textArea.setText(current.toString());
        }
    }

    //Removes selected order from collection
    private void removeOrder(ActionEvent e) {
        //TODO
        if(orderidCmb.getSelectionModel().getSelectedIndex() != -1 ){
            int id = orderidCmb.getSelectionModel().getSelectedIndex();
            current = order.remove(id);
            orderidCmb.getItems().remove(id);
            textArea.setText(null);
        }
    }


    //Writes orders to file
    private void saveOrdersToFile(File file) {
        System.out.println(file.getAbsolutePath());
        //TODO
       // currentFile =file;
        try (ObjectOutputStream file_out
                     = new ObjectOutputStream(new FileOutputStream(file))){

            file_out.writeObject(order);

        }
        catch(Exception e) {
            System.out.println("Problems with " + file);
            e.printStackTrace();
        }

    }

    //Reads orders from file
    @SuppressWarnings("unchecked")
    private void readOrdersFromFile(File file) {
        //TODO

        try (ObjectInputStream file_in
                     = new ObjectInputStream(new FileInputStream(file))){
            order= (ArrayList<Orderline3>)file_in.readObject();
        }
        catch(Exception e) {
                System.out.println("Problems with " + file);
            e.printStackTrace();
        }
        for(Orderline3 or : order){
            orderidCmb.getItems().add(or.Id);
        }
        //orderidCmb.setValue(order.get(0).Id);
        showOrder();
    }



    //Clears GUI controls
    private void clearControls() {
        textField1.setText(null);
        textField2.setText(null);
        textField3.setText(null);
        textArea.setText(null);
        productCmb.getSelectionModel().clearSelection();
        orderidCmb.getSelectionModel().clearSelection();
    }

    public static void main(String[] args) {
        launch(args);

    }

}
