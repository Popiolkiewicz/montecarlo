package pl.montecarlo;

import pl.montecarlo.visualization.PreviewCanvas;

/**
 * Created on 10 paü 2016 - 11:52:23
 *
 * @author Hubert Popio≥kiewicz
 */
public class TestClass implements Constants {

	public static void main(String[] args) {
		double[][] coords = new double[samplesRate][2];
		double[] trialResults = new double[trials];
		for (int i = 0; i < trials; i++) {
			int circleRateCounter = 0;
			for (int j = 0; j < samplesRate; j++) {
				double xCoord = (Math.random() * 2 - 1) * radius;
				double yCoord = (Math.random() * 2 - 1) * radius;
				coords[j][0] = xCoord;
				coords[j][1] = yCoord;
				if (Math.pow(xCoord, 2) + Math.pow(yCoord, 2) <= Math.pow(radius, 2))
					circleRateCounter++;
			}
			double result = 4 * ((double) circleRateCounter / samplesRate);
			trialResults[i] = result;
			System.out.println(String.format("Trial number %s, pi = %6f", i+1, result));
		}
		double s = 0.0;
		for (double trialResult : trialResults) {
			s+= trialResult;
		}
		System.out.println(s/trials);
		new PreviewCanvas(coords).showWindow();
	}
}