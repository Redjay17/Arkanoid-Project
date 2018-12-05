package edu.sjsu.cs151.model.maps;


/**
 * @author Leo_Le
 */
import java.util.ArrayList;

import edu.sjsu.cs151.model.Block;
import edu.sjsu.cs151.model.Map;

public class Map_OWO implements Map {
	ArrayList<Block> bricks = new ArrayList<Block>();
	@Override
	public ArrayList<Block> getBricks() {
		return bricks;
	}
	public Map_OWO() {
		bricks = new ArrayList<Block>();
		bricks.add(new Block(135, 120));
		bricks.add(new Block(150, 120));
		bricks.add(new Block(165, 120));
		bricks.add(new Block(180, 135));
		bricks.add(new Block(195, 150));
		bricks.add(new Block(210, 165));
		bricks.add(new Block(210, 180));
		bricks.add(new Block(210, 195));
		bricks.add(new Block(195, 210));
		bricks.add(new Block(180, 225));
		bricks.add(new Block(165, 240));
		bricks.add(new Block(150, 240));
		bricks.add(new Block(135, 240));
		bricks.add(new Block(120, 225));
		bricks.add(new Block(105, 210));
		bricks.add(new Block(90, 195));
		bricks.add(new Block(90, 180));
		bricks.add(new Block(90, 165));
		bricks.add(new Block(105, 150));
		bricks.add(new Block(120, 135));
		bricks.add(new Block(270, 195));
		bricks.add(new Block(270, 180));
		bricks.add(new Block(270, 165));
		bricks.add(new Block(285, 150));
		bricks.add(new Block(300, 135));
		bricks.add(new Block(315, 120));
		bricks.add(new Block(330, 120));
		bricks.add(new Block(345, 120));
		bricks.add(new Block(360, 135));
		bricks.add(new Block(375, 150));
		bricks.add(new Block(390, 165));
		bricks.add(new Block(390, 180));
		bricks.add(new Block(390, 195));
		bricks.add(new Block(375, 210));
		bricks.add(new Block(360, 225));
		bricks.add(new Block(345, 240));
		bricks.add(new Block(330, 240));
		bricks.add(new Block(315, 240));
		bricks.add(new Block(300, 225));
		bricks.add(new Block(285, 210));
		bricks.add(new Block(225, 105));
		bricks.add(new Block(210, 90));
		bricks.add(new Block(195, 75));
		bricks.add(new Block(180, 60));
		bricks.add(new Block(165, 45));
		bricks.add(new Block(270, 105));
		bricks.add(new Block(285, 90));
		bricks.add(new Block(300, 75));
		bricks.add(new Block(315, 60));
		bricks.add(new Block(330, 45));
		bricks.add(new Block(150, 300));
		bricks.add(new Block(150, 315));
		bricks.add(new Block(150, 330));
		bricks.add(new Block(150, 345));
		bricks.add(new Block(165, 360));
		bricks.add(new Block(180, 360));
		bricks.add(new Block(195, 360));
		bricks.add(new Block(210, 345));
		bricks.add(new Block(225, 330));
		bricks.add(new Block(240, 315));
		bricks.add(new Block(240, 300));
		bricks.add(new Block(240, 285));
		bricks.add(new Block(255, 330));
		bricks.add(new Block(270, 345));
		bricks.add(new Block(285, 360));
		bricks.add(new Block(300, 360));
		bricks.add(new Block(315, 360));
		bricks.add(new Block(330, 345));
		bricks.add(new Block(330, 330));
		bricks.add(new Block(330, 315));
		bricks.add(new Block(330, 300));

	}
}
