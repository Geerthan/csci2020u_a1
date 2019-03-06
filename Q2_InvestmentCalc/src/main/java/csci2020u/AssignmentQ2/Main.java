package csci2020.AssignmentQ2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Question_2");

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        TextField invest, years, rate, result;

        pane.add(new Label("Investment Amount: "), 0, 0);
        invest = new TextField();
        invest.setPromptText("Amount");
        pane.add(invest, 1, 0);

        pane.add(new Label("Years: "), 0, 1);
        years = new TextField();
        years.setPromptText("Years");
        pane.add(years, 1, 1);

        pane.add(new Label("Annual Interest Rate: "), 0, 2);
        rate = new TextField();
        rate.setPromptText("Rate");
        pane.add(rate, 1, 2);
        
        pane.add(new Label("Future Value: "), 0, 3);
        result = new TextField();
        pane.add(result, 1, 3);
        Button calculate = new Button("Calculate");

        calculate.setOnAction(new EventHandler<ActionEvent>() {
            
          public void handle(ActionEvent event) {
            double inv = Double.valueOf(invest.getText());
            double year = Double.valueOf(years.getText());
            double r = Double.valueOf(rate.getText()) / 100 / 12;
            String future;
            future = String.valueOf(inv * Math.pow((1 + r), year*12));
            result.setText(future);
          }
          
        });

        pane.add(calculate, 1, 4);
        GridPane.setHalignment(calculate, HPos.RIGHT);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
