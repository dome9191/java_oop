package java_oop;

import java.util.Date;
import java.util.Vector;

public class Player {
	
	private static Date TotalTime;
	private Date TurnTime;
	private Robot robot;
	private double Distance;
	
	public Player(){
		//Test.PrintLog();
		robot = new Robot();
	}
	
	public void SetTurnTime(Date newtime){
		//Test.PrintLog();
		TurnTime = newtime;
	}
	
	//ez lehetne az utols� h�v�s, �s a newpos ad�dna �t a jump-nak
	public void Move(Vektor newpos){
		
	}
	
	public void IncreaseDistance(double add_distance){
		
		Distance += add_distance;
		
	}
	
	public void CreateOil(){
		//Test.PrintLog("A j�t�kos �gy d�nt�tt lerak egy olajfoltot.");
		Oil newoil = new Oil();
		newoil.Init(robot.GetPosition());
	}
	
	public void CreatePutty(){
		//Test.PrintLog();
		Putty newputty = new Putty();
		newputty.Init(robot.GetPosition());
	}
	
	public void Turn(){
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
	
	public static void SetTotalTime(Date newTotalTime){
		//Test.PrintLog();
		TotalTime = newTotalTime;
	}
	
	
	public void SetObstaclesCount(int putty, int oil){
		//Test.PrintLog();
		robot.SetOilCount(oil);
		robot.SetPuttyCount(putty);
	}
	
	public static Date GetTotalTime(){
		/*Test.PrintLog();
		if(Test.selector == 6){
			System.out.println("Lej�rt az id�, m�r nem l�phet senki, v�ge a j�t�knak!");
		} */
		return TotalTime;
	}
}
