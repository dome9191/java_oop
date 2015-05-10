package java_oop;

import java.util.Date;
import java.util.Vector;

public class Player {
	
	private static int TotalTime;
	private int TurnTime;
	private Robot robot;
	private double Distance = 0;
	
	public Player(){
		//Test.PrintLog();
		robot = new Robot();
		robot.SetIsOnTrack(true);
		robot.SetPosition(GameObjectContainer.GetRaceTrack().GetStartingPoint());
		robot.SetSpeed(new Vektor(10,0));
	}
	
	public void SetTurnTime(int newtime){
		//Test.PrintLog();
		TurnTime = newtime;
	}
	
	//ez lehetne az utolsó hívás, és a newpos adódna át a jump-nak
	public void Move(Vektor newpos){
		
	}
	
	public void IncreaseDistance(double add_distance){
		
		Distance += add_distance;
		
	}
	
	public void CreateOil(){
		//Test.PrintLog("A játékos úgy döntött lerak egy olajfoltot.");
		if(robot.GetOilCount() > 0){
			Oil newoil = new Oil();
			newoil.Init(robot.GetPosition());
			robot.SetOilCount(robot.GetOilCount()-1);
		}
	}
	
	public void CreatePutty(){
		//Test.PrintLog();
		if(robot.GetPuttyCount() > 0){
			Putty newputty = new Putty();
			newputty.Init(robot.GetPosition());
			robot.SetPuttyCount(robot.GetPuttyCount()-1);
		}
	}
	
	public void Turn(){
		//megnézzük, hogy a robotunk még a pályán van-e
		if(robot != null && robot.GetIsOnTrack()){
			//meghívjuk az ütközéseket
			robot.Collision();
			//megkérdezzük a játékost akar-e olajat vagy ragacsot lerakni
			if(robot != null){
				int[] input = GameObjectContainer.GetGameScreen().AskInput("placeobstacles");
				//int[] input = Test.AskInput("placeobstacles");
				//robot.Jump(new Vektor(input[0], input[1]));
				switch(input[0])
				{
				case 0:
					//nem csinálunk semmit
					break;
				case 1:
					//lerakunk egy ragacsot
					if(robot.GetPuttyCount() > 0)
					{
						Putty myputty = new Putty();
						myputty.Init(robot.GetPosition());
					}
					break;
				case 2:
					//lerakunk egy olajfoltot
					if(robot.GetOilCount() > 0)
					{
						Oil myoil = new Oil();
						myoil.Init(robot.GetPosition());
					}
					break;
				default:
					break;
				}
			}
			//ha tudunk irányítani, irányítunk
			//a robot jump-ja eleve nézi, hogy tudunk-e irányítani
			if(robot != null){
				int[] input = GameObjectContainer.GetGameScreen().AskInput("coordinates");
				//int[] input = Test.AskInput("coordinates");
				robot.Jump(new Vektor(input[0], input[1]));
				this.IncreaseDistance(robot.GetSpeed().Length());
				
			}
			SetTotalTime(Player.GetTotalTime()-1);
		}
	/*	if(Test.selector == 2){
			Test.PrintLog();
			robot.GetIsOnTrack();
			robot.Collision();
			//testcode
			CreateOil();
			//testcode
			Oil testOil = new Oil();
			//testcode
			testOil.Init(robot.GetPosition());
			//testcode
			robot.Jump();
		}
		if(Test.selector == 3){
			Test.PrintLog();
			robot.GetIsOnTrack();
		}
		if(Test.selector == 4){
			Test.PrintLog();
			robot.GetIsOnTrack();
			robot.Collision();
			//testcode
			CreateOil();
			//testcode
			Oil testOil = new Oil();
			//testcode
			testOil.Init(robot.GetPosition());
		
		} */
	}
	
	public static void SetTotalTime(int newTotalTime){
		//Test.PrintLog();
		TotalTime = newTotalTime;
	}
	
	
	public void SetObstaclesCount(int putty, int oil){
		//Test.PrintLog();
		robot.SetOilCount(oil);
		robot.SetPuttyCount(putty);
	}
	
	public static int GetTotalTime(){
		/*Test.PrintLog();
		if(Test.selector == 6){
			System.out.println("Lejárt az idõ, már nem léphet senki, vége a játéknak!");
		} */
		return TotalTime;
	}
}
