package model.maps;

import java.util.ArrayList;
import java.util.Random;

import model.Block;
import model.Map;

public class Map_Random implements Map {
	
	ArrayList<Block> bricks = new ArrayList<Block>();
	
	@Override
	public ArrayList<Block> getBricks() {
		this.generateMap();
		return bricks;
	}
	
	private static int maxHealth = 5;
	
	public Map_Random() {
		this.generateMap();
	}
	
	private void generateMap() {
		bricks = new ArrayList<Block>();
		Random rand = new Random();
		
		for(int y = 0; y < 25; y++)
			for(int x = 0; x < 34; x++)
				if(rand.nextInt(10) > 6)
					bricks.add(new Block(x*15, y*15, 1 + rand.nextInt(maxHealth)));
	}
}
