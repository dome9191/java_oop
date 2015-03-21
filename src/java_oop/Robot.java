package java_oop;

import java.util.Vector;

public class Robot extends GameObject {
	
	private Vector<Integer> speed;
	private int oil;
	private int putty;
	private boolean isOnTrack;
	
	public Robot(){
		Test.PrintLog();
		GameObjectContainer.AddRobot(this);
	}
	
	public Vector<Integer> GetPosition(){
		Test.PrintLog();
		return position;
	}
	
	public void Jump(){
		//nem vagyok robot
		Test.PrintLog("A játékos úgy dönt ugrik.");
	}
	
	public void Modify(Vector<Integer> modvalue){
		
	}
	
	public void CalculateIsOnTrack(){
		
	}
	
	public boolean GetIsOnTrack(){
		Test.PrintLog("A robot a pályán van.");
		//testcode
		isOnTrack = true;
		return isOnTrack;
	}
	
	public void Collision(){
		Test.PrintLog();
		GameObjectContainer.GetObstacles();
	}
	
	public void Affect(Robot robot){
		
	}
	
	public void SetOilCount(int newvalue){
		Test.PrintLog();
	}
	
	public void SetPuttyCount(int newvalue){
		Test.PrintLog();
	}
	
	public int GetOilCount(){
		return oil;
	}
	
	public int GetPuttyCount(){
		return putty;
	}
}
