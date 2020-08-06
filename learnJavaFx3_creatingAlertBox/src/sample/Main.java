package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    Button button;
    Button button1;
    Button button2 ;
    @Override
    public void start(Stage primaryStage) throws Exception{
       window = primaryStage;
       window.setTitle("Nhan Nguyen");
       window.setOnCloseRequest(e ->{
           e.consume(); //Consumes this event so that it will not be processed in the default manner by the source which originated it. We can handling it manually through our method
           closeProgram();

       });

       button = new Button("Click Me to create an Alert Box");
       button.setOnAction(e -> AlertBox.display("AlertBox","Wow this alert box is awesome!!!!!"));

        button1 = new Button("Click Me to create a Confirm Box");
        button1.setOnAction(e -> {
            boolean result = ConfirmBox.display("Confirm Box","Are u sure u want to give me some money?");
            System.out.println(result);
        });

        button2 = new Button("Click Me to  c lose the program");
        button2.setOnAction(e -> {
                closeProgram();
        });

        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(20);
       layout.getChildren().addAll(button,  button1, button2 );
       Scene scene = new Scene(layout, 300,250);
       window.setScene(scene);
       window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void closeProgram(){
        Boolean answer = ConfirmBox.display("close Program", "Do you want to exit? ");
        if (answer)
            window.close();
    }
}
