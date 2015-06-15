import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Saves map
 * 
 * @author Hallmanns
 *
 */
public class MapSaver {
	PrintWriter writer = null;
	boolean fileSizeSet = false;
	int width, height = 0;
	int lineCounter = 0;

	/**
	 * Constructor
	 * 
	 * @param filePath
	 */
	public MapSaver(String filePath) {
		newFile(filePath);
	}

	/**
	 * sets sizes of map
	 * 
	 * @param width
	 * @param heigth
	 */
	public void setSize(int width, int heigth) {
		writer.println(heigth);
		writer.println(width);
		this.width = width;
		this.height = heigth;
		fileSizeSet = true;
	}

	/**
	 * adds one row of map to file
	 * 
	 * @param line
	 *            : one row of map
	 */
	public void addLine(String line) {
		if (!fileSizeSet) {
			System.err.println("the mapsize is not set");
			// return;
		}
		if (line.length() != width) {
			System.err.println("the length of the line is not correct");
			// return;
		}
		System.out.println(line);
		writer.println(line);
		lineCounter++;
	}

	/**
	 * closes map and writer
	 */
	public void closeMap() {
		System.out.println("linecounter=" + lineCounter);
		if (lineCounter != height) {
			System.err.println("the mapfile is corrupted");
		}
		writer.flush();
		writer.close();
	}

	/**
	 * creates new file
	 * 
	 * @param filePath
	 * @return true if the file is made successfully
	 */
	private boolean newFile(String filePath) {
		try {
			writer = new PrintWriter(filePath, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			writer = null;
			return false;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			writer = null;
			return false;
		}
		return true;
	}
}
