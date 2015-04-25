package java_oop;

import java.util.ArrayList;



public class Robot extends GameObject {
	
	private Vektor speed;
	private int oil;
	private int putty;
	private boolean isOnTrack;
	//sebesség állításának tiltására
	private boolean canSetSpeed = true;
	
	
	public Robot(){
		//Test.PrintLog();
		this.radius = 40;
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
		
		//normalizáljuk a bekattintott értéket
		clickedvalue = clickedvalue.Normalize();
		Vektor newspeed = new Vektor();
		
		//hozzáadjuk a sebességünkhöz
		newspeed = this.speed.Add(clickedvalue);
		
		//hozzáadjuk az összesített értéket az eddigi pozícióhoz, ez az új pozíció
		position = position.Add(newspeed);
	
		//ugrás után újra lehet állítani a sebességet
		this.canSetSpeed = true;
	}
	
	//az ütközött objektumok visszajelzése alapján átállítja a sebességet
	public void Modify(Vektor modvalue){
		//Test.PrintLog();
		//ha meg van engedve, hogy állítsuk a sebességet
		if(this.canSetSpeed && this.isOnTrack){
			speed = modvalue;
		}
	}
	
	public void CalculateIsOnTrack(){
		
		ArrayList<Vektor> trackpoints = GameObjectContainer.GetRaceTrack().GetPoints();
		int width = GameObjectContainer.GetRaceTrack().GetWidth();
		//magic starts here
		int mindistance = position.Substract(trackpoints.get(0)).Length();
		Vektor closestpoint = trackpoints.get(0);
		//megkeressük a legközelebbi pálya középvonal pontot hozzánk
		for(Vektor i: trackpoints){
			if(position.Substract(trackpoints.get(0)).Length()<mindistance){
				closestpoint = i;
				mindistance = position.Substract(trackpoints.get(0)).Length();
			}
		}
		//pályán vagyunk
		if(closestpoint.Substract(position).Length() < width)
			isOnTrack = true;
		//nem vagyunk
		else
			isOnTrack = false;
		
	}
	
	public boolean GetIsOnTrack(){
		CalculateIsOnTrack();
		return isOnTrack;
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
		//ezt itt célszerű meghívni
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
		if(robotlist.size() > 1){
			ArrayList<Robot> affected = new ArrayList<Robot>();
			for(Robot iter : robotlist){
				//pont azonos baromi ritkán lesz a pozíciójuk, radiusra kell vizsgálni
				/*if(iter.position.Equals(this.position)){*/
				//akkor történjen ütközés ha a két cucc távolsága kisebb mint a kiterjedéseik összege
				if((iter != this) && (iter.position.Substract(this.position).Length() < (iter.radius+this.radius))){
					affected.add(iter);
				}
			}
			for(Robot iter:affected){
				iter.Affect(this);
			}
		}
		
		//ha még életben van, nézzük meg másra is az ütközéseket
		if(isOnTrack){
			//elõször az akadályokat ellenõrizzük, hogy kisrobot ütközés esetén az újonnan lerakott akadály ne legyen hatással a robotra
			ArrayList<Obstacle> obstaclelist = GameObjectContainer.GetObstacles();
			for(Obstacle iter: obstaclelist){
				//itt is
				if(iter.position.Substract(this.position).Length() < (iter.radius+this.radius)){
					iter.Affect(this);
				}
			}
			
			ArrayList<SweeperRobot> sweeperlist = GameObjectContainer.GetSweeperRobot();
			ArrayList<SweeperRobot> affectthis = new ArrayList<SweeperRobot>();
			for(SweeperRobot iter : sweeperlist){
				//itt is
				if(iter.position.Substract(this.position).Length() < (iter.radius+this.radius)){
					affectthis.add(iter);
				}
			}
			for(SweeperRobot iter:affectthis){
				iter.Affect(this);
			}
		}
		
		
	}
	
	//vektorátlag számolása és pályáról levétel (ha ez a lassabb)
	public void Affect(Robot robot){
		Vektor newspeed = new Vektor();
		//ez lesz az új sebesség
		newspeed = this.speed.Add(robot.GetSpeed());
		newspeed = newspeed.DivideBy(2);
		
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
	
	public void SetSpeed(Vektor newspeed)
	{
		speed = newspeed;
	}
	
	public void SetPosition(Vektor newpos)
	{
		position = newpos;
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

	public boolean getCanSetSpeed() {
		return canSetSpeed;
	}

	public void setCanSetSpeed(boolean canSetSpeed) {
		this.canSetSpeed = canSetSpeed;
	}
	
	public void Draw(){
		GameObjectContainer.GetGameScreen().drawCircle(this.position.x, this.position.y, this.radius, this.radius, color.BLUE);
	}
}
