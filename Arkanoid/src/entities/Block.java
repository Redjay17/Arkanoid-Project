package entities;

import java.awt.Color;

import view.GamePanel;

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
	
	private int maxLives;
	private int lives;
	
	private Color color;
	
	public Block(int x, int y) {
		super(x, y, DEAULTSIZE, DEAULTSIZE);
		maxLives = DEAULTLIVES;
		lives = maxLives;
		this.changeColor();
	}
	
	public Block(int x, int y, int health) {
		this(x, y);
		maxLives = health;
		lives = maxLives;
		this.changeColor();
	}

	public void resetLives() {
		setLives(maxLives);
	}
	
	public int getMaxLives() {
		return maxLives;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void removeLife() {
		setLives(getLives() - 1);
		this.changeColor();
	}

	public boolean isDead() {
		return getLives() <= 0;
	}

	public void setLives(int lives) {
		this.lives = lives;
		this.changeColor();
	}
	
	private void changeColor() {
		if(this.isDead())
			color = GamePanel.backgroundColor;
		else
			switch(this.lives) {
			case 1:
				color = Color.blue;
				break;
			case 2:
				color = Color.CYAN;
				break;
			case 3:
				color = Color.ORANGE;
				break;
			case 4:
				color = Color.RED;
				break;
			case 5:
				color = Color.white;
				break;
			default:
				color = new Color(10 + maxLives, 10 + maxLives, 10 + maxLives);
			}
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public String toString() {
		return "Rect: " + getX() + " " 
				+ getY() + " " 
				+ getWidth() + " " 
				+ getLength() + " "
				+ "h: " + lives;
}
}
