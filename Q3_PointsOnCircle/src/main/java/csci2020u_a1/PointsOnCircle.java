
package csci2020u_a1.Q3_PointsOnCircle;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class PointsOnCircle extends Application {
	
	Circle[] crcs;
	Line ln1, ln2, ln3;
	Label[] lbls;

	public void start(Stage primaryStage) {
		
		Pane p = new Pane();
		p.setPadding(new Insets(10, 0, 0, 10));
		
		Circle mainCirc = new Circle(200, 200, 190, null);
		mainCirc.setStroke(Color.BLACK);
		
		EventHandler<MouseEvent> mousePressHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				Circle c = (Circle)(e.getSource());
				c.setFill(Color.MEDIUMSPRINGGREEN);
			}
		};
		
		EventHandler<MouseEvent> mouseReleaseHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				Circle c = (Circle)(e.getSource());
				c.setFill(Color.RED);
			}
		};
		
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
				
				if(notColliding(c, nx+200, -ny+200)) {
					c.setCenterX(nx+200);
					c.setCenterY(-ny+200);
				}
				
				updateLabels();
			}
		};
		
		crcs = new Circle[3];
		
		crcs[0] = new Circle(200, 10, 8, Color.RED);
		crcs[0].setStroke(Color.BLACK);
		crcs[0].setOnMouseDragged(dragHandler);
		crcs[0].setOnMousePressed(mousePressHandler);
		crcs[0].setOnMouseReleased(mouseReleaseHandler);
		
		crcs[1] = new Circle(390, 200, 8, Color.RED);
		crcs[1].setStroke(Color.BLACK);
		crcs[1].setOnMouseDragged(dragHandler);
		crcs[1].setOnMousePressed(mousePressHandler);
		crcs[1].setOnMouseReleased(mouseReleaseHandler);
		
		crcs[2] = new Circle(200, 390, 8, Color.RED);
		crcs[2].setStroke(Color.BLACK);
		crcs[2].setOnMouseDragged(dragHandler);
		crcs[2].setOnMousePressed(mousePressHandler);
		crcs[2].setOnMouseReleased(mouseReleaseHandler);
		
		ln1 = new Line();
		ln1.startXProperty().bind(crcs[0].centerXProperty());
		ln1.startYProperty().bind(crcs[0].centerYProperty());
		ln1.endXProperty().bind(crcs[1].centerXProperty());
		ln1.endYProperty().bind(crcs[1].centerYProperty());
		
		ln2 = new Line();
		ln2.startXProperty().bind(crcs[1].centerXProperty());
		ln2.startYProperty().bind(crcs[1].centerYProperty());
		ln2.endXProperty().bind(crcs[2].centerXProperty());
		ln2.endYProperty().bind(crcs[2].centerYProperty());
		
		ln3 = new Line();
		ln3.startXProperty().bind(crcs[2].centerXProperty());
		ln3.startYProperty().bind(crcs[2].centerYProperty());
		ln3.endXProperty().bind(crcs[0].centerXProperty());
		ln3.endYProperty().bind(crcs[0].centerYProperty());
		
		lbls = new Label[]{new Label(), new Label(), new Label()};
		
		updateLabels();
		
		p.getChildren().addAll(mainCirc, ln1, ln2, ln3, lbls[0], lbls[1], lbls[2], crcs[0], crcs[1], crcs[2]);
		
		Scene s = new Scene(p);
		primaryStage.setTitle("Question_3");
		primaryStage.setScene(s);
		primaryStage.show();
		
	}
	
	public void updateLabels() {
		
		double a1 = Math.toDegrees(Math.atan2(-ln1.getEndY() + ln1.getStartY(), ln1.getEndX() - ln1.getStartX()));
		double a2 = Math.toDegrees(Math.atan2(-ln2.getEndY() + ln2.getStartY(), ln2.getEndX() - ln2.getStartX()));
		double a3 = Math.toDegrees(Math.atan2(-ln3.getEndY() + ln3.getStartY(), ln3.getEndX() - ln3.getStartX()));
		
		double a1R = Math.toDegrees(Math.atan2(-ln1.getStartY() + ln1.getEndY(), ln1.getStartX() - ln1.getEndX()));
		double a2R = Math.toDegrees(Math.atan2(-ln2.getStartY() + ln2.getEndY(), ln2.getStartX() - ln2.getEndX()));
		double a3R = Math.toDegrees(Math.atan2(-ln3.getStartY() + ln3.getEndY(), ln3.getStartX() - ln3.getEndX()));
		
		if(a1 < 0) a1 = 360 + a1;
		if(a2 < 0) a2 = 360 + a2;
		if(a3 < 0) a3 = 360 + a3;
		
		if(a1R < 0) a1R = 360 + a1R;
		if(a2R < 0) a2R = 360 + a2R;
		if(a3R < 0) a3R = 360 + a3R;
		
		double val0 = a1 - a3R;
		double val1 = a2 - a1R;
		double val2 = a3 - a2R;
		
		if(val0 < 0) val0 = 360 + val0;
		if(val1 < 0) val1 = 360 + val1;
		if(val2 < 0) val2 = 360 + val2;
		
		String v0Out = String.valueOf(val0);
		String v1Out = String.valueOf(val1);
		String v2Out = String.valueOf(val2);
		
		v0Out = v0Out.substring(0, Math.min(v0Out.length(), 5));
		v1Out = v1Out.substring(0, Math.min(v1Out.length(), 5));
		v2Out = v2Out.substring(0, Math.min(v2Out.length(), 5));
		
		lbls[0].setText(v0Out);
		lbls[1].setText(v1Out);
		lbls[2].setText(v2Out);
		
//		lbls[0].layoutXProperty().bind(crcs[0].centerXProperty().add(((crcs[1].centerXProperty().add(crcs[2].centerXProperty())).subtract(crcs[0].centerXProperty().multiply(2))).multiply(0.07)));
//		lbls[0].layoutYProperty().bind(crcs[0].centerYProperty().add(((crcs[1].centerYProperty().add(crcs[2].centerYProperty())).subtract(crcs[0].centerYProperty().multiply(2))).multiply(0.07)));
//		
//		lbls[1].layoutXProperty().bind(crcs[1].centerXProperty().add(((crcs[0].centerXProperty().add(crcs[2].centerXProperty())).subtract(crcs[1].centerXProperty().multiply(2))).multiply(0.07)));
//		lbls[1].layoutYProperty().bind(crcs[1].centerYProperty().add(((crcs[0].centerYProperty().add(crcs[2].centerYProperty())).subtract(crcs[1].centerYProperty().multiply(2))).multiply(0.07)));
//		
//		lbls[2].layoutXProperty().bind(crcs[2].centerXProperty().add(((crcs[0].centerXProperty().add(crcs[1].centerXProperty())).subtract(crcs[2].centerXProperty().multiply(2))).multiply(0.07)));
//		lbls[2].layoutYProperty().bind(crcs[2].centerYProperty().add(((crcs[0].centerYProperty().add(crcs[1].centerYProperty())).subtract(crcs[2].centerYProperty().multiply(2))).multiply(0.07)));
		
		lbls[0].layoutXProperty().bind(ln1.startXProperty().add(ln1.endXProperty().subtract(ln1.startXProperty()).multiply(0.1)).add(ln3.startXProperty().subtract(ln3.endXProperty()).multiply(0.1)));
		lbls[0].layoutYProperty().bind(ln1.startYProperty().add(ln1.endYProperty().subtract(ln1.startYProperty()).multiply(0.1)).add(ln3.startYProperty().subtract(ln3.endYProperty()).multiply(0.1)));
		
		lbls[1].layoutXProperty().bind(ln2.startXProperty().add(ln2.endXProperty().subtract(ln2.startXProperty()).multiply(0.1)).add(ln1.startXProperty().subtract(ln1.endXProperty()).multiply(0.1)));
		lbls[1].layoutYProperty().bind(ln2.startYProperty().add(ln2.endYProperty().subtract(ln2.startYProperty()).multiply(0.1)).add(ln1.startYProperty().subtract(ln1.endYProperty()).multiply(0.1)));
		
		lbls[2].layoutXProperty().bind(ln3.startXProperty().add(ln3.endXProperty().subtract(ln3.startXProperty()).multiply(0.1)).add(ln2.startXProperty().subtract(ln2.endXProperty()).multiply(0.1)));
		lbls[2].layoutYProperty().bind(ln3.startYProperty().add(ln3.endYProperty().subtract(ln3.startYProperty()).multiply(0.1)).add(ln2.startYProperty().subtract(ln2.endYProperty()).multiply(0.1)));
		
	}
	
	public boolean notColliding(Circle c, double x, double y) {
		
		Circle c1 = null, c2 = null;
		
		for(int i = 0;i < 3;i++) {
			if(c == crcs[i]) continue;
			else if(c1 != null) c2 = crcs[i];
			else c1 = crcs[i];
		}
		
		double theta1 = Math.toDegrees(Math.atan2(-(c1.getCenterY()-200), c1.getCenterX()-200));
		double theta2 = Math.toDegrees(Math.atan2(-(c2.getCenterY()-200), c2.getCenterX()-200));
		double theta3 = Math.toDegrees(Math.atan2(-(c.getCenterY()-200), c.getCenterX()-200));
		double theta4 = Math.toDegrees(Math.atan2(-(y-200), x-200));
		
		if(theta1 < 0) theta1 = 360 + theta1;
		if(theta2 < 0) theta2 = 360 + theta2;
		if(theta3 < 0) theta3 = 360 + theta3;
		if(theta4 < 0) theta4 = 360 + theta4;
		
//		System.out.println(theta1 + " " + theta2 + " " + theta3 + " " + theta4);
		
		double maxTheta = Math.max(theta1, theta2);
		double minTheta = Math.min(theta1, theta2);
		
		double maxThetaHi = maxTheta+4;
		double maxThetaLo = maxTheta-4;
		double minThetaHi = minTheta+4;
		double minThetaLo = minTheta-4;
		
//		System.out.println(minThetaLo + " " + minThetaHi + " " + maxThetaLo + " " + maxThetaHi);
		
//		if(maxThetaHi > 360) maxThetaHi -= 360;
//		if(minThetaHi > 360) minThetaHi -= 360;
//		if(maxThetaLo < 0) maxThetaLo += 360;
//		if(minThetaLo < 0) minThetaLo += 360;
		
//		System.out.println("thetas " + minThetaLo + " " + minThetaHi + " " + maxThetaLo + " " + maxThetaHi);
		
		if(Double.isNaN(theta4)) return false;
		
		if(theta3 > minThetaHi && theta3 < maxThetaLo && (theta4 < minThetaHi || theta4 > maxThetaLo)) return false; 
		if((theta3 < minThetaLo || theta3 > maxThetaHi) && theta4 > minThetaLo && theta4 < maxThetaHi) return false; 
		
//		double minX = Math.min(c1.getCenterX(), c2.getCenterX()) - 8;
//		double maxX = Math.max(c1.getCenterX(), c2.getCenterX()) + 8;
//		double minY = Math.min(c1.getCenterY(), c2.getCenterY()) - 8;
//		double maxY = Math.max(c1.getCenterY(), c2.getCenterY()) + 8;
//		
//		if(c.getCenterX() < minX && x > minX || c.getCenterX() > maxX && x < maxX) {
//			if(x > minX && x < maxX && y > minY && y < maxY) return false;
//			System.out.println("here");
//		}
//		if(c.getCenterY() < minY && y > minY || c.getCenterY() > maxY && y < maxY) {
//			if(x > minX && x < maxX && y > minY && y < maxY) return false;
//			System.out.println("here2");
//		}
		
//		System.out.println(c.getCenterX());
//		System.out.println(minX + " " + maxX);
		
		return true;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
