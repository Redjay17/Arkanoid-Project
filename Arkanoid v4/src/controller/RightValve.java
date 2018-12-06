package controller;

import model.Model;

/**
 * A Valve implemented for the RIGHTSTART Command
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
