package java_oop;

import java.util.ArrayList;
import java.util.List;

public class RaceTrack extends GameObject {
	
	private ArrayList<Vektor> Points;
	private int Width;
	private Vektor startingpoint;
	
	public RaceTrack(){
		//Test.PrintLog();
		GameObjectContainer.AddRaceTrack(this);
	}
	
	public void Load(){
		//Test.PrintLog();
		//teszt kód
		//generálunk egy ellipszist....
		Width = 30;
		startingpoint = new Vektor(0,20);
		Points = new ArrayList<Vektor>();
		for(int i = 0; i<800; i++){
			Points.add(new Vektor(i, 20));
		}
		/*Vektor center = new Vektor(400,300);
		for(int i = 0; i<360; i++ ){
			Points.add(new Vektor(
					(int)Math.round(Math.sin(Math.toRadians( i ))*300.0),
					(int)Math.round(Math.cos(Math.toRadians( i ))*200.0)));
		} */
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
	
	public Vektor GetStartingPoint()
	{
		return startingpoint;
	}
}
