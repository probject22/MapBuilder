import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class MainBuilder {
	
	private static int height = 100;
	private static int width = 100;

	public static void main (String[] args){
		
		//MapGenerator mapGen = new MapGenerator(width, height, amountOfAgents);
		RandomMapGenerator mapGen =  new RandomMapGenerator(width, height);
		
	}
	
}
