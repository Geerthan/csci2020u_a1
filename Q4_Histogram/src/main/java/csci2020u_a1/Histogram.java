
package csci2020u_a1.Q4_Histogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
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

/**
 * This program displays a Histogram showing character frequencies in a given text file, using JavaFX.
 * @author Geerthan Srikantharajah
 * @author Gage Adam
 */

public class Histogram extends Application {
	
	Rectangle[] rects;
	Label[] lbls;

	public void start(Stage primaryStage) {
		
		//The paneVBox holds all elements
		VBox paneVBox = new VBox(8);
		paneVBox.setPadding(new Insets(10, 10, 10, 10));
		
		//The fileHBox holds the elements relating to filename
		HBox fileHBox = new HBox();
		fileHBox.setAlignment(Pos.CENTER_LEFT);
		
		//The chartGrid GridPane holds the actual histogram
		GridPane chartGrid = new GridPane();
		chartGrid.setHgap(5);
		
		rects = new Rectangle[26];
		lbls = new Label[26];
		
		//Generate a default histogram
		for(int i = 0;i < 26;i++) {
			rects[i] = new Rectangle(8, 50);
			rects[i].setFill(null);
			rects[i].setStroke(Color.BLACK);
			
			//Add labels for each character
			lbls[i] = new Label(String.valueOf((char)(65+i)));
			
			chartGrid.add(rects[i], i, 0);
			chartGrid.add(lbls[i], i, 1);
			
			//Bottom align all bars in the histogram during generation
			GridPane.setValignment(rects[i], VPos.BOTTOM);
		}
		
		Label lblFile = new Label("Filename");
		
		TextField txtfdFilename = new TextField();
		txtfdFilename.setPrefWidth(270);
		
		Button btViewGraph = new Button("View");

		//Read file listed in TextField, update histogram
		btViewGraph.setOnAction(e -> {
			
			for(int i = 0;i < 26;i++) {
				rects[i].setHeight(0);
			}
			
			Scanner in;
			
			try {
				in = new Scanner(new File(txtfdFilename.getText()));
				String str;
				
				while(in.hasNext()) {
					str = in.next();
					for(int i = 0;i < str.length();i++) {
						short idx = (short) Character.toUpperCase(str.charAt(i));

						//Use ASCII values for each character
						idx -= 65;

						//Use rectangle data as height counter, increment when new char is found
						if(idx >= 0 && idx < 26) rects[idx].setHeight(rects[idx].getHeight() + 5);
					}
				}
				
				//Update window size if necessary
				primaryStage.sizeToScene();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		
		fileHBox.getChildren().addAll(lblFile, txtfdFilename, btViewGraph);
		
		paneVBox.getChildren().addAll(chartGrid, fileHBox);
		
		Scene s = new Scene(paneVBox);
		
		primaryStage.setTitle("Question_4");
		primaryStage.setScene(s);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
