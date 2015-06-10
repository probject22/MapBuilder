
public class RandomMapGenerator extends MapGenerator{

	private int amountOfWalls = 75;
	
	public RandomMapGenerator(int width, int heigth){
		super(width, heigth);
		
	}
	
	protected void generateMap() {
		super.generateMap();
		
		double count = 0;
		while( count < amountOfWalls){
			int x = (int) (Math.random()*width);
			int y = (int) (Math.random()*heigth);
			int lengthWall = (int) (Math.random()*50);
			double rotation = Math.random();
			
			//door on this wall?
			double door = Math.random();
			boolean booleanDoor = false;
			if(door<0.25){
				booleanDoor = true;
			}
			int placeDoor = 0;
			if(booleanDoor == true){
				placeDoor = (int) (Math.random()*(lengthWall-1)+1);
			}
			
			if(map[x][y] == ' '){
				map[x][y] = '-';
				count ++;
			}
			for(int i = 1; i < lengthWall; i++){
				if(rotation<0.5){
					if(x+i<width&&map[x+i][y]== ' '){
						if(placeDoor == i){
							map[x+i][y] = 'D';
						}
						else{
							map[x+i][y] = '-';
						}
					}
				}
				else{
					if(y+i<heigth&&map[x][y+i]== ' '){
						if(placeDoor == i){
							map[x][y+i] = 'D';
						}
						else{
							map[x][y+i] = '-';
						}
					}		
				}
			}
			
		}
		
	}
	
}
