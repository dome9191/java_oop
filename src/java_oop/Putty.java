package java_oop;

import java.util.Vector;

public class Putty extends Obstacle {
	
	public Putty(){
		GameObjectContainer.AddObstacle(this);
	}
	
	//init megvalósítva az Obstacle-ben
	//public void Init(Vector<Integer> obstaclePos)
	
	public void Affect(Robot affected){
		//Test.PrintLog();
		//affected.Modify(new Vector<Integer>());
	}
	
	public void update(){
		
	}
}
