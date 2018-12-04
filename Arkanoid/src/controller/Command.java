package controller;

import model.Map;

public enum Command {
	ENTER, EXIT, SPACE, LEFTSTART, RIGHTSTART, MOVEEND, LOADMAP;
	
	public static Map currMap;
}
