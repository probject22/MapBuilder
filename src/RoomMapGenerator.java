/**
 * generates map by making rooms with doors
 * 
 * @author Hallmanns
 *
 */
public class RoomMapGenerator extends MapGenerator {

	final private int amountOfRooms = 40;
	final private int maxLengthWall = 35;

	/**
	 * constructor
	 * 
	 * @param width
	 * @param heigth
	 */
	public RoomMapGenerator(int width, int heigth) {
		super(width, heigth);
	}

	/**
	 * generates starting coordinates and width and heigth of room sends info to
	 * makeRoom uses emptyK
	 */
	protected void generateMap() {
		super.generateMap();

		for (int i = 0; i <= amountOfRooms; i++) {
			int startX = (int) (Math.random() * (width - 10));
			int startY = (int) (Math.random() * (height - 10));
			int wallWidth = (int) (Math.random() * maxLengthWall) + 2;
			int wallHeigth = (int) (Math.random() * maxLengthWall) + 2;

			makeRoom(startX, startY, wallWidth, wallHeigth);
		}
		emptyK();
	}

	/**
	 * creates room by using starting coordinate and width and height no rooms
	 * within rooms by putting K's within and around
	 * 
	 * @param startX
	 * @param startY
	 * @param wallWidth
	 * @param wallHeigth
	 */
	private void makeRoom(int startX, int startY, int wallWidth, int wallHeigth) {
		// outerroomwalls width
		int door1 = (int) (startX + (Math.random() * (wallWidth - 2))) + 1;
		int door2 = (int) (startX + (Math.random() * (wallWidth - 2))) + 1;
		int door3 = (int) (startY + (Math.random() * (wallHeigth - 2))) + 1;
		int door4 = (int) (startY + (Math.random() * (wallHeigth - 2))) + 1;
		for (int w = startX; w < startX + wallWidth; w++) {
			if (w < width && map[w][startY] == ' ') {
				if (w == door1) {
					map[w][startY] = 'D';
				} else {
					map[w][startY] = '-';
				}
			}
			if (w < width && startY + wallHeigth < height
					&& map[w][startY + wallHeigth] == ' ') {
				if (w == door2) {
					map[w][startY + wallHeigth] = 'D';
				} else {
					map[w][startY + wallHeigth] = '-';
				}
			}
		}
		// outerroomwalls heigth
		for (int h = startY; h < startY + wallHeigth; h++) {
			if (h < height && map[startX][h] == ' ') {
				if (h == door3) {
					map[startX][h] = 'D';
				} else {
					map[startX][h] = '-';
				}
			}
			if (h < height && startX + wallWidth < width
					&& map[startX + wallWidth][h] == ' ') {
				if (h == door4) {
					map[startX + wallWidth][h] = 'D';
				} else {
					map[startX + wallWidth][h] = '-';
				}
			}
		}
		// lowerright corner
		if (startX + wallWidth < width && startY + wallHeigth < height
				&& map[startX + wallWidth][startY + wallHeigth] == ' ') {
			map[startX + wallWidth][startY + wallHeigth] = '-';
		}
		// no rooms within rooms:
		for (int cx = startX - 1; cx < startX + wallWidth + 1; cx++) {
			if (cx > 0 && cx < width) {
				for (int cy = startY - 1; cy < startY + wallHeigth + 1; cy++) {
					if (cy > 0 && cy < height && map[cx][cy] == ' ') {
						map[cx][cy] = 'K';
					}
				}
			}
		}
	}
}
