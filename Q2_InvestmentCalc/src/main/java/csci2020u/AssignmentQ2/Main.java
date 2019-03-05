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


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Question_3");

        GridPane pane = new GridPane();
        TextField invest, years, rate, result;

        pane.getChildren().add(new Label("Investment Amount: "), 0, 0);
        invest = new TextField();
        invest.setPromptText("Amount");
        pane.getChildren().add(invest, 0, 1);

        pane.getChildren().add(new Label("Years: "), 1, 0);
        years = new TextField();
        years.setPromptText("Years");
        pane.getChildren().add(years, 1, 1);

        pane.getChildren().add(new Label("Annual Interest Rate: "), 2, 0);
        rate = new TextField();
        rate.setPromptText("Rate");
        pane.getChildren().add(rate, 2, 1);
        
        pane.getChildren().add(new Label("Future Value: "), 3, 0);
        result = new TextField();
        pane.getChildren().add(result, 3, 1);
        Button calculate = new Button("Calculate");

        calculate.setOnAction(new EventHandler<ActionEvent>()) {
          @Override
          public void handle(ActionEvent event)
          {
            double inv = double(invest.getText());
            double year = double(years.getText());
            double r = double(rate.getText());
            double future;
            future = inv * Math.pow((1 + r), year*12);
            result.setText(future);
          }
        }

        pane.getChildren().add(calculate, 4, 1);

        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
