
public class RoomMapGenerator extends MapGenerator{
	
	final private int amountOfRooms = 40;
	final private int maxLengthWall = 35;
	
	public RoomMapGenerator(int width, int heigth) {
		super(width, heigth);
	}

	protected void generateMap() {
		super.generateMap();
		
		for(int i = 0; i <= amountOfRooms; i++){
			int startX = (int)(Math.random()*(width-10));
			int startY = (int)(Math.random()*(height-10));
			int wallWidth = (int)(Math.random()*maxLengthWall)+2;
			int wallHeigth = (int)(Math.random()*maxLengthWall)+2;
			//System.out.println(startX + "+" +startY + "+"+ wallWidth+"+"+wallHeigth);
			
			makeRoom(startX, startY, wallWidth, wallHeigth);
		}
		emptyK();
	}
	
	private void emptyK() {
		for(int i = 0; i<width; i++){
			for(int j = 0; j<height; j++){
				if(map[i][j] == 'K'){
					map[i][j] = ' ';
				}
			}
		}
	}
	
	private void makeRoom(int startX, int startY, int wallWidth, int wallHeigth){
		//outerroomwalls width
		int door1 = (int) (startX + (Math.random()*(wallWidth-2)))+1;
		int door2 = (int) (startX + (Math.random()*(wallWidth-2)))+1;
		int door3 = (int) (startY + (Math.random()*(wallHeigth-2)))+1;
		int door4 = (int) (startY + (Math.random()*(wallHeigth-2)))+1;
		for(int w = startX; w<startX+wallWidth; w++){
			if(w<width && map[w][startY] == ' '){
				if(w==door1){
					map[w][startY] = 'D';
				}
				else{
					map[w][startY] = '-';
				}
			}
			if(w<width && startY+wallHeigth<height && map[w][startY+wallHeigth] == ' '){
				if(w==door2){
					map[w][startY+wallHeigth] = 'D';
				}
				else{
					map[w][startY+wallHeigth] = '-';
				}
			}
		}
		//outerroomwalls heigth
		for(int h = startY; h<startY+wallHeigth; h++){
			if(h<height && map[startX][h] == ' ' ){
				if(h==door3){
					map[startX][h] = 'D';
				}
				else{
					map[startX][h] = '-';
				}
			}
			if(h<height && startX+wallWidth<width && map[startX+wallWidth][h] == ' '){
				if(h==door4){
					map[startX+wallWidth][h] = 'D';
				}
				else{
					map[startX+wallWidth][h] = '-';
				}
			}
		}
		//lowerright corner
		if(startX+wallWidth<width && startY+wallHeigth<height && map[startX+wallWidth][startY+wallHeigth]==' '){
			map[startX+wallWidth][startY+wallHeigth]='-';
		}
		//no rooms within rooms:
		for(int cx = startX; cx<startX+wallWidth; cx++){
			if(cx<width){
				for(int cy = startY; cy< startY+wallHeigth; cy++){
					if(cy<height && map[cx][cy]==' '){
						map[cx][cy]='K';
					}
				}
			}
		}
	}
}
