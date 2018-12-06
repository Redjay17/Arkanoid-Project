package edu.sjsu.cs.cs151.controller.valve;

import edu.sjsu.cs.cs151.controller.Command;

/**
 * Valves performs certain actions based on their purpose.
 * Each valve has three states: Executed, Missed, and Finished.
 * If the valve has a different input than needed, it will throw a Missed flag
 * Else, the valve will execute and finish accordingly.
 * 
 * @author Arman Sandher
 *
 */
public interface Valve
{
	
	/**
	 * performs certain action in response to message
	 */
	public ValveResponse execute(Command message);
	
}
