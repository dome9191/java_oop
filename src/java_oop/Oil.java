package java_oop;

import java.util.Vector;

public class Oil extends Obstacle {
	
	public Oil(){
		//Test.PrintLog();
		GameObjectContainer.AddObstacle(this);
	}
	
	//init �s getcount megval�s�tva az Obstacle-ben
	
	public void Collision(){
		/*if(Test.selector == 4){
			Test.PrintLog();
			//ugly hack, k�tszer h�vjuk ugyanazt egy teszten bel�l
			Test.selector = 41;
			GameObjectContainer.RemoveObstacle(GameObjectContainer.GetObstacles().get(0));
		} */
		
	}
	
	//olajr�l elugr�s eset�ben nem lehet sebess�get v�ltoztatni
	public void Affect(Robot affected){
		
	}
	
	public void Update(){
		
	}
}
