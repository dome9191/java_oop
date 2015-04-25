package java_oop;


public class Putty extends Obstacle {
	
	public Putty(){
		GameObjectContainer.AddObstacle(this);
		this.radius = 20;
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
		
		//r�l�ptek egyszer
		this.count++;
		
		//ha m�r n�gyszer r�l�ptek, akkor t�rl�s
		if(this.count == 4){
			GameObjectContainer.RemoveObstacle(this);
		}
	}
	
	//asszem itt haszontalan, nem csin�l semmit
	public void Update(){
		
	}
	
	public void Draw(){
		GameObjectContainer.GetGameScreen().drawCircle(this.position.x, this.position.y, this.radius, this.radius, color.WHITE);
	}
}
