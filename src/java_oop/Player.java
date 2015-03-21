package java_oop;

import java.util.Date;
import java.util.Vector;

public class Player {
	
	private static Date TotalTime;
	private Date TurnTime;
	private Robot robot;
	private double Distance;
	
	public Player(){
		Test.PrintLog();
		robot = new Robot();
	}
	
	public void SetTurnTime(Date newtime){
		Test.PrintLog();
	}
	
	public void Move(Vector<Integer> newpos){
		
	}
	
	public void IncreaseDistance(double add_distance){
		
		Distance += add_distance;
		
	}
	
	public void CreateOil(){
		Test.PrintLog("A játékos úgy döntött lerak egy olajfoltot.");
	}
	
	public void CreatePutty(){
		Test.PrintLog();
	}
	
	public void Turn(){
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
	
	public static void SetTotalTime(Date newTotalTime){
		Test.PrintLog();
	}
	
	
	public void SetObstaclesCount(int putty, int oil){
		Test.PrintLog();
		robot.SetOilCount(oil);
		robot.SetPuttyCount(putty);
	}
}
