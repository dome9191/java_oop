package java_oop;

import java.util.ArrayList;
import java.util.List;

public final class GameObjectContainer {

	private static ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	private static ArrayList<Robot> robots = new ArrayList<Robot>();
	private static RaceTrack track;
	private static ArrayList<SweeperRobot> sweeperrobots = new ArrayList<SweeperRobot>();
	private static GameScreen screen;
	
	private GameObjectContainer()
	{
		//statikus osztály
	}
	
	public static ArrayList<Obstacle> GetObstacles(){
	/*	if(Test.selector == 2){
			Test.PrintLog();
		}
		if(Test.selector == 4){
			Test.PrintLog("Ütközés történt.");
			obstacles.get(0).Affect(robots.get(0));
		}
		if(Test.selector == 41){
			Test.PrintLog();
		} */
		return obstacles;
	}
	
	public static void AddObstacle(Obstacle addThis){
		//Test.PrintLog();
		obstacles.add(addThis);
	}
	
	public static void RemoveObstacle(Obstacle removeThis){
		//Test.PrintLog();
		obstacles.remove(removeThis);
		removeThis = null;
	}
	
	public static RaceTrack GetRaceTrack(){
		return track;
	}
	
	public static void AddRobot(Robot addThis){
		//Test.PrintLog();
		robots.add(addThis);
		
	}
	
	public static ArrayList<Robot> GetRobots(){
		//Test.PrintLog();
		return robots;
	}
	
	public static void AddRaceTrack(RaceTrack raceTrack){
		//Test.PrintLog();
		track = raceTrack;
	}
	
	public static void AddSweeperRobot(SweeperRobot newsweeper){
		sweeperrobots.add(newsweeper);
	}
	
	public static void RemoveSweeperRobot(SweeperRobot sRobot){
		sweeperrobots.remove(sRobot);
		sRobot = null;
	}
	
	public static ArrayList<SweeperRobot> GetSweeperRobot(){
		return sweeperrobots;
	}
	
	public static void RemoveRobot(Robot removethis){
		robots.remove(removethis);
		removethis = null;
	}
	
	public static void SetGameScreen(GameScreen myscreen){
		screen = myscreen;
	}
	
	public static GameScreen GetGameScreen(){
		return screen;
	}
}
