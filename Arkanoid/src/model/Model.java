package model;

import java.awt.Rectangle;
import java.util.ArrayList;

import controller.Controller;
import controller.GameInfo;

public class Model {
	private final boolean DEBUG = false;
	private static final int DEFAULTLIVES = 3;

	private Player player = new Player();
	private Ball ball = new Ball(player);
	
	private boolean alive = true;
	private boolean hasShot = false;
	private boolean hasWon = false;
	private boolean endMovement = false;
	
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
	
	public Model(Map map) {
		this.loadMap(map);
	}

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
		if (!this.alive || this.hasWon) {
			this.startNewLife();
			
			if(!this.alive) {
				this.alive = true;
				this.lives = DEFAULTLIVES;
				this.score = 0;
			}
			
			if(this.hasWon)
				this.hasWon = false;
				
			for (Block brick : this.bricks)
				brick.resetLives();
			
		} else {
			System.out.println("alive");
		}
	}
	
	private void startNewLife() {
		this.hasShot = false;
		this.player = new Player();
		this.ball = new Ball(player);
	}

	public void shoot() {
		if (!hasShot) {
			// xdir and ydir being set means the ball starts moving
			this.ball.setxDir(Ball.DEFAULTXDIR * player.getCurrDirection());
			this.ball.setyDir(-Ball.DEFAULTYDIR);
			this.hasShot = true;
			
			System.out.println("ball shot");
		}
	}

	@SuppressWarnings("unused")
	public void calculate() {
		if (ball.getY() > MAXBALLDOWNY + 50) {
			if(--lives <= 0)
				alive = false;
			startNewLife();
		}

		if (this.alive || !this.hasWon) {
			if(this.endMovement)
				this.slowMovement();
			//Move the player
			this.movePlayer();
			
			// moves the ball
			this.ball.setX(ball.getX() + ball.getxDir());
			this.ball.setY(ball.getY() + ball.getyDir());
			
			//Debug movement
			if(this.DEBUG && this.hasShot)
				this.player.setX(ball.getX() - (int)(player.getWidth()/2));
			
			this.checkCollision();	
			this.hasWon = checkCompletion();
		}
		
		GameInfo.update(this);
	}
	
	private void checkCollision() {
		Rectangle ballHitBox = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getLength());
		Rectangle playerHitBox = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getLength());
		
		// intersect only works with
		// rectangle objects
		// checks if ball touches the paddle
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
			
			if (brickHitBox.intersects(ballHitBox) && !brick.isDead()) {
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
						score = score + Block.BASESCORE * brick.getMaxLives();
					// brick.printInfo();
					
					break;
			}

		}
		
		// Horizontal borders
		if (ball.getX() < MAXPLAYERLEFTX||
				ball.getX() > MAXBALLRIGHTX) {
			ball.changexDir();
		}

		// Top border
		if (ball.getY() < BORDERSIZE) {
			ball.changeyDir();
		}
	}
	
	private boolean checkCompletion() {
		for(Block b: this.getBricks())
			if(!b.isDead())
				return false;
		return true;
	}

	private void slowMovement() {
		this.player.setMoveSpeed(player.getMoveSpeed()/5);
		if(player.getMoveSpeed() < 1|| player.getMoveSpeed() > -1 ) {
			player.setMoveSpeed(0);
			this.endMovement = false;
		}
	}
	
	public void startMovement(int direction) {
		player.setMoveSpeed(Player.DEFAULTPLAYERMOVESPEED * direction);
		this.endMovement = false;
		
	}

	public void endMovement() {
		this.endMovement = true;
	}
	
	private void movePlayer() {
		player.setX(player.getX() + player.getMoveSpeed());
		
		if (player.getX() >= MAXPLAYERRIGHTX)
			player.setX(MAXPLAYERRIGHTX);
		
		if (player.getX() <= MAXPLAYERLEFTX)
			player.setX(MAXPLAYERLEFTX);
		
		if (!hasShot)
			ball.setX(player.getX() + (int)(player.getWidth()/2.5));
	}

	public boolean getAlive() {
		return this.alive;
	}
	
	public boolean getWon() {
		return this.hasWon;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int getLives() {
		return this.lives;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Ball getBall() {
		return this.ball;
	}
}
