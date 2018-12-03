package Controller;

import java.util.ArrayList;

import Command.Command;
import Model.Ball;
import Model.Brick;
import Model.Map_CS151;
import Model.Map_Cadence;
import Model.Map_OWO;
import Model.Model;
import Model.Player;
import Model.Rect;
import View.View;
import ValveResponse.ValveResponse;


public class GameInfo 
{
	public Model model = new Model();
	
	static ArrayList<Brick> Bricks = null;
	static boolean IsAlive = false;
	static ArrayList<Rect> Objects = null;
	static boolean Win = false;
	static Player Player = null;
	static Ball Ball = null;
	static int Score = -1;




//	ArrayList<Brick> Bricks, boolean IsAlive, 
//	ArrayList<Rect> Objects, boolean win, Player Player, Ball Ball,
//	Model Score
	
	/**
	 * Game View object in Controller to keep all the inforamtion in Model and pass it onto View
	 * @param Bricks
	 * @param IsAlive
	 * @param Objects
	 * @param Win
	 */
	public GameInfo()
	{
		Bricks = model.getBricks();
		Objects = model.getObjects();
		IsAlive = model.getAlive();
		Win = model.getWon();
		Player = model.getPlayer();
		Ball  = model.getBall();
		Score = model.getScore();
	}
	
	public static void Update(ArrayList<Brick> bricks, boolean isAlive, ArrayList<Rect> objects,
			boolean win, Player player, Ball ball, int score)
	{
		Bricks = bricks;
		IsAlive = isAlive;
		Objects = objects;
		Win = win;
		Player = player;
		Ball = ball;
		Score = score;
	}
	
	public ArrayList<Brick> getBricks()
	{
		return Bricks;
	}
	
	public boolean getAlive()
	{
		return IsAlive;
	}
	
	public ArrayList<Rect> getObjects()
	{
		return Objects;
	}
	
	public boolean getWon()
	{
		return Win;
	}
	
	public Player getPlayer()
	{
		return Player;
	}
	
	public Ball getBall()
	{
		return Ball;
	}
	
	public int getScore()
	{
		return Score;
	}
	
	public void setBricks()
	{
		Bricks = model.getBricks();
	}
	
	public void setAlive()
	{
		Objects = model.getObjects();
	}
	
	public void setObjects()
	{
		IsAlive = model.getAlive();
	}
	
	public void setWon()
	{
		Win = model.getWon();
	}
	
	public void setPlayer()
	{
		Player = model.getPlayer();
	}
	
	public void setBall()
	{
		Ball  = model.getBall();
	}
	
	public void setScore()
	{
		Score = model.getScore();
	}
	
	
}
