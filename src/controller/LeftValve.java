package controller;

import model.Model;

/**
 * a valve for the Left command
 * @author Arman Sandher
 *
 */
public class LeftValve implements Valve
{

	private Model model;
	
	
	public LeftValve(Model model)
	{
		this.model = model;
	}
	
	public ValveResponse execute(Command message) 
	{
		// TODO Auto-generated method stub
		if(message.getClass() != Command.class || !(message == Command.LEFTSTART))
		{
			return ValveResponse.MISS;
		}
		
		model.startMovement(-1);
		
		return ValveResponse.EXECUTED;
		
	}
	
}
