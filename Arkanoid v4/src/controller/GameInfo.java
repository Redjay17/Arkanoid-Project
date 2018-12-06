package controller;

import java.util.ArrayList;

import model.*;

/**
 * This class gets information from Model and stores it. It is then used to be
 * taken from View
 * 
 * @author Arman Sandher
 *
 */
public class GameInfo {
	private static ArrayList<Block> bricks = new ArrayList<Block>();
	private static ArrayList<Rect> objects = new ArrayList<Rect>();
	private static Player player;
	private static Ball ball;
	private static int score;
	private static int lives;

	private static boolean isAlive;
	private static boolean win;

	private static boolean hasShot;

	/**
	 * Game View object in Controller to keep all the inforamtion in Model and pass
	 * it onto View
	 */
	public GameInfo(Model model) {
		update(model);
	}

	/**
	 * 
	 * This class updates  the information stored in GameInfo based on
	 * the information stored in Model.
	 * 
	 * @param bricks
	 * @param isAlive
	 * @param objects
	 * @param win
	 * @param player
	 * @param ball
	 * @param score
	 */
	public static void update(Model model) {
		bricks = model.getBricks();
		objects = model.getObjects();
		player = model.getPlayer();
		ball = model.getBall();
		isAlive = model.getAlive();
		win = model.getWon();
		score = model.getScore();
		lives = model.getLives();
		hasShot = model.getHasShot();
	}

	/**
	 * Creates a new ArrayList just to make sure that games with more than one try
	 * have only the basic components: Ball and Player
	 * 
	 * @return objects
	 */
	public static ArrayList<Rect> getObjects() {
		return objects;
	}

		
	/**
	 * Getter Method for bricks
	 * @return bricks
	 */
	public static ArrayList<Block> getBricks() {
		return bricks;
	}

	/**
	 * Getter Method for win
	 * @return win
	 */
	public static boolean getWon() {
		return win;
	}

	/**
	 * Getter Method for isAlive
	 * @return isAlive
	 */
	public static boolean getAlive() {
		return isAlive;
	}

	/**
	 * Getter Method for player
	 * @return player
	 */
	public static Player getPlayer() {
		return player;
	}

	/**
	 * Getter Method for ball
	 * @return ball
	 */
	public static Ball getBall() {
		return ball;
	}

	/**
	 * Getter Method for score
	 * @return
	 */
	public static int getScore() {
		return score;
	}
	
	/**
	 * Getter Method for lives
	 * @return lives
	 */
	public static int getLives() {
		return lives;
	}

	/**
	 * Getter Method for hasShot
	 * @return hasShot
	 */
	public static boolean getHasShot() {
		return hasShot;
	}

}