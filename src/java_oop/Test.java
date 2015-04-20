package java_oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public final class Test {

	private static int muted = 0;
	public static int selector = 0;
	private static Game testgame2 = new Game();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);  
		testgame2.SetEnvironment(100, 100);
		//testgame2.AddPlayer();
		testgame2.AddPlayer();
		testgame2.Start();
		/*Game testgame = new Game();
		testgame.SetEnvironment(new Date(0,0,0,0,1), new Date(0,0,0,0,1));
		testgame.AddPlayer();
		testgame.AddPlayer();
		testgame.Start(); */
		/*while(true)
		{
			System.out.println("Java_OOP csapat Robot Game test\n");
			System.out.println("Válassza ki a futtatandó tesztet:\n\n");
			
			System.out.println("[1] Inicializálás\n");
			System.out.println("[2] Akadály elhelyezése és ugrás\n");
			System.out.println("[3] Egy robot lelép a pályáról\n");
			System.out.println("[4] Akadályra lépés és új akadály elhelyezése\n");
			System.out.println("[5] Játék vége, mert nincs több robot a pályán\n");
			System.out.println("[6] Játék vége, mert lejárt az idõ\n");
			
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
				System.out.println("Véletlenül rossz számot ütöttél be. Kérlek olvasd el újra a "
						+ "lehetõségeket és próbálkozz újra!");
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
		String input;
		int[] result = new int[2];
			switch(opt)
			{
			case "coordinates":
				//System.out.println("Hova ugorjak Mester?\n");
				while(true)
				{
					input = in.nextLine();
					if(input.compareTo("")==0)
						continue;
					if(input.charAt(0)=='@')
					{
						HandleCommand(input);
					}
					else
					{
						break;
					}
				}
				result[0] = Integer.parseInt(input);
				while(true)
				{
					input = in.nextLine();
					if(input.compareTo("")==0)
						continue;
					if(input.charAt(0)=='@')
					{
						HandleCommand(input);
					}
					else
					{
						break;
					}
				}
				result[1] = Integer.parseInt(input);
				break;
			case "placeobstacles":
				//System.out.println("Mit rakjak le Mester?\n");
				while(true)
				{
					input = in.nextLine();
					if(input.compareTo("")==0)
						continue;
					if(input.charAt(0)=='@')
					{
						HandleCommand(input);
					}
					else
					{
						break;
					}
				}
				result[0] = Integer.parseInt(input);
				//0 semmit, 1 ragacsot, 2 olajat
				break;
			default:
				break;
			}
		return result;
	}
	
	public static void HandleCommand(String command)
	{
		//levágjuk az @ jelzőt ha esetleg konzolról jött a parancs
		if(command.charAt(0)=='@'){
			command = command.substring(1);
		}
		ArrayList<Integer> opts = new ArrayList<Integer>();
		if(command.contains("(")){
			String[] parts = command.split("\\(");
			command = parts[0];
			String[] data = parts[1].substring(0, parts[1].length()-1).split(",");
			for(String item: data){
				opts.add(Integer.parseInt(item));
			}
		}
		
		switch(command){
		case "loadMap":
			loadMap();
			break;
		case "addPlayer":
			addPlayer(opts.get(0));
			break;
		case "placeOil":
			placeOil(opts.get(0));
			break;
		case "placePutty":
			placePutty(opts.get(0));
			break;
		case "moveRobot":
			moveRobot(opts.get(0), opts.get(1), opts.get(2));
			break;
		case "startSweeperRobots":
			startSweeperRobots(opts.get(0), opts.get(1), opts.get(2), opts.get(3), opts.get(4), opts.get(5));
			break;
		case "deleteObstacle":
			deleteObstacle(opts.get(0), opts.get(1));
			break;
		case "listPlayers":
			listPlayers();
			break;
		case "listObstacles":
			listObstacles();
			break;
		case "listSweeperRobots":
			listSweeperRobots();
			break;
		case "setTimes":
			setTimes(opts.get(0), opts.get(1));
			break;
		case "remainingTotalTime":
			remainingTotalTime();
			break;
		case "moveSweeperRobot":
			moveSweeperRobot(opts.get(0), opts.get(1), opts.get(2));
			break;
		case "changeRobotSpeed":
			changeRobotSpeed(opts.get(0), opts.get(1), opts.get(2));
			break;
		case "Update":
			Update(opts.get(0));
			break;
		default:
			break;
		}
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
			System.out.println("\nNyomj Entert a következõ választáshoz!");
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadMap(){
		//nem állítunk be idõket, itt csak meghívódik a pálya Load-ja
		testgame2.SetEnvironment(100, 100);
	}
	
	//number számú játékost hoz létre
	public static void addPlayer(int number){
		for(int i = 0; i < number; i++){
			testgame2.AddPlayer();
		}
	}
	
	public static void placeOil(int robotindex){
		ArrayList<Player> players = testgame2.GetPlayers();
		Player lerako = players.get(robotindex);
		lerako.CreateOil();
	}
	
	public static void placePutty(int robotindex){
		ArrayList<Player> players = testgame2.GetPlayers();
		Player lerako = players.get(robotindex);
		lerako.CreatePutty();
	}
	
	
	public static void moveRobot(int x, int y, int robotindex){
		ArrayList<Robot> robotlist = GameObjectContainer.GetRobots();
		Robot mozgo = robotlist.get(robotindex);
		if(mozgo.GetIsOnTrack()){
			Vektor move = new Vektor(x, y);
			mozgo.CalculateIsOnTrack();
			mozgo.Collision();
			mozgo.Jump(move);
		}
	} 
	
	//3 kisrobotot tesz a pályára
	public static void startSweeperRobots(int x1, int y1, int x2, int y2, int x3, int y3){
		Vektor k1 = new Vektor(x1,y1);
		Vektor k2 = new Vektor(x2,y2);
		Vektor k3 = new Vektor(x3, y3);
		
		SweeperRobot a = new SweeperRobot();
		a.setStartPos(k1);
		
		
		SweeperRobot b = new SweeperRobot();
		b.setStartPos(k2);
	
		
		SweeperRobot c = new SweeperRobot();
		c.setStartPos(k3);
	
		
	}
	
	public static void deleteObstacle(int x, int y){
		Vektor akadaly = new Vektor(x, y);
		
		ArrayList<Obstacle> obstacles = GameObjectContainer.GetObstacles();
		Obstacle torlendo = null;
		for(Obstacle iter: obstacles){
			if(iter.GetPosition().Equals(akadaly)){
				torlendo = iter;
			}
		}
		GameObjectContainer.RemoveObstacle(torlendo);
	}
	
	public static void listPlayers(){
		ArrayList<Robot> robots = GameObjectContainer.GetRobots();
		int i = 0;
		for(Robot iter:robots){
			System.out.println(i+ " " + iter.GetPosition().toString() +" " + iter.GetOilCount()+" " + iter.GetPuttyCount()+" " + iter.GetSpeed().toString());
			i++;
		}
	}
	
	public static void listObstacles(){
		ArrayList<Obstacle> obstacles = GameObjectContainer.GetObstacles();
		int i = 0;
		for(Obstacle iter:obstacles){
			System.out.println(i+ " "+ iter.getClass().getSimpleName()+ " " + iter.GetPosition().toString());
			i++;
		}
	}
	
	public static void listSweeperRobots(){
		ArrayList<SweeperRobot> srobots = GameObjectContainer.GetSweeperRobot();
		int i = 0;
		for(SweeperRobot iter:srobots){
			System.out.println(i+ " " + iter.GetPosition()+ " " + iter.getDirection());
			i++;
		}
	}
	
	public static void setTimes(int totaltime, int turntime){
		testgame2.SetEnvironment(totaltime, turntime);
	}
	
	public static void remainingTotalTime(){
		ArrayList<Player> players = testgame2.GetPlayers();
		Player a = players.get(0);
		System.out.println(a.GetTotalTime());
	}
	
	public static void moveSweeperRobot(int x, int y, int srobotindex){
		ArrayList<SweeperRobot> srobots = GameObjectContainer.GetSweeperRobot();
		SweeperRobot kisrobi = srobots.get(srobotindex);
		Vektor jumpkoord = new Vektor(x, y);
		kisrobi.Collision();
		kisrobi.Jump(jumpkoord);
	}
	
	public static void changeRobotSpeed(int x, int y, int robotindex){
		ArrayList<Robot> robots = GameObjectContainer.GetRobots();
		Robot robi = robots.get(robotindex);
		Vektor newspeed = new Vektor(x, y);
		robi.Modify(newspeed);
	}
	
	public static void Update(int obstacleindex){
		ArrayList<Obstacle> oblist = GameObjectContainer.GetObstacles();
		Obstacle ob = oblist.get(obstacleindex);
		ob.Update();
	}
}

