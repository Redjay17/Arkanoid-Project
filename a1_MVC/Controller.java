package a1_MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.Timer;

public class Controller implements ActionListener {
	public static final int fieldPanelLength = 500;
	public static final int fieldPanelWidth = 500;
	Model model = new Model();
	
	//can replace Window with View class. Same result
	Window view = new Window();
	public static PriorityQueue<Command> commands = new PriorityQueue<>();
	int delay = 4;
	Timer timer = new Timer(delay, this);
	
	public Controller() {
		timer.start();
	}
	
	public void gameLoop() {
		model.calculate();
		if(commands.size() > 0) {
			Command command = commands.remove();
			if(command.equals(Command.SPACE)) {
				model.shoot();
			}
			if(command.equals(Command.LEFT)) {
				model.moveLeft();
			}
			
			if(command.equals(Command.RIGHT)) {
				model.moveRight();
			}
		}
		
		view.getGameView().setObjects(model.getObjects());
		view.getGameView().repaint();
		
		
	}

	
	public void actionPerformed(ActionEvent e) {
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
