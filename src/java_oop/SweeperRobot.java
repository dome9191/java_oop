package java_oop;

import java.util.ArrayList;
import java.util.Random;

public class SweeperRobot extends Obstacle {
	
	private Vektor speed;
	private Vektor startpos;
	private Vektor direction;
	
	public SweeperRobot(){
		GameObjectContainer.AddSweeperRobot(this);
		speed = new Vektor(10,0);
		this.radius = 2;
		direction = new Vektor(0,0);
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
		ArrayList<Obstacle> delete = new ArrayList<Obstacle>();
		for(Obstacle iter: obstacles){
			//itt is javítottam az ütközést
			if(iter.position.Substract(this.position).Length() < (iter.radius+this.radius)){
				delete.add(iter);
			}
		}
		for(Obstacle iter:delete){
			GameObjectContainer.RemoveObstacle(iter);
		}
		
		//megnézzük, hogy kisrobottal ütközött-e
		ArrayList<SweeperRobot> srobots = GameObjectContainer.GetSweeperRobot();
		for(SweeperRobot iter: srobots){
			if((iter != this) && (iter.position.Substract(this.position).Length() < (iter.radius+this.radius))){
				//ha ütközött, akkor irányt kell váltani
				this.ChangeDirection();
			}
		}
		
	}
	
	//szerintem neki nem kell jump, ott az update -- mégis lesz, hogy mûködjön a teszt
	public void Jump(Vektor clickedvalue){
		Vektor directionchange = clickedvalue;
		clickedvalue = clickedvalue.Normalize();
		
		Vektor newspeed = this.speed.Add(clickedvalue);
		
		position = position.Add(newspeed);
		//direction = directionchange;
		direction = direction.Add(directionchange);
	}
	
	public void ChangeDirection(){
		//ilyenkor már lefutott a GetDirection, tehát a speed be van állítva az új irányba, csak hozzá kell adni valami
		//random számot az egyik koordinátájához és normalizálni
		/*Random rn = new Random();
		
		//20-50 közötti random koorindátával eltoljuk y irányban
		int number = rn.nextInt((50 - 20) + 1) + 20; 
		Vektor changed = new Vektor(0, number); */
		Vektor changed = new Vektor(0, 30);
		//speed = speed.Add(changed).Normalize();
		direction = direction.Add(changed);
	}
	
	public void GetDirection(){
		//lekérjük az akadályokat
		ArrayList<Obstacle> obstacles = GameObjectContainer.GetObstacles();
		if(!obstacles.isEmpty()){
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
		direction = speed;
	}
	
	public void Update(){
		//megkeresik, hogy merre menjenek
		this.GetDirection();
		//ugrás elõtt megnézik, hogy nincs-e valami takarítani való, vagy ütközés
		this.Collision();
		
		//a kisrobotok maguktól mozognak
		position.Add(speed);
		
		//valamennyi körig lesznek bent, ez számolja
		count++;
	}
	
	public void setStartPos(Vektor pos){
		startpos = pos;
		position = startpos;
	}
	
	public Vektor getSpeed(){
		return this.speed;
	}
	
	public Vektor getDirection(){
		return direction;
	}
}
