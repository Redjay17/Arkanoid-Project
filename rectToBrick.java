package MapGenerator3_UI_Friendlier;

import java.util.ArrayList;

public class rectToBrick {

	public static void main(String[] args) {
		ArrayList<Rect> bricks = new ArrayList<Rect>();
		bricks.add(new Rect(200, 75, 25, 25));
		bricks.add(new Rect(200, 100, 25, 25));
		bricks.add(new Rect(225, 125, 25, 25));
		bricks.add(new Rect(250, 100, 25, 25));
		bricks.add(new Rect(250, 75, 25, 25));
		bricks.add(new Rect(225, 50, 25, 25));
		bricks.add(new Rect(200, 150, 25, 25));
		bricks.add(new Rect(175, 175, 25, 25));
		bricks.add(new Rect(200, 175, 25, 25));
		bricks.add(new Rect(225, 175, 25, 25));
		bricks.add(new Rect(275, 175, 25, 25));
		bricks.add(new Rect(250, 175, 25, 25));
		bricks.add(new Rect(250, 150, 25, 25));
		bricks.add(new Rect(150, 200, 25, 25));
		bricks.add(new Rect(125, 175, 25, 25));
		bricks.add(new Rect(125, 150, 25, 25));
		bricks.add(new Rect(125, 125, 25, 25));
		bricks.add(new Rect(125, 75, 25, 25));
		bricks.add(new Rect(125, 100, 25, 25));
		bricks.add(new Rect(300, 200, 25, 25));
		bricks.add(new Rect(325, 175, 25, 25));
		bricks.add(new Rect(325, 150, 25, 25));
		bricks.add(new Rect(325, 125, 25, 25));
		bricks.add(new Rect(325, 100, 25, 25));
		bricks.add(new Rect(325, 75, 25, 25));
		bricks.add(new Rect(125, 225, 25, 25));
		bricks.add(new Rect(100, 250, 25, 25));
		bricks.add(new Rect(75, 275, 25, 25));
		bricks.add(new Rect(100, 275, 25, 25));
		bricks.add(new Rect(125, 275, 25, 25));
		bricks.add(new Rect(150, 275, 25, 25));
		bricks.add(new Rect(175, 275, 25, 25));
		bricks.add(new Rect(200, 275, 25, 25));
		bricks.add(new Rect(225, 275, 25, 25));
		bricks.add(new Rect(250, 275, 25, 25));
		bricks.add(new Rect(275, 275, 25, 25));
		bricks.add(new Rect(300, 275, 25, 25));
		bricks.add(new Rect(325, 275, 25, 25));
		bricks.add(new Rect(350, 275, 25, 25));
		bricks.add(new Rect(375, 275, 25, 25));
		bricks.add(new Rect(350, 250, 25, 25));
		bricks.add(new Rect(325, 225, 25, 25));
		bricks.add(new Rect(200, 250, 25, 25));
		bricks.add(new Rect(225, 225, 25, 25));
		bricks.add(new Rect(250, 250, 25, 25));
		bricks.add(new Rect(150, 300, 25, 25));
		bricks.add(new Rect(150, 325, 25, 25));
		bricks.add(new Rect(150, 350, 25, 25));
		bricks.add(new Rect(150, 375, 25, 25));
		bricks.add(new Rect(125, 375, 25, 25));
		bricks.add(new Rect(100, 375, 25, 25));
		bricks.add(new Rect(300, 300, 25, 25));
		bricks.add(new Rect(300, 325, 25, 25));
		bricks.add(new Rect(300, 350, 25, 25));
		bricks.add(new Rect(300, 375, 25, 25));
		bricks.add(new Rect(325, 375, 25, 25));
		bricks.add(new Rect(350, 375, 25, 25));
		bricks.add(new Rect(250, 375, 25, 25));
		bricks.add(new Rect(275, 375, 25, 25));
		bricks.add(new Rect(200, 375, 25, 25));
		bricks.add(new Rect(175, 375, 25, 25));


		
		for(Rect rect : bricks) {
		System.out.println("bricks.add(new Brick("+ rect.x + ", " + rect.y +", " +rect.width +", " +rect.length + "));" );
		}


	}

}
