package java_oop;

public class SweeperRobot extends Obstacle {
	
	public SweeperRobot(){
		GameObjectContainer.AddSweeperRobot(this);
	}
	
	//init megval�s�tva az Obstacle-ben
	//public void Init(Vector<Integer> obstaclePos)
	
	//ez nem v�ltoztatja a robot tulajdons�gait, csak mag�t t�rli ki �s rak le egy olajat
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
