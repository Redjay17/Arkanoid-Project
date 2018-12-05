package edu.sjsu.cs151.model.maps;

import java.util.ArrayList;

import edu.sjsu.cs151.model.Block;
import edu.sjsu.cs151.model.Map;

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
