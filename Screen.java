package MapGenerator3_UI_Friendlier;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.*;

public class Screen extends JFrame implements MouseListener, ActionListener, KeyListener {
	int brickWidth = 15;
	int brickLength = 15;
	int windowWidth = 500;
	int windowLength = 500;
	int delay = 10;
	Stack<Brick> bricks = new Stack<Brick>();
	ArrayList<Rect> outlines = new ArrayList<Rect>();
	Timer timer = new Timer(delay, this);
	boolean paintBackOnce = false;

	public Screen() {
		this.pack();
		this.outLinesGenerator();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			for (Brick out : bricks) {
				System.out.println(
						"bricks.add(new Block(" + out.x + ", " + out.y + "));");
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}

		if (e.getKeyCode() == KeyEvent.VK_Z) {
			bricks.pop();
			System.out.println("REMOVED LAST");
			paintBackOnce = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			for (Brick brick : bricks) {
				brick.x = brick.x - brickWidth;
			}
			paintBackOnce = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			for (Brick brick : bricks) {
				brick.x = brick.x + brickWidth;
			}
			paintBackOnce = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			for (Brick brick : bricks) {
				brick.y = brick.y + brickLength;
			}
			paintBackOnce = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			for (Brick brick : bricks) {
				brick.y = brick.y - brickWidth;
			}
			paintBackOnce = true;
		}

	}

	public Stack<Brick> getBricks() {
		return bricks;
	}

	public void paint(Graphics g) {

		for (Brick rect : bricks) {
			g.setColor(Color.green);
			g.fillRect(rect.x, rect.y, rect.width, rect.length);

		}

		for (Rect rect : outlines) {
			g.setColor(Color.black);
			g.drawRect(rect.x, rect.y, rect.width, rect.length);
		}
		
		if(paintBackOnce) {
			paintBackOnce(g);
			paintBackOnce = false;
		}

		// uncomment this and see what happens
		// g.setColor(Color.white);
		// g.fillRect(0, 0, windowWidth, windowLength);

	}
	public void paintBackOnce(Graphics g) {
		 g.setColor(Color.white);
		 g.fillRect(0, 0, windowWidth, windowLength);
	}

	public void outLinesGenerator() {
		int columns = windowWidth / brickWidth;
		int rows = windowLength / brickLength;
		for (int i = 0; i <= columns; i++) {
			for (int j = 0; j <= rows; j++)
				outlines.add(new Rect(j * brickWidth, i * brickLength, brickWidth, brickLength));
		}
	}

