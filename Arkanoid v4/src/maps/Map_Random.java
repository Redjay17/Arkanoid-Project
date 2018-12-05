package maps;

import java.util.ArrayList;
import java.util.Random;

import model.Block;
import model.Map;

public class Map_Random implements Map {
	
	ArrayList<Block> bricks = new ArrayList<Block>();
	
	@Override
	public ArrayList<Block> getBricks() {
		return bricks;
	}
	
	private static int maxHealth = 5;
	
	public Map_Random() {
		
		bricks = new ArrayList<Block>();
		Random rand = new Random();
		
		for(int y = 0; y < 27; y++)
			for(int x = 0; x < 34; x++)
				if(rand.nextInt(10) > 6)
					bricks.add(new Block(x*15, y*15, 1 + rand.nextInt(maxHealth)));

	}
}
