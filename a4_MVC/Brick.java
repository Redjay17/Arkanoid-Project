package a4_MVC;

/**
 * Rectangles are displayed or not displayed depending on that rectangle's
 * number of lives. Rectangles that are not displayed are just set to the same
 * background color :')
 * 
 * @author Leo_Le
 *
 */
public class Brick extends Rect {
	public int defaultBrickLives = 1;
	int lives = 1;

	public Brick(int x, int y, int width, int length) {
		super(x, y, width, length);
	}

	public void resetLives() {
		lives = defaultBrickLives;
	}
	public int getLives() {
		return lives;
	}

	public void removeLife() {
		lives--;
	}

	public boolean isDead() {
		return lives == 0;
	}

	public void printInfo() {
		System.out.println("Brick: " + x + " " + y + " " + width + " " + length + " " + "lives: " + lives);
	}

}
