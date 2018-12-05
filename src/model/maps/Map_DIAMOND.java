package model.maps;

import model.ConcreteMap;

public class Map_DIAMOND extends ConcreteMap {
	
	public void createMap() {
		for(int y = 0; y < 25; y++)
			for(int x = 0; x < 34; x++)
				if(x%2 == 1 && y%2 == 0||x%2 == 0 && y%2 == 1)
					this.addBlock(x*15, y*15, 1 + (y%5));

	}
}
