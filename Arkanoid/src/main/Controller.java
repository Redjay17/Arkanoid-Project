package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

import javax.swing.Timer;

import entities.maps.*;
import view.GameView;
import view.SideView;

public class Controller implements ActionListener {
	public static final int FIELDLENGTH = 500;
	public static final int FIELDWIDTH = 510;
	public static final PriorityQueue<Command> commands = new PriorityQueue<>();
	
	private static final int DELAY = 4;
	
	Model model;
	View view;
	Timer timer;

	public Controller() {
		model = new Model();
		view = new View();
		timer = new Timer(DELAY, this);
		// default map
		model.loadMap(new Map_CS151());
		timer.start();
	}

	public void gameLoop() {
		model.calculate();
		if (commands.size() > 0) {
			Command command = commands.remove();
			if (command.equals(Command.SPACE)) {
				model.shoot();
			}
			if (command.equals(Command.LEFT)) {
				model.moveLeft();
			}

			if (command.equals(Command.RIGHT)) {
				model.moveRight();
			}
			if (command.equals(Command.ENTER)) {
				model.restart();
			}
			
			if (command.equals(Command.MAP_OWO)) {
				model.loadMap(new Map_OWO());
			}
			if (command.equals(Command.MAP_CS151)) {
				model.loadMap(new Map_CS151());
			}
			if (command.equals(Command.MAP_FILLED)) {
				model.loadMap(new Map_FILLED());
			}
			if (command.equals(Command.MAP_DIAMOND)) {
				model.loadMap(new Map_DIAMOND());
			}
			if (command.equals(Command.MAP_RANDOM)) {
				model.loadMap(new Map_Random());
			}
		}

		
		GameView gp = view.getGameView();
		SideView sv = view.getSideView();
		
		// repaints view based off of the new info in model
		gp.setObjects(model.getObjects());
		gp.setBricks((model.getBricks()));
		gp.setAlive(model.getAlive());
		gp.repaint();
		
		sv.setLives(model.getLives());
		sv.setScore(model.getScore());
		sv.repaint();

	}

	public void actionPerformed(ActionEvent e) {
		// yes. I wanted to follow naming conventions.
		gameLoop();

	}

	public void start() {
		view.start();

	}
}
