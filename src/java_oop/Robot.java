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
		Test.PrintLog();
	}
	
	public void CalculateIsOnTrack(){
		
	}
	
	public boolean GetIsOnTrack(){
		if(Test.selector == 2){
			Test.PrintLog("A robot a pályán van.");
			//testcode
			isOnTrack = true;
		}
		if(Test.selector == 3){
			Test.PrintLog("A robot nincs a pályán, vége a körnek");
			//testcode
			isOnTrack = false;
		}
		if(Test.selector == 4){
			Test.PrintLog("A robot a pályán van.");
			//testcode
			isOnTrack = true;
		}
		if(Test.selector == 5){
			Test.PrintLog("A robot nincs a pályán.");
			//testcode
			isOnTrack = false;
		}
		return isOnTrack;
	}
	
	public void Collision(){
		if(Test.selector == 2){
			Test.PrintLog();
			GameObjectContainer.GetObstacles();
			System.out.println("Nem történt ütközés.");
		}
		if(Test.selector == 4){
			Test.PrintLog();
			GameObjectContainer.GetObstacles();
		}
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
