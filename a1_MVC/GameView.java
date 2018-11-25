package a1_MVC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.JPanel;

public class GameView extends JPanel implements KeyListener {
	PriorityQueue<Command> commands = Controller.commands;
	ArrayList<Rect> objects = new ArrayList<Rect>();

	public GameView() {
		addKeyListener(this);
	}

	public void setObjects(ArrayList<Rect> objects) {
		this.objects = objects;
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

		g.setColor(backgroundColor);
		g.fillRect(0, 0, Controller.fieldPanelWidth, Controller.fieldPanelLength);
		g.setColor(playerColor);
		for (Rect rect : objects) {
			g.fillRect(rect.x, rect.y, rect.width, rect.length);
		}

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
			System.out.println("command revieved");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
