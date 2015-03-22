package java_oop;

import java.util.Vector;

public class Putty extends Obstacle {
	public void Affect(Robot affected){
		Test.PrintLog();
		affected.Modify(new Vector<Integer>());
	}
}
