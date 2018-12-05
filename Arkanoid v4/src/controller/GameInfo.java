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
	 * As the name implies, it updates the information stored in Model
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
	 * @return
	 */
	public static ArrayList<Rect> getObjects() {
		return objects;
	}

	// The rest are getter methods for their respective variables.

	public static ArrayList<Block> getBricks() {
		return bricks;
	}

	public static boolean getWon() {
		return win;
	}

	public static boolean getAlive() {
		return isAlive;
	}

	public static Player getPlayer() {
		return player;
	}

	public static Ball getBall() {
		return ball;
	}

	public static int getScore() {
		return score;
	}

	public static int getLives() {
		return lives;
	}

	public static boolean getHasShot() {
		return hasShot;
	}

}