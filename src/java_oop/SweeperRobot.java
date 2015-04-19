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
		//elkérjük az akadályok listáját
		ArrayList<Obstacle> obstacles = GameObjectContainer.GetObstacles();
		//megnézzük, hogy ütközött-e valamelyikkel
		for(Obstacle iter: obstacles){
			if(iter.position == this.position){
				GameObjectContainer.RemoveObstacle(iter);
			}
		}
		
		//megnézzük, hogy kisrobottal ütközött-e
		ArrayList<SweeperRobot> srobots = GameObjectContainer.GetSweeperRobot();
		for(SweeperRobot iter: srobots){
			if(iter.position == this.position){
				//ha ütközött, akkor irányt kell váltani
				
			}
		}
		
	}
	
	//szerintem neki nem kell jump, ott az update
	public void Jump(){
		
	}
	
	public void GetDirection(){
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
