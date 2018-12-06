package edu.sjsu.cs.cs151.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

import javax.swing.Timer;

import edu.sjsu.cs.cs151.controller.valve.EndMoveValve;
import edu.sjsu.cs.cs151.controller.valve.EnterValve;
import edu.sjsu.cs.cs151.controller.valve.LeftValve;
import edu.sjsu.cs.cs151.controller.valve.LoadMapValve;
import edu.sjsu.cs.cs151.controller.valve.RightValve;
import edu.sjsu.cs.cs151.controller.valve.SpaceValve;
import edu.sjsu.cs.cs151.controller.valve.Valve;
import edu.sjsu.cs.cs151.controller.valve.ValveResponse;
import edu.sjsu.cs.cs151.model.Map;
import edu.sjsu.cs.cs151.model.Model;
import edu.sjsu.cs.cs151.model.maps.*;
import edu.sjsu.cs.cs151.view.GamePanel;
import edu.sjsu.cs.cs151.view.SidePanel;
import edu.sjsu.cs.cs151.view.View;

/**
 * The controller takes all inputs, calculates it in model, and outputs it to the view
 * 
 * @author Arman Sandher
 * @author Redjay
 * @author Leo_Le
 * 
 */
public class Controller implements Valve{
	public static final PriorityQueue<Command> commands = new PriorityQueue<>();
	
	public static final int FIELDLENGTH = 500;
	public static final int FIELDWIDTH = 500;
	public static final Map DEFAULTMAP = new Map_Cadance();
	
	private static final int DELAY = 5;
	private Command currentCommand;
	
	private int NumberOfCommands = 6;
	private Valve[] data = new Valve[NumberOfCommands];
	
	private Model model;
	private View view;
	private Timer t;

	
	public Controller() {
		this.model = new Model(DEFAULTMAP);
		this.view = new View();
		this.initializeClassVariable();
		this.t = new Timer(DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameLoop();
			}
			
		});
	}
	
	/**
	 * The main loop in the game. Calculates the model and updates the view accordingly.
	 */
	public void gameLoop() {
		model.calculate();
		if (!commands.isEmpty()) {
			currentCommand = commands.remove();
			execute(currentCommand);
		}
			view.updatePanels();
		
	}

	/**
	 * Starts the game. The timer is started and the view is displayer.
	 * The game cannot start without this method.
	 */
	public void start() {
		t.start();
		view.start();
	}
	
	/**
	 * Valves instead of if's or cases
	 */
	@Override
	public ValveResponse execute(Command message)
	{		
		for(int i = 0; i < data.length ; i++)
		{
			data[i].execute(message);
		}
		return ValveResponse.EXECUTED;
	}
	
	/**
	 * Initialize the valves in the other classes based on model
	 */
	public void initializeClassVariable()
	{
		SpaceValve space = new SpaceValve(model);
		LeftValve left = new LeftValve(model);
		RightValve right = new RightValve(model);
		EndMoveValve endMove = new EndMoveValve(model);
		EnterValve enter = new EnterValve(model);
		LoadMapValve loadMap = new LoadMapValve(model);
		data[0] = space;
		data[1] = left;
		data[2] = right;
		data[3] = endMove;
		data[4] = enter;
		data[5] = loadMap;
	}
}
