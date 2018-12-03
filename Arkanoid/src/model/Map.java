package model;

import java.util.ArrayList;

import model.Block;

/**
 * Things that load maps need to take in obects of type map. Which is why all
 * maps will extend map
 * 
 * @author Leo_Le
 *
 */
public class Map {
	protected ArrayList<Block> bricks;
	
	public Map() {
		bricks = new ArrayList<Block>(); 
	}

	public ArrayList<Block> getBricks() {
		return bricks;
	}
}
