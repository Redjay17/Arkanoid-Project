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
	
	ArrayList<Brick> Bricks = null;
	boolean IsAlive = false;
	ArrayList<Rect> Objects = null;
	boolean win = false;
	Player Player = null;
	Ball Ball = null;
	int Score = -1;




//	ArrayList<Brick> Bricks, boolean IsAlive, 
//	ArrayList<Rect> Objects, boolean win, Player Player, Ball Ball,
//	Model Score
	
	/**
	 * Game View object in Controller to keep all the inforamtion in Model and pass it onto View
	 * @param Bricks
	 * @param IsAlive
	 * @param Objects
	 * @param win
	 */
	public GameInfo()
	{
		this.Bricks = model.getBricks();
		this.Objects = model.getObjects();
		this.IsAlive = model.getAlive();
		this.win = model.getWon();
		this.Player = model.getPlayer();
		this.Ball  = model.getBall();
		this.Score = model.getScore();
	}
	
	public void Update()
	{
		this.Bricks = model.getBricks();
		this.Objects = model.getObjects();
		this.IsAlive = model.getAlive();
		this.win = model.getWon();
		this.Player = model.getPlayer();
		this.Ball  = model.getBall();
		this.Score = model.getScore();
		
	}
	
	public ArrayList<Brick> getBricks()
	{
		return this.Bricks;
	}
	
	public boolean getAlive()
	{
		return this.IsAlive;
	}
	
	public ArrayList<Rect> getObjects()
	{
		return this.Objects;
	}
	
	public boolean getWon()
	{
		return this.win;
	}
	
	public Player getPlayer()
	{
		return this.Player;
	}
	
	public Ball getBall()
	{
		return this.Ball;
	}
	
	public int getScore()
	{
		return this.Score;
	}
	
	public void setBricks()
	{
		this.Bricks = model.getBricks();
	}
	
	public void setAlive()
	{
		this.Objects = model.getObjects();
	}
	
	public void setObjects()
	{
		this.IsAlive = model.getAlive();
	}
	
	public void setWon()
	{
		this.win = model.getWon();
	}
	
	public void setPlayer()
	{
		this.Player = model.getPlayer();
	}
	
	public void setBall()
	{
		this.Ball  = model.getBall();
	}
	
	public void setScore()
	{
		this.Score = model.getScore();
	}
	
	
}
