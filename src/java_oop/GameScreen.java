package java_oop;

import javax.swing.JFrame;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.*;

import java.awt.geom.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends JFrame {
	
	int x, y;
	private Game myGame;
	private int wantoil = 0;
	private int wantputty = 0;
	private int width = 800;
	private int height = 600;
	private Timer TotalTimer;
	
	public GameScreen(Game currentgame) {
		myGame = currentgame;
		TotalTimer = new Timer();
		TotalTimer.schedule(new TotalTimeTask(), 0, 1000);
		currentgame.SetScreen(this);
		setSize(width, height);
		this.setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //indulaskor rajzoljuk ki a jatekot
	    this.addComponentListener(new ComponentAdapter (){
	    	public void componentShown ( ComponentEvent e )
	        {
	            myGame.DrawGame();
	        }
	    });
	    
	    //billentyuzet figyelo
	    this.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				char pressed = arg0.getKeyChar();
				if(pressed == 'p' && wantoil != 1){
					if(wantputty == 1){
						wantputty = 0;
					}
					else{
						wantputty = 1;
					}
					drawPuttyGui();
				}
				if(pressed == 'o' && wantputty != 1){
					if(wantoil == 1){
						wantoil = 0;
					}
					else{
						wantoil = 1;
					}
					drawOilGui();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        });
	    //eger figyelo
	    this.addMouseListener(new MouseListener() {      
            public void mouseClicked(MouseEvent mouse) {
            	x = mouse.getX();
        	    y = mouse.getY();
        	    myGame.GetPlayers().get(myGame.GetNextPlayer()).Turn();
            	myGame.DrawGame();
            }
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}    
        });

	    this.addComponentListener(new ComponentAdapter (){
	    	public void componentShown ( ComponentEvent e )
	        {
	            TotalTimer.notify();
	            GameObjectContainer.GetGameScreen().drawTime(Player.GetTotalTime());
	        }
	    });
	}
	//kor rajzolas fuggveny
	public void drawCircle(int x, int y, int w, int h, Color color) {
        Graphics g = this.getGraphics();
        g.setColor(color);
        //g.drawOval(x, y, 100, 100);
        g.fillOval(x, y, w, h);
        //g.drawLine(0, 0, 100, 100);
        
    }
	
	public void drawLine() {
		
	}
	//kirajzolja a hatteret
	public void DrawBackground(){
		Graphics g = this.getGraphics();
		g.setColor(new Color(255,140,0));
        g.fillRect(0, 0, width, height);
        drawOilGui();
        drawPuttyGui();
	}
	//kiir valami szoveget tetszoleges helyre
	private void writeString(String i, int x, int y){
		Graphics g = this.getGraphics();
		Font font = new Font("Serif", Font.PLAIN, 20);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString(i, x, y);
	}
	//kirajzolja az olaj valasztast
	private void drawOilGui(){
		writeString("Olajat lerakni", width-180, height-45);
		if(wantoil == 1){
			drawCircle(width-40, height-60, 16 ,16, Color.DARK_GRAY);
			drawCircle(width-37, height-57, 10 ,10, Color.LIGHT_GRAY);
		}
		else{
			drawCircle(width-40, height-60, 15 ,15, Color.DARK_GRAY);
		}
	}
	//kirajzolja a ragacs valasztast
	private void drawPuttyGui(){
		writeString("Ragacsot lerakni", width-180, height-15);
		if(wantputty == 1){
			drawCircle(width-40, height-30, 16 ,16, Color.DARK_GRAY);
			drawCircle(width-37, height-27, 10 ,10, Color.LIGHT_GRAY);
		}
		else{
			drawCircle(width-40, height-30, 15 ,15, Color.DARK_GRAY);
		}
	}
	public void drawTime(int time){
		Graphics g = this.getGraphics();
		g.setColor(new Color(255,140,0));
        g.fillRect(0, 0, 100, 50);
        writeString("Kert ido: "+Integer.toString(time), 20, 50);
	}
	//ugyanaz a fuggveny mint a tesztosztalyban szepen visszaadja hogy mit akarunk
	public int[] AskInput(String opt){
		int[] result = new int[2];
		switch(opt)
		{
		case "coordinates":
			result[0] = x;
			result[1] = y;
			break;
		case "placeobstacles":
			result[0] = 0;
			if(wantoil == 1)
			{
				result[0] = 2;
				}
			if(wantputty == 1)
			{
				result[0] = 1;
			}
			wantoil = 0;
    	    wantputty = 0;
			break;
		default:
			break;
		}
	return result;
	}
}


class TotalTimeTask extends TimerTask {

	@Override
	public void run() {
		 if (Player.GetTotalTime()>0)
		 {
			 int helper = Player.GetTotalTime() - 1;
			 Player.SetTotalTime(helper);
			 
		 }
		
	}
}

