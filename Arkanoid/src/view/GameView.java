package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.JPanel;

import entities.Block;
import entities.Rect;
import main.Command;
import main.Controller;

public class GamePanel extends JPanel implements KeyListener {
	PriorityQueue<Command> commands = Controller.commands;
	// objects = player and ball
	private ArrayList<Rect> objects = new ArrayList<Rect>();
	private ArrayList<Block> bricks = new ArrayList<>();
	private boolean alive = true;
	
	// borderThickness
	public static Color backgroundColor = new Color(200, 200, 200);
	public static Color borderColor = new Color(66, 66, 66);

	public GamePanel() {
		addKeyListener(this);
		this.setPreferredSize(new Dimension(Controller.FIELDWIDTH, Controller.FIELDLENGTH));
	}

	public void setObjects(ArrayList<Rect> objects) {
		this.objects = objects;
	}

	public void setBricks(ArrayList<Block> bricks) {
		this.bricks = bricks;
	}

	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;

		// "refreshes" the screen with a new "layer" of paint. Take this off and see
		// what happens
		g.setColor(backgroundColor);
		g.fillRect(0, 0, Controller.FIELDWIDTH, Controller.FIELDLENGTH);

		// paints bricks depending on lives
		for (Block brick : bricks) {
			g.setColor(brick.getColor());
			g.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getLength());
		}
				
		// paints the player
		for (Rect rect : objects) {
			g.setColor(rect.getColor());
			g.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getLength());
		}
		
		if(!alive) {
			g.setColor(Color.black);
			g.fillRect(0, 0, Controller.FIELDWIDTH, Controller.FIELDWIDTH);
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
