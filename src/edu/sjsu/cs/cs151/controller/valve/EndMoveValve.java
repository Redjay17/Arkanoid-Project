package edu.sjsu.cs.cs151.controller.valve;

import edu.sjsu.cs.cs151.controller.Command;
import edu.sjsu.cs.cs151.model.Model;

/**
 * A valve for the End Move command
 * @author Arman Sandher
 *
 */
public class EndMoveValve implements Valve{

	private Model model;
	
	/**
	 * Constructor for EndMoveValve.
	 * @param model
	 */
	public EndMoveValve(Model model)
	{
		this.model = model;
	}
	
	@Override
	public ValveResponse execute(Command message) {
		// TODO Auto-generated method stub
		if(message.getClass() != Command.class || !(message == Command.MOVEEND))
		{
			return ValveResponse.MISS;
		}
		
		model.endMovement();
		
		return ValveResponse.EXECUTED;
		
	}
	
}
