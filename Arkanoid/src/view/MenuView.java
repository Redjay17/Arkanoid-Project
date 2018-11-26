package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import main.Command;
/*
 * Menu contains buttons for some of the game's options as well as a console
 * output.
 * 
 */
public class MenuView extends JPanel {	
	public static final int MENUWIDTH = 650;
	public static final int MENULENGTH = 75;
	
	public MenuView() {
		this.setLayout(new FlowLayout());
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		this.setBackground(Color.white); // Temporary.
		this.setPreferredSize(new Dimension(MENUWIDTH, MENULENGTH));

		MapButton owo = new MapButton("Load Face Map", Command.MAP_OWO);
		MapButton cs151 = new MapButton("Load Default Map", Command.MAP_CS151);
		MapButton filled = new MapButton("Load Filled Map", Command.MAP_FILLED);
		MapButton diamond = new MapButton("Load Diamond Map", Command.MAP_DIAMOND);
		MapButton random = new MapButton("Load Random Map", Command.MAP_RANDOM);
		
		this.add(owo);
		this.add(cs151);
		this.add(filled);
		this.add(diamond);
		this.add(random);
	}
}
