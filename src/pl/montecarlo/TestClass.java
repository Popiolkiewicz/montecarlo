package pl.montecarlo;

/**
 * Created on 10 paü 2016 - 11:52:23
 *
 * @author Hubert Popio≥kiewicz
 */
public class TestClass {

	static int radius = 1;
	static int samplesRate = 100_000_000;
	static int trials = 10;

	public static void main(String[] args) {
		for (int i = 0; i < trials; i++)  {
			int circleRateCounter = 0;
			for (int j = 0; j < samplesRate; j++) {
				double xCoord = (Math.random() * 2 - 1) * radius;
				double yCoord = (Math.random() * 2 - 1) * radius;
				if ((Math.pow(xCoord, 2) + Math.pow(yCoord, 2)) <= radius * radius)
					circleRateCounter++;
			}
			double result = 4 * ((double) circleRateCounter / samplesRate);
            System.out.println(String.format("Trial number %s, pi = %6f", i, result));
		}
	}

}
