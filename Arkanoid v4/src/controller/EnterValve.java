package controller;

import model.Model;

/**
 * A Valve implemented for the ENTER Command
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
