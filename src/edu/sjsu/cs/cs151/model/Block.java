package edu.sjsu.cs.cs151.model;

import java.awt.Color;

import edu.sjsu.cs.cs151.view.GamePanel;

/**
 * Block is the object that the ball must hit in order to clear the map.
 * Blocks are displayed or not displayed depending on that Block's number of lives. 
 * Blocks that have been destroyed are set to the color of the background.
 * Blocks, when destroyed, give a base score of 10 multiplied by the block's health.
 * 
 * @author Leo_Le
 * @author Redjay
 *
 */
public class Block extends Rect {
	public static final int DEAULTLIVES = 1;
	public static final int DEAULTSIZE = 15;
	public static final int BASESCORE = 10;
	
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
	
	/**
	 * Reseting lives simply sets the block's health to its maximum
	 * maxLives is defined when the block was made.
	 * 
	 */
	public void resetLives() {
		this.setLives(maxLives);
	}
	
	public int getMaxLives() {
		return maxLives;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void setLives(int lives) {
		this.lives = lives;
		this.changeColor();
	}
	
	/**
	 * Decreases live by 1 and changes color of the block.
	 */
	public void removeLife() {
		this.setLives(getLives() - 1);
		this.changeColor();
	}
	
	/**
	 * @return If the block's life is less than 0
	 */
	public boolean isDead() {
		return getLives() <= 0;
	}
	
	/**
	 * Sets the block's color according to it's life.
	 * Must always have the block's <0 life color be the color of the background to give the illusion of death.
	 */
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
