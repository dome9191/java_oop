package java_oop;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.*;
import java.awt.geom.*;

public class GameScreen extends JFrame {
	
	int x, y;
	private Game myGame;
	
	public GameScreen(Game currentgame) {
		myGame = currentgame;
		currentgame.SetScreen(this);
		setSize(800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.addMouseListener(new MouseListener() {      
            public void mouseClicked(MouseEvent mouse) {
        	    myGame.DrawGame();
        	    x = mouse.getX();
        	    y = mouse.getY();
        	    drawCircle(x,y,10,10, new Color(255,140,0));
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
	
	public void drawCircle(int x, int y, int w, int h, Color color) {
        Graphics g = this.getGraphics();
        g.setColor(color);
        //g.drawOval(x, y, 100, 100);
        g.fillOval(x, y, w, h);
        //g.drawLine(0, 0, 100, 100);
        
    }
	
	public void drawLine() {
		
	}
	
	public void DrawBackground(){
		Graphics g = this.getGraphics();
		g.setColor(new Color(255,140,0));
        g.fillRect(0, 0, 800, 600);
	}
}
