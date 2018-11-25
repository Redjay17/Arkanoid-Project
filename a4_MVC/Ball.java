package a4_MVC;

/**
 * The ball. Turns out the physics of the ball is just in swapping xDir / yDir
 * to make it change directions and stuff
 * 
 * @author Leo_Le
 *
 */
public class Ball extends Rect {

	public int xDir = 0;
	public int yDir = 0;
	public int initBallSize = 10;
	int ballSize = 10;

	public Ball(int x, int y, int width, int length) {
		super(x, y, width, length);
	}

	/**
	 * Ball's location during the initial creation is relative to player.
	 * 
	 * @param player
	 */
	public Ball(Player player) {
		x = player.getX() + player.getWidth() / 2 - initBallSize / 2;
		y = player.getY() - initBallSize - 2;
		width = initBallSize;
		length = initBallSize;
	}

	public int getxDir() {
		return xDir;
	}

	public void setxDir(int xDir) {
		this.xDir = xDir;
	}

	public int getyDir() {
		return yDir;
	}

	public void setyDir(int yDir) {
		this.yDir = yDir;
	}

	public void changexDir() {
		xDir = -xDir;
	}

	public void changeyDir() {
		yDir = -yDir;
	}
	public int getSize() {
		return ballSize;
	}

	public void printBallInfo() {
		System.out.println("Ball: " + y + " " + width + " " + length);
	}

}
