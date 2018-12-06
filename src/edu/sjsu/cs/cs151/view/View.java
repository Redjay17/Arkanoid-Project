package edu.sjsu.cs.cs151.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.PriorityQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.sjsu.cs.cs151.controller.Command;
import edu.sjsu.cs.cs151.controller.Controller;
import edu.sjsu.cs.cs151.model.Map;

/**
 * The FRAME which every panel is added onto. 
 * 
 * @author Leo_Le
 * @author Redjay
 */
public class View {
	public static final int VIEWLENGTH = 600; //Cannot be smaller than the total length of all other JPanels
	public static final int VIEWWIDTH = 650;  //Cannot be smaller than the total width of all other JPanels

	PriorityQueue<Command> commands = Controller.commands;
	
	JFrame mainFrame;

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
		mainFrame = new JFrame();
		mainFrame.setTitle("Arkanoid");
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setPreferredSize(new Dimension(VIEWWIDTH, VIEWLENGTH));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		
		mainFrame.add(gameplay, BorderLayout.CENTER);
		mainFrame.add(menuPanel, BorderLayout.SOUTH);
		mainFrame.add(sidePanel, BorderLayout.EAST);
		
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

	public void loadMap(Map map) {
		mainFrame.remove(gameplay);
		mainFrame.add(gameplay, BorderLayout.CENTER);
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
	
	public MenuPanel getMenuView() {
		return menuPanel;
	}
}