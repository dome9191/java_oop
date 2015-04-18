package java_oop;

import java.util.ArrayList;

public class SweeperRobot extends Obstacle {
	
	private Vektor speed;
	
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
	
	//szerintem neki nem kell jump, ott az update
	public void Jump(){
		
	}
	
	public void ChangeDirection(){
		//lek�rj�k az akad�lyokat
		ArrayList<Obstacle> obstacles = GameObjectContainer.GetObstacles();
		Obstacle nearest = obstacles.get(0);
		int mindistance = position.Substract(obstacles.get(0).position).Length();
		// megkeress�k a legk�zlebbit
		for(Obstacle i: obstacles){
			if(position.Substract(obstacles.get(0).position).Length() < mindistance){
				nearest = i;
				mindistance = position.Substract(obstacles.get(0).position).Length();
			}
		}
		//be�ll�tjuk az �j ir�nyt
		speed = nearest.position.Substract(position).Normalize();
	}
	
	public void Update(){
		//a kisrobotok magukt�l mozognak
		position.Add(speed);
	}
	
	
	
}
