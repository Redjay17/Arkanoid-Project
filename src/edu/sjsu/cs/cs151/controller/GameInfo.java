package edu.sjsu.cs.cs151.controller;

import java.util.ArrayList;

import edu.sjsu.cs.cs151.model.*;

/**
 * This class gets information from Model and stores it for display. 
 * It is then used to display information set in classes from the view.
 * 
 * @author Arman Sandher
 * @author Redjay
 */
public class GameInfo {
	private static ArrayList<Block> bricks = new ArrayList<Block>();
	private static ArrayList<Rect> objects = new ArrayList<Rect>();
	private static Player player;
	private static Ball ball;
	private static int score;
	private static int lives;
	private static boolean firstInstructions = true;

	private static boolean isAlive;
	private static boolean win;

	private static boolean hasShot;
	
	private static Map currMapLoaded;

	/**
	 * Game View object in Controller to keep all the inforamtion in Model.
	 * 
	 * @param model
	 * 
	 */
	public GameInfo(Model model) {
		update(model);
	}

	/**
	 * It updates the information stored in Model
	 * 
	 * @param model
	 * 
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
	 * 
	 * @return an ArrayList with the player and ball.
	 */
	public static ArrayList<Rect> getObjects() {
		return objects;
	}

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
	
	/**
	 * 
	 * @return a boolean stating if the first game has started.
	 */
	public static boolean getFirstInstructions() {
		return firstInstructions;
	}

	public static boolean getHasShot() {
		return hasShot;
	}
	
	/**
	 * 
	 * @return a map that was loaded from the Map Buttons.
	 */
	public static Map getCurrMapLoaded() {
		return currMapLoaded;
	}
	
	public static void setFirstInstructions(boolean a) {
		firstInstructions = a;
	}
	
	/**
	 * 
	 * @param m - a map that will be loaded in later.
	 */
	public static void setCurrMap(Map m) {
		currMapLoaded = m;
	}

}