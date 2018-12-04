package MapGenerator3_UI_Friendlier;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class ScreenKeyTest extends JFrame implements KeyListener {

	public static void main(String[] args) {
		ScreenKeyTest screen = new ScreenKeyTest();
		screen.start();
		screen.setFocusable(true);
	}

	public ScreenKeyTest() {
		addKeyListener(this);
		setFocusable(true);
	}

	public void start() {
		setBounds(100, 100, 500, 500);
		setVisible(true);
	}

	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("REMOVED LAST BRICK");
		}

	}

}
