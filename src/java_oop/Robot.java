package java_oop;

import java.util.Vector;

public class Robot extends GameObject {
	
	//sztem sima double legyen a speed
	private Vector<Double> speed;
	private int oil;
	private int putty;
	private boolean isOnTrack;
	
	
	
	public void Jump(){
		//nem vagyok robot
	}
	
	//int vektor lesz itt?
	public void Modify(Vector<Integer> modvalue, int obstacle){
		
	}
	
	public void CalculateIsOnTrack(){
		
	}
	
	public boolean GetIsOnTrack(){
		return isOnTrack;
	}
	
	public boolean Collision(Vector<Integer> pos){
		
		return false;
	}
	
	public void Affect(Robot robot){
		
	}
}
