
package csci2020u_a1.Q4_Histogram;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Histogram extends Application {
	
	Rectangle[] rects;
	Label[] lbls;

	public void start(Stage primaryStage) {
		
		VBox paneVBox = new VBox(8);
		paneVBox.setPadding(new Insets(10, 10, 10, 10));
		
		HBox fileHBox = new HBox();
		fileHBox.setAlignment(Pos.CENTER_LEFT);
		
		GridPane chartGrid = new GridPane();
		chartGrid.setHgap(5);
		
		rects = new Rectangle[26];
		lbls = new Label[26];
		
		for(int i = 0;i < 26;i++) {
			rects[i] = new Rectangle(8, 50);
			rects[i].setFill(null);
			rects[i].setStroke(Color.BLACK);
			
			lbls[i] = new Label(String.valueOf((char)(65+i)));
			
			chartGrid.add(rects[i], i, 0);
			chartGrid.add(lbls[i], i, 1);
		}
		
		Label lblFile = new Label("Filename");
		TextField txtfdFilename = new TextField();
		Button btViewGraph = new Button("View");
		
		txtfdFilename.setPrefWidth(270);
		
		fileHBox.getChildren().addAll(lblFile, txtfdFilename, btViewGraph);
		
		paneVBox.getChildren().addAll(chartGrid, fileHBox);
		
		Scene s = new Scene(paneVBox);
		
		primaryStage.setScene(s);
		primaryStage.show();
		
	}
	
	public void updateGraph(int[] charCount) {
		for(int i = 0;i < charCount.length;i++) {
			rects[i].setHeight(charCount[i]);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
