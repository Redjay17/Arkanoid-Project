package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.PriorityQueue;

import javax.swing.JButton;

import controller.Command;
import controller.Controller;
import model.Map;

/**
 * A way for a user to click a button and load a map into the screen.
 * 
 * @author Leo_Le
 *
 */
public class MapButton extends JButton {
	PriorityQueue<Command> commands = Controller.commands;
	Command command;
	Map map;

	public MapButton(String title, Map map) {
		this.command = Command.LOADMAP;
		this.setText(title);
		this.setFocusable(false);
		this.map = map;
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				commands.add(command);
				Command.currMap = map;

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
		});
	}
}
