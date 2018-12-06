package controller;

public interface Valve
{
	
	/**
	 * performs certain action in response to message
	 */
	public ValveResponse execute(Command message);
	
}