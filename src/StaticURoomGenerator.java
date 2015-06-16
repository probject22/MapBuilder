/**
 * Divides map into squares and places U-shapes into these squares.
 * 
 * @author Hallmanns
 *
 */

public class StaticURoomGenerator extends URoomGenerator {

	// length of squares
	private static int length = 5;

	/**
	 * constructor super goes to URoomGenerator
	 * 
	 * @param width
	 * @param height
	 */
	public StaticURoomGenerator(int width, int height) {
		super(width, height);
	}

	/**
	 * divides map into squares and decides rotation for every U sends it to
	 * URoomGenerator to write on map
	 */
	protected void generateMap() {
		generateOuterwalls();
		int stop = (int) ((width - 2) / length);
		for (int i = 0; i < stop; i++) {
			for (int j = 0; j < stop; j++) {
				int rr = (int) (Math.random() * 4);
				int ux = (i * length) + 2;
				int uy = (j * length) + 2;
				if (rr == 0) {
					upU(ux, uy, length - 2);
				} else if (rr == 1) {
					rightU(ux, uy, length - 2);
				} else if (rr == 2) {
					downU(ux, uy, length - 2);
				} else {
					leftU(ux, uy, length - 2);
				}
			}
		}
	}
}
