package edu.sjsu.cs.cs151.controller.valve;

import edu.sjsu.cs.cs151.controller.Command;
import edu.sjsu.cs.cs151.controller.GameInfo;
import edu.sjsu.cs.cs151.model.Model;

/**
 * A valve for the Load map command
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
		
		model.loadMap(GameInfo.getCurrMapLoaded());
		
		return ValveResponse.EXECUTED;
		
	}
	
}

