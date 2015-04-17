package java_oop;

import java.util.ArrayList;



public class Robot extends GameObject {
	
	private Vektor speed;
	private int oil;
	private int putty;
	private boolean isOnTrack;
	
	
	public Robot(){
		//Test.PrintLog();
		GameObjectContainer.AddRobot(this);
	}
	
	public Vektor GetPosition(){
		//Test.PrintLog();
		return position;
	}
	
	//adtam neki egy param�tert, hogy tudjuk, hogy hova klikkelt a user
	public void Jump(Vektor clickedvalue){
		//nem vagyok robot
		//Test.PrintLog("A j�t�kos �gy d�nt ugrik.");
	
	}
	
	//az �tk�z�tt objektumok visszajelz�se alapj�n �t�ll�tja a sebess�get
	public void Modify(Vektor modvalue){
		//Test.PrintLog();
		speed = modvalue;
	}
	
	public void CalculateIsOnTrack(){
		
		ArrayList<Vektor> trackpoints = GameObjectContainer.GetRaceTrack().GetPoints();
		
		//itt m�g kell valami magic
		
	}
	
	public boolean GetIsOnTrack(){
		/*if(Test.selector == 2){
			Test.PrintLog("A robot a p�ly�n van.");
			//testcode
			isOnTrack = true;
		}
		if(Test.selector == 3){
			Test.PrintLog("A robot nincs a p�ly�n, v�ge a k�rnek");
			//testcode
			isOnTrack = false;
		}
		if(Test.selector == 4){
			Test.PrintLog("A robot a p�ly�n van.");
			//testcode
			isOnTrack = true;
		}
		if(Test.selector == 5){
			Test.PrintLog("A robot nincs a p�ly�n.");
			//testcode
			isOnTrack = false;
		} */
		return isOnTrack;
	}
	
	public void SetIsOnTrack(boolean newvalue){
		isOnTrack = newvalue;
	}
	
	public void Collision(){
		/*if(Test.selector == 2){
			Test.PrintLog();
			GameObjectContainer.GetObstacles();
			System.out.println("Nem t�rt�nt �tk�z�s.");
		}
		if(Test.selector == 4){
			Test.PrintLog();
			GameObjectContainer.GetObstacles();
		} */
		
		
		ArrayList<Robot> robotlist = GameObjectContainer.GetRobots();
		for(Robot iter : robotlist){
			if(iter.position.Equals(this.position)){
				iter.Affect(this);
			}
		}
		
		//ha m�g �letben van, n�zz�k meg m�sra is az �tk�z�seket
		if(isOnTrack){
			//el�sz�r az akad�lyokat ellen�rizz�k, hogy kisrobot �tk�z�s eset�n az �jonnan lerakott akad�ly ne legyen hat�ssal a robotra
			ArrayList<Obstacle> obstaclelist = GameObjectContainer.GetObstacles();
			for(Obstacle iter: obstaclelist){
				if(iter.position.Equals(this.position)){
					iter.Affect(this);
				}
			}
			
			ArrayList<SweeperRobot> sweeperlist = GameObjectContainer.GetSweeperRobot();
			for(SweeperRobot iter : sweeperlist){
				if(iter.position.Equals(this.position)){
					iter.Affect(this);
				}
			}	
		}
		
		
	}
	
	//vektor�tlag sz�mol�sa �s p�ly�r�l lev�tel (ha ez a lassabb)
	public void Affect(Robot robot){
		Vektor newspeed = new Vektor();
		//ez lesz az �j sebess�g
		newspeed = this.speed.Add(robot.GetSpeed());
		
		//melyik robot sebess�ge volt nagyobb?
		if(this.speed.isGreaterThan(robot.GetSpeed())){
			this.Modify(newspeed);
			
			//�s a robot t�rl�se  --- majd �jra kell rajzoltatni ilyenkor a dolgokat
			GameObjectContainer.RemoveRobot(robot);
		}
		else{
			robot.Modify(newspeed);
			GameObjectContainer.RemoveRobot(this);
		}
		
	}
	
	public void SetOilCount(int newvalue){
		//Test.PrintLog();
		oil = newvalue;
	}
	
	public void SetPuttyCount(int newvalue){
		//Test.PrintLog();
		putty = newvalue;
	}
	
	public int GetOilCount(){
		return oil;
	}
	
	public int GetPuttyCount(){
		return putty;
	}

	public Vektor GetSpeed() {
		return speed;
	}

}
