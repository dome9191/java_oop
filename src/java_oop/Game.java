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
		boolean endgame = false;
		while(!endgame){
			Test.PrintLog("starting game");
			for(Player i: Players){
				Date time = Player.GetTotalTime();
				Test.PrintLog("first turn");
				if(time.compareTo(new Date(0,0,0,0,0)) > 0) 
					i.Turn();
				else 
					break; //end game
			//megn�zz�k van-e m�g robot a p�ly�n
				endgame = true;
				for(Robot item: GameObjectContainer.GetRobots()){
					if(item != null && item.GetIsOnTrack()) {
						endgame = false;
					}
					/*else{
						endgame = true;
						break;
					}*/
				}
				//nincs t�bb robot a p�ly�n, kil�p�nk
				if(endgame) break;
			}
			//k�r v�ge updatel�nk mindent
			for(Obstacle i: GameObjectContainer.GetObstacles())
				i.Update();
		}
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
				System.out.println("Nincs t�bb robot a p�ly�n.");
			}
			System.out.println("J�t�k v�ge: J�t�kos1 nyert");
		}
		else if(Test.selector == 6){
			Date time = Player.GetTotalTime();
			for(Player item: Players){
				if(time.compareTo(new Date(0,0,0,0,0)) > 0) item.Turn();
			}
			System.out.println("J�t�k v�ge: J�t�kos1 nyert");
		}
		
		else if(Test.selector == 3){
			Test.Mute();
			Player tesztPlayer = new Player();
			Test.Unmute();
			tesztPlayer.Turn();
		} */
	}
	
	public void AddPlayer(){
		//Test.PrintLog();
		Players.add(new Player());
		Players.get(Players.size()-1).SetObstaclesCount(3,3);
	}
	
	public void SetEnvironment(Date TotalTime, Date TurnTime){
		//Test.PrintLog();
		RaceTrack track = new RaceTrack();
		GameObjectContainer.GetRaceTrack().Load();
		track.Draw();
		
		Player.SetTotalTime(TotalTime);
		for(Player item:Players){
			item.SetTurnTime(TurnTime);
		}
	}
	
	public void RemovePlayer(Player removethis){
		Players.remove(removethis);
	}
	
	public ArrayList<Player> GetPlayers(){
		return Players;
	}
}
