package java_oop;

import java.util.List;
import java.util.Vector;

public class RaceTrack extends GameObject {
	
	//nyilván ArrayList lesz majd 
	List<Vector<Integer> > Points;
	
	public RaceTrack(){
		Test.PrintLog();
		GameObjectContainer.AddRaceTrack(this);
	}
	
	public void Load(){
		Test.PrintLog();
	}
	
	public void Draw(){
		Test.PrintLog();
	}
}
