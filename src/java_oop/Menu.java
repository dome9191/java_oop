package java_oop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.SpinnerNumberModel;

public class Menu extends JFrame {

	//protected, hogy ha esetleg el k�ne �rni m�shonnan
	protected JButton newgameButton;
	protected JLabel jatekosszamLabel;
	protected JLabel robotokLabel;
	protected JSpinner jatekosszamSpinner;
	protected JLabel olajLabel;
	protected JLabel ragacsLabel;
	protected JSpinner olajSpinner;
	protected JSpinner ragacsSpinner;
	protected JLabel jatekidoLabel;
	protected JLabel koridoLabel;
	protected JSpinner percSpinner;
	protected JLabel percLabel;
	protected JSpinner masopercSpinner;
	protected JLabel masopercLabel;
	protected JLabel phoebeLabel;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	//dolgok fel�p�t�se
	public Menu() {
		setTitle("java_oop project PHOEBE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 227);
		getContentPane().setLayout(null);
		
		newgameButton = new JButton("�j j�t�k");
		newgameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* ide j�n:
				 * 		-SetGameEnvironment a k�t id�s jspinner alapj�n
				 * 		-a Game Start() f�ggv�nye utols�nak
				 */
				java.awt.EventQueue.invokeLater(new Runnable() {
		              public void run() {
		            	   Game myscreentest = new Game();
		            	   
		            	   //id�be�ll�t�s
		            	   myscreentest.SetEnvironment((int)percSpinner.getValue()*60,(int)masopercSpinner.getValue());
		            	   
		            	   //annyi j�t�kos, amennyit bejel�ltek
		            	   //hozza�rtam egy +1-t
		            	   for(int i = 1; i < (int)jatekosszamSpinner.getValue()+1; i++){
		            		   myscreentest.AddPlayer();
		            	   }
		            	   
		            	   //robotoknak olaj �s ragacs sz�m be�ll�t�sa
		            	   ArrayList<Robot> robotok = GameObjectContainer.GetRobots();
		            	   for(Robot iter : robotok){
		            		   iter.SetOilCount((int)olajSpinner.getValue());
		            		   iter.SetPuttyCount((int)ragacsSpinner.getValue());
		            	   }
		            	  
		                   GameScreen frame = new GameScreen(myscreentest);
		                   frame.setVisible(true);
		                   frame.repaint();
		              }
		        });
			}
		});

		newgameButton.setBounds(133, 154, 89, 23);
		getContentPane().add(newgameButton);
		
		jatekosszamLabel = new JLabel("J�t�kosok sz�ma:");
		jatekosszamLabel.setBounds(29, 56, 120, 14);
		getContentPane().add(jatekosszamLabel);
		
		robotokLabel = new JLabel("Robotok:");
		robotokLabel.setBounds(219, 59, 60, 14);
		getContentPane().add(robotokLabel);
		
		jatekosszamSpinner = new JSpinner();
		jatekosszamSpinner.setModel(new SpinnerNumberModel(2, 2, 5, 1));
		jatekosszamSpinner.setBounds(140, 53, 29, 20);
		getContentPane().add(jatekosszamSpinner);
		
		olajLabel = new JLabel("Olaj:");
		olajLabel.setBounds(219, 88, 46, 14);
		getContentPane().add(olajLabel);
		
		ragacsLabel = new JLabel("Ragacs:");
		ragacsLabel.setBounds(219, 124, 46, 14);
		getContentPane().add(ragacsLabel);
		
		olajSpinner = new JSpinner();
		olajSpinner.setModel(new SpinnerNumberModel(0,0,10,1));
		olajSpinner.setBounds(270, 85, 39, 20);
		getContentPane().add(olajSpinner);
		
		ragacsSpinner = new JSpinner();
		ragacsSpinner.setModel(new SpinnerNumberModel(0,0,10,1));
		ragacsSpinner.setBounds(270, 121, 39, 20);
		getContentPane().add(ragacsSpinner);
		
		jatekidoLabel = new JLabel("J�t�kid�");
		jatekidoLabel.setBounds(29, 88, 60, 14);
		getContentPane().add(jatekidoLabel);
		
		koridoLabel = new JLabel("K�rid�");
		koridoLabel.setBounds(29, 124, 46, 14);
		getContentPane().add(koridoLabel);
		
		percSpinner = new JSpinner();
		percSpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		percSpinner.setBounds(85, 85, 39, 20);
		getContentPane().add(percSpinner);
		
		percLabel = new JLabel("perc");
		percLabel.setBounds(130, 85, 46, 23);
		getContentPane().add(percLabel);
		
		masopercSpinner = new JSpinner();
		masopercSpinner.setModel(new SpinnerNumberModel(10, 0, 60, 1));
		masopercSpinner.setBounds(85, 121, 39, 20);
		getContentPane().add(masopercSpinner);
		
		masopercLabel = new JLabel("m�sodperc");
		masopercLabel.setBounds(130, 124, 80, 14);
		getContentPane().add(masopercLabel);
		
		phoebeLabel = new JLabel("java_oop project PHOEBE");
		phoebeLabel.setForeground(Color.BLUE);
		phoebeLabel.setBackground(Color.BLACK);
		phoebeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoebeLabel.setBounds(100, 11, 174, 19);
		getContentPane().add(phoebeLabel);
		
		//jelennyen m�' meg k�z�pen 
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
