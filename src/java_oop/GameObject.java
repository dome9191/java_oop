package java_oop;

import java.awt.Color;
import java.util.Vector;

public abstract class GameObject implements Drawable {
	
	protected Vector<Integer> position;
	protected int radius;
	protected Color color;
	
	
	public void Collision(Vector<Integer> pos){
		
	}
	
	public void Affect(Robot robot){
		
	}
	
	public void Draw(){
		
	}
}
