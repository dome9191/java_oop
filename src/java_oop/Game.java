package java_oop;

import java.util.Date;
import java.util.List;

public class Game {
	
	private List<Player> Players;
	private RaceTrack raceTrack;
	
	public void Start(){
		/*String name = new Object(){}.getClass().getEnclosingMethod().getName();
		String name2 = new Object(){}.getClass().getName();
		System.out.println(name2+" "+name);*/
		Test.PrintLog(1);
	}
	
	public void AddPlayer(){
		
	}
	
	public void SetEnvironment(Date TotalTime, Date TurnTime){
		
	}
	
	public void RemovePlayer(Player removethis){
		
		Players.remove(removethis);
		
	}
}
