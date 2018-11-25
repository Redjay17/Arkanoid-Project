package a4_MVC;
/**
 * Player is the paddle.
 * @author Leo_Le
 *
 */
public class Player extends Rect {
	public int initPlayerWidth = 80;
	public int initPlayerLength = 10;

	public int moveSpeed = 35;
	public int defaultlives = 3;
	public int lives;

	public Player() {
		x = Controller.fieldPanelWidth / 2 - initPlayerWidth / 2;
		y = Controller.fieldPanelLength - 95 + -initPlayerLength;
		width = initPlayerWidth;
		length = initPlayerLength;
		lives = defaultlives;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public void printPlayerInfo() {
		System.out.println("Player: " + x + " " + y + " " + width + " " + length);
	}

	public void decreaseLife() {
		lives--;
	}

	public int getLives() {
		return lives;
	}

	public boolean isDead() {
		return (lives == 0);
	}

	public void reset() {

	}

}
