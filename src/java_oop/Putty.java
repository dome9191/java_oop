package java_oop;

import java.util.Vector;


public class Putty extends Obstacle {
	
	public Putty(){
		GameObjectContainer.AddObstacle(this);
	}
	
	//init �s count megval�s�tva az Obstacle-ben
	
	//fel�re cs�kkenti a robot sebess�g�t
	public void Affect(Robot affected){
		//Test.PrintLog();
		//affected.Modify(new Vector<Integer>());
		
	}
	
	public void Update(){
		
	}
}
