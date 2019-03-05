package csci2020.AssignmentQ1;

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
import java.util.Random;


public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception
  {
      primaryStage.setTitle("Question_1");

      Pane pane = new Pane();
      HBox hbox = new HBox(3);
      Random rand = new Random();
      int n1 = rand.nextInt(53) + 1;
      int n2 = rand.nextInt(53) + 1;
      int n3 = rand.nextInt(53) + 1;
      while (true)
      {
        if (n2 == n1)
        {
          int n2 = rand.nextInt(53) + 1;
        }
        else if (n3 == n1 || n3 == n2)
        {
          int n3 = rand.nextInt(53) + 1;
        }
        else
        {
          break;
        }
      }

      Image card1 = new Image("Cards/" + n1 + ".png");
      Image card2 = new Image("Cards/" + n2 + ".png");
      Image card3 = new Image("Cards/" + n3 + ".png");

      hbox.getChildren().add(new ImageView(card1));
      hbox.getChildren().add(new ImageView(card2));
      hbox.getChildren().add(new ImageView(card3));


      Scene scene = new Scene(pane, 400, 600);
      primaryStage.setScene(scene);
      primaryStage.show();


    public static void main(String[] args) {
        launch(args);
    }
}
