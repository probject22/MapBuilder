
public class MapGenerator {

	private MapSaver mapSaver = null;
	protected char[][] map;
	protected int width;
	protected int heigth;
	public MapGenerator(int width, int heigth){
		this.width = width;
		this.heigth = heigth;
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
		generateTarget();
	}

	protected void generateTarget() {
		boolean target=false;
		while(!target){
			int x =(int) (Math.random()*width);
			int y =(int) (Math.random()*heigth);
			if(map[x][y]==' '){
				map[x][y] = 'T';
				target = true;
			}
			
		}
		
	}

	private void generateOuterwalls(){
		map[width-1][heigth-1] = '+';
		for(int i = 0; i < width-1; i++){
			map[i][0] = '+';
			map[i][heigth-1] = '+';
		}
		for(int i = 0; i<heigth-1;i++){
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
			mapSaver.addLine(line);
		}
		mapSaver.closeMap();
	}
	
}
