/**
 * 
 */
package pl.montecarlo.visualization;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created on 10 paü 2016 - 13:34:55
 *
 * @author Hubert Popio≥kiewicz
 */
public class PreviewCanvas {


	private double[][] coords;

	public PreviewCanvas(double[][] coords) {
		this.coords = coords;
	}

	{ // Fake invoking JavaFX thread
		new JFXPanel();
	}
	
	public void showWindow() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				start();
			}
		});
	}

	public void start() {
		Stage primaryStage = new Stage();
		Group root = new Group();
		Canvas canvas = new Canvas(650, 650);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawShapes(gc);
		root.getChildren().add(canvas);
		primaryStage.setTitle("Drawing Operations Test");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	private void drawShapes(GraphicsContext gc) {
		gc.setFill(Color.GREEN);
		gc.setStroke(Color.BLUE);
		gc.strokeRect(25, 25, 600, 600);
		gc.strokeOval(25, 25, 600, 600);
		gc.strokeLine(25, 325, 625, 325);
		gc.strokeLine(325, 25, 325, 625);
		gc.setStroke(Color.RED);
		for (double[] ds : coords) 
			gc.strokeOval(ds[0] + 325, ds[1] + 325, 0.01, 0.01);
	}

}
