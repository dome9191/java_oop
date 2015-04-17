package java_oop;

import java.util.List;

public class RaceTrack extends GameObject {
	
	//nyilván ArrayList lesz majd 
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
