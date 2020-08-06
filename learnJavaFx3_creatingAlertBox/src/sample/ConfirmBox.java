package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class ConfirmBox{

    static boolean answer;


    public static boolean display(String title, String message){ // this display method will not return void, it will return a boolean var
        Stage window = new Stage();// create a new window
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        //Create 2 butons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e  -> {
            answer = true;
            window.close();


        });//  quick way to make a method

        noButton.setOnAction(e  -> {
            answer = false;
            window.close();
        });//
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();//show this stage and waits for it to be hidden before returning to the caller.

        return answer;
    }
}





















