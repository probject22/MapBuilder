import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class RandomMapGenerator {
	private MapSaver mapSaver = null;
	private char[][] map;
	private int width;
	private int heigth;
	private int amountOfAgents;

	public RandomMapGenerator(int width, int heigth, int amountOfAgents) {
		this.width = width;
		this.heigth = heigth;
		this.amountOfAgents = amountOfAgents;
		
		generateMap();
		save();
	}
	
	private void generateMap(){
		for(int i = 0; i < width; i++){
			
		}
	}
	
	private void save(){
		
		mapSaver = new MapSaver("test.map");
		mapSaver.setSize(width, heigth);
		for(int i = 0; i<map[0].length; i++){
			//TODO add line
			mapSaver.addLine(line);
		}
		mapSaver.closeMap();
	}
	

	
}
