package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

import javax.swing.Timer;

import model.Map;
import model.Model;
import model.maps.*;
import view.GamePanel;
import view.SidePanel;
import view.View;

/*
 * The controller takes all inputs, calculates it in model, and outputs it to the view
 * 
 * TODO: Implement valves. Maybe add strategy
 * 
 * 
 */
public class Controller{
	public static final PriorityQueue<Command> commands = new PriorityQueue<>();
	
	public static final int FIELDLENGTH = 500;
	public static final int FIELDWIDTH = 500;
	public static final Map DEFAULTMAP = new Map_CS151();
	
	private static final int DELAY = 1;
	private Command currentCommand;
	
	Model model;
	View view;
	Timer t;

	public Controller() {
		model = new Model(DEFAULTMAP);
		view = new View();
		
		model.loadMap(new Map_CS151());
		
		t = new Timer(DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameLoop();
			}
			
		});
		
		t.start();
	}

	public void gameLoop() {
		//while(currentCommand != Command.EXIT) {
		model.calculate();
		if (!commands.isEmpty()) {
			currentCommand = commands.remove();
			switch(currentCommand) {
			case SPACE:
				model.shoot();
				break;
			case LEFTSTART:
				model.startMovement(-1);
				break;
			case RIGHTSTART:
				model.startMovement(1);
				break;
			case MOVEEND:
				model.endMovement();
				break;
			case ENTER:
				model.restart();
				break;
			//MAPS
			case LOADMAP:
				model.loadMap(Command.currMap);
			default:
				break;
			}
		}
			
			view.updatePanels();
		//}
	}

	public void start() {
		view.start();
	}
}
