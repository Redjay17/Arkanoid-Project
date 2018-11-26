package entities;

import java.awt.Color;

import main.Controller;

/**
 * Player is the paddle.
 * @author Leo_Le
 *
 */
public class Player extends Rect {
	public static final int DEFAULTPLAYERWIDTH = 80;
	public static final int DEFAULTPLAYERLENGTH = 10;

	private int moveSpeed = 35;
	private Color color;
	

	public Player() {
		super(Controller.FIELDWIDTH / 2 - DEFAULTPLAYERWIDTH / 2,
				Controller.FIELDLENGTH - DEFAULTPLAYERLENGTH - 40,
				DEFAULTPLAYERWIDTH,
				DEFAULTPLAYERLENGTH);
		color = Color.cyan;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public void reset() {

	}
	
	public Color getColor() {
		return this.color;
	}

}
