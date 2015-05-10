package java_oop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
	
	static ArrayList<Player> Players;
	private RaceTrack raceTrack;
	private int nextplayer = 0;
	
	public Game(){
		Players = new ArrayList<Player>();
	}
	
	public void Start(){
		boolean endgame = false;
		while(!endgame){
			for(Player i: Players){
				if(Player.GetTotalTime() > 0){ 
					i.Turn();
				}
				else{
					endgame = true;
					break; //end game
				}
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
		//Players.get(Players.size()-1).SetObstaclesCount(3,3);
	}
	
	public void SetEnvironment(int TotalTime, int TurnTime){
		//Test.PrintLog();
		RaceTrack track = new RaceTrack();
		GameObjectContainer.GetRaceTrack().Load();
		//track.Draw();
		Player.SetTotalTime(TotalTime);
		Player.SetTurnTimeHelper(TurnTime);
		for(Player i : Players){
			i.SetTurnTime(TurnTime);
		}
	}
	
	public void RemovePlayer(Player removethis){
		Players.remove(removethis);
	}
	
	public ArrayList<Player> GetPlayers(){
		return Players;
	}
	
	//visszaadja ki k�vetkezik �s n�veli is
	public int GetNextPlayer(){
		int ret = nextplayer;
		if(nextplayer == Players.size()-1){
			nextplayer = 0;
		}
		else{
			nextplayer += 1;
		}
		return ret;
	}
	
	public void DrawGame(){
		//a h�tt�r kirajzol�sa
		GameObjectContainer.GetGameScreen().DrawBackground();
		GameObjectContainer.GetGameScreen().drawTime(Player.GetTotalTime());
		//p�lya kirajzol�sa
		GameObjectContainer.GetRaceTrack().Draw();
		//akad�lyok kirajzol�sa
		for(GameObject elem:GameObjectContainer.GetObstacles()){
			elem.Draw();
		}
		//robotok kirajzol�sa
		for(GameObject elem:GameObjectContainer.GetRobots()){
			elem.Draw();
		}
	}
	
	public void SetScreen(GameScreen myscreen){
		GameObjectContainer.SetGameScreen(myscreen);
	}
}
