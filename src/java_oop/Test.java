package java_oop;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public final class Test {

	private static int muted = 0;
	public static int selector = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);  
		Game testgame = new Game();
		testgame.Start();
		/*while(true)
		{
			System.out.println("Java_OOP csapat Robot Game test\n");
			System.out.println("V�lassza ki a futtatand� tesztet:\n\n");
			
			System.out.println("[1] Inicializ�l�s\n");
			System.out.println("[2] Akad�ly elhelyez�se �s ugr�s\n");
			System.out.println("[3] Egy robot lel�p a p�ly�r�l\n");
			System.out.println("[4] Akad�lyra l�p�s �s �j akad�ly elhelyez�se\n");
			System.out.println("[5] J�t�k v�ge, mert nincs t�bb robot a p�ly�n\n");
			System.out.println("[6] J�t�k v�ge, mert lej�rt az id�\n");
			
			selector = in.nextInt();
			switch(selector)
			{
			case 1:
				Game testGame = new Game();
				testGame.AddPlayer();
				testGame.AddPlayer();
				testGame.SetEnvironment(new Date(0,0,0,0,2,0), new Date(0,0,0,0,0,10));
				
				AfterTest();
				break;
			case 2:
				Mute();
				Player testPlayer = new Player();
				Unmute();
				testPlayer.Turn();
			
				AfterTest();
				break;
			case 3:
				Mute();
				Player testPlayer2 = new Player();
				GameObjectContainer.AddObstacle(new Putty());
				Unmute();
				Game testGame3 = new Game();
				testGame3.Start();
				//testPlayer2.Turn();
				
				AfterTest();
				break;
			case 4:
				Mute();
				Player testPlayer3 = new Player();
				GameObjectContainer.AddObstacle(new Putty());
				Unmute();
				testPlayer3.Turn();
				
				AfterTest();
				break;
			case 5:
				Mute();
				Game testGame2 = new Game();
				testGame2.AddPlayer();
				testGame2.AddPlayer();
				testGame2.SetEnvironment(new Date(0,0,0,0,0,0), new Date(0,0,0,0,0,10));
				GameObjectContainer.AddObstacle(new Oil());
				Unmute();
				testGame2.Start();
				
				AfterTest();
			case 6:
				Mute();
				Game testGame4 = new Game();
				testGame4.AddPlayer();
				testGame4.SetEnvironment(new Date(0,0,0,0,0,0), new Date(0,0,0,0,0,10));
				Unmute();
				testGame4.Start();
				
				AfterTest();
			default :
				System.out.println("V�letlen�l rossz sz�mot �t�tt�l be. K�rlek olvasd el �jra a "
						+ "lehet�s�geket �s pr�b�lkozz �jra!");
				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}*/
	}
	
	public static int[] AskInput(String opt)
	{
		Scanner in = new Scanner(System.in);
		int[] result = new int[2];
		switch(opt)
		{
		case "coordinates":
			System.out.println("Hova ugorjak Mester?\n");
			result[0] = in.nextInt();
			result[1] = in.nextInt();
			break;
		case "placeobstacles":
			System.out.println("Mit rakjak le Mester?\n");
			result[0] = in.nextInt();
			//0 semmit, 1 ragacsot, 2 olajat
			break;
		default:
			break;
		}
		return result;
	}
	
	public static void PrintLog()
	{
		if(muted != 1){
			final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
			for(int i=0; i<ste.length-4; i++){
				System.out.print("\t");
			}
			System.out.println(ste[2].getClassName() + "\t" + ste[2].getMethodName());
		}
	}
	
	public static void PrintLog(String message)
	{
		if(muted != 1){
			final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
			for(int i=0; i<ste.length-4; i++){
				System.out.print("\t");
			}
			System.out.println(ste[2].getClassName() + "\t" + ste[2].getMethodName());
			System.out.println(message);
		}
	}
	
	public static void Mute(){
		muted = 1;
	}
	
	public static void Unmute(){
		muted = 0;
	}
	public static void AfterTest(){
		try {
			System.out.println("\nNyomj Entert a k�vetkez� v�laszt�shoz!");
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
