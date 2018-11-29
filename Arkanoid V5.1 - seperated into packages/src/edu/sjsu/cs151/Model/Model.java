package edu.sjsu.cs151.Model;

import java.awt.Rectangle;
import java.util.ArrayList;

import edu.sjsu.cs151.Controller.Controller;

/**
 * Handles the calculation of the physics in calculate()
 * 
 * @author Leo Le
 *
 */
public class Model {

	Player player = new Player();
	Ball ball = new Ball(player);
	boolean alive = true;
	boolean firstShot = false;
	boolean won = false;
	int score = 0;
	Map map;
	ArrayList<Brick> bricks;
	
	public static int borderThickness = 0;
	public int maxBallDown = Controller.fieldPanelLength - ball.getLength();
	public int maxBallLeft = borderThickness;
	public int maxBallRight = Controller.fieldPanelWidth - borderThickness - ball.getWidth();
	public final int maxPlayerLeftX = borderThickness;
	public final int maxPlayerRightX = Controller.fieldPanelLength - player.getWidth() - borderThickness;


	public ArrayList<Rect> getObjects() {
		ArrayList<Rect> objects = new ArrayList<Rect>();
		objects.add(player);
		objects.add(ball);
		return objects;

	}

	public ArrayList<Brick> getBricks() {
		return bricks;

	}

	// loads a new map by loading all the new bricks and setting all variables to
	// their
	// default state
	public void loadMap(Map map) {
		this.map = map;
		// clear the arraylist so it doesn't stack with bricks
		bricks = new ArrayList<Brick>(map.getBricks());
		alive = false;
		restart();
	}

	// resets the game by resetting all the variables to their default state
	public void restart() {
		if (!alive || won) {
			alive = true;
			won = false;
			firstShot = false;
			player = new Player();
			ball = new Ball(player);
			score = 0;
			for (Brick brick : bricks) {
				brick.resetLives();
			}
		}
	}

	public void shoot() {
		if (!firstShot) {
			// xdir and ydir being set means the ball starts moving
			ball.setxDir(1);
			ball.setyDir(2);
			firstShot = true;
		}
	}

	public void calculate() {
		checkIfWon();

		if (ball.getY() > maxBallDown) {
			alive = false; // oof.
		}

		if (alive && !won) {
			// moves the ball
			ball.setX(ball.getX() + ball.getxDir());
			ball.setY(ball.getY() + ball.getyDir());

			// intersect only works with
			// rectangle objects
			// checks if ball touches the paddle
			Rectangle ballHitBox = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getLength());
			Rectangle playerHitBox = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getLength());
			if (ballHitBox.intersects(playerHitBox)) {
				// first check if ball is inside player
				if (ball.getX() + ball.getWidth() + 3 >= player.getX()
						&& ball.getX() - 3 <= player.getX() + player.getWidth()
						&& ball.getY() + ball.getLength() - 3 >= player.getY()) {

					// is it in the left half of the player, move the player
					// outside the panel to the left of it
					if (ball.getX() + ball.getWidth() + 1 <= player.getX() + (player.getWidth() / 2)) {
						ball.setX(player.getX() - 2 - ball.getWidth());
						ball.setxDir(ball.getxDir() * -1);
					}

					// if it is inside the right half of the player..
					if (ball.getX() - 1 >= player.getX() + (player.getWidth() / 2)) {
						ball.setX(player.getX() + 2 + player.getWidth());
						ball.setxDir(ball.getxDir() * -1);
					}

				} else {
					// if the ball is not inside the player, just change its direction
					ball.setyDir(ball.getyDir() * -1);
				}
				// notice how there is no code to check if the ball is left or right of the
				// player, just
				// whether it is inside to the left or inside to the right of the player.

			}

			for (int i = 0; i < bricks.size(); i++) {
				Brick brick = bricks.get(i);

				// check if ball hits brick
				Rectangle brickHitBox = new Rectangle(brick.getX(), brick.getY(), brick.getWidth(), brick.getLength());
				if (brickHitBox.intersects(ballHitBox)) {
					if (brick.isDead()) {// do nothing if break is dead c:
					} else {

						// checks if ball is left OR right of brick
						// if b
						// if the ball hits a brick from above or below from the side
						// ball's x will still be less/greater than bricks.
						// so we need the + ballsize stuff
						// basically, if ball's x is to the sides of brick when it collides with brick
						// without the one pixel buffer for safety, it falsely jumps to Y
						if (ball.getX() + ball.getWidth() - 1 <= brick.getX()
								|| ball.getX() + 1 >= brick.getX() + brick.getWidth()) {
							ball.changexDir();
						} else {
							// else ball is above or below brick.
							ball.changeyDir();
						}
						// brick.printInfo();
						brick.removeLife();
						score = score + 10;
						// brick.printInfo();
						break;
					}
				}

			}

			// left corner
			if (ball.getX() < maxPlayerLeftX) {
				ball.changexDir();
			}

			// top
			if (ball.getY() < borderThickness) {
				ball.changeyDir();
			}

			// right
			if (ball.getX() > maxBallRight) {
				ball.changexDir();
			}
		}
	}

	// if all the balls are broken, set won to true
	public void checkIfWon() {
		int broken = 0;
		for (Brick brick : bricks) {
			if (brick.getLives() <= 0) {
				broken++;
				if (broken == bricks.size()) {
					won = true;

				}
			}
		}
	}

	public void moveRight() {
		// don't let player leave map
		if (player.getX() >= maxPlayerRightX) {
			player.setX(maxPlayerRightX);
		} else {
			// move as normal
			player.setX(player.getX() + player.getMoveSpeed());
			if (!firstShot) {
				ball.setX(ball.getX() + player.getMoveSpeed());
			}
		}
	}

	public void moveLeft() {
		// don't let player leave map
		if (player.getX() <= maxPlayerLeftX) {
			player.setX(maxPlayerLeftX);
		} else {
			// move as normal
			player.setX(player.getX() - player.getMoveSpeed());
			if (!firstShot) {
				ball.setX(ball.getX() - player.getMoveSpeed());
			}

		}
	}

	public Player getPlayer() {
		return player;
	}

	public Ball getBall() {
		return ball;
	}

	public boolean getAlive() {
		return alive;
	}

	public boolean getWon() {
		return won;
	}

	public int getScore() {
		return score;
	}

}
