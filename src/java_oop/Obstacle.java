package java_oop;

public abstract class Obstacle extends GameObject {
	
	private int count;
	
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
