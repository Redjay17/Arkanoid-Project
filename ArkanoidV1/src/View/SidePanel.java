package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Controller.GameInfo;

/**
 * handles writing of the score, or anything involving text for that matter
 * 
 * @author Leo_Le
 *
 */
public class SidePanel extends JPanel {
	public int score = 0;
	final private int panelLength = 150;
	final private int panelWidth = 400;

	public SidePanel() {
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(panelLength, panelWidth));
		setBorder(BorderFactory.createBevelBorder(0));

	}

	Color backgroundColor = Color.gray;
	Color guiColor = Color.black;

	// displays the score
	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		//Update Score based on GameInfo from controller
		score = GameInfo.getScore();
		g.setColor(backgroundColor);
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(guiColor);
		g.setFont(new Font("serif", Font.BOLD, 35));

		// the line under score
		g.fillRect(20, 200, 110, 3);

		g.drawString("Score", 30, 190);
		g.setFont(new Font("serif", Font.BOLD, 35));
		g.drawString(Integer.toString(score), 45, 240);
	}

	public void setScore(int score) {
		this.score = score;
	}
}