	public void start() {
		this.setBounds(100, 100, windowWidth, windowLength);
		this.setVisible(true);
		timer.start();
		setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int xClick = e.getX();
		int yClick = e.getY();
		Rectangle clickBrick = new Rectangle(xClick, yClick, brickWidth, brickLength);
		for (Rect out : outlines) {
			Rectangle outline = new Rectangle(out.x, out.y, out.width, out.length);
			if (clickBrick.intersects(outline)) {
				Brick add = new Brick(out.x, out.y, out.width, out.length);
				bricks.add(add);
				// bricks.add(new Rect(x,y,width,length))

				break;
			}

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Screen screen = new Screen();
		Stack<Brick> bricks = screen.getBricks();
		screen.start();
		bricks.add(new Brick(240, 165, 15, 15));
		bricks.add(new Brick(225, 150, 15, 15));
		bricks.add(new Brick(210, 135, 15, 15));
		bricks.add(new Brick(195, 120, 15, 15));
		bricks.add(new Brick(195, 105, 15, 15));
		bricks.add(new Brick(210, 90, 15, 15));
		bricks.add(new Brick(225, 90, 15, 15));
		bricks.add(new Brick(240, 105, 15, 15));
		bricks.add(new Brick(255, 90, 15, 15));
		bricks.add(new Brick(270, 90, 15, 15));
		bricks.add(new Brick(285, 105, 15, 15));
		bricks.add(new Brick(285, 120, 15, 15));
		bricks.add(new Brick(270, 135, 15, 15));
		bricks.add(new Brick(255, 150, 15, 15));
		bricks.add(new Brick(240, 210, 15, 15));
		bricks.add(new Brick(225, 195, 15, 15));
		bricks.add(new Brick(210, 180, 15, 15));
		bricks.add(new Brick(195, 165, 15, 15));
		bricks.add(new Brick(180, 150, 15, 15));
		bricks.add(new Brick(165, 135, 15, 15));
		bricks.add(new Brick(255, 195, 15, 15));
		bricks.add(new Brick(270, 180, 15, 15));
		bricks.add(new Brick(285, 165, 15, 15));
		bricks.add(new Brick(300, 150, 15, 15));
		bricks.add(new Brick(315, 135, 15, 15));
		bricks.add(new Brick(315, 120, 15, 15));
		bricks.add(new Brick(315, 105, 15, 15));
		bricks.add(new Brick(315, 90, 15, 15));
		bricks.add(new Brick(165, 120, 15, 15));
		bricks.add(new Brick(165, 105, 15, 15));
		bricks.add(new Brick(165, 90, 15, 15));
		bricks.add(new Brick(165, 75, 15, 15));
		bricks.add(new Brick(165, 60, 15, 15));
		bricks.add(new Brick(180, 60, 15, 15));
		bricks.add(new Brick(210, 60, 15, 15));
		bricks.add(new Brick(195, 60, 15, 15));
		bricks.add(new Brick(225, 60, 15, 15));
		bricks.add(new Brick(240, 60, 15, 15));
		bricks.add(new Brick(255, 60, 15, 15));
		bricks.add(new Brick(270, 60, 15, 15));
		bricks.add(new Brick(285, 60, 15, 15));
		bricks.add(new Brick(300, 60, 15, 15));
		bricks.add(new Brick(315, 60, 15, 15));
		bricks.add(new Brick(315, 75, 15, 15));
		bricks.add(new Brick(135, 60, 15, 15));
		bricks.add(new Brick(135, 75, 15, 15));
		bricks.add(new Brick(135, 90, 15, 15));
		bricks.add(new Brick(135, 105, 15, 15));
		bricks.add(new Brick(135, 120, 15, 15));
		bricks.add(new Brick(120, 60, 15, 15));
		bricks.add(new Brick(90, 60, 15, 15));
		bricks.add(new Brick(105, 60, 15, 15));
		bricks.add(new Brick(75, 60, 15, 15));
		bricks.add(new Brick(60, 60, 15, 15));
		bricks.add(new Brick(45, 60, 15, 15));
		bricks.add(new Brick(30, 60, 15, 15));
		bricks.add(new Brick(15, 60, 15, 15));
		bricks.add(new Brick(15, 75, 15, 15));
		bricks.add(new Brick(15, 90, 15, 15));
		bricks.add(new Brick(15, 105, 15, 15));
		bricks.add(new Brick(15, 120, 15, 15));
		bricks.add(new Brick(75, 90, 15, 15));
		bricks.add(new Brick(60, 105, 15, 15));
		bricks.add(new Brick(45, 120, 15, 15));
		bricks.add(new Brick(60, 135, 15, 15));
		bricks.add(new Brick(75, 150, 15, 15));
		bricks.add(new Brick(90, 135, 15, 15));
		bricks.add(new Brick(105, 120, 15, 15));
		bricks.add(new Brick(90, 105, 15, 15));
		bricks.add(new Brick(75, 105, 15, 15));
		bricks.add(new Brick(75, 120, 15, 15));
		bricks.add(new Brick(75, 135, 15, 15));
		bricks.add(new Brick(60, 120, 15, 15));
		bricks.add(new Brick(90, 120, 15, 15));
		bricks.add(new Brick(135, 135, 15, 15));
		bricks.add(new Brick(135, 150, 15, 15));
		bricks.add(new Brick(15, 135, 15, 15));
		bricks.add(new Brick(75, 165, 15, 15));
		bricks.add(new Brick(60, 180, 15, 15));
		bricks.add(new Brick(45, 195, 15, 15));
		bricks.add(new Brick(30, 210, 15, 15));
		bricks.add(new Brick(15, 225, 15, 15));
		bricks.add(new Brick(15, 210, 15, 15));
		bricks.add(new Brick(15, 195, 15, 15));
		bricks.add(new Brick(15, 180, 15, 15));
		bricks.add(new Brick(15, 165, 15, 15));
		bricks.add(new Brick(15, 150, 15, 15));
		bricks.add(new Brick(90, 180, 15, 15));
		bricks.add(new Brick(105, 195, 15, 15));
		bricks.add(new Brick(120, 210, 15, 15));
		bricks.add(new Brick(135, 165, 15, 15));
		bricks.add(new Brick(135, 180, 15, 15));
		bricks.add(new Brick(135, 195, 15, 15));
		bricks.add(new Brick(135, 210, 15, 15));
		bricks.add(new Brick(135, 225, 15, 15));
		bricks.add(new Brick(345, 60, 15, 15));
		bricks.add(new Brick(345, 75, 15, 15));
		bricks.add(new Brick(345, 90, 15, 15));
		bricks.add(new Brick(345, 105, 15, 15));
		bricks.add(new Brick(345, 120, 15, 15));
		bricks.add(new Brick(345, 135, 15, 15));
		bricks.add(new Brick(345, 150, 15, 15));
		bricks.add(new Brick(345, 165, 15, 15));
		bricks.add(new Brick(345, 180, 15, 15));
		bricks.add(new Brick(345, 195, 15, 15));
		bricks.add(new Brick(345, 210, 15, 15));
		bricks.add(new Brick(345, 225, 15, 15));
		bricks.add(new Brick(360, 60, 15, 15));
		bricks.add(new Brick(375, 60, 15, 15));
		bricks.add(new Brick(390, 60, 15, 15));
		bricks.add(new Brick(405, 60, 15, 15));
		bricks.add(new Brick(420, 60, 15, 15));
		bricks.add(new Brick(435, 60, 15, 15));
		bricks.add(new Brick(450, 60, 15, 15));
		bricks.add(new Brick(465, 60, 15, 15));
		bricks.add(new Brick(465, 75, 15, 15));
		bricks.add(new Brick(465, 90, 15, 15));
		bricks.add(new Brick(465, 105, 15, 15));
		bricks.add(new Brick(465, 120, 15, 15));
		bricks.add(new Brick(465, 135, 15, 15));
		bricks.add(new Brick(465, 150, 15, 15));
		bricks.add(new Brick(465, 165, 15, 15));
		bricks.add(new Brick(465, 180, 15, 15));
		bricks.add(new Brick(465, 195, 15, 15));
		bricks.add(new Brick(465, 210, 15, 15));
		bricks.add(new Brick(465, 225, 15, 15));
		bricks.add(new Brick(450, 210, 15, 15));
		bricks.add(new Brick(360, 210, 15, 15));
		bricks.add(new Brick(375, 195, 15, 15));
		bricks.add(new Brick(390, 180, 15, 15));
		bricks.add(new Brick(435, 195, 15, 15));
		bricks.add(new Brick(420, 180, 15, 15));
		bricks.add(new Brick(405, 165, 15, 15));
		bricks.add(new Brick(405, 150, 15, 15));
		bricks.add(new Brick(405, 135, 15, 15));
		bricks.add(new Brick(390, 135, 15, 15));
		bricks.add(new Brick(420, 135, 15, 15));
		bricks.add(new Brick(375, 120, 15, 15));
		bricks.add(new Brick(390, 120, 15, 15));
		bricks.add(new Brick(405, 120, 15, 15));
		bricks.add(new Brick(420, 120, 15, 15));
		bricks.add(new Brick(435, 120, 15, 15));
		bricks.add(new Brick(420, 105, 15, 15));
		bricks.add(new Brick(405, 105, 15, 15));
		bricks.add(new Brick(390, 105, 15, 15));
		bricks.add(new Brick(405, 90, 15, 15));
		bricks.add(new Brick(60, 360, 15, 15));
		bricks.add(new Brick(45, 345, 15, 15));
		bricks.add(new Brick(30, 330, 15, 15));
		bricks.add(new Brick(15, 315, 15, 15));
		bricks.add(new Brick(75, 360, 15, 15));
		bricks.add(new Brick(90, 360, 15, 15));
		bricks.add(new Brick(105, 360, 15, 15));
		bricks.add(new Brick(120, 360, 15, 15));
		bricks.add(new Brick(135, 360, 15, 15));
		bricks.add(new Brick(150, 360, 15, 15));
		bricks.add(new Brick(165, 360, 15, 15));
		bricks.add(new Brick(180, 360, 15, 15));
		bricks.add(new Brick(300, 360, 15, 15));
		bricks.add(new Brick(315, 360, 15, 15));
		bricks.add(new Brick(330, 360, 15, 15));
		bricks.add(new Brick(345, 360, 15, 15));
		bricks.add(new Brick(360, 360, 15, 15));
		bricks.add(new Brick(375, 360, 15, 15));
		bricks.add(new Brick(390, 360, 15, 15));
		bricks.add(new Brick(405, 360, 15, 15));
		bricks.add(new Brick(420, 360, 15, 15));
		bricks.add(new Brick(435, 345, 15, 15));
		bricks.add(new Brick(450, 330, 15, 15));
		bricks.add(new Brick(465, 315, 15, 15));
		bricks.add(new Brick(120, 345, 15, 15));
		bricks.add(new Brick(120, 255, 15, 15));
		bricks.add(new Brick(105, 270, 15, 15));
		bricks.add(new Brick(90, 285, 15, 15));
		bricks.add(new Brick(105, 285, 15, 15));
		bricks.add(new Brick(120, 285, 15, 15));
		bricks.add(new Brick(135, 285, 15, 15));
		bricks.add(new Brick(135, 270, 15, 15));
		bricks.add(new Brick(120, 270, 15, 15));
		bricks.add(new Brick(150, 285, 15, 15));
		bricks.add(new Brick(120, 330, 15, 15));
		bricks.add(new Brick(120, 315, 15, 15));
		bricks.add(new Brick(120, 300, 15, 15));
		bricks.add(new Brick(360, 345, 15, 15));
		bricks.add(new Brick(360, 330, 15, 15));
		bricks.add(new Brick(360, 315, 15, 15));
		bricks.add(new Brick(360, 300, 15, 15));
		bricks.add(new Brick(360, 255, 15, 15));
		bricks.add(new Brick(345, 270, 15, 15));
		bricks.add(new Brick(360, 270, 15, 15));
		bricks.add(new Brick(375, 270, 15, 15));
		bricks.add(new Brick(330, 285, 15, 15));
		bricks.add(new Brick(345, 285, 15, 15));
		bricks.add(new Brick(360, 285, 15, 15));
		bricks.add(new Brick(375, 285, 15, 15));
		bricks.add(new Brick(390, 285, 15, 15));

	}

}
