package entities;

import java.awt.Color;

/**
 * Rectangles are displayed or not displayed depending on that rectangle's
 * number of lives. Rectangles that are not displayed are just set to the same
 * background color :')
 * 
 * @author Leo_Le
 *
 */
public class Block extends Rect {
	public static final int DEAULTLIVES = 1;
	public static final int DEAULTSIZE = 15;
	
	private int lives = 1;
	
	private Color blockColorAlive;
	private Color blockColorDead;

	public Block(int x, int y) {
		super(x, y, DEAULTSIZE, DEAULTSIZE);
		blockColorAlive = new Color(109, 239, 161);
		blockColorDead = Color.gray;
	}
	
	public Block(int x, int y, int size) {
		super(x, y, size, size);
		blockColorAlive = new Color(109, 239, 161);
		blockColorDead = Color.gray;
	}

	public void resetLives() {
		setLives(DEAULTLIVES);
	}
	public int getLives() {
		return lives;
	}

	public void removeLife() {
		setLives(getLives() - 1);
	}

	public boolean isDead() {
		return getLives() == 0;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public Color getColor() {
		if(!this.isDead())
			return this.blockColorAlive;
		return this.blockColorDead;
	}

}
