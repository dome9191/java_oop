package java_oop;

import java.util.ArrayList;

public abstract class Obstacle extends GameObject {
	
	protected int count = 0;
	
	public void Init(Vektor obstaclePos){
		//Test.PrintLog();
		this.position = obstaclePos;
		
		//legkérjük az akadályokat, megnézzük, hogy van-e már itt valami
		ArrayList<Obstacle> obstacles = GameObjectContainer.GetObstacles();
		ArrayList<Obstacle> marked = new ArrayList<Obstacle>();
		for(Obstacle iter : obstacles){
			if(iter.position.Substract(this.position).Length() < (iter.radius+this.radius)){
				//ha van, akkor töröljük
				marked.add(iter);
			}
		}
		//kitöröljük az összes megjelölt objektumot
		for(Obstacle iter: marked){
			GameObjectContainer.RemoveObstacle(iter);
		}
	}
	
	public int GetCount(){
		return count;
	}
	
	public void Update(){
		
	}
}
