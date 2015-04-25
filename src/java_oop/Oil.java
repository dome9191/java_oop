package java_oop;

import java.util.Vector;

public class Oil extends Obstacle {
	
	public Oil(){
		//Test.PrintLog();
		GameObjectContainer.AddObstacle(this);
		this.radius = 20;
	}
	
	//init �s getcount megval�s�tva az Obstacle-ben
	
	//nem is kell most
	public void Collision(){
		/*if(Test.selector == 4){
			Test.PrintLog();
			//ugly hack, k�tszer h�vjuk ugyanazt egy teszten bel�l
			Test.selector = 41;
			GameObjectContainer.RemoveObstacle(GameObjectContainer.GetObstacles().get(0));
		} */
		
	}
	
	public void Affect(Robot affected){
		//olajr�l elugr�s eset�ben nem lehet sebess�get v�ltoztatni
		affected.setCanSetSpeed(false);
	}
	
	public void Update(){
		//k�r v�g�n n�velj�k a sz�ml�l�j�t
		count++;
		
		//h�rom k�r ut�n felsz�rad
		if(this.count == 3){
			GameObjectContainer.RemoveObstacle(this);
		}
	}
	
	public void Draw(){
		GameObjectContainer.GetGameScreen().drawCircle(this.position.x, this.position.y, this.radius, this.radius, color.BLACK);
	}
}
