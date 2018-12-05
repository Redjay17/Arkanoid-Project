package model.maps;

import java.util.Random;

import model.ConcreteMap;

public class Map_Random extends ConcreteMap {
	
	public void resetMap() {
		this.clearMap();
		this.createMap();
	}
	
	public void createMap() {
		this.clearMap();
		Random rand = new Random();
		
		for(int y = 0; y < 25; y++)
			for(int x = 0; x < 34; x++)
				if(rand.nextInt(10) > 6)
					this.addBlock(x*15, y*15, 1 + rand.nextInt(5));
	}
}
