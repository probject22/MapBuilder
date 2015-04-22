import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class MapSaver {
	PrintWriter writer = null;
	boolean fileSizeSet = false;
	int widht, height = 0;
	int lineCounter = 0;
	public MapSaver(String filePath){
		newFile(filePath);
	}
	
	public void setSize(int width, int heigth){
		writer.println(heigth);
		writer.println(width);
		this.widht = width;
		this.height = heigth;
		fileSizeSet = true;
	}
	
	public void addLine(String line){
		if (!fileSizeSet){
			System.err.println("the mapsize is not set");
			return;
		}
		if (line.length() != widht){
			System.err.println("the length of the line is not correct");
			return;
		}
		writer.println(line);
	}
	public void closeMap(){
		if (lineCounter != height){
			System.err.println("the mapfile is corrupted");
		}
	}
	
	/**
	 * returns true if the file is made successfully
	 * @param filePath
	 * @return
	 */
	private boolean newFile(String filePath){
		try {
			writer = new PrintWriter(filePath, "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			writer = null;
			return false;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			writer = null;
			return false;
		}
		return true;
	}
}
