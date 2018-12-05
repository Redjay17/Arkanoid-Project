package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;
import model.maps.*;
/*
 * Menu contains buttons for some of the game's options as well as a console
 * output.
 * 
 */
public class MenuPanel extends JPanel {	
	public static final int MENUWIDTH = 650;
	public static final int MENULENGTH = 100;
	
	public MenuPanel() {
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		this.setBackground(Color.white); // Temporary.
		this.setMinimumSize(new Dimension(MENUWIDTH, MENULENGTH));
		this.setPreferredSize(new Dimension(MENUWIDTH, MENULENGTH));
		
		this.add(MenuPanel.createLeftPanel(), BorderLayout.CENTER);
		this.add(MenuPanel.createRightPanel(), BorderLayout.EAST);
	}
	
	private static JPanel createLeftPanel() {
		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(Controller.FIELDWIDTH, MENULENGTH));
		leftPanel.setLayout(new FlowLayout());

		MapButton owo = new MapButton("Load Face Map", new Map_OWO());
		MapButton cs151 = new MapButton("Load Default Map", new Map_CS151());
		MapButton filled = new MapButton("Load Filled Map", new Map_FILLED());
		MapButton diamond = new MapButton("Load Diamond Map", new Map_DIAMOND());
		MapButton cadance = new MapButton("Load Cadance Map", new Map_Cadance());
		MapButton nothing = new MapButton("Load An Empty Map", new Map_Nothing());
		MapButton random = new MapButton("Load Random Map", new Map_Random());
		
		//Actual maps
		leftPanel.add(owo);
		leftPanel.add(cs151);
		leftPanel.add(cadance);
		
		//Code Maps
		leftPanel.add(filled);
		leftPanel.add(diamond);
		leftPanel.add(nothing);
		leftPanel.add(random);
		
		return leftPanel;
	}
	
	private static JPanel createRightPanel() {
		JPanel rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(SidePanel.SIDEVIEWWIDTH, MENULENGTH));
		rightPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JButton pauseButton = new JButton();
		pauseButton.setText("Pause");
		
		JButton resumeButton = new JButton();
		resumeButton.setText("Resume");
		
		resumeButton.setEnabled(false);
		
		JButton resetButton = new JButton();
		resetButton.setText("Reset");
		
		pauseButton.setPreferredSize(new Dimension(SidePanel.SIDEVIEWWIDTH, 25));
		resumeButton.setPreferredSize(new Dimension(SidePanel.SIDEVIEWWIDTH, 25));
		resetButton.setPreferredSize(new Dimension(SidePanel.SIDEVIEWWIDTH, 25));
		
		pauseButton.setBackground(Color.white);
		resumeButton.setBackground(Color.white);
		resetButton.setBackground(Color.white);
		
		
		rightPanel.add(pauseButton);
		rightPanel.add(resumeButton);
		rightPanel.add(resetButton);
		
		return rightPanel;
	}
}
