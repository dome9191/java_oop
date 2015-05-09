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

public class GameScreen extends JFrame {
	
	int x, y;
	private Game myGame;
	private int wantoil = 0;
	private int wantputty = 0;
	private int width = 800;
	private int height = 600;
	
	public GameScreen(Game currentgame) {
		myGame = currentgame;
		currentgame.SetScreen(this);
		setSize(width, height);
		this.setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //induláskor rajzoljuk ki a játékot
	    this.addComponentListener(new ComponentAdapter (){
	    	public void componentShown ( ComponentEvent e )
	        {
	            myGame.DrawGame();
	        }
	    });
	    //billentyűzet figyelő
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
	    //egér figyelő
	    this.addMouseListener(new MouseListener() {      
            public void mouseClicked(MouseEvent mouse) {
            	x = mouse.getX();
        	    y = mouse.getY();
        	    wantoil = 0;
        	    wantputty = 0;
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
	}
	//kör rajzoló függvény
	public void drawCircle(int x, int y, int w, int h, Color color) {
        Graphics g = this.getGraphics();
        g.setColor(color);
        //g.drawOval(x, y, 100, 100);
        g.fillOval(x, y, w, h);
        //g.drawLine(0, 0, 100, 100);
        
    }
	
	public void drawLine() {
		
	}
	//kirajzolja a hátteret
	public void DrawBackground(){
		Graphics g = this.getGraphics();
		g.setColor(new Color(255,140,0));
        g.fillRect(0, 0, width, height);
        drawOilGui();
        drawPuttyGui();
	}
	//kiír valami szöveget tetszőleges helyre
	private void writeString(String i, int x, int y){
		Graphics g = this.getGraphics();
		Font font = new Font("Serif", Font.PLAIN, 20);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString(i, x, y);
	}
	//kirajzolja az olaj választót
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
	//kirajzolja a ragacs választót
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
}
