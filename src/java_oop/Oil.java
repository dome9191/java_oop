package java_oop;

import java.util.Vector;

public class Oil extends Obstacle {
	public Oil(){
		//Test.PrintLog();
		GameObjectContainer.AddObstacle(this);
	}
	
	//init megvalósítva az Obstacle-ben
	//public void Init(Vector<Integer> obstaclePos)
	
	public void Collision(Vector<Integer> obstaclePos){
		/*if(Test.selector == 4){
			Test.PrintLog();
			//ugly hack, kétszer hívjuk ugyanazt egy teszten belül
			Test.selector = 41;
			GameObjectContainer.RemoveObstacle(GameObjectContainer.GetObstacles().get(0));
		} */
		
	}
	
	public void Update(){
		
	}
}
