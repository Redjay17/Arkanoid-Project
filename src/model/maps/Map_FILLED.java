package model.maps;

import java.util.ArrayList;

import model.Block;
import model.Map;

public class Map_FILLED implements Map {
	ArrayList<Block> bricks = new ArrayList<Block>();
	@Override
	public ArrayList<Block> getBricks() {
		return bricks;
	}
	public Map_FILLED() {
		bricks = new ArrayList<Block>();
		
		for(int y = 0; y < 25; y++)
			for(int x = 0; x < 34; x++)
				bricks.add(new Block(x*15, y*15));

	}
}
