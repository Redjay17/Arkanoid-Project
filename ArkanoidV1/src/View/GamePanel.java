package View;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.JPanel;

import Controller.GameInfo;
import Command.Command;
import Controller.Controller;
import Model.Ball;
import Model.Brick;
import Model.Player;
import Model.Rect;

/**
 * The Jpanel that is to be added to View's gamefield. Displays the information
 * regarding the objects of the game
 *
 */
public class GamePanel extends JPanel implements KeyListener {
	PriorityQueue<Command> commands = Controller.commands;
	// objects = player and ball
	ArrayList<Model.Rect> objects = new ArrayList<Model.Rect>();
	ArrayList<Model.Brick> bricks = new ArrayList<>();
	Model.Player player = new Model.Player();
	Model.Ball ball = new Model.Ball(player);

	boolean alive = true;
	boolean won = false;

	public GamePanel() {
		addKeyListener(this);
	}

	public void setObjects(ArrayList<Model.Rect> objects) {
		this.objects = objects;
	}

	public void setBricks(ArrayList<Model.Brick> bricks) {
		this.bricks = bricks;
	}

	// borderThickness
	Color backgroundColor = Color.gray;
	Color playerColor = Color.cyan;
	Color ballColor = Color.orange;
	Color brickColor = new Color(109, 239, 161);
	// new Color(148, 246, 233);
	Color borderColor = new Color(66, 66, 66);
	Color victoryText = new Color(113, 255, 137);

	Color guiColor = Color.black;

	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		
		//Refresh the View with Controller's GameInfo
		objects = GameInfo.getObjects();
		bricks = GameInfo.getBricks();
		alive = GameInfo.getAlive();
		won = GameInfo.getWon();
		player = GameInfo.getPlayer();
		ball = GameInfo.getBall();
		
		// "refreshes" the screen with a new "layer" of paint. Take this off and see
		// what happens
		g.setColor(backgroundColor);
		g.fillRect(0, 0, Controller.fieldPanelWidth, Controller.fieldPanelLength);

		// paints the player
		g.setColor(playerColor);
		g.fillRect(player.x, player.y, player.width, player.length);
		g.setColor(ballColor);
		g.fillRect(ball.x, ball.y, ball.width, ball.length);

		// paints bricks depending on lives
		for (Model.Brick brick : bricks) {
			if (brick.getLives() < 0) {
				g.setColor(backgroundColor);
				g.fillRect(brick.x, brick.y, brick.width, brick.length);
			} else if (brick.getLives() >= 1) {
				g.setColor(brickColor);
				g.fillRect(brick.x, brick.y, brick.width, brick.length);
			}
		}

		if (!alive) {
			paintDead(g);
		}

		if (won) {
			paintWin(g);
		}

	}

	public void paintWin(Graphics2D g) {
		g.setColor(backgroundColor);
		g.fillRect(0, 0, Controller.fieldPanelWidth, Controller.fieldPanelWidth);
		g.setColor(victoryText);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		g.drawString("You Actually beat it.", 50, 150);
		g.drawString("Nice.", 185, 210);

		g.setFont(new Font("serif", Font.BOLD, 35));
		g.drawString("press Enter to restart", 80, 300);

	}

	public void paintDead(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Controller.fieldPanelWidth, Controller.fieldPanelWidth);
		g.setColor(Color.red);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
		g.drawString("YOU DIED", 50, 200);

		g.setFont(new Font("serif", Font.BOLD, 30));
		g.drawString("press Enter to restart", 110, 250);
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
			if (e.getKeyCode() == KeyEvent.VK_E) {
				commands.add(Command.MAP_CADENCE);
			}

		}
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public void setPlayer(Model.Player player) {
		this.player = player;
	}

	public void setBall(Model.Ball ball) {
		this.ball = ball;
	}
}
