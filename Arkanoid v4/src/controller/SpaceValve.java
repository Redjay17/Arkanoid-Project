package controller;

import model.Model;

/**
 * A Valve implemented for the SPACE Command
 * @author Arman Sandher
 *
 */
public class SpaceValve implements Valve{

	private Model model;
	
	
	/**
	 * Constructor for SpaceValve.
	 * @param model
	 */
	public SpaceValve(Model model)
	{
		this.model = model;
	}
	
	@Override
	public ValveResponse execute(Command message) {
		// TODO Auto-generated method stub
		if(message.getClass() != Command.class || !(message == Command.SPACE))
		{
			return ValveResponse.MISS;
		}
		
		model.shoot();
		
		return ValveResponse.EXECUTED;
		
	}
	
}
