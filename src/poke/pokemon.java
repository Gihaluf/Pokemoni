package poke;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class pokemon extends JPanel implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8895138277472371392L;
	
	//main panel size 751x565
		//main panel location 32x109
	Timer tm = new Timer(5, this);
	int x = 0, y = 0, velX = 0, velY = 0;
	public pokemon() {
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(x, y, 90, 50);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		x += velX;
		y += velY;
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_W) {
			velY = -5;
		}
		if (c == KeyEvent.VK_S) {
			velY = 5;
		}
		if (c == KeyEvent.VK_A) {
			velX = -5;
		}
		if (c == KeyEvent.VK_D) {
			velX = 5;
		}
		
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_W) {
			velY = 0;
		}
		if (c == KeyEvent.VK_S) {
			velY = 0;
		}
		if (c == KeyEvent.VK_A) {
			velX = 0;
		}
		if (c == KeyEvent.VK_D) {
			velX = 0;
		}
	}
	
	static JLabel pokedex(String txt) {
		ImageIcon poke = new ImageIcon("bildes/"+txt);
		JLabel bilde= new JLabel(poke);
		return bilde;
	}
	//make me a panel that u can move around with keyboard WASD 
	
	public static void main(String[] args) {
		//main frame size 1244x700
		JFrame main = new JFrame();
		main.setLocation(150, 50);
		main.setSize(1244, 700);
		main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		ImageIcon icon = new ImageIcon("bildes/pokeframe.png");
		JLabel background = new JLabel(icon);
		main.setContentPane(background);
		main.setUndecorated(true);
		
		//main panel
		JPanel panel = new JPanel();
		panel.setSize(751, 565);
		panel.setLocation(32, 109);
		panel.setOpaque(false);
		
		//startup frame
		ImageIcon gif = new ImageIcon("bildes/Startup.gif");
		JLabel Sgif = new JLabel(gif);
		Sgif.setSize(751, 560);
		panel.add(Sgif);
		
		//pokemon type panel
		JPanel Pokemon = new JPanel();
		Pokemon.setSize(260, 165);
		Pokemon.setLocation(915, 90);
		Pokemon.setOpaque(false);
		
		
		//stop button
		JButton Stop = new JButton();
		Stop.setSize(84, 60);
		Stop.setLocation(58, 12);
		Stop.setOpaque(false);
		Stop.setContentAreaFilled(false);
		Stop.setBorderPainted(false);
		Stop.addActionListener(e -> System.exit(0));
		
		//pokedex button
		JButton Pokedex = new JButton();
		Pokedex.setSize(72, 73);
		Pokedex.setLocation(1008, 383);
		Pokedex.setOpaque(false);
		Pokedex.setContentAreaFilled(false);
		Pokedex.setBorderPainted(false);
		
		String[] pokemoni = {"Squirtle1.gif", "Lick1.gif", };
		String[] type = {"Sqrt.png", "Lck.png", };
		String[] info = {"Pēc piedzimšanas mugura uzbriest un sacietē čaulā. Tā izsmidzina no mutes spēcīgu putu.",
				"Ja šī Pokemona lipīgā siekala uzlīdīs tev virsū un tu to nenotīrīsi, iegriezīsies intensīva nieze. Nieze arī neaizies.",
				};
		
		Pokedex.addActionListener(e -> {
			panel.removeAll();
			
			JButton nak = new JButton();
			nak.setSize(38, 30);
			nak.setLocation(1038, 257);
			nak.setOpaque(false);
			nak.setContentAreaFilled(false);
			nak.setBorderPainted(false);
			main.add(nak);
			
			int[] skaits = {0};
			JLabel pirmais = pokedex(type[skaits[0]]);
			pirmais.setSize(260, 167);
			Pokemon.add(pirmais);
			
			JTextArea pirmaisa = new JTextArea(info[skaits[0]]);
			pirmaisa.setLineWrap(true);
			pirmaisa.setWrapStyleWord(true);
			pirmaisa.setOpaque(false);
			pirmaisa.setSize(700, 200);
			panel.add(pirmaisa);
			
			JLabel pirmaisb = pokedex(pokemoni[skaits[0]]);
			panel.add(pirmaisb);
			
			nak.addActionListener(ev -> {
				Pokemon.removeAll();
				Pokemon.revalidate();
				Pokemon.repaint();
				panel.removeAll();
				skaits[0]++;
				if (skaits[0]>pokemoni.length-1) {
					skaits[0]=0;
				}
				JTextArea apraksts = new JTextArea(info[skaits[0]]);
				apraksts.setLineWrap(true);
				apraksts.setWrapStyleWord(true);
				apraksts.setOpaque(false);
				apraksts.setSize(700, 200);
				panel.add(apraksts);
				
				JLabel bildite = pokedex(pokemoni[skaits[0]]);
				panel.add(bildite);
				
				JLabel tips = pokedex(type[skaits[0]]);
				tips.setSize(260, 167);
				Pokemon.add(tips);
				panel.revalidate();
				panel.repaint();
				
			});
			JButton iepr = new JButton();
			iepr.setSize(38, 30);
			iepr.setLocation(998, 257);
			iepr.setOpaque(false);
			iepr.setContentAreaFilled(false);
			iepr.setBorderPainted(false);
			main.add(iepr);
			
			iepr.addActionListener(ev -> {
				Pokemon.removeAll();
				Pokemon.revalidate();
				Pokemon.repaint();
				panel.removeAll();
				
				skaits[0]--;
				if (skaits[0]<0) {
					skaits[0]=pokemoni.length-1;
				}
				
				JTextArea apraksts = new JTextArea(info[skaits[0]]);
				apraksts.setLineWrap(true);
				apraksts.setWrapStyleWord(true);
				apraksts.setOpaque(false);
				apraksts.setSize(700, 200);
				panel.add(apraksts);
				
				JLabel bildite = pokedex(pokemoni[skaits[0]]);
				panel.add(bildite);
				
				JLabel tips = pokedex(type[skaits[0]]);
				tips.setSize(260, 167);
				Pokemon.add(tips);
				panel.revalidate();
				panel.repaint();
			});
			
			JLabel bildit = pokedex("Bulbasaur");
			bildit.setSize(260, 167);
			Pokemon.add(bildit);
			panel.revalidate();
			panel.repaint();
			
		});
		//home button
		JButton Home = new JButton();
		Home.setSize(84, 60);
		Home.setLocation(342, 12);
		Home.addActionListener(e -> {
			
			panel.removeAll();
			panel.add(Sgif);
			panel.revalidate();
			panel.repaint();
			Pokemon.removeAll();
			Pokemon.revalidate();
			Pokemon.repaint();
	
		});
		
		
		
		main.add(Stop);
		main.add(panel);
		main.add(Pokemon);
		main.add(Pokedex);
		main.add(Home);
		
		main.setVisible(true);
		
		
	}
	
}