package entities;

import java.util.ArrayList;

import powerups.PowerUp;

/**
 * Blocks are breakable objects within the field. 
 * In order to progress, the field must not have any breakable block objects. 
 * Unblockable block objects do not need to be destroyed in order for the level to progress.
 * @author Team 5
 *
 */
public class Block {
	public int health;
	private int size;
	private int chanceToDropPowerUp;
	private boolean unbreakable;
	private ArrayList<PowerUp> powerupDrops;

	public Block() {
		
	}
	
	/**
	 * onCollision alters the health of the block. If the block has no health, then
	 * the block is removed. If block is removed, determine if it should
	 * drop a powerup or not.
	 */
	public void onCollision() {
		
	}
	
	/**
	 * Checks if the block has no more health
	 * @return True if health < 0. False otherwise
	 */
	public boolean isDead() {
		return false;
	}
	
	/**
	 * Random number is rolled to see if a powerUp should be dropped or not.
	 * @return True if random number is greater than drop chance. False otherwise.
	 */
	public boolean powerUpDropped() {
		return false;
	}
	
	public boolean getUnbreakable() {
		return unbreakable;
	}
	
	
}
