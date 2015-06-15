/**
 * superclass of MapGenerator. Basic features are in here
 * 
 * @author Hallmanns
 *
 */
public class MapGenerator {

	private MapSaver mapSaver = null;
	protected char[][] map;
	protected int width;
	protected int height;
	protected boolean emptyCorner = true;

	/**
	 * MapGenerator constructor generates walls, target, clears corners and
	 * saves map
	 * 
	 * @param width
	 * @param height
	 */
	public MapGenerator(int width, int height) {
		this.width = width;
		this.height = height;
		map = new char[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				map[i][j] = ' ';
			}
		}
		generateMap();
		generateTarget();
		if (emptyCorner) {
			emptyCorners();
		}
		// for experiments, do not save here!
		save();
	}

	public char[][] getMap() {
		return map;
	}

	/**
	 * generates outerwalls to be extended in subclasses
	 */
	protected void generateMap() {
		generateOuterwalls();
	}

	/**
	 * places target on random spot
	 */
	private void generateTarget() {
		boolean target = false;
		while (!target) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			if (map[x][y] == ' ') {
				map[x][y] = 'T';
				target = true;
			}

		}

	}

	/**
	 * generate outer walls
	 */
	protected void generateOuterwalls() {
		map[width - 1][height - 1] = '+';
		for (int i = 0; i < width - 1; i++) {
			map[i][0] = '+';
			map[i][height - 1] = '+';
		}
		for (int i = 0; i < height - 1; i++) {
			map[0][i] = '+';
			map[width - 1][i] = '+';
		}
	}

	/**
	 * empty corners and middle to put agents there
	 */
	private void emptyCorners() {
		map[1][1] = ' ';
		map[2][1] = ' ';
		map[1][2] = ' ';

		map[1][height - 2] = ' ';
		map[1][height - 3] = ' ';
		map[2][height - 2] = ' ';

		map[width - 2][1] = ' ';
		map[width - 2][2] = ' ';
		map[width - 3][1] = ' ';

		map[width - 2][height - 2] = ' ';
		map[width - 3][height - 2] = ' ';
		map[width - 2][height - 3] = ' ';

		if (isEven(width)) {
			if (isEven(height)) {
				map[width / 2][height / 2] = ' ';
				map[width / 2 + 1][height / 2] = ' ';
				map[width / 2][height / 2 + 1] = ' ';
				map[width / 2 + 1][height / 2 + 1] = ' ';
			} else {
				map[width / 2][(int) (height / 2) + 1] = ' ';
				map[width / 2 + 1][(int) (height / 2) + 1] = ' ';
			}
		} else {
			if (isEven(height)) {
				map[(int) (width / 2) + 1][height / 2] = ' ';
				map[(int) (width / 2) + 1][height / 2 + 1] = ' ';
			} else {
				map[(int) (width / 2) + 1][(int) (height / 2) + 1] = ' ';
			}
		}

	}

	/**
	 * checks if number is even
	 * 
	 * @param number
	 * @return true if even
	 */
	protected boolean isEven(int number) {
		if ((number & 1) == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * clears map from K's K's can be used to make sure walls won't be placed
	 * too near etc
	 */
	protected void emptyK() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (map[i][j] == 'K') {
					map[i][j] = ' ';
				}
			}
		}
	}

	/**
	 * saves map
	 */
	private void save() {

		mapSaver = new MapSaver("test.map");
		mapSaver.setSize(width, height);
		for (int i = 0; i < map[0].length; i++) {
			String line = "";
			for (int j = 0; j < width; j++) {
				line += map[j][i];
			}
			mapSaver.addLine(line);
		}
		mapSaver.closeMap();
	}

}
