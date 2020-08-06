package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    Scene scene1, scene2;
    @Override
    public void start(Stage primaryStage) throws Exception{
       window = primaryStage;
       //button 1
       Label label1 = new Label("Welcome to the first scene!");
       Button button1 = new Button("go to scene2");
       button1.setOnAction(e -> window.setScene(scene2));

       //Layout 1- children are laid out in vertical column
        VBox layout1 = new VBox(20); //space mount 20px so they are not buttered up right up against each other
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200,200);

        //button 2
        Button button2 = new Button("This scene sucks, go back to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));

        //Layout 2-
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 300);// 600 is horizontal/ width, 300 is vertical/height

        //set up when pop up window first display the program
        window.setScene(scene1);
        window.setTitle("Switching Scenes");
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
