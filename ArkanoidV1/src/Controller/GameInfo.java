package Controller;

import java.util.ArrayList;

import Model.Ball;
import Model.Brick;

import Model.Model;
import Model.Player;
import Model.Rect;



/**
 * This class gets information from Model and stores it. It is then used to be taken from View
 * @author Arman Sandher
 *
 */
public class GameInfo 
{
	public Model model = new Model();
	
	static ArrayList<Brick> Bricks = new ArrayList<Brick>();
	static boolean IsAlive = true;
	static ArrayList<Rect> Objects = new ArrayList<Rect>();
	static boolean Win = false;
	static Player Player = new Player();
	static Ball Ball = new Ball(Player);
	static int Score = 0;

	
	/**
	 * Game View object in Controller to keep all the inforamtion in Model and pass it onto View
	 =
	 */
	public GameInfo()
	{
		Bricks = Model.getBricks();
		Objects = Model.getObjects();
		IsAlive = Model.getAlive();
		Win = Model.getWon();
		Player = Model.getPlayer();
		Ball  = Model.getBall();
		Score = Model.getScore();
	}
	
	
	/**
	 * As the name implies, it updates the information stored in Model
	 * @param bricks
	 * @param isAlive
	 * @param objects
	 * @param win
	 * @param player
	 * @param ball
	 * @param score
	 */
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
	
	
	
	/**
	 * Creates a new Arraylist just to make sure that games with more than one try have only
	 * the basic components: Ball and Player
	 * @return
	 */
	public static ArrayList<Rect> getObjects()
	{
		ArrayList<Rect> Objects = new ArrayList<Rect>();
		Objects.add(Player);
		Objects.add(Ball);
		return Objects;
	}
	
	//The rest are getter methods for their respective variables.
	
	public static ArrayList<Brick> getBricks()
	{
		return Bricks;
	}
	
	
	public static boolean getWon()
	{
		return Win;
	}
	
	
	public static boolean getAlive()
	{
		return IsAlive;
	}
	
	
	public static Player getPlayer()
	{
		return Player;
	}
	
	
	public static Ball getBall()
	{
		return Ball;
	}
	
	
	public static int getScore()
	{
		return Score;
	}
	
}
