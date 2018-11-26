package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.Timer;

import entities.maps.Map_CS151;
import entities.maps.Map_OWO;
import view.GameView;
import view.SideView;

public class Controller implements ActionListener {
	public static final int FIELDLENGTH = 500;
	public static final int FIELDWIDTH = 500;
	
	public static final PriorityQueue<Command> commands = new PriorityQueue<>();
	
	Model model = new Model();
	View view = new View();

	int delay = 4;
	Timer timer = new Timer(delay, this);
	
	public Controller() {
		timer.start();
		// default map
		model.loadMap(new Map_CS151());
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
			if (command.equals(Command.MAP_OWO)) {
				model.loadMap(new Map_OWO());
			}
			if (command.equals(Command.MAP_CS151)) {
				model.loadMap(new Map_CS151());
			}

			if (command.equals(Command.ENTER)) {
				model.restart();
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
