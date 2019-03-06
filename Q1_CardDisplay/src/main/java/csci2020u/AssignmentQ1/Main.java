package csci2020.AssignmentQ1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Random;


public class Main extends Application {

  public void start(Stage primaryStage) {
      primaryStage.setTitle("Question_1");

      HBox hbox = new HBox(3);
      Random rand = new Random();
      int n1 = rand.nextInt(54) + 1;
      int n2 = rand.nextInt(54) + 1;
      int n3 = rand.nextInt(54) + 1;
      while (true)
      {
        if (n2 == n1)
        {
          n2 = rand.nextInt(53) + 1;
        }
        else if (n3 == n1 || n3 == n2)
        {
          n3 = rand.nextInt(53) + 1;
        }
        else
        {
          break;
        }
      }

      Image card1 = new Image("file:Cards/" + n1 + ".png");
      Image card2 = new Image("file:Cards/" + n2 + ".png");
      Image card3 = new Image("file:Cards/" + n3 + ".png");

      hbox.getChildren().add(new ImageView(card1));
      hbox.getChildren().add(new ImageView(card2));
      hbox.getChildren().add(new ImageView(card3));

      Scene scene = new Scene(hbox);
      
      primaryStage.setScene(scene);
      primaryStage.show();

  }
  public static void main(String[] args) {
     launch(args);
  }
}
