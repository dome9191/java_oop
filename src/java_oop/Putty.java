package java_oop;


public class Putty extends Obstacle {
	
	public Putty(){
		GameObjectContainer.AddObstacle(this);
	}
	
	//init �s getcount megval�s�tva az Obstacle-ben
	
	//fel�re cs�kkenti a robot sebess�g�t
	public void Affect(Robot affected){
		//Test.PrintLog();
		//affected.Modify(new Vector<Integer>());
		Vektor newspeed = affected.GetSpeed();
		
		//felezz�k a sebess�get
		newspeed =  newspeed.DivideBy(2);
		
		//be�ll�tjuk a robotnak
		affected.Modify(newspeed);
	}
	
	public void Update(){
		
	}
}
