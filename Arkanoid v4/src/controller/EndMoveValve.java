package controller;

import model.Model;

/**
 * A Valve implemented for the MOVEEND Command
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
	
	//
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
