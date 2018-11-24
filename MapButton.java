package a7_Send;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**
 * A way for a user to click a button and load a map into the screen.
 * 
 * @author Leo_Le
 *
 */
public class MapButton extends JButton implements MouseListener {
	Map map;
	GamePanel panel;

	public MapButton(String title, Map map, GamePanel panel) {
		super(title);
		this.map = map;
		this.panel = panel;
		addMouseListener(this);
		setFocusable(false);
	}

	public void setMap(Map map) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		panel.loadMap(map);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
