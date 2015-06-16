/**
 * Places U s of different rotations and lengths on random spots on map
 * 
 * @author Hallmanns
 *
 */
public class URoomGenerator extends MapGenerator {

	private final int us = 100;
	private final int ulength = 25;

	/**
	 * constructor
	 * 
	 * @param width
	 * @param height
	 */
	public URoomGenerator(int width, int height) {
		super(width, height);
	}

	/**
	 * calculates starting point , rotation and length of U, send it to right
	 * rotation-method
	 */
	protected void generateMap() {
		super.generateMap();
		for (int i = 0; i < us; i++) {

			int rl = (int) (Math.random() * (ulength - 3)) + 3;
			int rx = (int) (Math.random() * (width - 8 - rl)) + 4;
			int ry = (int) (Math.random() * (height - 8 - rl)) + 4;
			int rr = (int) (Math.random() * 4);
			// rotation up
			if (rr == 0) {
				upU(rx, ry, rl);
			} else if (rr == 1) {
				rightU(rx, ry, rl);
			} else if (rr == 2) {
				downU(rx, ry, rl);
			} else {
				leftU(rx, ry, rl);
			}
			// Choose either to fill the square with K's or not
			// use surround to enable S shaped corridors
			// fullK(rl, rx, ry);
			surroundK(rl, rx, ry, rr);

		}
		emptyK();
	}

	/**
	 * surround the U with K's so lines won't touch, but S shaped corridors can
	 * be created
	 * 
	 * @param rl
	 *            : randomLength of U
	 * @param rx
	 *            : randomX startingpoint of U
	 * @param ry
	 *            : randomY startingpoint of U
	 * @param rr
	 *            : randomRotation of U
	 */
	private void surroundK(int rl, int rx, int ry, int rr) {

		// upper
		if (rr == 1 || rr == 2 || rr == 3) {
			for (int i = 0; i < rl + 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (map[rx - 1 + i][ry - 1 + j] == ' ') {
						map[rx - 1 + i][ry - 1 + j] = 'K';
					}
				}
			}
		}
		// down
		if (rr == 0 || rr == 1 || rr == 3) {
			for (int i = 0; i < rl + 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (map[rx - 1 + i][ry + rl - 1 + j] == ' ') {
						map[rx - 1 + i][ry + rl - 1 + j] = 'K';
					}
				}
			}
		}
		// left
		if (rr == 0 || rr == 1 || rr == 2) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < rl + 3; j++) {
					if (map[rx - 1 + i][ry - 1 + j] == ' ') {
						map[rx - 1 + i][ry - 1 + j] = 'K';
					}
				}
			}
		}
		// right
		if (rr == 0 || rr == 3 || rr == 2) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < rl + 3; j++) {
					if (map[rx + rl - 1 + i][ry - 1 + j] == ' ') {
						map[rx + rl - 1 + i][ry - 1 + j] = 'K';
					}
				}
			}
		}
	}

	/**
	 * create U with upside open
	 * 
	 * @param rx
	 *            : randomX startingpoint of U
	 * @param ry
	 *            : randomY startingpoint of U
	 * @param rl
	 *            : randomLength of U
	 */
	protected void upU(int rx, int ry, int rl) {

		// REMEMBER: ONE SIDE RL, OTHER SIDES RL-1
		map[rx][ry] = '-';
		map[rx + rl][ry] = '-';
		for (int i = 1; i <= rl; i++) {
			if (map[rx][ry + i] == ' ') {
				map[rx][ry + i] = '-';
			}
			if (map[rx + i][ry + rl] == ' ') {
				map[rx + i][ry + rl] = '-';
			}
			if (map[rx + rl][ry + i] == ' ') {
				map[rx + rl][ry + i] = '-';
			}
		}
	}

	/**
	 * create U with rightside open
	 * 
	 * @param rx
	 *            : randomX startingpoint of U
	 * @param ry
	 *            : randomY startingpoint of U
	 * @param rl
	 *            : randomLength of U
	 */
	protected void rightU(int rx, int ry, int rl) {

		// REMEMBER: ONE SIDE RL, OTHER SIDES RL-1
		map[rx][ry] = '-';
		for (int i = 1; i <= rl; i++) {
			if (map[rx][ry + i] == ' ') {
				map[rx][ry + i] = '-';
			}
			if (map[rx + i][ry] == ' ') {
				map[rx + i][ry] = '-';
			}
			if (map[rx + i][ry + rl] == ' ') {
				map[rx + i][ry + rl] = '-';
			}
		}
	}

	/**
	 * create U with downside open
	 * 
	 * @param rx
	 *            : randomX startingpoint of U
	 * @param ry
	 *            : randomY startingpoint of U
	 * @param rl
	 *            : randomLength of U
	 */
	protected void downU(int rx, int ry, int rl) {
		// REMEMBER: ONE SIDE RL, OTHER SIDES RL-1
		map[rx][ry] = '-';
		for (int i = 1; i <= rl; i++) {
			if (map[rx][ry + i] == ' ') {
				map[rx][ry + i] = '-';
			}
			if (map[rx + i][ry] == ' ') {
				map[rx + i][ry] = '-';
			}
			if (map[rx + rl][ry + i] == ' ') {
				map[rx + rl][ry + i] = '-';
			}
		}
	}

	/**
	 * create U with leftside open
	 * 
	 * @param rx
	 *            : randomX startingpoint of U
	 * @param ry
	 *            : randomY startingpoint of U
	 * @param rl
	 *            : randomLength of U
	 */
	protected void leftU(int rx, int ry, int rl) {
		// REMEMBER: ONE SIDE RL, OTHER SIDES RL-1
		map[rx][ry] = '-';
		map[rx][ry + rl] = '-';
		for (int i = 1; i <= rl; i++) {
			if (map[rx + i][ry] == ' ') {
				map[rx + i][ry] = '-';
			}
			if (map[rx + i][ry + rl] == ' ') {
				map[rx + i][ry + rl] = '-';
			}
			if (map[rx + rl][ry + i] == ' ') {
				map[rx + rl][ry + i] = '-';
			}
		}
	}

	/**
	 * fill square around U with K's so lines won't touch, S shaped corridors
	 * canNOT be created
	 * 
	 * @param rl
	 *            : randomLength of U
	 * @param rx
	 *            : randomX startingpoint of U
	 * @param ry
	 *            : randomY startingpoint of U
	 */
	protected void fullK(int rl, int rx, int ry) {
		for (int cx = 0; cx <= rl + 2; cx++) {
			for (int cy = 0; cy <= rl + 2; cy++) {
				if (map[rx + cx - 1][ry + cy - 1] == ' ') {
					map[rx + cx - 1][ry + cy - 1] = 'K';
				}
			}
		}
	}
}
