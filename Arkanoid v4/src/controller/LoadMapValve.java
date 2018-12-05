package controller;

import model.Model;

/**
 * a valve for the Load map command
 * @author Arman Sandher
 *
 */
public class LoadMapValve implements Valve{

	private Model model;
	
	
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

