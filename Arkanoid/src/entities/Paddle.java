package entities;


/**
 * The paddle is the object that will only be changed by player input.
 * It can change in length, position on the X axis, and collides with the boundaries.
 * It's y position must be fixed. 
 * It acts as a way for the ball to collide with an object at the bottom boundary.
 * @author Team 5
 *
 */
public class Paddle {
	
	public int speed;
	public int length;
	public int yPos;
	public int xPos;
	
	public Paddle() {
		
	}
	
	/**
	 * The paddle can only collide with two objects: the ball object and the boundary object.
	 * In the boundary case, it will simply stop the paddle.
	 * In the ball case, the ball will change direction and increase in speed.
	 */
	public void onCollision() {
		
	}
	
}
