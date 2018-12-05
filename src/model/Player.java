package model;

import java.awt.Color;

import controller.Controller;

/**
 * Player is the paddle.
 * @author Leo_Le
 *
 */
public class Player extends Rect {
	public static final int DEFAULTPLAYERWIDTH = 80;
	public static final int DEFAULTPLAYERLENGTH = 10;
	public static final int DEFAULTPLAYERMOVESPEED = 4;

	private int moveSpeed;
	private int currDirection;
	private Color color;
	

	public Player() {
		super(Controller.FIELDWIDTH / 2 - DEFAULTPLAYERWIDTH / 2,
				Controller.FIELDLENGTH - DEFAULTPLAYERLENGTH - 40,
				DEFAULTPLAYERWIDTH,
				DEFAULTPLAYERLENGTH);
		this.color = Color.black;
		this.moveSpeed = 0;
		this.currDirection = 1;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
		if(this.moveSpeed > 0)
			this.currDirection = 1;
		if(this.moveSpeed < 0)
			this.currDirection = -1;
	}

	public int getCurrDirection() {
		return this.currDirection;
	}
	
	public Color getColor() {
		return this.color;
	}

}
