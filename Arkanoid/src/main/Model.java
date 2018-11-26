package main;

import java.awt.Rectangle;
import java.util.ArrayList;

import entities.Ball;
import entities.Block;
import entities.Map;
import entities.Player;
import entities.Rect;

public class Model {
	private final boolean DEBUG = true;
	private static final int DEFAULTLIVES = 3;

	private Player player = new Player();
	private Ball ball = new Ball(player);
	
	private boolean alive = true;
	private boolean firstShot = false;
	private int score = 0;
	private int lives = DEFAULTLIVES;
	
	public final int BORDERSIZE = 0;
	public final int MAXBALLDOWNY = Controller.FIELDLENGTH - ball.getLength();
	public final int MAXBALLLEFTX = BORDERSIZE;
	public final int MAXBALLRIGHTX = Controller.FIELDWIDTH - BORDERSIZE - ball.getWidth();
	public final int MAXPLAYERLEFTX = BORDERSIZE;
	public final int MAXPLAYERRIGHTX = Controller.FIELDLENGTH - player.getWidth() - BORDERSIZE;
	
	Map map;
	ArrayList<Block> bricks;

	public ArrayList<Rect> getObjects() {
		ArrayList<Rect> objects = new ArrayList<Rect>();
		objects.add(player);
		objects.add(ball);
		return objects;

	}

	public ArrayList<Block> getBricks() {
		return bricks;

	}

	public void loadMap(Map map) {
		this.map = map;
		// clear the arraylist so it doesn't stack with bricks
		this.bricks = new ArrayList<Block>(map.getBricks());
		this.alive = false;
		this.restart();
	}

	public void restart() {
		if (!alive) {
			this.lives = DEFAULTLIVES;
			this.alive = true;
			this.firstShot = false;
			this.player = new Player();
			this.ball = new Ball(player);
			this.score = 0;
			
			for (Block brick : this.bricks) {
				brick.resetLives();
			}
		}
		else {
			System.out.println("alive");
		}
	}
	
	private void startNewLife() {
		this.firstShot = false;
		this.player = new Player();
		this.ball = new Ball(player);
	}

	public void shoot() {
		if (!firstShot) {
			// xdir and ydir being set means the ball starts moving
			this.ball.setxDir(2);
			this.ball.setyDir(4);
			this.firstShot = true;
			
			System.out.println("ball shot");
		}
	}

	public void calculate() {
		if (ball.getY() > MAXBALLDOWNY + 50) {
			if(--lives <= 0)
				alive = false;
			startNewLife();
		}

		if (alive) {

			// moves the ball
			ball.setX(ball.getX() + ball.getxDir());
			ball.setY(ball.getY() + ball.getyDir());
			
			if(DEBUG)
				player.setX(player.getX() + ball.getxDir());
			
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
				Block brick = bricks.get(i);

				// check if ball hits brick
				Rectangle brickHitBox = new Rectangle(
						brick.getX(), brick.getY(), 
						brick.getWidth(), brick.getLength());
				
				if (brickHitBox.intersects(ballHitBox)) {
					if (brick.isDead()) {
					} else {
						// System.out.println();
						// System.out.println(brick.getLives());
						// System.out.println("ball intersect brick");

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
							// System.out.println("ball changed x dir");
						} else {
							// else ball is above or below brick.
							ball.changeyDir();
							// System.out.println("ball changed y dir");
						}
						// brick.printInfo();
						brick.removeLife();
						if(brick.isDead())
							score = score + 10 * brick.getMaxLives();
						// brick.printInfo();
						break;
					}
				}

			}

			// left corner
			if (ball.getX() < MAXPLAYERLEFTX)
				ball.changexDir();
			
			if (ball.getY() < BORDERSIZE)
				ball.changeyDir();
			
			if (ball.getX() > MAXBALLRIGHTX)
				ball.changexDir();
		}
	}

	public void moveRight() {
		// don't let player leave map
		if (player.getX() >= MAXPLAYERRIGHTX) {
			player.setX(MAXPLAYERRIGHTX);
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
		if (player.getX() <= MAXPLAYERLEFTX) {
			player.setX(MAXPLAYERLEFTX);
		} else {
			// move as normal
			player.setX(player.getX() - player.getMoveSpeed());
			if (!firstShot) {
				ball.setX(ball.getX() - player.getMoveSpeed());
			}

		}
	}

	public boolean getAlive() {
		return this.alive;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int getLives() {
		return this.lives;
	}

}
