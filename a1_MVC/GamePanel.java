package a1_MVC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * GamePanel handles the drawing and physics calculation based off of the
 * variables of the ball and player
 * 
 * @author Leo_Le
 *
 */
// Credit to Awais Mirza's youtube tutorial.
// I'm using his method of emulating ball collision physics.
// https://www.youtube.com/watch?v=K9qMm3JbOH0

public class GamePanel extends JPanel implements KeyListener, ActionListener {
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
	public final int maxPlayerRightX = Controller.fieldPanelWidth - player.getWidth() - borderThickness; // -
																										// borderThickness
	Color backgroundColor = Color.gray;
	Color playerColor = Color.cyan;
	Color ballColor = Color.orange;
	Color brickColor = new Color(109, 239, 161);
	// new Color(148, 246, 233);
	Color borderColor = new Color(66, 66, 66); // cause ur trapped in heck
												// player.getWidth();
	private Timer timer;
	private int delay = 5;
	Map map;
	ArrayList<Brick> bricks;

	public GamePanel(Map map) {
		this.map = map;
		bricks = map.getBricks();
		addKeyListener(this);
		setFocusable(true);
		timer = new Timer(delay, this);
		timer.start();
	}

	public void loadMap(Map map) {
		this.map = map;
		bricks = new ArrayList<Brick>(map.getBricks());
		player = new Player();
		ball = new Ball(player);
		alive = true;
		firstShot = false;
		restart();
	}

	/**
	 * handles the displaying. Re-displayed as the physics are calculated in the
	 * method actionPreformed
	 */
	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		// background
		g.setColor(backgroundColor);
		g.fillRect(0, 0, Controller.fieldPanelWidth, Controller.fieldPanelLength);

		// draw map
		paintMap(g, brickColor);
		// Borders
		g.setColor(borderColor);
		// left border
		g.fillRect(0, 0, borderThickness, Controller.fieldPanelLength);
		g.setColor(borderColor);
		// top border
		g.fillRect(0, 0, Controller.fieldPanelWidth, borderThickness);
		g.setColor(borderColor);
		// right border
		g.fillRect(Controller.fieldPanelWidth - borderThickness, 0, borderThickness, Controller.fieldPanelLength);

		// paddle
		g.setColor(playerColor);
		g.fillRect(player.getX(), player.getY(), player.getWidth(), player.getLength());

		// ball
		g.setColor(ballColor);
		g.fillRect(ball.getX(), ball.getY(), ball.getWidth(), ball.getLength());

		// death message
		deathMessage(g);

	}

	public void paintMap(Graphics2D g, Color color) {
		for (Brick brick : bricks) {
			if (brick.isDead()) {
				g.setColor(backgroundColor);
				g.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getLength());
			}

			else {
				g.setColor(color);
				g.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getLength());
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight();
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft();
		}

		// Space "shoots" the ball from the paddle on first shot
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!firstShot) {
				// xdir and ydir being set means the ball starts moving
				ball.setxDir(1);
				ball.setyDir(2);
				firstShot = true;
			}
		}

		// Enter resets the game if game has ended
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!alive) {
				restart();

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

	Color backgroundDeathColor = Color.black;

	public void deathMessage(Graphics2D g) {
		// If they died, give them the old DarkSoulserino
		if (!alive) {
			g.setColor(Color.black);
			g.fillRect(0, 0, Controller.fieldPanelWidth, Controller.fieldPanelWidth);
			ball.setxDir(0);
			ball.setyDir(0);
			g.setColor(Color.red);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
			g.drawString("YOU DIED", 50, 200);

			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("press Enter to restart", 110, 250);
		}

	}

	public void restart() {
		// The user pressed enter
		alive = true;
		firstShot = false;
		player = new Player();
		ball = new Ball(player);
		for (Brick brick : bricks) {
			brick.lives = defaultBrickLives;
		}
	}

	@Override
	/**
	 * actionperformed happens when every (delay) milliseconds. it is triggered by
	 * the timer. So every 10 milliseconds, the code below happens. Actionperformed
	 * is the physics calculator, so it strictly deals with manipulating variables,
	 * not displaying the results of said manipulations. That's repaint()'s job.
	 */
	public void actionPerformed(ActionEvent e) {
		this.repaint();

		if (ball.getY() > maxBallDown) {
			alive = false;
		}

		if (alive) {

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
					if (brick.isDead()) {
					} else {
//						System.out.println();
//						System.out.println(brick.getLives());
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
						// System.out.println("life removed");
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
			if (ball.getY() < borderThickness) {
				ball.changeyDir();
			}
			if (ball.getX() > maxBallRight) {
				ball.changexDir();
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			loadMap(new Map_OWO());
		}

		if (e.getKeyCode() == KeyEvent.VK_W) {
			loadMap(new Map_CS151());
		}

	}

	public int getScore() {
		return score;
	}

}
