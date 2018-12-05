package edu.sjsu.cs151.model;

import java.util.ArrayList;

/**
 * I think the ability to add different maps is an example of a strategy pattern
 * In this case, the way we generate maps can benefit from variants of an
 * algorithm. Clients can replace the map that is generated with their own
 * custom versions. All they need is to return an arraylist of blocks, which
 * this interface ensures.
 * 
 * @author Leo_Le
 *
 */
public interface Map {
	public ArrayList<Block> getBricks();
}
