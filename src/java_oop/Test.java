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
			System.out.println("V�lassza ki a futtatand� tesztet:\n\n");
			
			System.out.println("[1] Inicializ�l�s\n");
			System.out.println("[2] Akad�ly elhelyez�se �s ugr�s\n");
			System.out.println("[3] Egy robot lel�p a p�ly�r�l\n");
			System.out.println("[4] Akad�lyra l�p�s �s �j akad�ly elhelyez�se\n");
			System.out.println("[5] J�t�k v�ge\n");
			
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
				System.out.println("V�letlen�l rossz sz�mot �t�tt�l be. K�rlek olvasd el �jra a "
						+ "lehet�s�geket �s pr�b�lkozz �jra!");
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
