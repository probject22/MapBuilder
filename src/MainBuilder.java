import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class MainBuilder {
	
	private static int height = 200;
	private static int width = 200;
	private static int amountOfAgents = 10;

	public static void main (String[] args){
		
		//MapGenerator mapGen = new MapGenerator(width, height, amountOfAgents);
		RandomMapGenerator mapGen =  new RandomMapGenerator(width, height, amountOfAgents);
		
	}
	
}
