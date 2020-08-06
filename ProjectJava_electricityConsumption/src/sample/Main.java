package sample;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import static javafx.collections.FXCollections.*;

/*
 * Application for calculating electricity consumption of different devices. Features:
 * Read devices and consumption from specific file
 * Create new user infomation and add time length and its consumption of devices to it
 * Show entered date
 * Save consumption to .dat file
 * Read consumption from .dat file
 */
public class Main extends Application {

    private final ComboBox<String> devicesCmb = new ComboBox<>();
    private final HashMap<String, Double> devices = new HashMap<>();
    private final TextField textField1 = new TextField();
    private final TextField textField2 = new TextField();
    private final TextField textField3 = new TextField();
    private final TextField textField4 = new TextField();
    private final TextField textField5 = new TextField();
    private final TextArea textArea = new TextArea();
    private final ComboBox<String> dateCmb = new ComboBox<>();
    private final FileChooser fileChooser = new FileChooser();
    private final String devicesFile = "sample/devices.txt";
    private ArrayList<UserInfo>User = new ArrayList<>();
    private ArrayList<devicesConsumption>devicess = new ArrayList<>();

    private UserInfo current;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            readDevices();
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Problems with the file");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            return;
        }
        BorderPane mainpanel = new BorderPane();

        //Controls for creating new user
        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10); //Horizontal space between columns
        grid1.setVgap(10); //Vertical space between rows
        grid1.setPadding(new Insets(0, 25, 15, 25));

        // Text control for instructions
        Text instrText = new Text("Give User Information And Create New List");
        instrText.getStyleClass().add("label");
        // In column 0, row 0, column span 2 and row span 1
        grid1.add(instrText, 0, 0, 2, 1);
        // Label in column 0, row 1
        Label label1 = new Label("UserName:");
        grid1.add(label1, 0, 1);
        // TextField in column 1, row 1
        grid1.add(textField1, 1, 1);
        // Label in column 0, row 2
        Label label2 = new Label("Date in Use (DD.MM.YYYY):");
        grid1.add(label2, 0, 2);
        // TextField in column 1, row 2
        grid1.add(textField2, 1, 2);
        // Label in column 0, row 3
        Label label3 = new Label("Location");
        grid1.add(label3, 0, 3);
        // TextField in column 1, row 3
        grid1.add(textField3, 1, 3);
        // Button to create new list in column 1, row 4
        Button createBtn = new Button("Create new list");
        createBtn.getStyleClass().add("button");
        grid1.add(createBtn, 1, 4);

        //Grid1 left on borderpane
        mainpanel.setLeft(grid1);
        grid1.getStyleClass().add("backgroundColor");// add style to grid1


        // Information about devices consumption
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10); //Horizontal space between columns
        grid2.setVgap(10); //Vertical space between rows
        grid2.setPadding(new Insets(0, 25, 45, 35)); // from border to content(top/right/bottom/left)
        //Instruction for adding new devices to consumption arraylist
        Text instrText2 = new Text("Choose devices, give hours that devices in use");
        instrText2.getStyleClass().add("label");
        grid2.add(instrText2, 0, 5, 2, 1);
        Label label4 = new Label("Devices:");
        grid2.add(label4, 0, 6);
        // ComboBox in column 1, row 6
        grid2.add(devicesCmb, 1, 6);
        Label label5 = new Label("Time:");
        Label label5_1 = new Label("Hours:");
        Label label5_2 = new Label("Minutes:");
        grid2.add(label5, 0, 7);
        grid2.add(label5_1, 0, 8);
        grid2.add(textField4, 1, 8);
        grid2.add(label5_2, 0, 9);
        grid2.add(textField5, 1, 9);
        Button addBtn = new Button("Add");
        addBtn.getStyleClass().add("button");
        grid2.add(addBtn, 1, 10);
        //create bar chart window
        Button barChartBtn = new Button();
        barChartBtn .setText("Bar Chart Consumption");
        barChartBtn.getStyleClass().add("button");
        grid2.add( barChartBtn , 1, 11);

        //Grid2 right on borderpane
        mainpanel.setRight(grid2);
        grid2.getStyleClass().add("backgroundColor");

        //Controls to choose consumption date in ComboBox
        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(10); //Horizontal space between columns
        grid3.setVgap(2); //Vertical space between rows
        grid3.setPadding(new Insets(0, 25, 45, 35)); // from border to content(top/right/bottom/left)
        Text instrText3 = new Text("Choose date to view it." +
                "");
        instrText3.getStyleClass().add("label");
        grid3.add(instrText3, 0, 11, 2, 1);
        Label label6 = new Label("Show consumption date:");
        grid3.add(label6, 0, 12);
        grid3.add(dateCmb, 1, 12);
        //Grid3 bottom on borderpane
        mainpanel.setBottom(grid3);
        grid3.getStyleClass().add("backgroundColor");

        //TextArea center of borderpane
        textArea.setEditable(false);
        textArea.setFont(Font.font("monospace", FontWeight.NORMAL, 12));
        mainpanel.setCenter(textArea);

        //Create menubar and File menu
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        menuBar.getMenus().add(menuFile);

        MenuItem startNew = new MenuItem("New");
        MenuItem open = new MenuItem("Open");
        MenuItem saveAs = new MenuItem("Save As");
        MenuItem exit = new MenuItem("Exit");
        menuFile.getItems().addAll(startNew, open, saveAs, new SeparatorMenuItem(), exit);
        //menuBar Top on borderpane
        mainpanel.setTop(menuBar);

        Scene scene = new Scene(mainpanel, 1250, 600);
        primaryStage.setTitle("Electricity Consumption");
        primaryStage.setScene(scene);
        scene.getStylesheets().add("sample/style.css"); // add stylesheet to GUI control
        primaryStage.show();

        //Event handlers

        //create new window for bar chart
        barChartBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                createBarChart(e);
            }
        });

        //create new user
        createBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                createNewUser(e);
            }
        });

        //give info about length in use of devices and their consumption
        addBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                addDeviceConsumption(e);
            }
        });

        // get date and show info about devices and users in that date
        dateCmb.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                showSelectedDate();
            }
        });

        //save data you input to a .dat file
        saveAs.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                File file = fileChooser.showSaveDialog(primaryStage);
                if (file != null) {
                    saveDataToFile(file);
                }

            }
        });

        //open .dat file you saved
        open.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    readDataFromFile(file);
                }

            }
        });

        // exit window
        exit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                //System.exit(0);
                Platform.exit();
            }
        });

        //start new file
        startNew.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                //TODO
                clearControls();
            }
        });

    }//End of method start

    //method to create a bar chart based on information users gave
    private void createBarChart(ActionEvent e) {
        final double[] values = {0.000, 0.000, 0.000, 0.000, 0.000, 0.000, 0.000, 0.000, 0.000, 0.000};
        final String[] devicesName = {"Television", "dishwasher", "fridge", "freezer", "laptop", "stove", "oven", "sauna", "washing machine (40 degree)","washing machine (60 degree)"};

        //create bar chart
        final CategoryAxis xAxis = new CategoryAxis(); //String category
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> barchart = new BarChart<>(xAxis,yAxis);
        xAxis.setLabel("Devices");
        yAxis.setLabel("Consumption Data(Kw/h)");
        barchart.setTitle(" Electricity Consumption");
        barchart.setLegendVisible(false); //Just one series, legend is not needed

        VBox vbox = new VBox();
        Text resultText = new Text();
        resultText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        vbox.getChildren().addAll( barchart,resultText);
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();


        for(int i = 0; i < devicesName.length; i++) {
            for(int y =0; y < devicess.size(); y++) {
                if (devicesName[i].equals(devicess.get(y).deviceName)) {
                    values[i] += devicess.get(y).sum();
                }
            }

        }
        for(int i = 0; i < devicesName.length; i++) {
            series1.getData().add(new XYChart.Data<>(devicesName[i], values[i]));
        }
        //calculate total sum of consumption values
        double sumConsumption = 0;
        for (devicesConsumption de : devicess)
            sumConsumption += de.sum();

        resultText.setText(String.format("The total sum of consumption values for different devices: %.2fkW",sumConsumption ));
        barchart.getData().add(series1);

        Scene secondScene = new Scene(vbox, 500, 400);

        Stage newWindow = new Stage();
        newWindow.setTitle("Bar Chart ");
        newWindow.setScene(secondScene);

        newWindow.show();
    }
    //Reads devices and their consumption in unit kWh/hour from text file
    public void readDevices() throws Exception{
        ClassLoader cl = this.getClass().getClassLoader();
        URL url = cl.getResource(devicesFile);

        try(InputStream in = url.openStream(); BufferedReader input = new BufferedReader(new InputStreamReader(in))){
            String line;
            while((line = input.readLine()) != null) {
                double consumption = new Double(input.readLine()); //should be device -one line and kwH/hour -one line in text file
                devices.put(line,  consumption);
            }
            List<String> names = devices.keySet().stream().sorted().collect(Collectors.toList());
            devicesCmb.setItems(observableArrayList(names));
        }
    }

    //Creates new user info and adds it to collection. Variable current order refers to
    //new User.
    private void createNewUser(ActionEvent e) {
        try{
            if(textField1.getText().isEmpty() || textField2.getText().isEmpty()|| textField3.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the blanks");
                alert.showAndWait();
            }
            else {
                String userName = textField1.getText();
                String dateInUse = textField2.getText();
                String location = textField3.getText();
                current = new UserInfo(userName, new date(dateInUse), location);
                textArea.setText(current.toString());
                User.add(current);
                dateCmb.getItems().add(dateInUse);
            }
        }catch(Exception error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Insert Value! Please insert like this form: DD.MM.YYYY!");
            alert.showAndWait();
        }
    }

    //Add new device consumption to the collection
    private void addDeviceConsumption (ActionEvent e){
        try {
            if (devicesCmb.getValue().isEmpty() || textField4.getText().isEmpty() || textField5.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the blanks");
                alert.showAndWait();
            } else {
                    String deviceName = devicesCmb.getValue();
                    double consumptionValue = devices.get(devicesCmb.getValue());
                    int hour = Integer.parseInt(textField4.getText());
                    int minutes = Integer.parseInt(textField5.getText());
                    devicesConsumption d = new devicesConsumption(deviceName, consumptionValue, hour, minutes);
                    devicess.add(d);
                    current.addNewDevices(d);
                textArea.setText(current.toString());
            }
        }
         catch(Exception error){
             Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Insert Value!");
             alert.showAndWait();
         }
    }

    //Shows entered days
    private void showSelectedDate(/*ActionEvent e*/) {
        if(dateCmb.getSelectionModel().getSelectedIndex() != -1 ) {
            int id = dateCmb.getSelectionModel().getSelectedIndex();
            current = User.get(id);
            textArea.setText(current.toString());// add sum of that day

        }
    }

    //Writes consumption to file
    private void saveDataToFile(File file) {
        System.out.println(file.getAbsolutePath());
        try (ObjectOutputStream file_out
                     = new ObjectOutputStream(new FileOutputStream(file))){

            file_out.writeObject(User);
//            file_out.writeObject(devicess);// ADD LATER

        }
        catch(Exception e) {
            System.out.println("Problems with " + file);
            e.printStackTrace();
        }

    }

    //Reads consumption from file
    @SuppressWarnings("unchecked")
    private void readDataFromFile(File file) {
        //TODO

        try (ObjectInputStream file_in
                     = new ObjectInputStream(new FileInputStream(file))){
            User= (ArrayList<UserInfo>)file_in.readObject();
        }
        catch(Exception e) {
            System.out.println("Problems with " + file);
            e.printStackTrace();
        }
        for(UserInfo us : User){
            dateCmb.getItems().add(us.dateUsed.toString()); //check again dateSplit()
        }
        showSelectedDate();
    }

    //Clears GUI controls
    private void clearControls() {
        textField1.setText(null);
        textField2.setText(null);
        textField3.setText(null);
        textField4.setText(null);
        textField5.setText(null);
        textArea.setText(null);
        devicesCmb.getSelectionModel().clearSelection();
        dateCmb.getSelectionModel().clearSelection();
        dateCmb.getItems().clear();
        devicess.clear();

    }

    public static void main(String[] args) {
        launch(args);

    }

}

