package java_oop;

import java.util.List;

public class RaceTrack extends GameObject {
	
	//nyilv�n ArrayList lesz majd 
	List<Vektor> Points;
	
	public RaceTrack(){
		//Test.PrintLog();
		GameObjectContainer.AddRaceTrack(this);
	}
	
	public void Load(){
		//Test.PrintLog();
	}
	
	public void Draw(){
		//Test.PrintLog();
	}
}
