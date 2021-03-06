/**
 * Generates map by splitting rooms with random rotation of split
 * 
 * @author Hallmanns
 *
 */
public class RandomSplitRoomGenerator extends MapGenerator {

	private final int splits = 10;

	/**
	 * constructor
	 * 
	 * @param width
	 * @param height
	 */
	public RandomSplitRoomGenerator(int width, int height) {
		super(width, height);
	}

	/**
	 * starts generating map goes to splitOne or splitTwo (chooses randomly)
	 */
	protected void generateMap() {
		super.generateMap();
		if (Math.random() < 0.5) {
			splitOne(1, width - 1, 1, height - 1, splits);
		} else {
			splitTwo(1, width - 1, 1, height - 1, splits);
		}
	}

	/**
	 * splits room into two parts place of split is randomly chosen where it's
	 * sent to is randomly chosen if room is too small or splits is 0, goes to
	 * makeDoors
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
	private void splitOne(int startX, int endX, int startY, int endY, int splits) {
		if (splits == 0 || (endX - startX) * (endY - startY) <= 30
				|| endX - startX <= 5 || endY - startY <= 5) {
			makeDoors(startX, endX, startY, endY);
		} else {

			int h = endY - startY;
			int splitH = (int) ((Math.random() * (h - 4)) + 2);
			for (int i = startX; i <= endX; i++) {
				if (map[i][startY + splitH] == ' ') {
					map[i][startY + splitH] = '-';
				}
			}
			if (Math.random() < 0.5) {
				splitOne(startX, endX, startY, startY + splitH - 1, splits - 1);
			} else {
				splitTwo(startX, endX, startY, startY + splitH - 1, splits - 1);
			}
			if (Math.random() < 0.5) {
				splitOne(startX, endX, startY + splitH + 1, endY, splits - 1);
			} else {
				splitTwo(startX, endX, startY + splitH + 1, endY, splits - 1);
			}

		}
	}

	/**
	 * splits room into two parts place of split is randomly chosen where it's
	 * sent to is randomly chosen if room is too small or splits is 0, goes to
	 * makeDoors
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
	private void splitTwo(int startX, int endX, int startY, int endY, int splits) {
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
			if (Math.random() < 0.5) {
				splitOne(startX, startX + splitW - 1, startY, endY, splits - 1);
			} else {
				splitTwo(startX, startX + splitW - 1, startY, endY, splits - 1);
			}
			if (Math.random() < 0.5) {
				splitOne(startX + splitW + 1, endX, startY, endY, splits - 1);
			} else {
				splitTwo(startX + splitW + 1, endX, startY, endY, splits - 1);
			}
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
