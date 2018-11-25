package a1_MVC;

/**
 * Ball, Player, and bricks are all things that can be built using fillRect, so
 * I'm using these to keep track of measurement data. All extends Rect.
 * 
 * @author Leo_Le
 *
 */
public class Rect {
	public int x = 0;
	public int y = 0;
	public int width = 0;
	public int length = 0;

	public Rect(int x, int y, int width, int length) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.length = length;
	}

	public Rect() {
		// how to fix Player constructor: Step 1.
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
