package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    //start method is main entry point for application.
    //Stage is top-level container.
    @Override
    public void start(Stage primaryStage) throws Exception{
       primaryStage.setTitle("Assignment7");

        //GridPane for flexible layout of controls in rows and columns
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); //Horizontal space between columns
        grid.setVgap(10); //Vertical space between rows
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Text control for instructions
        Text instrText = new Text("Give two values");
        instrText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        // In column 0, row 0, column span 2 and row span 1
        grid.add(instrText, 0, 0, 2, 1);

        // Label in column 0, row 1
        Label label1 = new Label("I:");
        grid.add(label1, 0, 1);

        // TextField in column 1, row 1
        TextField textField1 = new TextField();
        grid.add(textField1, 1, 1);


        //symbol of I (A)
        Label label11 = new Label("A");
        grid.add(label11, 3, 1);

        // Label2 in column 0, row 2
        Label label2 = new Label("V:");
        grid.add(label2, 0, 2);

        //TextField2 in column 1, row 2
        TextField textField2 = new TextField();
        grid.add(textField2, 1, 2);

        //symbol of V (V)
        Label label22 = new Label("V");
        grid.add(label22, 3, 2);

        // Label in column 0, row 3
        Label label3 = new Label("R:");
        grid.add(label3, 0, 3);

        TextField textField3 = new TextField();
        grid.add(textField3, 1, 3);

        //symbol of R (Ohm)
        Label label33 = new Label("Ohm");
        grid.add(label33, 3, 3);

        //button in column 1, row 4
        Button btn = new Button("Calculate");
        grid.add(btn, 1, 4);

        //Where result is printed
        Text resultText = new Text();
        grid.add(resultText, 0, 6, 2, 1);
        resultText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

        // Event handling for button
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent a) {
                if(textField1.getText().isEmpty()){
                    double V = Double.parseDouble(textField2.getText());
                    double R = Double.parseDouble(textField3.getText());
                    double I = V/R;
                    resultText.setText("I = V/R =" + I +" A");
                }
                else if(textField2.getText().isEmpty()){
                    double I = Double.parseDouble(textField1.getText());
                    double R = Double.parseDouble(textField3.getText());
                    double V = I*R;
                    resultText.setText("V = I*R =" + V +" V");
                }
                else if(textField3.getText().isEmpty()){
                    double I = Double.parseDouble(textField1.getText());
                    double V = Double.parseDouble(textField2.getText());
                    double R = V/I;
                    resultText.setText("R = V/I =" + R + " Ohm");
                }
                else{
                    resultText.setText("Not valid. Please try again!");
                }

            }
        });

        //Scene is container for all content
        Scene scene = new Scene(grid, 300,275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
