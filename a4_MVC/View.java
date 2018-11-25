package a4_MVC;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * View of the game
 * 
 * @author Team 5
 *
 */
public class View extends JFrame {
	private static final long serialVersionUID = 1L;

	// MAKE 100% ABSOLUTELY SURE THAT FIELDPANELENGTH AND FIELDPANEWITH ARE
	// USED TO CONSTRUCT THE JPANEL WHERE THE GAME IS PLAYED
	public static final int fieldPanelLength = 500;
	public static final int fieldPanelWidth = 500;

	PriorityQueue<Command> commands = Controller.commands;

	JPanel sidePanel;
	JPanel menuPanel;
	JPanel fieldPanel;
	GameView gameplay = new GameView();

	public View() {
		this.setTitle("Arkanoid");
		this.setLayout(new BorderLayout());

		sidePanel = createSidePanel();
		menuPanel = createMenuPanel();
		fieldPanel = new JPanel();

		fieldPanel.setBackground(Color.white); // Temporary.
		fieldPanel.setPreferredSize(new Dimension(fieldPanelWidth, fieldPanelLength));
	}

	public void start() {
		this.add(gameplay, BorderLayout.CENTER);
		this.add(menuPanel, BorderLayout.SOUTH);
		this.add(sidePanel, BorderLayout.EAST);

		gameplay.setFocusable(true);
		menuPanel.setFocusable(false);

		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	/*
	 * Sets the field panel according to what the state of the game is (Menu, level
	 * select, game)
	 */
	public void setFieldPanel(JPanel fieldPanel) {
		this.fieldPanel = fieldPanel;
	}

	/*
	 * Menu contains buttons for some of the game's options as well as a console
	 * output.
	 * 
	 */
	private JPanel createMenuPanel() {
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new BorderLayout());
		menuPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		menuPanel.setBackground(Color.white); // Temporary.
		menuPanel.setPreferredSize(new Dimension(650, 100));

		// Console output
		JTextArea textArea = new JTextArea();
		textArea.setBorder(BorderFactory.createBevelBorder(0));
		textArea.setEditable(false);
		textArea.setPreferredSize(new Dimension(149, 100));

		textArea.setText("Testing");
		textArea.setFocusable(false);
		textArea.setBackground(Color.green); // Temporary.

		// Buttons
		JPanel buttonPanel = new JPanel(new GridLayout(3, 2));
		buttonPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		buttonPanel.setBackground(new Color(66, 66, 66));
		buttonPanel.setPreferredSize(new Dimension(501, 100));

		MapButton owo = new MapButton("Load_Map_OWO", Command.MAP_OWO);
		buttonPanel.add(owo);

		MapButton cs151 = new MapButton("Load_Map_CS151", Command.MAP_CS151);
		buttonPanel.add(cs151);

		menuPanel.add(textArea, BorderLayout.EAST);
		menuPanel.add(buttonPanel, BorderLayout.CENTER);

		return menuPanel;

	}

	/*
	 * Side panel contains stats for the game
	 */
	private JPanel createSidePanel() {
		JPanel sidePanel = new JPanel();

		sidePanel.setLayout(new FlowLayout());
		sidePanel.setPreferredSize(new Dimension(150, 400));
		sidePanel.setBorder(BorderFactory.createBevelBorder(0));
		sidePanel.setBackground(Color.GRAY); // Temporary.

		JTextPane nameArea = new JTextPane();
		nameArea.setPreferredSize(new Dimension(150, 62));
		nameArea.setText("\n------------Arkanoid------------");
		nameArea.setFocusable(false);

		JPanel scoreArea = new JPanel();
		JTextField score = new JTextField("Score");
		score.setFocusable(false);
		JTextField scoreVar = new JTextField("A Number");
		scoreVar.setFocusable(false);
		scoreArea.setLayout(new BoxLayout(scoreArea, BoxLayout.PAGE_AXIS));
		scoreArea.setPreferredSize(new Dimension(150, 140));
		scoreArea.add(score);
		scoreArea.add(scoreVar);

		JPanel livesArea = new JPanel();
		JTextField lives = new JTextField("Lives");
		lives.setFocusable(false);
		JTextField livesVar = new JTextField("A Number");
		livesVar.setFocusable(false);
		livesArea.setLayout(new BoxLayout(livesArea, BoxLayout.PAGE_AXIS));
		livesArea.setPreferredSize(new Dimension(150, 140));
		livesArea.add(lives);
		livesArea.add(livesVar);

		JPanel levelArea = new JPanel();
		JTextField level = new JTextField("Lives");
		level.setFocusable(false);
		JTextField levelVar = new JTextField("A Number");
		levelVar.setFocusable(false);
		levelArea.setPreferredSize(new Dimension(150, 140));
		levelArea.setLayout(new BoxLayout(levelArea, BoxLayout.PAGE_AXIS));
		levelArea.setPreferredSize(new Dimension(150, 140));
		levelArea.add(level);
		levelArea.add(levelVar);

		// scoreArea.setText("------Score------\n");
		// livesArea.setText("------Lives------\n");
		// levelArea.setText("-Current level-\n");

		sidePanel.add(nameArea);
		sidePanel.add(scoreArea);
		sidePanel.add(livesArea);
		sidePanel.add(levelArea);

		return sidePanel;
	}

	public void loadMap(Map map) {
		remove(gameplay);
		this.add(gameplay, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		View w = new View();
		w.start();
	}

	public GameView getGameView() {
		return gameplay;
	}
}