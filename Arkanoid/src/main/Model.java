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
	
	int currentScore;
	int currLives;
	Block[][] field;
	Paddle paddle;
	ArrayList<Ball> ball; //There may be multiple balls on the field.
	
	public Model() {
		
	}
	
	
}
