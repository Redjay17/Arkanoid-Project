package edu.sjsu.cs.cs151.controller.valve;

import edu.sjsu.cs.cs151.controller.Command;
import edu.sjsu.cs.cs151.model.Model;

/**
 * A valve for the Right command
 * @author Arman Sandher
 *
 */
public class RightValve implements Valve{

	private Model model;
	
	/**
	 * Constructor for RightValve.
	 * @param model
	 */
	public RightValve(Model model)
	{
		this.model = model;
	}
	
	@Override
	public ValveResponse execute(Command message) {
		// TODO Auto-generated method stub
		if(message.getClass() != Command.class || !(message == Command.RIGHTSTART))
		{
			return ValveResponse.MISS;
		}
		
		model.startMovement(1);
		
		return ValveResponse.EXECUTED;
		
	}
	
}
