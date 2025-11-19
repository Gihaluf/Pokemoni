package poke;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import main.GamePanel;

public class pokemon {
	public static GamePanel  gamePanel = new GamePanel();
	public static JFrame kust = new JFrame();
	
	static JLabel pokedex(String txt) {
		ImageIcon poke = new ImageIcon("bildes/"+txt);
		JLabel bilde= new JLabel(poke);
		return bilde;
	}
	
	public static void main(String[] args) {
		JFrame main = new JFrame();
		main.setLocation(150, 50);
		main.setSize(1244, 700);
		main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		ImageIcon icon = new ImageIcon("bildes/pokeframe.png");
		JLabel background = new JLabel(icon);
		main.setContentPane(background);
		main.setUndecorated(true);
		
		
		JPanel panel = new JPanel();
		panel.setSize(751, 565);
		panel.setLocation(32, 109);
		panel.setOpaque(false);
		main.add(panel);
		
		
		ImageIcon gif = new ImageIcon("bildes/Startup.gif");
		JLabel Sgif = new JLabel(gif);
		Sgif.setSize(751, 560);
		panel.add(Sgif);
		
		
		JPanel Pokemon = new JPanel();
		Pokemon.setSize(260, 165);
		Pokemon.setLocation(915, 90);
		Pokemon.setOpaque(false);
		main.add(Pokemon);
		
		
		JButton Stop = new JButton();
		Stop.setSize(84, 60);
		Stop.setLocation(58, 12);
		Stop.setOpaque(false);
		Stop.setContentAreaFilled(false);
		Stop.setBorderPainted(false);
		Stop.addActionListener(e -> System.exit(0));
		main.add(Stop);
		
		
		JButton Home = new JButton();
		Home.setSize(72, 73);
		Home.setLocation(907, 500);
		Home.setOpaque(false);
		Home.setContentAreaFilled(false);
		Home.setBorderPainted(false);
		main.add(Home);
		
		JButton Pokedex = new JButton();
		Pokedex.setSize(72, 73);
		Pokedex.setLocation(1008, 383);
		Pokedex.setOpaque(false);
		Pokedex.setContentAreaFilled(false);
		Pokedex.setBorderPainted(false);
		main.add(Pokedex);
		String[] pokemoni = {"Squirtle1.gif", "Lick1.gif", };
		String[] type = {"Sqrt.png", "Lck.png", };
		String[] info = {"Pēc piedzimšanas mugura uzbriest un sacietē čaulā. Tā izsmidzina no mutes spēcīgu putu.",
				"Ja šī Pokemona lipīgā siekala uzlīdīs tev virsū un tu to nenotīrīsi, iegriezīsies intensīva nieze. Nieze arī neaizies.",
				};
		
		
		
		JButton stiagat = new JButton();
		stiagat.setSize(72, 73);
		stiagat.setLocation(907, 384);
		stiagat.setOpaque(false);
		stiagat.setContentAreaFilled(false);
		stiagat.setBorderPainted(false);
		main.add(stiagat);
		
		
		int []PBsk= {5};
		int []MBsk= {2};
		int []UBsk= {1};
		JLabel PokeballSk = new JLabel();
			PokeballSk.setText(String.valueOf(PBsk[0]));
			PokeballSk.setSize(40, 20);
			PokeballSk.setLocation(337, 63);
		JLabel MediumballSk = new JLabel();
			MediumballSk.setText(String.valueOf(MBsk[0]));
			MediumballSk.setSize(40, 20);
			MediumballSk.setLocation(503, 63);
		JLabel UltraballSk = new JLabel();
			UltraballSk.setText(String.valueOf(UBsk[0]));
			UltraballSk.setSize(40, 20);
			UltraballSk.setLocation(667, 63);
		main.add(PokeballSk);
		main.add(MediumballSk);
		main.add(UltraballSk);
			
		
		JButton Shop = new JButton();
		Shop.setSize(72, 73);
		Shop.setLocation(1108, 384);
		Shop.setOpaque(false);
		Shop.setContentAreaFilled(false);
		Shop.setBorderPainted(false);
		main.add(Shop);
		
		JButton buyPB = new JButton();
		buyPB.setSize(125, 64);
		buyPB.setLocation(39, 13);
		
		buyPB.setOpaque(false);
		buyPB.setContentAreaFilled(false);
		buyPB.setBorderPainted(false);
		
		buyPB.addActionListener(ev -> {
			PBsk[0]++;
			PokeballSk.setText(String.valueOf(PBsk[0]));
		});
		JButton buyMB = new JButton();
		buyMB.setSize(125, 64);
		buyMB.setLocation(207, 13);
		
		buyMB.setOpaque(false);
		buyMB.setContentAreaFilled(false);
		buyMB.setBorderPainted(false);
		
		buyMB.addActionListener(ev -> {
			MBsk[0]++;
			MediumballSk.setText(String.valueOf(MBsk[0]));
		});
		JButton buyUB = new JButton();
		buyUB.setSize(125, 64);
		buyUB.setLocation(370, 13);
		
		buyUB.setOpaque(false);
		buyUB.setContentAreaFilled(false);
		buyUB.setBorderPainted(false);
		
		buyUB.addActionListener(ev -> {
			UBsk[0]++;
			UltraballSk.setText(String.valueOf(UBsk[0]));
		});
		
		
		
		//Pokemon storage button
		JButton storage = new JButton();
		storage.setSize(72, 73);
		storage.setLocation(1108, 500);
		main.add(storage);
		
		
		JButton fight = new JButton();
		fight.setSize(72, 73);
		fight.setLocation(1008, 600);
		main.add(fight);
		
		
		main.setVisible(true);
		
		
		//action listeners
		
		Home.addActionListener(e -> {
			
			panel.removeAll();
			panel.add(Sgif);
			panel.revalidate();
			panel.repaint();
			Pokemon.removeAll();
			Pokemon.revalidate();
			Pokemon.repaint();
	
		});
		
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
		
		
		stiagat.addActionListener(e -> {
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			
			
			kust.setLocation(200, 200);
			kust.setUndecorated(false);
			kust.setSize(751, 565);
			
			kust.setResizable(false);
			kust.add(gamePanel);
			kust.pack();
			kust.setVisible(true);
		
			gamePanel.startGameThread();
			
		});
		
		
		Shop.addActionListener(e -> {
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			
			ImageIcon s = new ImageIcon("bildes/shop.png");
			JLabel shop = new JLabel(s);
			shop.setSize(751, 560);
			
			shop.add(buyPB);
			shop.add(buyMB);
			shop.add(buyUB);
			shop.revalidate();
			shop.repaint();
			
			panel.add(shop);
			
		});
		
	}
}