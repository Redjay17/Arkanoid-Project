package View;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.PriorityQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Command.Command;
import Controller.Controller;

/**
 * View of the game
 * 
 * @author Team 5
 *
 */
public class View extends JFrame {
	private static final long serialVersionUID = 1L;

	public static final int fieldPanelLength = 500;
	public static final int fieldPanelWidth = 500;

	PriorityQueue<Command> commands = Controller.commands;

	SidePanel sidePanel = new SidePanel();
	JPanel menuPanel;
	JPanel fieldPanel;
	GamePanel gameplay = new GamePanel();

	public View() {
		this.setTitle("Arkanoid");
		this.setLayout(new BorderLayout());

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
		textArea.setPreferredSize(new Dimension(153, 100));

		textArea.setText("\n ==== Arkanoid Project ==== \n ======= CS 151 ======= \n =======Group 6=======");

		textArea.setFocusable(false);
		textArea.setBackground(Color.white); // Temporary.

		// Buttons
		JPanel buttonPanel = new JPanel(new GridLayout(3, 2));
		buttonPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		buttonPanel.setBackground(new Color(66, 66, 66));
		buttonPanel.setPreferredSize(new Dimension(501, 100));

		//the buttons that load the map
		MapButton owo = new MapButton("Load_Map_OWO", Command.MAP_OWO);
		buttonPanel.add(owo);

		MapButton cs151 = new MapButton("Load_Map_CS151", Command.MAP_CS151);
		buttonPanel.add(cs151);

		MapButton cadence = new MapButton("Load_Map_Cadence", Command.MAP_CADENCE);
		buttonPanel.add(cadence);

		menuPanel.add(textArea, BorderLayout.EAST);
		menuPanel.add(buttonPanel, BorderLayout.CENTER);

		return menuPanel;

	}

	/*
	 * Side panel contains stats for the game
	 */
	
	public static void main(String[] args) {
		View w = new View();
		w.start();
	}

	public GamePanel getGameView() {
		return gameplay;
	}

	public SidePanel getSidePanel() {
		return sidePanel;
	}
}