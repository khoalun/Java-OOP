package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.EventListener;
import java.util.Stack;

public class Main extends Application {
    Button button;
    Button button2;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        button = new Button();
        button.setText("Hey baby");
        //This class will handle the button events

        /*button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("I am anonymous inner class");
            }
        });*/

          //optimize by lambdas
        button.setOnAction(e -> System.out.println("hey now brown cow"));

        //button2 = new Button();
        //button2.setText("Clickk meee");
        //button2.setOnAction(this);
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        //layout.getChildren().add(button2);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        //primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
