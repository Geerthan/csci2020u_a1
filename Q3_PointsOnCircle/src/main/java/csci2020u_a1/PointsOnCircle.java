
package csci2020u_a1.Q3_PointsOnCircle;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PointsOnCircle extends Application {

	public void start(Stage primaryStage) {
		
		Pane p = new Pane();
		p.setPadding(new Insets(10, 0, 0, 10));
		
		Circle mainCirc = new Circle(200, 200, 190, null);
		mainCirc.setStroke(Color.BLACK);
		
		EventHandler<MouseEvent> dragHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				double x = e.getSceneX() - 200;
				double y = -(e.getSceneY() - 200);
				double m = y/x;
				
//				double angle = Math.atan2(y, x);
//				System.out.println(Math.toDegrees(angle));
//				double h = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
//				System.out.println(h);
//				y/x = m, h = 190
//				190 = Math.sqrt(Math.pow(x, 2) + Math.pow(mx, 2))
//				190^2 = Math.pow(x, 2) + Math.pow(mx, 2))
//				190^2 =  x(x + mx)
				
				double nx = (x/Math.abs(x))*190 * Math.sqrt(1 / (Math.pow(m, 2) + 1));
				double ny = m * nx;
//				System.out.println(nx + " " + ny);
				
				Circle c = (Circle)(e.getSource());
				c.setCenterX(nx+200);
				c.setCenterY(-ny+200);
			}
		};
		
		Circle c1 = new Circle(200, 10, 8, Color.RED);
		c1.setStroke(Color.BLACK);
		c1.setOnMouseDragged(dragHandler);
		
		Circle c2 = new Circle(390, 200, 8, Color.RED);
		c2.setStroke(Color.BLACK);
		c2.setOnMouseDragged(dragHandler);
		
		Circle c3 = new Circle(200, 390, 8, Color.RED);
		c3.setStroke(Color.BLACK);
		c3.setOnMouseDragged(dragHandler);
		
		p.getChildren().addAll(mainCirc, c1, c2, c3);
		
		Scene s = new Scene(p);
		primaryStage.setScene(s);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
