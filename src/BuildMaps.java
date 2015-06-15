import java.io.File;


public class BuildMaps {

	String path = "";
	
	public BuildMaps(int batches, int amount, int size) {
		for (int batch = 0; batch < batches; batch++) {
			File dir = new File("batch" + batch);
			dir.mkdir();
			for (int i = 0; i < amount; i++) {
				String name = "batch" + batch + "/maze-" + size + "x" + size + "-" + i + ".map";

				MapSaver saver = new MapSaver(path + name);
				saver.setSize(size, size);

				//RandomMapGenerator mapGen =  new RandomMapGenerator(size, size);
				//RoomMapGenerator mapGen = new RoomMapGenerator(size, size);
				//SplitRoomGenerator mapGen = new SplitRoomGenerator(size, size);
				RandomSplitRoomGenerator mapGen = new RandomSplitRoomGenerator(size, size);
				//URoomGenerator mapGen = new URoomGenerator(size, size);
				//StaticURoomGenerator mapGen = new StaticURoomGenerator(size, size);
				
				for (int j = 0; j < mapGen.getMap().length; j++) {
					String line = "";
					for (int l = 0; l < mapGen.getMap()[0].length; l++) {
						line += mapGen.getMap()[j][l];
					}
					saver.addLine(line);
				}
				saver.closeMap();
			}
		}
	}
}
