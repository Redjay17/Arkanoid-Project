package entities.maps;

import java.util.ArrayList;

/**
 * @author Leo_Le
 */

import entities.Block;
import entities.Map;

public class Map_DIAMOND extends Map {
	public Map_DIAMOND() {
		bricks = new ArrayList<Block>();
		
		for(int y = 0; y < 27; y++)
			for(int x = 0; x < 34; x++)
				if(x%2 == 1 && y%2 == 0||x%2 == 0 && y%2 == 1)
					bricks.add(new Block(x*15, y*15, 1 + (y%5)));

	}
}
