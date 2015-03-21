package java_oop;

import java.io.IOException;
import java.util.Scanner;

public final class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int selector = 0;
		Scanner in = new Scanner(System.in); 
		Game testGame = new Game();
		
		while(true)
		{
			System.out.println("Java_OOP csapat Robot Game test\n");
			System.out.println("Válassza ki a futtatandó tesztet:\n\n");
			
			System.out.println("[1] Inicializálás\n");
			System.out.println("[2] Akadály elhelyezése és ugrás\n");
			System.out.println("[3] Egy robot lelép a pályáról\n");
			System.out.println("[4] Akadályra lépés és új akadály elhelyezése\n");
			System.out.println("[5] Játék vége\n");
			
			selector = in.nextInt();
			switch(selector)
			{
			case 1:
				testGame.Start();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default :
				System.out.println("Véletlenül rossz számot ütöttél be. Kérlek olvasd el újra a "
						+ "lehetõségeket és próbálkozz újra!");
				break;
			}
		}
		
		
	}
	
	public static void PrintLog(int dif)
	{
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		System.out.println(ste[ste.length - 1 - dif].getClassName() + "\t" + ste[ste.length - 1 - dif].getMethodName());
		System.out.println();
	}
}
