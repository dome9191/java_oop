package java_oop;

public abstract class Obstacle extends GameObject {
	
	protected int count = 0;
	
	public void Init(Vektor obstaclePos){
		//Test.PrintLog();
		this.position = obstaclePos;
	}
	
	public int GetCount(){
		return count;
	}
	
	public void Update(){
		
	}
}
