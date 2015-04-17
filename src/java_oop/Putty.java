package java_oop;

import java.util.Vector;


public class Putty extends Obstacle {
	
	public Putty(){
		GameObjectContainer.AddObstacle(this);
	}
	
	//init és count megvalósítva az Obstacle-ben
	
	//felére csökkenti a robot sebességét
	public void Affect(Robot affected){
		//Test.PrintLog();
		//affected.Modify(new Vector<Integer>());
		
	}
	
	public void Update(){
		
	}
}
