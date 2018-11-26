package entities;

/**
 * Rectangles are displayed or not displayed depending on that rectangle's
 * number of lives. Rectangles that are not displayed are just set to the same
 * background color :')
 * 
 * @author Leo_Le
 *
 */
public class Block extends Rect {
	public int defaultBrickLives = 1;
	private int lives = 1;

	public Block(int x, int y, int width, int length) {
		super(x, y, width, length);
	}

	public void resetLives() {
		setLives(defaultBrickLives);
	}
	public int getLives() {
		return lives;
	}

	public void removeLife() {
		setLives(getLives() - 1);
	}

	public boolean isDead() {
		return getLives() == 0;
	}

	public void printInfo() {
		System.out.println("Brick: " + x + " " + y + " " + width + " " + length + " " + "lives: " + getLives());
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

}
