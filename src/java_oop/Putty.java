package java_oop;


public class Putty extends Obstacle {
	
	public Putty(){
		GameObjectContainer.AddObstacle(this);
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
	}
	
	public void Update(){
		
	}
}
