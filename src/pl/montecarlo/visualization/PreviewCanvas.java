package pl.montecarlo.visualization;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.montecarlo.Constants;

/**
 * Created on 10 paü 2016 - 13:34:55
 *
 * @author Hubert Popio≥kiewicz
 */
public class PreviewCanvas implements Constants {

  private double[][] coords;
  private boolean[] circleHits;

  public PreviewCanvas(double[][] coords, boolean[] circleHits) {
    this.coords = coords;
    this.circleHits = circleHits;
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
    Canvas canvas = new Canvas(width, height);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    drawShapes(gc);
    root.getChildren().add(canvas);
    primaryStage.setTitle("Monte carlo experiment visualization.");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  private void drawShapes(GraphicsContext gc) {
    gc.setFill(Color.GREEN);
    gc.setStroke(Color.BLACK);
    gc.strokeRect(margin, margin, diameter, diameter);
    gc.strokeOval(margin, margin, diameter, diameter);
    gc.strokeLine(margin, margin + radius, 
        margin + diameter, margin + radius);
    gc.strokeLine(margin + radius, margin, 
        margin + radius, margin + diameter);
    for (int i = 0; i < coords.length; i++) {
      if (circleHits[i])
        gc.setStroke(Color.RED);
      else
        gc.setStroke(Color.BLUEVIOLET);
      double[] ds = coords[i];
      gc.strokeOval(ds[0] + margin + radius, ds[1] + 
          margin + radius, sampleWidth, sampleHeight);
    }
  }
}
