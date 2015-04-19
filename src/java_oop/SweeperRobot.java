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
		//elk�rj�k az akad�lyok list�j�t
		ArrayList<Obstacle> obstacles = GameObjectContainer.GetObstacles();
		//megn�zz�k, hogy �tk�z�tt-e valamelyikkel
		for(Obstacle iter: obstacles){
			if(iter.position == this.position){
				GameObjectContainer.RemoveObstacle(iter);
			}
		}
		
		//megn�zz�k, hogy kisrobottal �tk�z�tt-e
		ArrayList<SweeperRobot> srobots = GameObjectContainer.GetSweeperRobot();
		for(SweeperRobot iter: srobots){
			if(iter.position == this.position){
				//ha �tk�z�tt, akkor ir�nyt kell v�ltani
				
			}
		}
		
	}
	
	//szerintem neki nem kell jump, ott az update
	public void Jump(){
		
	}
	
	public void GetDirection(){
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
