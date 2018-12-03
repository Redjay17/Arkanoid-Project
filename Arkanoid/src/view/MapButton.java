package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.PriorityQueue;

import javax.swing.JButton;

import controller.Command;
import controller.Controller;

/**
 * A way for a user to click a button and load a map into the screen.
 * 
 * @author Leo_Le
 *
 */
public class MapButton extends JButton {
	PriorityQueue<Command> commands = Controller.commands;
	Command command;

	public MapButton(String title, Command command) {
		this.command = command;
		this.setText(title);
		this.setFocusable(false);
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				commands.add(command);

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
