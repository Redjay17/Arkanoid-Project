package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

import javax.swing.Timer;

import entities.maps.*;
import main.Model;
import view.GamePanel;
import view.SideView;
import view.View;

public class Controller implements ActionListener {
	public static final int FIELDLENGTH = 500;
	public static final int FIELDWIDTH = 500;
	public static final PriorityQueue<Command> commands = new PriorityQueue<>();
	
	private static final int DELAY = 1;
	private Command currentCommand;
	
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
		//gameLoop();
	}

	public void gameLoop() {
		//while(currentCommand != Command.EXIT) {
			model.calculate();
			if (commands.size() > 0) {
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
				case MAP_OWO:
					model.loadMap(new Map_OWO());
					break;
				case MAP_CS151:
					model.loadMap(new Map_CS151());
					break;
				case MAP_FILLED:
					model.loadMap(new Map_FILLED());
					break;
				case MAP_DIAMOND:
					model.loadMap(new Map_DIAMOND());
					break;
				case MAP_RANDOM:
					model.loadMap(new Map_Random());
					break;
				default:
					break;
				}
			}

			GamePanel gp = view.getGameView();
			SideView sv = view.getSideView();

			// repaints view based off of the new info in model
			gp.setObjects(model.getObjects());
			gp.setBricks((model.getBricks()));
			gp.setAlive(model.getAlive());
			gp.repaint();

			sv.setLives(model.getLives());
			sv.setScore(model.getScore());
			sv.repaint();
			//}
	}

	public void actionPerformed(ActionEvent e) {
		// yes. I wanted to follow naming conventions.
		gameLoop();

	}

	public void start() {
		view.start();

	}
}
