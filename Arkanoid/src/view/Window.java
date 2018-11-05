package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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
 * @author Team 5
 *
 */
public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JPanel sidePanel;
	JPanel menuPanel;
	JPanel fieldPanel;
	
	
	public Window() {
		this.setTitle("Arkanoid");
		this.setLayout(new BorderLayout());
		
		sidePanel = createSidePanel();
		menuPanel = createMenuPanel();
		fieldPanel = new JPanel();
		
		fieldPanel.setBackground(Color.black); // Temporary.
		
		fieldPanel.setPreferredSize(new Dimension(500, 500));
	}
	
	public void start() {
		this.add(fieldPanel, BorderLayout.CENTER);
		this.add(menuPanel, BorderLayout.SOUTH);
		this.add(sidePanel, BorderLayout.EAST);
		
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	/*
	 * Sets the field panel according to what the state of the game is (Menu, level select, game) 
	 */
	public void setFieldPanel(JPanel fieldPanel) {
		this.fieldPanel = fieldPanel;
	}
	
	
	/*
	 * Menu contains buttons for some of the game's options as well as a console output.
	 * 
	 */
	private JPanel createMenuPanel() {
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new BorderLayout());
		menuPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		menuPanel.setBackground(Color.white); // Temporary.
		menuPanel.setPreferredSize(new Dimension(650, 100));
		
		
		//Console output
		JTextArea textArea = new JTextArea();
		textArea.setBorder(BorderFactory.createBevelBorder(0));
		textArea.setEditable(false);
		textArea.setPreferredSize(new Dimension(149,100));
		
		textArea.setText("Testing");
		textArea.setBackground(Color.green); // Temporary.
		
		//Buttons
		JPanel buttonPanel = new JPanel(new GridLayout(3, 2));
		buttonPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		buttonPanel.setBackground(Color.red);
		buttonPanel.setPreferredSize(new Dimension(501, 100));
		
		for(int a = 0; a < 6; a++) {
			JButton button = new JButton("Button " + a);
			button.setEnabled(false);
			buttonPanel.add(button);
		}
		
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
		
		JPanel scoreArea = new JPanel();
		JTextField score = new JTextField("Score");
		JTextField scoreVar = new JTextField("A Number");
		scoreArea.setLayout(new BoxLayout(scoreArea, BoxLayout.PAGE_AXIS));
		scoreArea.setPreferredSize(new Dimension(150, 140));
		scoreArea.add(score);
		scoreArea.add(scoreVar);
		
		
		JPanel livesArea = new JPanel();
		JTextField lives = new JTextField("Lives");
		JTextField livesVar = new JTextField("A Number");
		livesArea.setLayout(new BoxLayout(livesArea, BoxLayout.PAGE_AXIS));
		livesArea.setPreferredSize(new Dimension(150, 140));
		livesArea.add(lives);
		livesArea.add(livesVar);
		
		
		JPanel levelArea = new JPanel();
		JTextField level = new JTextField("Lives");
		JTextField levelVar = new JTextField("A Number");
		levelArea.setPreferredSize(new Dimension(150, 140));
		levelArea.setLayout(new BoxLayout(levelArea, BoxLayout.PAGE_AXIS));
		levelArea.setPreferredSize(new Dimension(150, 140));
		levelArea.add(level);
		levelArea.add(levelVar);
		
		
		//scoreArea.setText("------Score------\n");
		//livesArea.setText("------Lives------\n");
		//levelArea.setText("-Current level-\n");
		
		sidePanel.add(nameArea);
		sidePanel.add(scoreArea);
		sidePanel.add(livesArea);
		sidePanel.add(levelArea);
		
		return sidePanel;
	}
	
	public static void main(String[] args) {
		Window w = new Window();
		w.start();
	}
}