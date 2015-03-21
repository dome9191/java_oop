package java_oop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Game {
	
	private ArrayList<Player> Players;
	private RaceTrack raceTrack;
	
	public Game(){
		Players = new ArrayList<Player>();
	}
	
	public void Start(){
		/*String name = new Object(){}.getClass().getEnclosingMethod().getName();
		String name2 = new Object(){}.getClass().getName();
		System.out.println(name2+" "+name);*/
		Test.PrintLog();
	}
	
	public void AddPlayer(){
		Test.PrintLog();
		Players.add(new Player());
		Players.get(Players.size()-1).SetObstaclesCount(5,5);
	}
	
	public void SetEnvironment(Date TotalTime, Date TurnTime){
		Test.PrintLog();
		RaceTrack track = new RaceTrack();
		track.Load();
		track.Draw();
		for(Player item:Players){
			item.SetTotalTime(TotalTime);
			item.SetTurnTime(TurnTime);
		}
	}
	
	public void RemovePlayer(Player removethis){
		
		Players.remove(removethis);
		
	}
}
