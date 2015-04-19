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
		/*Test.PrintLog();
		if(Test.selector != 3 && Test.selector != 6){
			boolean endgame = false;
			while(!endgame){
				endgame = true;
				for(Robot item: GameObjectContainer.GetRobots()){
					if(item.GetIsOnTrack()) endgame = false;
				}
				System.out.println("Nincs több robot a pályán.");
			}
			System.out.println("Játék vége: Játékos1 nyert");
		}
		else if(Test.selector == 6){
			Date time = Player.GetTotalTime();
			for(Player item: Players){
				if(time.compareTo(new Date(0,0,0,0,0)) > 0) item.Turn();
			}
			System.out.println("Játék vége: Játékos1 nyert");
		}
		
		else if(Test.selector == 3){
			Test.Mute();
			Player tesztPlayer = new Player();
			Test.Unmute();
			tesztPlayer.Turn();
		} */
		
		for(Player i: Players){
			i.Turn();
		}
	}
	
	public void AddPlayer(){
		//Test.PrintLog();
		Players.add(new Player());
		Players.get(Players.size()-1).SetObstaclesCount(3,3);
	}
	
	public void SetEnvironment(Date TotalTime, Date TurnTime){
		//Test.PrintLog();
		RaceTrack track = new RaceTrack();
		track.Load();
		track.Draw();
		
		Player.SetTotalTime(TotalTime);
		for(Player item:Players){
			item.SetTurnTime(TurnTime);
		}
	}
	
	public void RemovePlayer(Player removethis){
		Players.remove(removethis);
	}
}
