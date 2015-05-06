
public class MapGenerator {

	private MapSaver mapSaver = null;
	protected char[][] map;
	protected int width;
	protected int heigth;
	protected int amountOfAgents;

	public MapGenerator(int width, int heigth, int amountOfAgents){
		this.width = width;
		this.heigth = heigth;
		this.amountOfAgents = amountOfAgents;
		map = new char[width][heigth];
		for(int i =0;i<width;i++){
			for(int j =0; j<heigth;j++){
				map[i][j]= ' ';
			}
		}
		
		generateMap();
		save();
	}
	
	protected void generateMap() {
		generateOuterwalls();
	}

	private void generateOuterwalls(){
		map[0][0] = '+';
		map[width-1][heigth-1] = '+';
		for(int i = 1; i < width-2; i++){
			map[i][0] = '+';
			map[i][heigth-1] = '+';
		}
		for(int i = 0; i<heigth-2;i++){
			map[0][i] = '+';
			map[width-1][i] = '+';
		}
	}
	
	private void save(){
		
		mapSaver = new MapSaver("test.map");
		mapSaver.setSize(width, heigth);
		for(int i = 0; i<map[0].length; i++){
			String line = "";
			for(int j = 0; j < width; j++){
				line += map[j][i];
			}
			System.out.println(line);
			mapSaver.addLine(line);
		}
		mapSaver.closeMap();
	}
	
}
