package java_oop;

import java.awt.Color;

public abstract class GameObject implements Drawable {
	
	protected Vektor position;
	protected int radius;
	protected Color color;
	
	
	public void Collision(){
		
	}
	
	public void Affect(Robot robot){
		
	}
	
	public void Draw(){
		
	}
	
	public Vektor GetPosition(){
		return position;
	}
}
