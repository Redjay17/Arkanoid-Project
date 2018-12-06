package edu.sjsu.cs.cs151.model;

import java.util.ArrayList;
/**
 * ConcreteMap implements the interface map. 
 * All maps created in the maps package extends the ConcreteMap.
 * @author Redjay
 *
 */
public abstract class ConcreteMap implements Map {
	private ArrayList<Block> blockMap;
	
	public ConcreteMap() {
		this.blockMap = new ArrayList<Block>();
		this.createMap();
	}
	
	/**
	 * Returns a copy of the map.
	 */
	public ArrayList<Block> getMap(){
		return new ArrayList<Block>(this.blockMap);
	}
	
	/**
	 * Sets each block's health to its default health.
	 */
	public void resetMap() {
		for(Block b: this.blockMap) {
			b.resetLives();
		}
	}
	
	/**
	 * Adds a block based on the coordinates given in the param
	 * @param x coordinate
	 * @param y coordinate
	 */
	public void addBlock(int x, int y) {
		this.blockMap.add(new Block(x, y));
	}
	
	/**
	 * Adds a block based on the coordinates given in the param. 
	 * Is also set with health more than one.
	 * @param x
	 * @param y
	 * @param health
	 */
	public void addBlock(int x, int y, int health) {
		this.blockMap.add(new Block(x, y, health));
	}
	
	/**
	 * Should only be used if a map has features that are randomly generated.
	 * Do not use in any other circumstance.
	 */
	@Deprecated
	public void clearMap() {
		this.blockMap = new ArrayList<Block>();
	}
	
	/**
	 * Left to be implemented in other maps.
	 */
	public abstract void createMap();
}
