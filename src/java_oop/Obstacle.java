package java_oop;

import java.util.ArrayList;

public abstract class Obstacle extends GameObject {
	
	protected int count = 0;
	
	public void Init(Vektor obstaclePos){
		//Test.PrintLog();
		this.position = obstaclePos;
		
		//legkérjük az akadályokat, megnézzük, hogy van-e már itt valami
		ArrayList<Obstacle> obstacles = GameObjectContainer.GetObstacles();
		for(Obstacle iter : obstacles){
			if(iter.position == this.position){
				//ha van, akkor töröljük
				GameObjectContainer.RemoveObstacle(iter);
			}
		}
	}
	
	public int GetCount(){
		return count;
	}
	
	public void Update(){
		
	}
}
