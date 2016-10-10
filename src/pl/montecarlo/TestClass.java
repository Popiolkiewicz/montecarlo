package pl.montecarlo;

import pl.montecarlo.visualization.PreviewCanvas;

/**
 * Created on 10 paü 2016 - 11:52:23
 *
 * @author Hubert Popio≥kiewicz
 */
public class TestClass {

	static int radius = 300;
	static int samplesRate = 100000;
	static int trials = 1;

	public static void main(String[] args) {
		for (int i = 0; i < trials; i++) {
			int circleRateCounter = 0;
			double[][] coords = new double[samplesRate][2];
			for (int j = 0; j < samplesRate; j++) {
				double xCoord = (Math.random() * 2 - 1) * radius;
				double yCoord = (Math.random() * 2 - 1) * radius;
				coords[j][0] = xCoord;
				coords[j][1] = yCoord;
				if ((Math.pow(xCoord, 2) + Math.pow(yCoord, 2)) <= radius * radius)
					circleRateCounter++;
			}
			double result = 4 * ((double) circleRateCounter / samplesRate);
			System.out.println(String.format("Trial number %s, pi = %6f", i, result));
			new PreviewCanvas(coords).showWindow();
		}
	}
}