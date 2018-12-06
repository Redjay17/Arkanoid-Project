package edu.sjsu.cs.cs151.controller.valve;

import edu.sjsu.cs.cs151.controller.Command;
import edu.sjsu.cs.cs151.model.Model;

/**
 * A valve for the Enter command
 * @author Arman Sandher
 *
 */
public class EnterValve implements Valve{

	private Model model;
	
	/**
	 * Constructor for EnterValve.
	 * @param model
	 */
	public EnterValve(Model model)
	{
		this.model = model;
	}
	
	@Override
	public ValveResponse execute(Command message) {
		// TODO Auto-generated method stub
		if(message.getClass() != Command.class || !(message == Command.ENTER))
		{
			return ValveResponse.MISS;
		}
		
		model.restart();
		
		return ValveResponse.EXECUTED;
		
	}
	
}
