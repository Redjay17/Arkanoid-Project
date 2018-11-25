package a1_MVC;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.PriorityQueue;

import javax.swing.JFrame;

public class MyView extends JFrame implements KeyListener {
	PriorityQueue<Command> commands = new PriorityQueue<>();
	GameView gameView= new GameView();
	public void start() {
		setLayout(new BorderLayout());
		add(gameView, BorderLayout.CENTER);
		gameView.setSize(Controller.fieldPanelWidth,Controller.fieldPanelLength);
		setVisible(true);
	}
	

	public GameView getGameView() {
		return gameView;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
