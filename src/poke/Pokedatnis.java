package poke;



import java.awt.Font;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import main.GamePanel;
/*	NAV PIEVINOTS CATCH OPCIJA, VAJAG SALABOT POKEDEX, FIGHT, STORAGE(ARRAYLIST UN ATTELI)*/
public class Pokedatnis {
	private static JFrame main = new JFrame();
	public static GamePanel  gamePanel = new GamePanel();
	public static JFrame kust = new JFrame();
	static boolean reize = true;
	private static int []PBsk= {5};
	private static int []MBsk= {2};
	private static int []UBsk= {1};
	private static JLabel PokeballSk = new JLabel();
	private static JLabel MediumballSk = new JLabel();
	private static JLabel UltraballSk = new JLabel();
	static JLabel pokedex(String txt) {
		ImageIcon poke = new ImageIcon("bildes/"+txt);
		JLabel bilde= new JLabel(poke);
		return bilde;
	}
	
	public static void main(String[] args) {
		
		main.setLocation(150, 50);
		main.setSize(1244, 700);
		main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		ImageIcon icon = new ImageIcon("bildes/PokeFram.png");
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
		Home.setSize(72, 104);
		Home.setLocation(907, 530);
		Home.setOpaque(false);
		Home.setContentAreaFilled(false);
		Home.setBorderPainted(false);
		main.add(Home);
		
		JButton Pokedex = new JButton();
		Pokedex.setSize(72, 110);
		Pokedex.setLocation(1008, 383);
		Pokedex.setOpaque(false);
		Pokedex.setContentAreaFilled(false);
		Pokedex.setBorderPainted(false);
		main.add(Pokedex);
		String[] name = {"Squirtle", "Wartortle", "Blastoise", "Lickitung", "Lickylicky", "Elekid", "Elecabuzz", "Electivire"};
		String[] hp = {"44","59","79","90","110","45","65","75"};
		String[] atk = {"48","63","83","55","85","63","83","123"};
		String[] spd = {"43","58","78","","30","50","95","105","95"};
		String[] pokemoni = {"Squirtle1.gif", "wartortle21.gif", "Blastoise12.gif", "Lick1.gif", "lickylicky.gif", "elekid.gif", "electabuzz.gif", "electivire.gif"};
		String[] type = {"Sqrt.png","Sqrt.png","Sqrt.png", "Lck.png", "Lck.png", "ele.png", "ele.png", "ele.png"};
		String[] info = {
				"After birth, its back swells and hardens into a shell. It sprays a potent foam from its mouth."
				,"Wartortle’s long, furry tail is a symbol of longevity, so this Pokémon is quite popular among older people."
				,"It deliberately increases its body weight so it can withstand the recoil of the water jets it fires."
				,"If this Pokémon’s sticky saliva gets on you and you don’t clean it off, an intense itch will set in. The itch won’t go away, either."
				,"Lickilicky’s strange tongue can stretch to many times the length of its body. No one has figured out how Lickilicky’s tongue can stretch so far."
				,"It loves violent thunder. The space between its horns flickers bluish white when it is charging energy."
				,"Its body constantly discharges electricity. Getting close to it will make your hair stand on end."
				,"When it gets excited, it thumps its chest. With every thud, thunder roars and electric sparks shower all around."
		};
		
		
		
		JButton stiagat = new JButton();
		stiagat.setSize(72, 110);
		stiagat.setLocation(1008, 530);
		stiagat.setOpaque(false);
		stiagat.setContentAreaFilled(false);
		stiagat.setBorderPainted(false);
		main.add(stiagat);
		
		
		PokeballSk.setText(String.valueOf(PBsk[0]));
		PokeballSk.setSize(40, 20);
		PokeballSk.setLocation(337, 63);
	
		MediumballSk.setText(String.valueOf(MBsk[0]));
		MediumballSk.setSize(40, 20);
		MediumballSk.setLocation(503, 63);
	
		UltraballSk.setText(String.valueOf(UBsk[0]));
		UltraballSk.setSize(40, 20);
		UltraballSk.setLocation(667, 63);
		
		main.add(PokeballSk);
		main.add(MediumballSk);
		main.add(UltraballSk);
			
		
		JButton Shop = new JButton();
		Shop.setSize(72, 110);
		Shop.setLocation(907, 384);
		Shop.setOpaque(false);
		Shop.setContentAreaFilled(false);
		Shop.setBorderPainted(false);
		main.add(Shop);
		
		JButton buyPB = new JButton();
		buyPB.setSize(170, 160);
		buyPB.setLocation(124,235);
		
		buyPB.setOpaque(false);
		buyPB.setContentAreaFilled(false);
		buyPB.setBorderPainted(false);
		
		buyPB.addActionListener(ev -> {
			PBsk[0]++;
			PokeballSk.setText(String.valueOf(PBsk[0]));
		});
		JButton buyMB = new JButton();
		buyMB.setSize(170, 160);
		buyMB.setLocation(310,235);
		
		buyMB.setOpaque(false);
		buyMB.setContentAreaFilled(false);
		buyMB.setBorderPainted(false);
		
		buyMB.addActionListener(ev -> {
			MBsk[0]++;
			MediumballSk.setText(String.valueOf(MBsk[0]));
		});
		JButton buyUB = new JButton();
		buyUB.setSize(170, 160);
		buyUB.setLocation(490, 235);
		
		buyUB.setOpaque(false);
		buyUB.setContentAreaFilled(false);
		buyUB.setBorderPainted(false);
		
		buyUB.addActionListener(ev -> {
			UBsk[0]++;
			UltraballSk.setText(String.valueOf(UBsk[0]));
		});
		
		
		
		
		JButton storage = new JButton();
		storage.setSize(76, 110);
		storage.setLocation(1118, 384);
		storage.setOpaque(false);
		storage.setContentAreaFilled(false);
		storage.setBorderPainted(false);
		main.add(storage);
		
		
		/*JButton fight = new JButton();
		fight.setSize(72, 73);
		fight.setLocation(1008, 600);
		main.add(fight);*/
		
		
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
		
		storage.addActionListener(e ->{
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			
			ImageIcon inv = new ImageIcon("bildes/Inventoyy.png");
			JLabel INV = new JLabel(inv);
			INV.setSize(751, 560);
			panel.add(INV);
			
		});
		
		
		Pokedex.addActionListener(e -> {
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			
			ImageIcon inf = new ImageIcon("bildes/Inf.png");
			JLabel INF = new JLabel(inf);
			INF.setSize(751, 560);
			panel.add(INF);
			
			
			JButton nak = new JButton();
			nak.setSize(50, 30);
			nak.setLocation(1030, 257);
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
			pirmaisa.setFont(new Font("Monospaced", Font.BOLD, 16));
			pirmaisa.setLocation(30,470);
			
			
			JLabel bildit = pokedex(pokemoni[skaits[0]]);
			bildit.setLocation(267,113);
			bildit.setSize(240, 216);
			
			
			JTextArea NAME = new JTextArea(name[skaits[0]]);
			NAME.setLineWrap(true);
			NAME.setWrapStyleWord(true);
			NAME.setOpaque(false);
			NAME.setSize(20, 20);
			NAME.setFont(new Font("Monospaced", Font.BOLD, 20));
			NAME.setLocation(30,470);
			
			JTextArea HP = new JTextArea(hp[skaits[0]]);
			HP.setLineWrap(true);
			HP.setWrapStyleWord(true);
			HP.setOpaque(false);
			HP.setSize(700, 200);
			HP.setFont(new Font("Monospaced", Font.BOLD, 20));
			HP.setLocation(100,100);
			
			JTextArea ATK = new JTextArea(atk[skaits[0]]);
			ATK.setLineWrap(true);
			ATK.setWrapStyleWord(true);
			ATK.setOpaque(false);
			ATK.setSize(700, 200);
			ATK.setFont(new Font("Monospaced", Font.BOLD, 20));
			ATK.setLocation(100,410);
			
			JTextArea SPD = new JTextArea(spd[skaits[0]]);
			pirmaisa.setLineWrap(true);
			pirmaisa.setWrapStyleWord(true);
			pirmaisa.setOpaque(false);
			pirmaisa.setSize(700, 200);
			pirmaisa.setFont(new Font("Monospaced", Font.BOLD, 20));
			pirmaisa.setLocation(30,470);
			
			
			INF.add(pirmaisa);
			INF.add(bildit);
			INF.add(bildit);
			INF.add(NAME);
			INF.add(HP);
			INF.add(ATK);
			INF.add(SPD);
			
			panel.revalidate();
			panel.repaint();
			
			nak.addActionListener(ev -> {
				Pokemon.removeAll();
				Pokemon.revalidate();
				Pokemon.repaint();
				INF.removeAll();
				INF.revalidate();
				INF.repaint();
				
				skaits[0]++;
				if (skaits[0]>pokemoni.length-1) {
					skaits[0]=0;
				}
				JTextArea apraksts = new JTextArea(info[skaits[0]]);
				apraksts.setLineWrap(true);
				apraksts.setWrapStyleWord(true);
				apraksts.setOpaque(false);
				apraksts.setSize(700, 200);
				apraksts.setFont(new Font("Monospaced", Font.BOLD, 16));
				apraksts.setLocation(30,470);
				
				//250x220
				JLabel bildite = pokedex(pokemoni[skaits[0]]);
				bildite.setLocation(267,113);
				bildite.setSize(240, 216);
				
				JLabel tips = pokedex(type[skaits[0]]);
				tips.setSize(260, 167);
				Pokemon.add(tips);
				JTextArea N = new JTextArea(name[skaits[0]]);
				pirmaisa.setLineWrap(true);
				pirmaisa.setWrapStyleWord(true);
				pirmaisa.setOpaque(false);
				pirmaisa.setSize(20, 20);
				pirmaisa.setFont(new Font("Monospaced", Font.BOLD, 20));
				pirmaisa.setLocation(30,470);
				
				JTextArea H = new JTextArea(hp[skaits[0]]);
				pirmaisa.setLineWrap(true);
				pirmaisa.setWrapStyleWord(true);
				pirmaisa.setOpaque(false);
				pirmaisa.setSize(700, 200);
				pirmaisa.setFont(new Font("Monospaced", Font.BOLD, 20));
				pirmaisa.setLocation(100,100);
				
				JTextArea A = new JTextArea(atk[skaits[0]]);
				pirmaisa.setLineWrap(true);
				pirmaisa.setWrapStyleWord(true);
				pirmaisa.setOpaque(false);
				pirmaisa.setSize(700, 200);
				pirmaisa.setFont(new Font("Monospaced", Font.BOLD, 20));
				pirmaisa.setLocation(100,410);
				
				JTextArea S = new JTextArea(spd[skaits[0]]);
				pirmaisa.setLineWrap(true);
				pirmaisa.setWrapStyleWord(true);
				pirmaisa.setOpaque(false);
				pirmaisa.setSize(700, 200);
				pirmaisa.setFont(new Font("Monospaced", Font.BOLD, 20));
				pirmaisa.setLocation(30,470);
				
				
				INF.add(apraksts);
				INF.add(bildite);
				INF.add(N);
				INF.add(H);
				INF.add(A);
				INF.add(S);
				Pokemon.add(tips);
				
			});
			JButton iepr = new JButton();
			iepr.setSize(50, 30);
			iepr.setLocation(980, 257);
			iepr.setOpaque(false);
			iepr.setContentAreaFilled(false);
			iepr.setBorderPainted(false);
			main.add(iepr);
			
			iepr.addActionListener(ev -> {
				skaits[0]--;
				if (skaits[0]<0) {
					skaits[0]=pokemoni.length-1;
				}
				Pokemon.removeAll();
				Pokemon.revalidate();
				Pokemon.repaint();
				INF.removeAll();
				INF.revalidate();
				INF.repaint();
				
				JTextArea apraksts = new JTextArea(info[skaits[0]]);
				apraksts.setLineWrap(true);
				apraksts.setWrapStyleWord(true);
				apraksts.setOpaque(false);
				apraksts.setSize(700, 200);
				apraksts.setFont(new Font("Monospaced", Font.BOLD, 16));
				apraksts.setLocation(30,470);
				
				
				JLabel bildite = pokedex(pokemoni[skaits[0]]);
				bildite.setLocation(267,113);
				bildite.setSize(240, 216);
				
				JLabel tips = pokedex(type[skaits[0]]);
				tips.setSize(260, 167);
				Pokemon.add(tips);
				
				INF.add(apraksts);
				INF.add(bildite);
				Pokemon.add(tips);
			});
		});
		
		
		stiagat.addActionListener(e -> {
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			
			
			if(reize) {
			kust.setUndecorated(true);
			kust.setLocation(182, 159);
			kust.setSize(751, 565);
			
			kust.setResizable(false);
			kust.add(gamePanel);
			kust.pack();
			kust.setVisible(true);
		
			gamePanel.startGameThread();
			reize = false;
			}
			kust.setVisible(true);
		});
		
		
		Shop.addActionListener(e -> {
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			
			ImageIcon s = new ImageIcon("bildes/pokedihss.png");
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
	
	private static int iespeja=-1;
	public static void triggerRandomPanel(String nodots){
		
		
		if (Pokedatnis.kust != null) {
            Pokedatnis.kust.setVisible(false);
            Pokedatnis.kust.dispose();
        }
		if(iespeja>=0) {
			switch(nodots) {
			
			}
        }
		Random rand = new Random();
		String []izvele = {"Squirtle112.png", "lick1.png", "Elekid1.png",};
		String png;
		
		if(iespeja == -1) {
			png = izvele[rand.nextInt(izvele.length)];
		}else {
			png = nodots;
		}
	    JPanel logs = new JPanel();
	    logs.setLayout(null); 
        logs.setSize(751, 565);
        logs.setLocation(32, 109);
        logs.setOpaque(false);
	    main.add(logs);
	    
	    JButton kert = new JButton();
	    kert.setSize(50,50);
	    kert.setLocation(100,150);
	    logs.add(kert);
	    
	    
	    JButton begt = new JButton();
	    begt.setSize(50,50);
	    begt.setLocation(150,100);
	    logs.add(begt);
	    
	    JButton fight = new JButton();
	    fight.setSize(50,50);
	    fight.setLocation(150,150);
	    logs.add(fight);
	    
	    JLabel bilde = pokedex(png);
	    bilde.setSize(200, 200);
	    bilde.setLocation(40, 50);
	    logs.add(bilde);
	    
	    logs.setVisible(true); 
	    main.revalidate();
        main.repaint();
	    
	    /*JButton inv = new JButton();
	    logs.add(inv);*/
	     
        
	    kert.addActionListener(e -> {
	    	logs.removeAll();
	    	logs.revalidate();
			logs.repaint();
			
		    JLabel POpc = new JLabel(new ImageIcon("bildes/pokedihss.png"));
		    POpc.setSize(751, 560);
		    
		    JButton p = new JButton();
		    p.setSize(170, 160);
			p.setLocation(124,235);
		    p.setOpaque(false);
			p.setContentAreaFilled(false);
			p.setBorderPainted(false);
			
		    JButton m = new JButton();
		    m.setSize(170, 160);
			m.setLocation(310,235);
			m.setOpaque(false);
			m.setContentAreaFilled(false);
			m.setBorderPainted(false);
			

		    JButton u = new JButton();
		    u.setSize(170, 160);
			u.setLocation(490, 235);
			u.setOpaque(false);
			u.setContentAreaFilled(false);
			u.setBorderPainted(false);
			
		    
			POpc.add(p);
			POpc.add(m);
			POpc.add(u);
		    
			logs.add(POpc);
		    logs.revalidate();
			logs.repaint();
			
			p.addActionListener(ev -> {
				if(PBsk[0]>0) {
					PBsk[0]-=1;
					PokeballSk.setText(String.valueOf(PBsk[0]));
					main.revalidate();
					main.repaint();
					iespeja=rand.nextInt(4);
					logs.removeAll();
			    	main.remove(logs);
			    	triggerRandomPanel(png);
				}
			});
		
			m.addActionListener(ev -> {
				if(MBsk[0]>0) {
					MBsk[0]-=1;
					MediumballSk.setText(String.valueOf(MBsk[0]));
					main.revalidate();
					main.repaint();
					iespeja=rand.nextInt(3);
					logs.removeAll();
			    	logs.revalidate();
					logs.repaint();
					kert.setSize(50,50);
				    kert.setLocation(100,150);
					logs.add(kert);
					logs.add(begt);
					logs.add(fight);
				}
			});
			u.addActionListener(ev -> {
				if(UBsk[0]>0) {
					UBsk[0]-=1;
					UltraballSk.setText(String.valueOf(UBsk[0]));
					main.revalidate();
					main.repaint();
					iespeja=rand.nextInt(2);
					logs.removeAll();
			    	logs.revalidate();
					logs.repaint();
					kert.setSize(50,50);
				    kert.setLocation(100,150);
					logs.add(kert);
					logs.add(begt);
					logs.add(fight);
				}
			});
			
			
	    });
	    begt.addActionListener(e -> {
           
            main.remove(logs);
            main.revalidate();
            main.repaint();
            Pokedatnis.kust.setVisible(true);
        });
	}
	    
}