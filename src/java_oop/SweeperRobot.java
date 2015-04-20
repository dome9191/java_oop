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
		ArrayList<Obstacle> delete = new ArrayList<Obstacle>();
		for(Obstacle iter: obstacles){
			//itt is jav�tottam az �tk�z�st
			if(iter.position.Substract(this.position).Length() < (iter.radius+this.radius)){
				delete.add(iter);
			}
		}
		for(Obstacle iter:delete){
			GameObjectContainer.RemoveObstacle(iter);
		}
		
		//megn�zz�k, hogy kisrobottal �tk�z�tt-e
		ArrayList<SweeperRobot> srobots = GameObjectContainer.GetSweeperRobot();
		for(SweeperRobot iter: srobots){
			if((iter != this) && (iter.position.Substract(this.position).Length() < (iter.radius+this.radius))){
				//ha �tk�z�tt, akkor ir�nyt kell v�ltani
				this.ChangeDirection();
			}
		}
		
	}
	
	//szerintem neki nem kell jump, ott az update -- m�gis lesz, hogy m�k�dj�n a teszt
	public void Jump(Vektor clickedvalue){
		Vektor directionchange = clickedvalue;
		clickedvalue = clickedvalue.Normalize();
		
		Vektor newspeed = this.speed.Add(clickedvalue);
		
		position = position.Add(newspeed);
		//direction = directionchange;
		direction = direction.Add(directionchange);
	}
	
	public void ChangeDirection(){
		//ilyenkor m�r lefutott a GetDirection, teh�t a speed be van �ll�tva az �j ir�nyba, csak hozz� kell adni valami
		//random sz�mot az egyik koordin�t�j�hoz �s normaliz�lni
		/*Random rn = new Random();
		
		//20-50 k�z�tti random koorind�t�val eltoljuk y ir�nyban
		int number = rn.nextInt((50 - 20) + 1) + 20; 
		Vektor changed = new Vektor(0, number); */
		Vektor changed = new Vektor(0, 30);
		//speed = speed.Add(changed).Normalize();
		direction = direction.Add(changed);
	}
	
	public void GetDirection(){
		//lek�rj�k az akad�lyokat
		ArrayList<Obstacle> obstacles = GameObjectContainer.GetObstacles();
		if(!obstacles.isEmpty()){
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
		direction = speed;
	}
	
	public void Update(){
		//megkeresik, hogy merre menjenek
		this.GetDirection();
		//ugr�s el�tt megn�zik, hogy nincs-e valami takar�tani val�, vagy �tk�z�s
		this.Collision();
		
		//a kisrobotok magukt�l mozognak
		position.Add(speed);
		
		//valamennyi k�rig lesznek bent, ez sz�molja
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
