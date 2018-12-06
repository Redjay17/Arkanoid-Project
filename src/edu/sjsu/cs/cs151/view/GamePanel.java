package edu.sjsu.cs.cs151.view;

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

import edu.sjsu.cs.cs151.controller.Command;
import edu.sjsu.cs.cs151.controller.Controller;
import edu.sjsu.cs.cs151.controller.GameInfo;
import edu.sjsu.cs.cs151.model.Block;
import edu.sjsu.cs.cs151.model.Rect;

/**
 * 
 * This is where the player, map, and ball are displayed. It is added to the
 * View Frame.
 * 
 * @author Leo_Le
 * @author Redjay
 */
public class GamePanel extends JPanel {
	PriorityQueue<Command> commands = Controller.commands;

	public static Color backgroundColor = new Color(200, 200, 200);
	public static Color borderColor = new Color(66, 66, 66);

	public GamePanel() {
		this.setPreferredSize(new Dimension(Controller.FIELDWIDTH, Controller.FIELDLENGTH));
		this.addKeyListener(new KeyListener() {
			/**
			 * The right and left arrow buttons controlls the player. 
			 * To help prevent movement from stuttering, the last key pressed has priority.
			 * If both keys are pressed, only the last key pressed will have precedence.
			 * The movement is not completely perfect, but it's suitable for this application.
			 * 
			 */

			private boolean keyLeftActivated = false;
			private boolean keyRightActivated = false;

			private int priority = 0;

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (!commands.contains(Command.RIGHTSTART)) {
						commands.add(Command.RIGHTSTART);
						keyRightActivated = true;
						priority = 1;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (!commands.contains(Command.LEFTSTART)) {
						commands.add(Command.LEFTSTART);
						keyLeftActivated = true;
						priority = 0;
					}
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
				if (keyRightActivated && keyLeftActivated)
					if (priority == 1)
						keyLeftActivated = false;
					else
						keyRightActivated = false;

				if (e.getKeyCode() == KeyEvent.VK_RIGHT && !keyLeftActivated) {
					keyRightActivated = false;
					commands.add(Command.MOVEEND);
				}

				if (e.getKeyCode() == KeyEvent.VK_LEFT && !keyRightActivated) {
					keyLeftActivated = false;
					commands.add(Command.MOVEEND);
				}
			}

		});
	}
	
	/**
	 * This displays the various states of the game
	 * @param gr
	 */
	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		
		if(!GameInfo.getAlive()) 					//If the player has no lives
			this.paintDead(g);
		else if(GameInfo.getWon()) 					//If every brick has been destroyed
			this.paintWin(g);
		else {
			this.paintMap(g); 						//Displays the current map state if the game is still going
			if(GameInfo.getFirstInstructions()){ 	//If the game first launched.
				if(!GameInfo.getHasShot()) {
					this.paintInstructions(g);
				} else {
					GameInfo.setFirstInstructions(false);
				}
			}
		}
		
	}
	
	
	/**
	 * This displays the map in its current state.
	 * @param g
	 */
	public void paintMap(Graphics2D g) {
		// "refreshes" the screen with a new "layer" of paint. Take this off and see
		// what happens
		g.setColor(backgroundColor);
		g.fillRect(0, 0, Controller.FIELDWIDTH, Controller.FIELDLENGTH);

		// paints bricks depending on lives.
		for (Block brick : GameInfo.getBricks()) {
			g.setColor(brick.getColor());
			g.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getLength());
		}

		// paints the player and ball.
		for (Rect rect : GameInfo.getObjects()) {
			g.setColor(rect.getColor());
			g.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getLength());
		}
	}

	/**
	 * This paints the victory screen. There is also a corner case if a map is empty.
	 * @param g
	 */
	public void paintWin(Graphics2D g) {
		g.setColor(backgroundColor);
		g.fillRect(0, 0, Controller.FIELDWIDTH, Controller.FIELDLENGTH);
		g.setColor(new Color(113, 255, 137));
		if (!GameInfo.getBricks().isEmpty()) { //If every brick is considered dead.
			g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			g.drawString("The level is over!", 50, 150);
			
			g.setFont(new Font("serif", Font.BOLD, 35));
			g.drawString("Press Enter to restart", 80, 300);
		} else { //If there was an empty map loaded
			g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
			g.setColor(Color.black);
			g.drawString("Game cannot be played without a map", 40, 150);

			g.setFont(new Font("serif", Font.PLAIN, 25));
			g.drawString("Please choose another map.", 90, 300);
		}

	}
	
	/**
	 * This displays the game over screen. It is a reference to a game known for its game over screen.
	 * @param g
	 */
	public void paintDead(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Controller.FIELDWIDTH, Controller.FIELDLENGTH);
		g.setColor(Color.red);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
		g.drawString("YOU DIED", 50, 200);

		g.setFont(new Font("serif", Font.BOLD, 30));
		g.drawString("press Enter to restart", 110, 250);
	}
	
	/**
	 * This displays the instructions on how to play the game. Will only appear at the beginning of the game only.
	 * @param g
	 */
	
	public void paintInstructions(Graphics2D g) {
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g.drawString("<-- Move with arrow keys --> ", 120, 400);
		g.drawString("Launch the ball with space bar. ", 120, 425);
	}

}
