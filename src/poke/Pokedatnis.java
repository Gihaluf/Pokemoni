package poke;



import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
	public static ArrayList<Object> poki = new ArrayList<>();
	public static ArrayList<Object> oppo = new ArrayList<>();
	private static JFrame main = new JFrame();
	public static GamePanel  gamePanel = new GamePanel();
	public static JFrame kust = new JFrame();
	static boolean reize = true;
	private static int []PBsk= {5};
	private static int []MBsk= {2};
	private static int []UBsk= {100};
	private static JLabel PokeballSk = new JLabel();
	private static JLabel MediumballSk = new JLabel();
	private static JLabel UltraballSk = new JLabel();
	
	public static String[] name = {"Squirtle", "Wartortle", "Blastoise", "Lickitung", "Lickylicky", "Elekid", "Elecabuzz", "Electivire"};
	public static String[] hp = {"44","59","79","90","110","45","65","75"};
	public static String[] atk = {"48","63","83","55","85","63","83","123"};
	public static String[] spd = {"43","58","78","30","50","95","105","95"};
	public static String[] pokemoni = {"Squirtle1.gif", "wartortle21.gif", "Blastoise12.gif", "Lick1.gif", "lickylicky.gif", "elekid.gif", "electabuzz.gif", "electivire.gif"};
	public static String[] type = {"Sqrt.png","Sqrt.png","Sqrt.png", "Lck.png", "Lck.png", "ele.png", "ele.png", "ele.png"};
	public static String[] info = {
			"After birth, its back swells and hardens into a shell. It sprays a potent foam from its mouth."
			,"Wartortle’s long, furry tail is a symbol of longevity, so this Pokémon is quite popular among older people."
			,"It deliberately increases its body weight so it can withstand the recoil of the water jets it fires."
			,"If this Pokémon’s sticky saliva gets on you and you don’t clean it off, an intense itch will set in. The itch won’t go away, either."
			,"Lickilicky’s strange tongue can stretch to many times the length of its body. No one has figured out how Lickilicky’s tongue can stretch so far."
			,"It loves violent thunder. The space between its horns flickers bluish white when it is charging energy."
			,"Its body constantly discharges electricity. Getting close to it will make your hair stand on end."
			,"When it gets excited, it thumps its chest. With every thud, thunder roars and electric sparks shower all around."
	};
	
	static JLabel pokedex(String txt) {
		ImageIcon poke = new ImageIcon("bildes/"+txt);
		JLabel bilde= new JLabel(poke);
		return bilde;
	}
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		start();
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
		
		//DONE
		JButton Stop = new JButton();
		Stop.setSize(84, 60);
		Stop.setLocation(58, 12);
		Stop.setOpaque(false);
		Stop.setContentAreaFilled(false);
		Stop.setBorderPainted(false);
		Stop.addActionListener(e -> System.exit(0));
		main.add(Stop);
		
		//DONE
		JButton Home = new JButton();
		Home.setSize(72, 104);
		Home.setLocation(907, 530);
		Home.setOpaque(false);
		Home.setContentAreaFilled(false);
		Home.setBorderPainted(false);
		main.add(Home);
		//DONE
		JButton Pokedex = new JButton();
		Pokedex.setSize(72, 110);
		Pokedex.setLocation(1008, 383);
		Pokedex.setOpaque(false);
		Pokedex.setContentAreaFilled(false);
		Pokedex.setBorderPainted(false);
		main.add(Pokedex);
		
		
		
		
		//UNFINISHED
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
			
		//DONE
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
		
		//DONE
		JButton storage = new JButton();
		storage.setSize(76, 110);
		storage.setLocation(1118, 384);
		storage.setOpaque(false);
		storage.setContentAreaFilled(false);
		storage.setBorderPainted(false);
		main.add(storage);
		
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
			Pokemon.removeAll();
			Pokemon.revalidate();
			Pokemon.repaint();
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			
			ImageIcon inv = new ImageIcon("bildes/Inventoyy.png");
			JLabel INV = new JLabel(inv);
			INV.setSize(751, 560);
	
			if(poki.size()>0) {
				String b = "";
				int reize=0;
				int col=0;
				for(int i=1; i<poki.size()+1; i++) {
					String nosaukums = ((Pokemons)poki.get(i-1)).getVards();
					switch(nosaukums) {
					case "Squirtle":
						b="s.png";
						break;
					case "Elekid":
						b="e.png";
						break;
					}
					JLabel pirm = pokedex(b);
					//88 84
					pirm.setSize(61,60);
					
					pirm.setLocation(227+(col*88),162+(reize*84));
					col++;
					if(col==4) col=0;
					if(i%4==0) reize++;
					
					INV.add(pirm);
				}
			}
			panel.add(INV); 
			panel.revalidate();
			panel.repaint();
		});
		
		
		Pokedex.addActionListener(e -> {
			Pokemon.removeAll();
			Pokemon.revalidate();
			Pokemon.repaint();
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
			NAME.setSize(200, 50);
			NAME.setFont(new Font("Monospaced", Font.BOLD, 20));
			NAME.setLocation(115,378);
			
			JTextArea HP = new JTextArea(hp[skaits[0]]);
			HP.setLineWrap(true);
			HP.setWrapStyleWord(true);
			HP.setOpaque(false);
			HP.setSize(200, 50);
			HP.setFont(new Font("Monospaced", Font.BOLD, 20));
			HP.setLocation(70,399);
			
			JTextArea ATK = new JTextArea(atk[skaits[0]]);
			ATK.setLineWrap(true);
			ATK.setWrapStyleWord(true);
			ATK.setOpaque(false);
			ATK.setSize(200, 50);
			ATK.setFont(new Font("Monospaced", Font.BOLD, 20));
			ATK.setLocation(90,420);
			
			JTextArea SPD = new JTextArea(spd[skaits[0]]);
			SPD.setLineWrap(true);
			SPD.setWrapStyleWord(true);
			SPD.setOpaque(false);
			SPD.setSize(200, 50);
			SPD.setFont(new Font("Monospaced", Font.BOLD, 20));
			SPD.setLocation(90,445);
			
			
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
				N.setLineWrap(true);
				N.setWrapStyleWord(true);
				N.setOpaque(false);
				N.setSize(200, 50);
				N.setFont(new Font("Monospaced", Font.BOLD, 20));
				N.setLocation(115,378);
				
				JTextArea H = new JTextArea(hp[skaits[0]]);
				H.setLineWrap(true);
				H.setWrapStyleWord(true);
				H.setOpaque(false);
				H.setSize(200, 50);
				H.setFont(new Font("Monospaced", Font.BOLD, 20));
				H.setLocation(70,399);
				
				JTextArea A = new JTextArea(atk[skaits[0]]);
				A.setLineWrap(true);
				A.setWrapStyleWord(true);
				A.setOpaque(false);
				A.setSize(200, 50);
				A.setFont(new Font("Monospaced", Font.BOLD, 20));
				A.setLocation(90,420);
				
				JTextArea S = new JTextArea(spd[skaits[0]]);
				S.setLineWrap(true);
				S.setWrapStyleWord(true);
				S.setOpaque(false);
				S.setSize(200, 50);
				S.setFont(new Font("Monospaced", Font.BOLD, 20));
				S.setLocation(90,445);
				
				INF.add(N);
				INF.add(H);
				INF.add(A);
				INF.add(S);
				INF.add(apraksts);
				INF.add(bildite);
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
				JTextArea N = new JTextArea(name[skaits[0]]);
				N.setLineWrap(true);
				N.setWrapStyleWord(true);
				N.setOpaque(false);
				N.setSize(200, 50);
				N.setFont(new Font("Monospaced", Font.BOLD, 20));
				N.setLocation(115,378);
				
				JTextArea H = new JTextArea(hp[skaits[0]]);
				H.setLineWrap(true);
				H.setWrapStyleWord(true);
				H.setOpaque(false);
				H.setSize(200, 50);
				H.setFont(new Font("Monospaced", Font.BOLD, 20));
				H.setLocation(70,399);
				
				JTextArea A = new JTextArea(atk[skaits[0]]);
				A.setLineWrap(true);
				A.setWrapStyleWord(true);
				A.setOpaque(false);
				A.setSize(200, 50);
				A.setFont(new Font("Monospaced", Font.BOLD, 20));
				A.setLocation(90,420);
				
				JTextArea S = new JTextArea(spd[skaits[0]]);
				S.setLineWrap(true);
				S.setWrapStyleWord(true);
				S.setOpaque(false);
				S.setSize(200, 50);
				S.setFont(new Font("Monospaced", Font.BOLD, 20));
				S.setLocation(90,445);
				
				INF.add(N);
				INF.add(H);
				INF.add(A);
				INF.add(S);
				INF.add(apraksts);
				INF.add(bildite);
				Pokemon.add(tips);
			});
		});
		
		
		stiagat.addActionListener(e -> {
			Pokemon.removeAll();
			Pokemon.revalidate();
			Pokemon.repaint();
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			
			
			if(reize) {
				oppo.add(new UdensP(
						"Water",
						"Squirtle",
						44,
						48,
						43));
				oppo.add(new ElektriskaisP(
						"Electric",
						"Elekid",
						45,
						63,
						95));
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
			Pokemon.removeAll();
			Pokemon.revalidate();
			Pokemon.repaint();
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
	private static boolean playing = false;
	static Clip clip;
	 public static void start() throws MalformedURLException, 
	            UnsupportedAudioFileException, IOException, 
	            LineUnavailableException {
	        if (!playing) {
	            File f = new File(".//sound//main.wav");
	            AudioInputStream ais = AudioSystem.getAudioInputStream(f.toURI().toURL());
	            clip = AudioSystem.getClip();
	            clip.open(ais);
	            clip.start();
	            playing = true;
	        } else {
	            if (clip != null && clip.isRunning()) {
	            	File f = new File(".//sound//fight.wav");
	                clip.stop();
	                AudioInputStream ais = AudioSystem.getAudioInputStream(f.toURI().toURL());
		            clip = AudioSystem.getClip();
		            clip.open(ais);
		            clip.start();
	                
	            }
	            playing = false;
	        }
	    }
	private static int iespeja=-1;
	private static boolean fighting = false;
	public static void triggerRandomPanel(String nodots, String bumb){
		
		JPanel logs = new JPanel();
		
		logs.setLayout(null); 
        logs.setSize(751, 565);
        logs.setLocation(32, 109);
        logs.setOpaque(false);
	    main.add(logs);
	    
		if (Pokedatnis.kust != null) {
            Pokedatnis.kust.setVisible(false);
            Pokedatnis.kust.dispose();
        }
		JButton back = new JButton();
		back.setSize(109,38);
		back.setLocation(529, 487);
		/*back.setOpaque(false);
	    back.setContentAreaFilled(false);
	    back.setBorderPainted(false);*/
		
		if(poki.size()>0)
		if(fighting) {
			
			JLabel tavs = pokedex("Squirtle.png");
			tavs.setSize(200, 200);
			tavs.setLocation(10,200);
			
			JLabel pret = pokedex(nodots);
			if(nodots == "Int.png") {
				pret.setSize(200, 400);
				pret.setLocation(585,212);
		    }else {
		    	pret.setSize(200, 200);
			    pret.setLocation(540,200);
		    }
			
			JLabel scene = new JLabel(new ImageIcon("bildes/ekra.png"));
			scene.setSize(751, 560);
			scene.add(pret);
			scene.add(tavs);
			
			logs.add(scene);
			JLabel fopc = new JLabel(new ImageIcon("bildes/fight.png"));
			fopc.setSize(751, 560);
			 JButton atak = new JButton();
				 atak.setSize(140,38);
				 atak.setLocation(305, 210);
				 /*atak.setOpaque(false);
				 atak.setContentAreaFilled(false);
				 atak.setBorderPainted(false);*/
		 	JButton defe = new JButton();
		 	defe.setSize(140,38);
		 	defe.setLocation(305, 260);
		 	defe.setOpaque(false);
			defe.setContentAreaFilled(false);
			atak.setBorderPainted(false);
			
			fopc.add(atak);
			fopc.add(defe);
			scene.add(fopc)	;
			
			atak.addActionListener(e -> {
				scene.remove(fopc);
				scene.revalidate();
				scene.repaint();
				
			});	
			//triggerRandomPanel(nodots,"");
		}
		if(iespeja==0) {
			switch(bumb) {
			case "pp":
				JLabel pp = new JLabel(new ImageIcon("bildes/pp.png"));
				pp.setSize(751, 565);
				logs.add(back);
				logs.add(pp);
				break;
			case "mm":
				JLabel mm = new JLabel(new ImageIcon("bildes/mm.png"));
				mm.setSize(751, 565);
				logs.add(back);
				logs.add(mm);
				break;
			case "uu":
				JLabel uu = new JLabel(new ImageIcon("bildes/uu.png"));
				uu.setSize(751, 565);
				logs.add(back);
				logs.add(uu);
				break;
			}
			switch(nodots) {
			case "Squirtle112.png": 
				poki.add(new UdensP(
						"Water",
						"Squirtle",
						44,
						48,
						43));
				break;
			case "Elekid1.png":
				poki.add(new ElektriskaisP(
						"Electric",
						"Elekid",
						45,
						63,
						95));
				break;
			}
			iespeja=-1;
        }else {
			Random rand = new Random();
			String []izvele = {"Squirtle112.png", "Elekid1.png","Int.png"};
			String png;
			
			if(iespeja == -1) {
				png = izvele[rand.nextInt(izvele.length)];
			}else {
				png = nodots;
			}
		    
			JLabel backg = new JLabel(new ImageIcon("bildes/opcijas.png"));
			backg.setSize(751, 565);
			logs.add(backg);
			
		    //DONE
		    JButton kert = new JButton();
		    kert.setSize(109,38);
		    kert.setLocation(530,442);
		    kert.setOpaque(false);
		    kert.setContentAreaFilled(false);
		    kert.setBorderPainted(false);
		    
		    //DONE
		    JButton begt = new JButton();
		    begt.setSize(109,38);
		    begt.setLocation(529, 487);
		    begt.setOpaque(false);
		    begt.setContentAreaFilled(false);
		    begt.setBorderPainted(false);
		    
		    //NOT DONE 
		    JButton fight = new JButton();
		    fight.setSize(109,38);
		    fight.setLocation(409,442);
		    fight.setOpaque(false);
		    fight.setContentAreaFilled(false);
		    fight.setBorderPainted(false);
		   
		    
		    JButton secret = new JButton();
		    secret.setSize(109,38);
		    secret.setLocation(409, 487);
		    
		    
		    JLabel bilde = pokedex(png);
		    if(png == "Int.png") {
			    bilde.setSize(200, 400);
			    bilde.setLocation(250,0);
		    }else {
			    bilde.setSize(200, 200);
			    bilde.setLocation(270,170);
		    }
		    
		    logs.setVisible(true); 
		    main.revalidate();
	        main.repaint();
		    
		    logs.add(secret);
	        logs.add(begt);
		    logs.add(kert);
		    logs.add(fight);
		    logs.add(bilde);
		    logs.add(backg);
		    kert.addActionListener(e -> {
		    	logs.removeAll();
		    	logs.revalidate();
				logs.repaint();
				
			    JLabel POpc = new JLabel(new ImageIcon("bildes/Useitem.png"));
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
				    	triggerRandomPanel(png, "pp");
					}
				});
			
				m.addActionListener(ev -> {
					if(MBsk[0]>0) {
						MBsk[0]-=1;
						MediumballSk.setText(String.valueOf(MBsk[0]));
						main.revalidate();
						main.repaint();
						iespeja=rand.nextInt(3);
						main.revalidate();
						main.repaint();
						iespeja=rand.nextInt(4);
						logs.removeAll();
				    	main.remove(logs);
				    	triggerRandomPanel(png, "mm");
					}
				});
				u.addActionListener(ev -> {
					if(UBsk[0]>0) {
						UBsk[0]-=1;
						UltraballSk.setText(String.valueOf(UBsk[0]));
						main.revalidate();
						main.repaint();
						iespeja=rand.nextInt(2);
						main.revalidate();
						main.repaint();
						iespeja=rand.nextInt(4);
						logs.removeAll();
				    	main.remove(logs);
				    	triggerRandomPanel(png, "uu");
					}
				});
				
				
		    });
		    begt.addActionListener(e -> {
	           
	            main.remove(logs);
	            main.revalidate();
	            main.repaint();
	            Pokedatnis.kust.setVisible(true);
	        });
		    
		    fight.addActionListener(e ->{
		    	logs.removeAll();
		    	logs.revalidate();
				logs.repaint();
				fighting = true;
				try {
					start();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
				triggerRandomPanel(png,"");
		    });
		    back.addActionListener(e -> {
				logs.removeAll();
		    	logs.revalidate();
				logs.repaint();
				triggerRandomPanel(png,null);
			});
		}
		
		
	}
	
}