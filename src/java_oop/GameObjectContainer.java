package java_oop;

import java.util.ArrayList;
import java.util.List;

public final class GameObjectContainer {

	private static final ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	private static ArrayList<Robot> robots = new ArrayList<Robot>();
	private static RaceTrack track;
	
	private GameObjectContainer()
	{
		//statikus osztály
	}
	
	public static List<Obstacle> GetObstacles(){
		return obstacles;
	}
	
	public static void AddObstacle(Obstacle addThis){
		
		obstacles.add(addThis);
		
	}
	
	public static void RemoveObstacle(Obstacle removeThis){
		
		obstacles.remove(removeThis);
		
	}
	
	public static RaceTrack GetRaceTrack(){
		
		return track;
		
	}
	
	public static void AddRobot(Robot addThis){
		Test.PrintLog();
		robots.add(addThis);
		
	}
	
	public static List<Robot> GetRobots(){
		
		return robots;
		
	}
	
	public static void AddRaceTrack(RaceTrack raceTrack){
		Test.PrintLog();
	}
}
