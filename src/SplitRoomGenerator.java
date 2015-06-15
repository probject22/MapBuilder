/**
 * generates map by splitting room, alternating between splitting horizontally
 * and vertically
 * 
 * @author Hallmanns
 *
 */
public class SplitRoomGenerator extends MapGenerator {

	final private int splits = 10;

	/**
	 * constructor
	 * 
	 * @param width
	 * @param height
	 */
	public SplitRoomGenerator(int width, int height) {
		super(width, height);
	}

	/**
	 * if #splits is even, go to splitEven else go to splitOdd
	 */
	protected void generateMap() {
		super.generateMap();
		if (isEven(splits)) {
			splitEven(1, width - 1, 1, height - 1, splits);
		} else {
			splitOdd(1, width - 1, 1, height - 1, splits);
		}
	}

	/**
	 * splits room horizontally if room too small or no splits left, stop and
	 * make doors
	 * 
	 * @param startX
	 *            : smallest x of room (without wall)
	 * @param endX
	 *            : largest x of room (without wall)
	 * @param startY
	 *            : smallest y of room (without wall)
	 * @param endY
	 *            : largest y of room (without wall)
	 * @param splits
	 *            : amount of splits left to do
	 */
	private void splitOdd(int startX, int endX, int startY, int endY, int splits) {
		if ((endX - startX) * (endY - startY) <= 30 || endX - startX <= 5
				|| endY - startY <= 5) {
			makeDoors(startX, endX, startY, endY);
		} else {
			int h = endY - startY;
			int splitH = (int) ((Math.random() * (h - 4)) + 2);
			for (int i = startX; i <= endX; i++) {
				if (map[i][startY + splitH] == ' ') {
					map[i][startY + splitH] = '-';
				}
			}
			splitEven(startX, endX, startY, startY + splitH - 1, splits - 1);
			splitEven(startX, endX, startY + splitH + 1, endY, splits - 1);

		}
	}

	/**
	 * splits room vertically if room too small or no splits left, stop and make
	 * doors
	 * 
	 * @param startX
	 *            : smallest x of room (without wall)
	 * @param endX
	 *            : largest x of room (without wall)
	 * @param startY
	 *            : smallest y of room (without wall)
	 * @param endY
	 *            : largest y of room (without wall)
	 * @param splits
	 *            : amount of splits left to do
	 */
	protected void splitEven(int startX, int endX, int startY, int endY,
			int splits) {
		if (splits == 0 || (endX - startX) * (endY - startY) <= 30
				|| endX - startX <= 5 || endY - startY <= 5) {
			makeDoors(startX, endX, startY, endY);
		} else {
			int w = endX - startX;
			int splitW = (int) ((Math.random() * (w - 4)) + 2);
			for (int i = startY; i <= endY; i++) {
				if (map[startX + splitW][i] == ' ') {
					map[startX + splitW][i] = '-';
				}
			}
			splitOdd(startX, startX + splitW - 1, startY, endY, splits - 1);
			splitOdd(startX + splitW + 1, endX, startY, endY, splits - 1);
		}
	}

	/**
	 * places two doors in every wall of room
	 * 
	 * @param startX
	 *            : smallest x of room (without wall)
	 * @param endX
	 *            : largest x of room (without wall)
	 * @param startY
	 *            : smallest y of room (without wall)
	 * @param endY
	 *            : largest y of room (without wall)
	 */
	private void makeDoors(int startX, int endX, int startY, int endY) {
		int doorW1 = (int) (Math.random() * (endX - startX - 2)) + 1;
		int doorW2 = (int) (Math.random() * (endX - startX - 2)) + 1;
		int doorH1 = (int) (Math.random() * (endY - startY - 2)) + 1;
		int doorH2 = (int) (Math.random() * (endY - startY - 2)) + 1;
		if (startY - 1 > 0 && map[startX + doorW1][startY - 1] == '-') {
			map[startX + doorW1][startY - 1] = 'D';
		}
		if (endY + 1 < height && map[startX + doorW2][endY + 1] == '-') {
			map[startX + doorW2][endY + 1] = 'D';
		}
		if (startX - 1 > 0 && map[startX - 1][startY + doorH1] == '-') {
			map[startX - 1][startY + doorH1] = 'D';
		}
		if (endX + 1 < width && map[endX + 1][startY + doorH2] == '-') {
			map[endX + 1][startY + doorH2] = 'D';
		}

	}
}
