package java_oop;

public class SweeperRobot extends Obstacle {
	
	public SweeperRobot(){
		GameObjectContainer.AddSweeperRobot(this);
	}
	
	//init megvalósítva az Obstacle-ben
	//public void Init(Vector<Integer> obstaclePos)
	
	//ez nem változtatja a robot tulajdonságait, csak magát törli ki és rak le egy olajat
	public void Affect(Robot robot){
		Oil newoil = new Oil();
		newoil.Init(this.position);
		
		GameObjectContainer.RemoveSweeperRobot(this);
	}
	
	public void Collision(){
		
	}
	
	public void Jump(){
		
	}
	
	public void ChangeDirection(){
		
	}
	
	public void Update(){
		
	}
	
	
	
}
