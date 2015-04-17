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
	
	//adtam neki egy paramétert, hogy tudjuk, hogy hova klikkelt a user
	public void Jump(Vektor clickedvalue){
		//nem vagyok robot
		//Test.PrintLog("A játékos úgy dönt ugrik.");
	
	}
	
	//az ütközött objektumok visszajelzése alapján átállítja a sebességet
	public void Modify(Vektor modvalue){
		//Test.PrintLog();
		speed = modvalue;
	}
	
	public void CalculateIsOnTrack(){
		
		ArrayList<Vektor> trackpoints = GameObjectContainer.GetRaceTrack().GetPoints();
		
		//itt még kell valami magic
		
	}
	
	public boolean GetIsOnTrack(){
		/*if(Test.selector == 2){
			Test.PrintLog("A robot a pályán van.");
			//testcode
			isOnTrack = true;
		}
		if(Test.selector == 3){
			Test.PrintLog("A robot nincs a pályán, vége a körnek");
			//testcode
			isOnTrack = false;
		}
		if(Test.selector == 4){
			Test.PrintLog("A robot a pályán van.");
			//testcode
			isOnTrack = true;
		}
		if(Test.selector == 5){
			Test.PrintLog("A robot nincs a pályán.");
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
			System.out.println("Nem történt ütközés.");
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
		
		//ha még életben van, nézzük meg másra is az ütközéseket
		if(isOnTrack){
			//elõször az akadályokat ellenõrizzük, hogy kisrobot ütközés esetén az újonnan lerakott akadály ne legyen hatással a robotra
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
	
	//vektorátlag számolása és pályáról levétel (ha ez a lassabb)
	public void Affect(Robot robot){
		Vektor newspeed = new Vektor();
		//ez lesz az új sebesség
		newspeed = this.speed.Add(robot.GetSpeed());
		
		//melyik robot sebessége volt nagyobb?
		if(this.speed.isGreaterThan(robot.GetSpeed())){
			this.Modify(newspeed);
			
			//és a robot törlése  --- majd újra kell rajzoltatni ilyenkor a dolgokat
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
