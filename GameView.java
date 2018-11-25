package a4_MVC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.JPanel;

public class GameView extends JPanel implements KeyListener {
	PriorityQueue<Command> commands = Controller.commands;
	// objects = player and ball
	ArrayList<Rect> objects = new ArrayList<Rect>();
	ArrayList<Brick> bricks = new ArrayList<>();
	boolean alive = true;

	public GameView() {
		addKeyListener(this);
	}

	public void setObjects(ArrayList<Rect> objects) {
		this.objects = objects;
	}

	public void setBricks(ArrayList<Brick> bricks) {
		this.bricks = bricks;
	}

	// borderThickness
	Color backgroundColor = Color.gray;
	Color playerColor = Color.cyan;
	Color ballColor = Color.orange;
	Color brickColor = new Color(109, 239, 161);
	// new Color(148, 246, 233);
	Color borderColor = new Color(66, 66, 66);

	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;

		// "refreshes" the screen with a new "layer" of paint. Take this off and see
		// what happens
		g.setColor(backgroundColor);
		g.fillRect(0, 0, Controller.fieldPanelWidth, Controller.fieldPanelLength);

		// paints the player
		g.setColor(playerColor);
		for (Rect rect : objects) {
			g.fillRect(rect.x, rect.y, rect.width, rect.length);
		}

		// paints bricks depending on lives
		for (Brick brick : bricks) {
			if (brick.getLives() < 0) {
				g.setColor(backgroundColor);
				g.fillRect(brick.x, brick.y, brick.width, brick.length);
			} else if (brick.getLives() >= 1) {
				g.setColor(brickColor);
				g.fillRect(brick.x, brick.y, brick.width, brick.length);
			}
		}
		
		if(!alive) {
			g.setColor(Color.black);
			g.fillRect(0, 0, Controller.fieldPanelWidth, Controller.fieldPanelWidth);
			g.setColor(Color.red);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
			g.drawString("YOU DIED", 50, 200);

			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("press Enter to restart", 110, 250);
		}

	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void paintBricks(Graphics2D g) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			commands.add(Command.RIGHT);
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			commands.add(Command.LEFT);
		}

		// Space "shoots" the ball from the paddle on first shot
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			commands.add(Command.SPACE);
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			commands.add(Command.ENTER);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		{
			if (e.getKeyCode() == KeyEvent.VK_Q) {
				commands.add(Command.MAP_OWO);
			}

			if (e.getKeyCode() == KeyEvent.VK_W) {
				commands.add(Command.MAP_CS151);
			}

		}
	}
}
