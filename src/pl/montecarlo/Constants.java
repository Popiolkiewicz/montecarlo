/**
 * 
 */
package pl.montecarlo;

/**
 * @author Hubert
 *
 */
public interface Constants {

	int samplesRate = 1_000_000;
	int trials = 10;
	int radius = 500;
	int diameter = radius * 2;
	int margin = 25;
	int height = diameter + (margin * 2);
	int width = height;
	float sampleWidth = 0.000_001f;
	float sampleHeight = 0.000_001f;
}
