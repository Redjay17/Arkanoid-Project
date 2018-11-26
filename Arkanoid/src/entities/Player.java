package entities;

import main.Controller;

/**
 * Player is the paddle.
 * @author Leo_Le
 *
 */
public class Player extends Rect {
	public int initPlayerWidth = 80;
	public int initPlayerLength = 10;

	public int moveSpeed = 35;

	public Player() {
		x = Controller.FIELDWIDTH / 2 - initPlayerWidth / 2;
		y = Controller.FIELDLENGTH - 95 + -initPlayerLength;
		width = initPlayerWidth;
		length = initPlayerLength;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public void printPlayerInfo() {
		System.out.println("Player: " + x + " " + y + " " + width + " " + length);
	}

	public void reset() {

	}

}
