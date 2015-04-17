package java_oop;

import java.util.Vector;

public class Oil extends Obstacle {
	
	public Oil(){
		//Test.PrintLog();
		GameObjectContainer.AddObstacle(this);
	}
	
	//init és getcount megvalósítva az Obstacle-ben
	
	public void Collision(){
		/*if(Test.selector == 4){
			Test.PrintLog();
			//ugly hack, kétszer hívjuk ugyanazt egy teszten belül
			Test.selector = 41;
			GameObjectContainer.RemoveObstacle(GameObjectContainer.GetObstacles().get(0));
		} */
		
	}
	
	//olajról elugrás esetében nem lehet sebességet változtatni
	public void Affect(Robot affected){
		
	}
	
	public void Update(){
		
	}
}
