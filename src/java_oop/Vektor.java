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
	
	public int Length(){
		return (int)Math.round(Math.sqrt(this.x * this.x + this.y * this.y));
	}
	public Vektor Normalize(){
		Vektor normalized = new Vektor();
		
		double length = Math.sqrt(this.x * this.x + this.y * this.y);
		
		//van pár eset, amikor a math.round jobb
		normalized.x = (int) Math.round(this.x / length);
		normalized.y = (int) Math.round(this.y /length);
		
		return normalized;
	}
	
	public Vektor Add(Vektor addThis){
		Vektor added = new Vektor();
		
		added.x = this.x + addThis.x;
		added.y = this.y + addThis.y;
		
		return added;
	}
	
	public Vektor Substract(Vektor substractThis){
		//az eredetiből vonjuk az újat, szóval az eredményvektor az eredetibe mutat
		Vektor substracted = new Vektor();
		substracted.x = this.x - substractThis.x;
		substracted.y = this.y - substractThis.y;
		return substracted;
	}
	
	public Vektor DivideBy(int number){
		Vektor divided = new Vektor();
		
		divided.x =(int)Math.round( this.x /number);
		divided.y = (int)Math.round(this.y / number);
		
		return divided;
	}
	
	public boolean Equals(Vektor pos){
		if(this.x == pos.x && this.y == pos.y){
			return true;
		}
		return false;
	}
	
	public boolean isGreaterThan(Vektor pos){
		//csak a sebesség nagysága alapján hasonlítunk
		double magnitude = Math.sqrt(this.x * this.x + this.y * this.y);
		double othermagnitude = Math.sqrt(pos.x * pos.x + pos.y * pos.y);
		
		if(magnitude > othermagnitude){
			return true;
		}
		else 
			return false;
	}
	
	public String toString(){
		String vissza = "" + this.x + " " + this.y;
		return vissza;
	}
}
