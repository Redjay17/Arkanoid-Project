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
public class Boundary extends Block {
	public int size;
	public boolean removesBallOnCollision;
	
	public Boundary() {
		
	}
	
	/**
	 * On collision, the ball will either do two actions
	 * 1) Change direction and increase in speed
	 * 2) Be removed from the game if collides with the bottom boundary.
	 */
	public void onCollision() {
		
	}
	
	/**
	 * Will always return false because boundaries cannot be removed from the game.
	 * @return false always
	 */
	public boolean isDead() {
		return false;
	}
}
