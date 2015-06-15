/**
 * creates map with randomly placed walls
 * 
 * @author Hallmanns
 *
 */
public class RandomMapGenerator extends MapGenerator {

	private int amountOfWalls = 75;

	/**
	 * constructor
	 * 
	 * @param width
	 * @param heigth
	 */
	public RandomMapGenerator(int width, int heigth) {
		super(width, heigth);

	}

	/**
	 * generates map place #amountOfWalls walls on random start coordinate,
	 * random rotation and random length with random chance of door
	 */
	protected void generateMap() {
		super.generateMap();

		double count = 0;
		// place wall by wall
		while (count < amountOfWalls) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			int lengthWall = (int) (Math.random() * 50);
			double rotation = Math.random();

			// door on this wall?
			double door = Math.random();
			boolean booleanDoor = false;
			if (door < 0.25) {
				booleanDoor = true;
			}
			int placeDoor = 0;
			if (booleanDoor == true) {
				placeDoor = (int) (Math.random() * (lengthWall - 1) + 1);
			}

			if (map[x][y] == ' ') {
				map[x][y] = '-';
				count++;
			}
			// place whole wall, brick by brick
			for (int i = 1; i < lengthWall; i++) {
				if (rotation < 0.5) {
					if (x + i < width && map[x + i][y] == ' ') {
						if (placeDoor == i) {
							map[x + i][y] = 'D';
						} else {
							map[x + i][y] = '-';
						}
					}
				} else {
					if (y + i < height && map[x][y + i] == ' ') {
						if (placeDoor == i) {
							map[x][y + i] = 'D';
						} else {
							map[x][y + i] = '-';
						}
					}
				}
			}
		}
	}
}
