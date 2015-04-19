package java_oop;

import java.util.ArrayList;

public abstract class Obstacle extends GameObject {
	
	protected int count = 0;
	
	public void Init(Vektor obstaclePos){
		//Test.PrintLog();
		this.position = obstaclePos;
		
		//legk�rj�k az akad�lyokat, megn�zz�k, hogy van-e m�r itt valami
		ArrayList<Obstacle> obstacles = GameObjectContainer.GetObstacles();
		for(Obstacle iter : obstacles){
			if(iter.position == this.position){
				//ha van, akkor t�r�lj�k
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
