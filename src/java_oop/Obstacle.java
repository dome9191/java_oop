package java_oop;

import java.util.Vector;

public abstract class Obstacle extends GameObject {
	
	public void Init(Vector<Integer> obstaclePos){
		Test.PrintLog();
		GameObjectContainer.AddObstacle(this);
	}
	
}
