package controller;

import model.Model;

/**
 * a valve for the Space command
 * @author Arman Sandher
 *
 */
public class SpaceValve implements Valve{

	private Model model;
	
	
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
