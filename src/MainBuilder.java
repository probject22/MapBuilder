

public class MainBuilder {
	
	protected static int height = 50;
	protected static int width = 50;

	public static void main (String[] args){
		
		//REMEMBER TO CHANGE SAVER SETTINGS!!!!!!!!
		
		//MapGenerator mapGen = new MapGenerator(width, height);
		//RandomMapGenerator mapGen =  new RandomMapGenerator(width, height);
		//RoomMapGenerator mapGen = new RoomMapGenerator(width, height);
		//SplitRoomGenerator mapGen = new SplitRoomGenerator(width, height);
		RandomSplitRoomGenerator mapGen = new RandomSplitRoomGenerator(width, height);
		//URoomGenerator mapGen = new URoomGenerator(width, height);
		//StaticURoomGenerator mapGen = new StaticURoomGenerator(width, height);
		//BuildMaps mapBuilder = new BuildMaps(2, 5, 20);
	}
	
}
