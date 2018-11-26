package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

import entities.Map;
import view.GameView;
import view.MapButton;
import view.SideView;

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
	public static final int FIELDLENGTH = 500;
	public static final int FIELDWIDTH = 500;

	PriorityQueue<Command> commands = Controller.commands;

	JPanel menuPanel;
	SideView sidePanel;
	GameView gameplay;

	public View() {
		this.setTitle("Arkanoid");
		this.setLayout(new BorderLayout());
		
		gameplay = new GameView();
		sidePanel = new SideView();
		menuPanel = createMenuPanel();
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
	 * Menu contains buttons for some of the game's options as well as a console
	 * output.
	 * 
	 */
	private JPanel createMenuPanel() {
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new FlowLayout());
		menuPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		menuPanel.setBackground(Color.white); // Temporary.
		menuPanel.setPreferredSize(new Dimension(640, 100));

		MapButton owo = new MapButton("Load_Map_OWO", Command.MAP_OWO);
		menuPanel.add(owo);

		MapButton cs151 = new MapButton("Load_Map_CS151", Command.MAP_CS151);
		menuPanel.add(cs151);

		return menuPanel;

	}

	public void loadMap(Map map) {
		remove(gameplay);
		this.add(gameplay, BorderLayout.CENTER);
	}

	public GameView getGameView() {
		return gameplay;
	}
	
	public SideView getSideView() {
		return sidePanel;
	}
}