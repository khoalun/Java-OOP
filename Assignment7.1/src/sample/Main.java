package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Grade Example");

        final int[] values = {0, 0, 0, 0, 0,0};
        final String[] grades = {"0", "1", "2", "3", "4", "5"};


        Label label1 = new Label("Grade");
        TextField textField1 = new TextField();
        Button btn = new Button("Insert");
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(20);
        hbox.getChildren().addAll(label1, textField1, btn);


        //create bar chart
        final CategoryAxis xAxis = new CategoryAxis(); //String category
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> barchart = new BarChart<>(xAxis,yAxis);
        xAxis.setLabel("Grade");
        yAxis.setLabel("Frequency");
        barchart.setTitle("Grade Distribution");
        barchart.setLegendVisible(false); //Just one series, legend is not needed

        Text resultText = new Text();
        resultText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox, barchart, resultText);
        XYChart.Series<String, Number> series1 = new Series<>();



        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    Integer.parseInt(textField1.getText());
                }catch (NumberFormatException e){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Value!");
                    textField1.requestFocus();
                    textField1.selectAll();
                    alert.showAndWait();
                    return;
                }

                int val = Integer.parseInt(textField1.getText());
                if(val < 0 || val > 5){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Value!");
                    textField1.requestFocus();
                    textField1.selectAll();
                    alert.showAndWait();
                    return ;
                }


                values[val]+= 1;
                for(int i = 0; i < values.length; i++) {
                    series1.getData().add(new Data<>(grades[i],values[i]));
                }

                double average = 0;
                int count = 0;
                double total = 0;

                for(int i= 0; i < values.length; i++) count += values[i];
                for(int i= 0; i < values.length; i++) total += values[i] *i;
                average = total/count;



                resultText.setText(String.format("Average: %.2f, Count: %d", average, count ));


            }
        });


        barchart.getData().add(series1);

        Scene scene =new Scene(vbox, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();


        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
