package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controller.GameInfo;

/**
 * Side panel displays the score and lives.
 */
public class SidePanel extends JPanel {	
	public static final int SIDEVIEWLENGTH = 500;
	public static final int SIDEVIEWWIDTH = 150;

	public SidePanel() {
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(SIDEVIEWWIDTH, SIDEVIEWLENGTH));
		setBorder(BorderFactory.createBevelBorder(0));
	}

	Color backgroundColor = Color.white;
	Color guiColor = Color.black;

	/**
	 * Displays the score and lives
	 */
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
		
		int score = GameInfo.getScore();
		
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
		
		int lives = GameInfo.getLives();
		
		if((lives / 10) == 0)
			g.drawString(Integer.toString(lives), 60, 240);
		else if((lives / 100) == 0)
			g.drawString(Integer.toString(lives), 50, 240);
		else if((lives / 1000) == 0)
			g.drawString(Integer.toString(lives), 40, 240);
		else
			g.drawString(Integer.toString(lives), 30, 240);
		

	}
}
