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
public class Controller implements Valve{
	public static final PriorityQueue<Command> commands = new PriorityQueue<>();
	
	public static final int FIELDLENGTH = 500;
	public static final int FIELDWIDTH = 500;
	public static final Map DEFAULTMAP = new Map_CS151();
	
	private static final int DELAY = 1;
	private Command currentCommand;
	
	int NumberOfCommands = 6;
	Valve[] data = new Valve[NumberOfCommands];
	
	Model model;
	View view;
	Timer t;

	public Controller() {
		model = new Model(DEFAULTMAP);
		view = new View();
		initializeClassVariable();
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
			
			execute(currentCommand);
		}
			view.updatePanels();
	}

	public void start() {
		view.start();
	}

	/**
	 * valves instead of if's or cases
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
	 * initialize the valves in the other classes based on model
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

