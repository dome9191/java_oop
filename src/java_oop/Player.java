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
		
	}
	
	public void CreatePutty(){
		
	}
	
	public void Turn(){
		
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
