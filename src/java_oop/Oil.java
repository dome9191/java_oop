package java_oop;

import java.util.Vector;

public class Oil extends Obstacle {
	public Oil(){
		Test.PrintLog();
	}
	
	public void Init(Vector<Integer> obstaclePos){
		if(Test.selector == 2){
			Test.PrintLog();
			GameObjectContainer.AddObstacle(this);
		}
		if(Test.selector == 4){
			Test.PrintLog();
			Collision(obstaclePos);
			GameObjectContainer.AddObstacle(this);
		}
	}
	
	public void Collision(Vector<Integer> obstaclePos){
		if(Test.selector == 4){
			Test.PrintLog();
			//ugly hack, kétszer hívjuk ugyanazt egy teszten belül
			Test.selector = 41;
			GameObjectContainer.RemoveObstacle(GameObjectContainer.GetObstacles().get(0));
		}
	}
}
