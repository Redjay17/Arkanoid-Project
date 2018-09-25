package main;

import java.util.ArrayList;

import entities.*;

/**
 * Model class stores information about the current game such as lives, score, the field,
 * and position/state of both the ball and paddle.
 * @author Team 5
 *
 */
public class Model {
	static int highScore;
	
	int currLevel;
	int currentScore;
	int currLives;
	Block[][] field;
	Paddle paddle;
	ArrayList<Ball> ball; //There may be multiple balls on the field.
	
	public Model() {
		
	}
	
	/**
	 * Changes the level field. A level reset is changing the level to it's current field.
	 */
	public void changeLevel() {
		
	}
	
	/**
	 * Starts the current level. The ball begins to move and the player can start moving.
	 */
	public void startLevel() {
		
	}
	
	/**
	 * Ends the current level. The ball and paddle are reset to their original positions and states.
	 */
	public void endLevel() {
		
	}
	
	/**
	 * Pauses the game. All of the ball objects stop moving and the player cannot move the paddle until they resume.
	 */
	
	public void pauseResume() {
		
	}
	
	/**
	 * Reacts accordingly depending on which two objects collided.
	 */
	
	public void onCollision() {
		
	}
}
