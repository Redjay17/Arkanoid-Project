package edu.sjsu.cs151.Model;
import java.util.ArrayList;

/**
 * Things that load maps need to take in obects of type map. Which is why all
 * maps will extend map
 * 
 * @author Leo_Le
 *
 */
public class Map {
	ArrayList<Brick> bricks = new ArrayList<Brick>();

	public ArrayList<Brick> getBricks() {
		return bricks;
	}

	// public void paint(Graphics gr) {
	// Graphics2D g = (Graphics2D) gr;
	// for (Brick brick : bricks) {
	// g.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getLength());
	// }
	// }
	//
	// public void removeBrick(int i) {
	// bricks.remove(i);
	// System.out.print("Map removed: ");
	// bricks.get(i).printInfo();
	// }
	//
	// public Brick getBrick(int i) {
	// return bricks.get(i);
	// }
	//
	// public void printBrick(int i) {
	// Brick brick = bricks.get(i);
	// System.out.println("Map Brick: " + brick.getX() + " " + brick.getY() + " " +
	// brick.getWidth() + " "
	// + brick.getLength() + " " + brick.getLives());
	// }
}
