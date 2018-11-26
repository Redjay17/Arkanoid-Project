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
	public static final int MENULENGTH = 50;
	
	public MenuView() {
		this.setLayout(new FlowLayout());
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		this.setBackground(Color.white); // Temporary.
		this.setPreferredSize(new Dimension(MENUWIDTH, MENULENGTH));

		MapButton owo = new MapButton("Load_Map_OWO", Command.MAP_OWO);
		this.add(owo);

		MapButton cs151 = new MapButton("Load_Map_CS151", Command.MAP_CS151);
		this.add(cs151);
		
		MapButton defaultMap = new MapButton("Load Default Map", Command.MAP_DEFAULT);
		this.add(defaultMap);
	}
}
