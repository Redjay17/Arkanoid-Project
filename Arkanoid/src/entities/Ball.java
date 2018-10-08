package entities;

/**
 * The ball class is the only way for blocks to be broken. 
 * It changes direction When it collides with either the paddle, blocks, or the boundaries.
 * Each collision causes the ball to increase in speed. 
 * The ball is removed when it hits the bottom boundary. 
 * @author Team 5
 *
 */

//test

public class Ball {
	public int speed;
	public int timesHit;
	public double xDirection;
	public double yDirection;
	public double diameter;
	public double maxSpeed;
	public int x_coord;
	public int y_coord;
	
	/**
	 * constructs a ball with default diameter, will be determined.
	 */
	public Ball() {
		
	}
	
	/**
	 * ball needs to initially launch in a direction
	 * based off of paddle momentum
	 */
	public void Launch(){
		
	}
	
	/**
	 * Calculates where it will bounce next
	 * and what direction it will throw the ball
	 * stores the x and y in an array
	 */
	private int[] nextBounceDirection() {
		return null;
	
	}
	
	
	/**
	 * if ball isn't at max speed, increase the speed
	 */
	public void increaseSpeed() {
		
	}
}
