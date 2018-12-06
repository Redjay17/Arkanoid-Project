package controller;

import model.Model;

/**
 * A Valve implemented for the LOADMAP Command
 * @author Arman Sandher
 *
 */
public class LoadMapValve implements Valve{

	private Model model;
	
	
	/**
	 * Constructor for LoadMapValve.
	 * @param model
	 */
	public LoadMapValve(Model model)
	{
		this.model = model;
	}
	
	@Override
	public ValveResponse execute(Command message) {
		// TODO Auto-generated method stub
		if(message.getClass() != Command.class || !(message == Command.LOADMAP))
		{
			return ValveResponse.MISS;
		}
		
		model.loadMap(Command.currMap);
		
		return ValveResponse.EXECUTED;
		
	}
	
}

