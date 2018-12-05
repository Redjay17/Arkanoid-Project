package edu.sjsu.cs151.controller;

import edu.sjsu.cs151.model.Map;

public enum Command {
	ENTER, EXIT, SPACE, LEFTSTART, RIGHTSTART, MOVEEND, LOADMAP;
	
	public static Map currMap;
}
