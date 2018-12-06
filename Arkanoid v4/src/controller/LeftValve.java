package controller;

import model.Model;

/**
 * A Valve implemented for the LEFTSTART Command
 * @author Arman Sandher
 *
 */
public class LeftValve implements Valve
{

	private Model model;
	
	
	/**
	 * Constructor for LeftValve.
	 * @param model
	 */
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
