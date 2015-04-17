package java_oop;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Vektor implements Serializable {
	public int x;
	public int y;
	
	public Vektor(){
		this.x = 0;
		this.y = 0;
	}
	
	public Vektor(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vektor Normalize(){
		Vektor normalized = new Vektor();
		
		double length = Math.sqrt(this.x * this.x + this.y * this.y);
		
		normalized.x = (int) (this.x / length);
		normalized.y = (int) (this.y /length);
		
		
		return normalized;
	}
	
	public Vektor Add(Vektor addThis){
		Vektor added = new Vektor();
		
		added.x = this.x + addThis.x;
		added.y = this.x + addThis.y;
		
		return added;
	}
}
