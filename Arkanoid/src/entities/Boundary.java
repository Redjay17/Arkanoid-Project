package entities;

/**
 * Boundary is an unbreakable block. 
 * Unlike a block, it has no health, has no chance to give a powerup, and is fixed in each level. 
 * There are two boundaries: 
 * One where the ball simply bounces back relative to its direction
 * One that removes the ball completely if it touches that boundary.
 * @author Team 5
 *
 */
public class Boundary {
	public int size;
	public boolean removesBallOnCollision;
	
	public Boundary() {
		
	}
}
