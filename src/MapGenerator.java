
public class MapGenerator {

	private MapSaver mapSaver = null;
	protected char[][] map;
	protected int width;
	protected int height;
	
	public MapGenerator(int width, int height){
		this.width = width;
		this.height = height;
		map = new char[width][height];
		for(int i =0;i<width;i++){
			for(int j =0; j<height;j++){
				map[i][j]= ' ';
			}
		}
		generateMap();
		generateTarget();
		save();
	}

	protected void generateMap() {
		generateOuterwalls();
	}

	protected void generateTarget() {
		boolean target=false;
		while(!target){
			int x =(int) (Math.random()*width);
			int y =(int) (Math.random()*height);
			if(map[x][y]==' '){
				map[x][y] = 'T';
				target = true;
			}
			
		}
		
	}

	private void generateOuterwalls(){
		map[width-1][height-1] = '+';
		for(int i = 0; i < width-1; i++){
			map[i][0] = '+';
			map[i][height-1] = '+';
		}
		for(int i = 0; i<height-1;i++){
			map[0][i] = '+';
			map[width-1][i] = '+';
		}
	}
	
	private void save(){
		
		mapSaver = new MapSaver("test.map");
		mapSaver.setSize(width, height);
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
