package model.maps;

import java.util.ArrayList;

import model.Block;
import model.Map;

public class Map_FILLED extends Map {
	public Map_FILLED() {
		bricks = new ArrayList<Block>();
		
		for(int y = 0; y < 27; y++)
			for(int x = 0; x < 34; x++)
				bricks.add(new Block(x*15, y*15));

	}
}
