package java_oop;

import java.util.ArrayList;

public class SweeperRobot extends Obstacle {
	
	private Vektor speed;
	
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
	
	//szerintem neki nem kell jump, ott az update
	public void Jump(){
		
	}
	
	public void ChangeDirection(){
		//lekérjük az akadályokat
		ArrayList<Obstacle> obstacles = GameObjectContainer.GetObstacles();
		Obstacle nearest = obstacles.get(0);
		int mindistance = position.Substract(obstacles.get(0).position).Length();
		// megkeressük a legközlebbit
		for(Obstacle i: obstacles){
			if(position.Substract(obstacles.get(0).position).Length() < mindistance){
				nearest = i;
				mindistance = position.Substract(obstacles.get(0).position).Length();
			}
		}
		//beállítjuk az új irányt
		speed = nearest.position.Substract(position).Normalize();
	}
	
	public void Update(){
		//a kisrobotok maguktól mozognak
		position.Add(speed);
	}
	
	
	
}
