package a1_MVC;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Model {

	Player player = new Player();
	public int defaultBrickLives = 1;
	Ball ball = new Ball(player);
	boolean alive = true;
	boolean firstShot = false;
	int score = 0;
	public static int borderThickness = 0;
	public int maxBallDown = Controller.fieldPanelLength - ball.getLength();
	public int maxBallLeft = borderThickness;
	public int maxBallRight = Controller.fieldPanelWidth - borderThickness - ball.getWidth();
	public final int maxPlayerLeftX = borderThickness;
	public final int maxPlayerRightX = Controller.fieldPanelLength - player.getWidth() - borderThickness;
	Map map;
	ArrayList<Brick> bricks;

	public ArrayList<Rect> getObjects() {
		ArrayList<Rect> objects = new ArrayList<Rect>();
		objects.add(player);
		objects.add(ball);
		return objects;

	}

	public void shoot() {
		if (!firstShot) {
			// xdir and ydir being set means the ball starts moving
			ball.setxDir(1);
			ball.setyDir(2);
			firstShot = true;
			System.out.println("ball shot");
		}
	}

	public void calculate() {
		if (ball.getY() > maxBallDown) {
			alive = false;
		}

		System.out.println(ball.getX());
		if (alive) {

			// moves the ball
			ball.setX(ball.getX() + ball.getxDir());
			ball.setY(ball.getY() + ball.getyDir());
			System.out.println("moved ball");

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

			// left corner
			if (ball.getX() < maxPlayerLeftX) {
				ball.changexDir();
			}
			if (ball.getY() < borderThickness) {
				ball.changeyDir();
			}
			if (ball.getX() > maxBallRight) {
				ball.changexDir();
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

}
