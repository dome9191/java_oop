package java_oop;

import java.util.Vector;

public class Oil extends Obstacle {
	
	public Oil(){
		//Test.PrintLog();
		GameObjectContainer.AddObstacle(this);
		this.radius = 20;
	}
	
	//init és getcount megvalósítva az Obstacle-ben
	
	//nem is kell most
	public void Collision(){
		/*if(Test.selector == 4){
			Test.PrintLog();
			//ugly hack, kétszer hívjuk ugyanazt egy teszten belül
			Test.selector = 41;
			GameObjectContainer.RemoveObstacle(GameObjectContainer.GetObstacles().get(0));
		} */
		
	}
	
	public void Affect(Robot affected){
		//olajról elugrás esetében nem lehet sebességet változtatni
		affected.setCanSetSpeed(false);
	}
	
	public void Update(){
		//kör végén növeljük a számlálóját
		count++;
		
		//három kör után felszárad
		if(this.count == 3){
			GameObjectContainer.RemoveObstacle(this);
		}
	}
	
	public void Draw(){
		GameObjectContainer.GetGameScreen().drawCircle(this.position.x, this.position.y, this.radius, this.radius, color.BLACK);
	}
}
