
public class MapGenerator {

	private MapSaver mapSaver = null;
	protected char[][] map;
	protected int width;
	protected int height;
	protected boolean emptyCorner = true;
	
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
		if(emptyCorner){
			emptyCorners();
		}
		save();
	}

	protected void generateMap() {
		generateOuterwalls();
	}

	private void generateTarget() {
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

	protected void generateOuterwalls(){
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
	
	private void emptyCorners(){
		map[1][1] = ' ';
		map[2][1] = ' ';
		map[1][2] = ' ';
		
		map[1][height-2] = ' ';
		map[1][height-3] = ' ';
		map[2][height-2] = ' ';
		
		map[width-2][1] = ' ';
		map[width-2][2] = ' ';
		map[width-3][1] = ' ';
		
		map[width-2][height-2] = ' ';
		map[width-3][height-2] = ' ';
		map[width-2][height-3] = ' ';
		
		if(isEven(width)){
			if(isEven(height)){
				map[width/2][height/2] = ' ';
				map[width/2+1][height/2] = ' ';
				map[width/2][height/2+1] = ' ';
				map[width/2+1][height/2+1] = ' ';
			}
			else{
				map[width/2][(int)(height/2)+1] = ' ';
				map[width/2+1][(int)(height/2)+1] = ' ';
			}
		}
		else{
			if(isEven(height)){
				map[(int)(width/2)+1][height/2] = ' ';
				map[(int)(width/2)+1][height/2+1] = ' ';
			}
			else{
				map[(int)(width/2)+1][(int)(height/2)+1] = ' ';
			}
		}
		
	}
	
	protected boolean isEven(int number) {
		if ((number & 1) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	protected void emptyK() {
		for(int i = 0; i<width; i++){
			for(int j = 0; j<height; j++){
				if(map[i][j] == 'K'){
					map[i][j] = ' ';
				}
			}
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
