package java_oop;

import java.util.Vector;

public class Oil extends Obstacle {
	public Oil(){
		Test.PrintLog();
	}
	
	public void Init(Vector<Integer> obstaclePos){
		Test.PrintLog();
		if(Test.selector == 2){
			GameObjectContainer.AddObstacle(this);
		}
		if(Test.selector == 4){
			
		}
	}
}
