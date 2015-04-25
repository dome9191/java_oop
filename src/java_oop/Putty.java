package java_oop;


public class Putty extends Obstacle {
	
	public Putty(){
		GameObjectContainer.AddObstacle(this);
		this.radius = 20;
	}
	
	//init és getcount megvalósítva az Obstacle-ben
	
	//felére csökkenti a robot sebességét
	public void Affect(Robot affected){
		//Test.PrintLog();
		//affected.Modify(new Vector<Integer>());
		Vektor newspeed = affected.GetSpeed();
		
		//felezzük a sebességet
		newspeed =  newspeed.DivideBy(2);
		
		//beállítjuk a robotnak
		affected.Modify(newspeed);
		
		//ráléptek egyszer
		this.count++;
		
		//ha már négyszer ráléptek, akkor törlés
		if(this.count == 4){
			GameObjectContainer.RemoveObstacle(this);
		}
	}
	
	//asszem itt haszontalan, nem csinál semmit
	public void Update(){
		
	}
	
	public void Draw(){
		GameObjectContainer.GetGameScreen().drawCircle(this.position.x, this.position.y, this.radius, this.radius, color.WHITE);
	}
}
