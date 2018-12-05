package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.PriorityQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Command;
import controller.Controller;
import model.Map;

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
	public static final int VIEWLENGTH = MenuPanel.MENULENGTH + SidePanel.SIDEVIEWLENGTH;
	public static final int VIEWWIDTH = MenuPanel.MENUWIDTH + 13;

	PriorityQueue<Command> commands = Controller.commands;

	MenuPanel menuPanel;
	SidePanel sidePanel;
	GamePanel gameplay;

	public View() {
		gameplay = new GamePanel();
		sidePanel = new SidePanel();
		menuPanel = new MenuPanel();
		
		gameplay.setFocusable(true);
		sidePanel.setFocusable(false);
		menuPanel.setFocusable(false);
	}

	public void start() {
		this.setTitle("Arkanoid");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.add(gameplay, BorderLayout.CENTER);
		this.add(menuPanel, BorderLayout.SOUTH);
		this.add(sidePanel, BorderLayout.EAST);
		
		this.pack();
		this.setVisible(true);
	}

	public void loadMap(Map map) {
		this.remove(gameplay);
		this.add(gameplay, BorderLayout.CENTER);
	}
	
	public void updatePanels() {
		this.sidePanel.repaint();
		this.gameplay.repaint();
	}

	public GamePanel getGameView() {
		return gameplay;
	}
	
	public SidePanel getSideView() {
		return sidePanel;
	}
}