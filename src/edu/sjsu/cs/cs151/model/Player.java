package edu.sjsu.cs.cs151.model;

import java.awt.Color;

import edu.sjsu.cs.cs151.controller.Controller;

/**
 * The player is a paddle that must keep the ball within the game area.
 * The player moves this paddle around to bounce the ball.
 * 
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
		//Have the player's starting position be in the middle of the screen.
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
	
	/**
	 * Used to calculate where the ball starts when first shooting.
	 * @param moveSpeed
	 */
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
		return this.color; //In case the player can be set to a different color.
	}

}
