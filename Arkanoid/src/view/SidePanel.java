package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/*
 * Side panel contains stats for the game
 */
public class SidePanel extends JPanel {
	private int score = 0;
	private int lives = 3;
	
	final private int VIEWLENGTH = 400;
	final private int VIEWWIDTH = 150;

	public SidePanel() {
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(VIEWWIDTH, VIEWLENGTH));
		setBorder(BorderFactory.createBevelBorder(0));
	}

	Color backgroundColor = Color.white;
	Color guiColor = Color.black;

	// displays the score
	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setColor(backgroundColor);
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(guiColor);
		g.setFont(new Font("serif", Font.BOLD, 35));

		// the line under score
		g.fillRect(20, 60, 110, 3);

		g.drawString("Score", 30, 50);
		g.setFont(new Font("serif", Font.BOLD, 35));
		
		if((score / 10) == 0)
			g.drawString(Integer.toString(score), 60, 100);
		else if((score / 100) == 0)
			g.drawString(Integer.toString(score), 50, 100);
		else if((score / 1000) == 0)
			g.drawString(Integer.toString(score), 40, 100);
		else
			g.drawString(Integer.toString(score), 30, 100);
		
	
		g.fillRect(20, 200, 110, 3);

		g.drawString("Lives", 30, 190);
		g.setFont(new Font("serif", Font.BOLD, 35));
		
		if((lives / 10) == 0)
			g.drawString(Integer.toString(lives), 60, 240);
		else if((lives / 100) == 0)
			g.drawString(Integer.toString(lives), 50, 240);
		else if((lives / 1000) == 0)
			g.drawString(Integer.toString(lives), 40, 240);
		else
			g.drawString(Integer.toString(lives), 30, 240);
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void setLives(int lives) {
		this.lives = lives;
	}
}
