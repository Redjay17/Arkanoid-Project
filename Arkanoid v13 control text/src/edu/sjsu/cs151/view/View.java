package edu.sjsu.cs151.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.PriorityQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.sjsu.cs151.controller.Command;
import edu.sjsu.cs151.controller.Controller;
import edu.sjsu.cs151.model.Map;

/**
 * The FRAME which every panel is added onto. 
 * 
 * @author Team 5
 *
 */
public class View extends JFrame {
	private static final long serialVersionUID = 1L;

	// MAKE 100% ABSOLUTELY SURE THAT FIELDPANELENGTH AND FIELDPANEWITH ARE
	// USED TO CONSTRUCT THE JPANEL WHERE THE GAME IS PLAYED
	public static final int VIEWLENGTH = 600;
	public static final int VIEWWIDTH = 650;

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
		this.setPreferredSize(new Dimension(VIEWWIDTH, VIEWLENGTH));
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
		this.menuPanel.repaint();
	}

	public GamePanel getGameView() {
		return gameplay;
	}
	
	public SidePanel getSideView() {
		return sidePanel;
	}
	
	public MenuPanel getMenuView() {
		return menuPanel;
	}
}