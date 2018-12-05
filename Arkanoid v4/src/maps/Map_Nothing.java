package maps;

import java.util.ArrayList;

import model.Block;
import model.Map;

public class Map_Nothing implements Map {
	ArrayList<Block> bricks = new ArrayList<Block>();
	@Override
	public ArrayList<Block> getBricks() {
		return bricks;
	}
	public Map_Nothing() {
		//bricks.add(new Block(390, 285));
	}

}
