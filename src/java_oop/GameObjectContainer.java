package java_oop;

import java.util.List;

public class GameObjectContainer {

	private List<Obstacle> obstacles;
	private List<Robot> robots;
	private RaceTrack track;
	
	public List<Obstacle> GetObstacles(){
		return obstacles;
	}
	
	public void AddObstacle(Obstacle addThis){
		
		obstacles.add(addThis);
		
	}
	
	public void RemoveObstacle(Obstacle removeThis){
		
		obstacles.remove(removeThis);
		
	}
	
	public RaceTrack GetRaceTrack(){
		
		return track;
		
	}
	
	public void AddRobot(Robot addThis){
		
		robots.add(addThis);
		
	}
	
	public List<Robot> GetRobots(){
		
		return robots;
		
	}
	
	public void AddRaceTrack(RaceTrack raceTrack){
		
	}
}
