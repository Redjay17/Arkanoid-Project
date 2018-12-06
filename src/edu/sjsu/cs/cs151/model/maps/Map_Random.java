package edu.sjsu.cs.cs151.model.maps;

import java.util.Random;

import edu.sjsu.cs.cs151.model.ConcreteMap;
/**
 * Map created through a defined pattern.
 * Used to randomly create a map.
 * This is the only map in this program that must requires the use of the clearMap method.
 * @author Redjay
 *
 */
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
