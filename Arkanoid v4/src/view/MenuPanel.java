package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import maps.*;
/**
 * Menu contains buttons for some of the game's options as well as a console
 * output.
 * 
 */
public class MenuPanel extends JPanel {	
	public static final int MENUWIDTH = 650;
	public static final int MENULENGTH = 100;
	
	public MenuPanel() {
		this.setLayout(new FlowLayout());
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		this.setBackground(Color.white); // Temporary.
		this.setPreferredSize(new Dimension(MENUWIDTH, MENULENGTH));

		MapButton owo = new MapButton("Load Face Map", new Map_OWO());
		MapButton cs151 = new MapButton("Load CS151 Map", new Map_CS151());
		MapButton filled = new MapButton("Load Filled Map", new Map_FILLED());
		MapButton diamond = new MapButton("Load Diamond Map", new Map_DIAMOND());
		MapButton cadance = new MapButton("Load Cadance Map", new Map_Cadance());
		MapButton nothing = new MapButton("Load An Empty Map", new Map_Nothing());
		MapButton random = new MapButton("Load Random Map", new Map_Random());
		
		this.add(owo);
		this.add(cs151);
		this.add(filled);
		this.add(diamond);
		this.add(cadance);
		this.add(nothing);
		this.add(random);
	}

}
