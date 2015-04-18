package java_oop;

import java.util.ArrayList;
import java.util.List;

public class RaceTrack extends GameObject {
	
	private ArrayList<Vektor> Points;
	private int Width;
	
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
	
	public ArrayList<Vektor> GetPoints(){
		return Points;
	}
	
	public int GetWidth(){
		return Width;
	}
}
