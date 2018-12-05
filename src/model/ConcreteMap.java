package model;

import java.util.ArrayList;

public abstract class ConcreteMap implements Map {
	private ArrayList<Block> blockMap;
	
	public ConcreteMap() {
		this.blockMap = new ArrayList<Block>();
		this.createMap();
	}
	
	public ArrayList<Block> getMap(){
		return this.blockMap;
	}
	
	public void resetMap() {
		for(Block b: this.blockMap) {
			b.resetLives();
		}
	}
	
	public void addBlock(int x, int y) {
		this.blockMap.add(new Block(x, y));
	}
	
	public void addBlock(int x, int y, int health) {
		this.blockMap.add(new Block(x, y, health));
	}
	
	public void clearMap() {
		this.blockMap = new ArrayList<Block>();
	}
	
	public abstract void createMap();
}
