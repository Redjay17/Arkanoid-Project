package a4_MVC;

import java.util.PriorityQueue;
import java.util.Queue;

public class test {

	public static void main(String[] args) {
		PriorityQueue<Command> queue = new PriorityQueue<>();
		queue.add(Command.SPACE);
		
		Command command = queue.remove();

	

		System.out.println(command.toString());
		if(command == Command.SPACE) {
			System.out.println("yes");
		}

		if (queue.size() > 0) {
			Command command2 = queue.remove();
		}
		else {
			System.out.println("empty queue");
		}
		
		queue.add((Command.LEFT));
		if (queue.size() > 0) {
			Command command3 = queue.remove();
			System.out.println(command3);
		}
	}

}
