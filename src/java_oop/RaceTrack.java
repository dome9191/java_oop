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
		Width = 100;
		startingpoint = new Vektor(100,200);
		Points = new ArrayList<Vektor>();
		/*for(int i = 0; i<800; i++){
			Points.add(new Vektor(i, 200));
		}*/
		Vektor center = new Vektor(350,250);
		for(int i = 0; i<360; i++ ){
			Points.add(new Vektor(
					(int)Math.round(Math.sin(Math.toRadians( i ))*300.0)+center.x,
					(int)Math.round(Math.cos(Math.toRadians( i ))*200.0)+center.y));
		} 
	}
	
	public void Draw(){
		for(Vektor elem : Points){
			int i = 0;
			i++;
			GameObjectContainer.GetGameScreen().drawCircle(elem.x, elem.y, Width, Width, color.GRAY);
		}
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
