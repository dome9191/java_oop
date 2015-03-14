package java_oop;

import java.awt.Color;
import java.util.Vector;

public abstract class GameObject implements Drawable {
	
	private Vector<Integer> position;
	private int radius;
	private Color color;
	
	
	public boolean Collision(Vector<Integer> pos){
		
		return false;
	}
	
	public void Affect(Robot robot){
		
	}
	
	public void Draw(){
		
	}
}
