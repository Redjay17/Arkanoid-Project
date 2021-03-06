package edu.sjsu.cs.cs151.model.maps;

import edu.sjsu.cs.cs151.model.ConcreteMap;
/**
 * Map created through a defined pattern.
 * Used to test collision.
 * @author Redjay
 *
 */
public class Map_FILLED extends ConcreteMap {
	public void createMap() {
		for(int y = 0; y < 25; y++)
			for(int x = 0; x < 34; x++)
				this.addBlock(x*15, y*15);
	}
}
