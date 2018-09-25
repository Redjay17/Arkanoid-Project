package entities;
/**
 * The ball class is the only way for blocks to be broken. 
 * It changes direction When it collides with either the paddle, blocks, or the boundaries.
 * Each collision causes the ball to increase in speed. 
 * The ball is removed when it hits the bottom boundary. 
 * @author Team 5
 *
 */
public class Ball {
	public int speed;
	public int timesHit;
	public double xPos;
	public double yPos;
	public double xDirection;
	public double yDirection;
	public double diameter;
	
	public Ball() {
		
	}
	
	/**
	 * When a ball hits a collision, it will react according to which object it hit.
	 * Block - Reduces health if possible
	 * Paddle, block, boundary - Change direction of ball. Increase speed.
	 */
	public void onCollision() {
		
	}
}
