package model;

import java.awt.Color;

/**
 * The ball. Turns out the physics of the ball is just in swapping xDir / yDir
 * to make it change directions and stuff
 * 
 * @author Leo_Le
 *
 */
public class Ball extends Rect {
	public final static int DEFAULTSIZE = 10;
	public static final int DEFAULTXDIR = 1;
	public static final int DEFAULTYDIR = 2;
	
	int xDir;
	int yDir;
	int size;
	
	private Color color;

	public Ball(int x, int y, int width, int length) {
		super(x, y, width, length);
		size = DEFAULTSIZE;
		xDir = 0;
		yDir = 0;
		color = Color.orange;
	}

	/**
	 * Ball's location during the initial creation is relative to player.
	 * 
	 * @param player
	 */
	public Ball(Player player) {
		this(player.getX() + player.getWidth() / 2 - DEFAULTSIZE / 2,
				player.getY() - DEFAULTSIZE - 2,
				DEFAULTSIZE,
				DEFAULTSIZE
				);
	}

	public int getxDir() {
		return xDir;
	}

	public void setxDir(int xDir) {
		this.xDir = xDir;
	}

	public int getyDir() {
		return yDir;
	}

	public void setyDir(int yDir) {
		this.yDir = yDir;
	}

	public void changexDir() {
		xDir = -xDir;
	}

	public void changeyDir() {
		yDir = -yDir;
	}
	
	public int getSize() {
		return size;
	}
	
	public Color getColor() {
		return this.color;
	}

}
