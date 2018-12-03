package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.Timer;

import Command.Command;
import Model.Ball;
import Model.Brick;
import Model.Map_CS151;
import Model.Map_Cadence;
import Model.Map_OWO;
import Model.Model;
import Model.Player;
import Model.Rect;
import View.View;
import ValveResponse.ValveResponse;


/**
 * takes information from model to feed into view
 * 
 * @author Leo Le
 *
 */
public class Controller implements ActionListener {
	
	public static final int fieldPanelLength = 500;
	public static final int fieldPanelWidth = 500;
	public Model model = new Model();

	// can replace Window with View class. Same result
	View view = new View();
	public static PriorityQueue<Command> commands = new PriorityQueue<>();
	int delay = 5;
	Timer timer = new Timer(delay, this);

	public Controller() {
		timer.start();

		// default map
		model.loadMap(new Map_Cadence());
	}

	
	/**
	 * Game View object in Controller to keep all the inforamtion in Model and pass it onto View
	 * @param Bricks
	 * @param IsAlive
	 * @param Objects
	 * @param win
	 */
//	public void GameInfo(ArrayList<Brick> Bricks, boolean IsAlive, 
//			ArrayList<Rect> Objects, boolean win, Player Player, Ball Ball,
//			Model Score)
//	{
//		Bricks = model.getBricks();
//		Objects = model.getObjects();
//		IsAlive = model.getAlive();
//		win = model.getWon();
//		Player = model.getPlayer();
//		Ball  = model.getBall();
//	}
	
	
//	
//	public ValveResponse execute(Command message)
//	{
//		if(message.getClass() != NewGameMessage.class)
//		{
//			return ValveResponse.MISS;
//		}
//		
//		//something in Model
//		return ValveResponse.EXECUTED;
//	}
	
	
	
	
	/**
	 * use this
	 */
	public void gameLoop() {
		// all the physics are refreshed and do as they need to
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
			if (command.equals(Command.MAP_CADENCE)) {
				model.loadMap(new Map_Cadence());
			}

			if (command.equals(Command.ENTER)) {
				model.restart();
			}
			
//			if(command.getClass() != null){
//				return ValveResponse.MISS;
//			}
//			
//			//do stuff for Model
//			
//			return ValveResponse.EXECUTED;
		}

		// feeds information to view so view can repaint
		
		view.getGameView().setObjects(model.getObjects());
		view.getGameView().setBricks((model.getBricks()));
		view.getGameView().setAlive(model.getAlive());
		view.getGameView().setWon(model.getWon());
		view.getGameView().setPlayer(model.getPlayer());
		view.getGameView().setBall(model.getBall());
		view.getGameView().repaint();

		// feeds information to model so model can repaint
		view.getSidePanel().setScore(model.getScore());
		view.getSidePanel().repaint();

		//return ValveResponse.EXECUTED;
	}

	public void actionPerformed(ActionEvent e) {
		// yes. I wanted to follow naming conventions.
		gameLoop();

	}

	public void start() {
		view.start();

	}

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.start();
	}
}
