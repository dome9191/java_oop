package java_oop;

import java.util.Vector;

public abstract class Obstacle extends GameObject {
	
	private int count;
	
	public void Init(Vector<Integer> obstaclePos){
		//Test.PrintLog();
		this.position = obstaclePos;
	}
	
	public int GetCount(){
		return count;
	}
	
	public void Update(){
		
	}
}
