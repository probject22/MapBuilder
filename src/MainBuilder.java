import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class MainBuilder {
	
	protected static int height = 100;
	protected static int width = 100;

	public static void main (String[] args){
		
		//MapGenerator mapGen = new MapGenerator(width, height);
		//RandomMapGenerator mapGen =  new RandomMapGenerator(width, height);
		//RoomMapGenerator mapGen = new RoomMapGenerator(width, height);
		SplitRoomGenerator mapGen = new SplitRoomGenerator(width, height);
		
	}
	
}
