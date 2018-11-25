package a4_MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.Timer;

public class Controller implements ActionListener {
	public static final int fieldPanelLength = 500;
	public static final int fieldPanelWidth = 500;
	public Model model = new Model();

	// can replace Window with View class. Same result
	View view = new View();
	public static PriorityQueue<Command> commands = new PriorityQueue<>();
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

		// repaints view based off of the new info in model
		view.getGameView().setObjects(model.getObjects());
		view.getGameView().setBricks((model.getBricks()));
		view.getGameView().repaint();
		view.getGameView().setAlive(model.getAlive());

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
