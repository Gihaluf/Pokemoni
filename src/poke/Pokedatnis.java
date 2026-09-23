package poke;



import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.GamePanel;
import ui.UIStateManager;
/*	NAV PIEVINOTS CATCH OPCIJA, VAJAG SALABOT POKEDEX, FIGHT, STORAGE(ARRAYLIST UN ATTELI)*/
public class Pokedatnis {
	public static ArrayList<Object> poki = new ArrayList<>();
	public static ArrayList<Object> oppo = new ArrayList<>();
	private static JFrame main = new JFrame();
	public static GamePanel  gamePanel = new GamePanel();
	public static JFrame kust = new JFrame();
	private static JPanel mainPanel;
	private static JPanel pokemonPanel;
	static boolean reize = true;
	private static BattleSystem activeBattle;
	private static Pokemons activeBattleEnemy;
	private static String activeBattleEnemyImage;
	private static int []PBsk= {0};
	private static int []MBsk= {0};
	private static int []UBsk= {0};
	private static int[] skaits = {0};
	private static JLabel PokeballSk = new JLabel();
	private static JLabel MediumballSk = new JLabel();
	private static JLabel UltraballSk = new JLabel();
	private static JLabel statusMessage = new JLabel();
	private static Set<String> seenPokemon = new HashSet<>();
	private static Set<String> caughtPokemon = new HashSet<>();
	
	public static String[] name = {"Squirtle", "Wartortle", "Blastoise", "Lickitung", "Lickylicky", "Elekid", "Electabuzz", "Electivire"};
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
		mainPanel = panel;
		
		
		ImageIcon gif = new ImageIcon("bildes/Startup.gif");
		JLabel Sgif = new JLabel(gif);
		Sgif.setSize(751, 560);
		panel.add(Sgif);
		
		
		JPanel Pokemon = new JPanel();
		Pokemon.setSize(260, 165);
		Pokemon.setLocation(915, 90);
		Pokemon.setOpaque(false);
		main.add(Pokemon);
		pokemonPanel = Pokemon;
		
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
		
		statusMessage.setSize(450, 20);
		statusMessage.setLocation(34, 84);
		main.add(statusMessage);
			
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
			saveProgress();
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
			saveProgress();
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
			saveProgress();
		});
		
		//DONE
		JButton storage = new JButton();
		storage.setSize(76, 110);
		storage.setLocation(1118, 384);
		storage.setOpaque(false);
		storage.setContentAreaFilled(false);
		storage.setBorderPainted(false);
		main.add(storage);
		
		loadProgress();
		main.setVisible(true);
		//action listeners
		
		Home.addActionListener(e -> {
			
			UIStateManager.setPanelContent(panel, Sgif);
			UIStateManager.clearAndRefresh(Pokemon);
			
		});
		
		storage.addActionListener(e ->{
			UIStateManager.clearAndRefresh(Pokemon);
			UIStateManager.clearAndRefresh(panel);
			
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
					case "Wartortle":
						b="s.png";
						break;
					case "Elekid":
						b="a.png";
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
			UIStateManager.setPanelContent(panel, INV);
		});
		
		
		Pokedex.addActionListener(e -> openPokedexWindow());
		
		
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
				oppo.add(new ElektriskaisP(
						"Intars",
						"Intars",
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
			UIStateManager.clearAndRefresh(Pokemon);
			UIStateManager.clearAndRefresh(panel);
			
			ImageIcon s = new ImageIcon("bildes/shop.png");
			JLabel shop = new JLabel(s);
			shop.setSize(751, 560);
			
			shop.add(buyPB);
			shop.add(buyMB);
			shop.add(buyUB);
			shop.revalidate();
			shop.repaint();
			
			UIStateManager.setPanelContent(panel, shop);
			
		});
		
	}
	private static boolean isMainTrack = true;
	
	static Clip clip;
	public static void start() throws MalformedURLException, 
	            UnsupportedAudioFileException, IOException, 
	            LineUnavailableException {
		 
			 if (clip != null && clip.isRunning()) {
		            clip.stop();
		            clip.close(); // Close the clip resources
		          
		        }
			 String fileName = ".//sound//main.wav";
			 if(poki.size()>0) {
		        if (isMainTrack) {
		             fileName = ".//sound//fight.wav";
		            isMainTrack = false;
		        
		        } else {
		            fileName = ".//sound//main.wav";
		            isMainTrack = true;
		        }
			 }
	
		        File f = new File(fileName);
		        
		        try (AudioInputStream ais = AudioSystem.getAudioInputStream(f)) {
		            
		            clip = AudioSystem.getClip();
		            clip.open(ais);
		            clip.start();
		            
		            clip.loop(Clip.LOOP_CONTINUOUSLY); 

		        } 
	    }
	static Clip c;
	public static void secr() throws MalformedURLException, 
	            UnsupportedAudioFileException, IOException, 
	            LineUnavailableException {
				File f = new File(".//sound//secret.wav");
		        clip.stop();
		        AudioInputStream ais = AudioSystem.getAudioInputStream(f);
	            c = AudioSystem.getClip();
	            c.open(ais);
	            c.start();
	            
		     
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
		Random rand = new Random();
		String []izvele = {"Squirtle112.png", "WartortleEncounter.png", "Elekid1.png","Int.png"};
		String png;
		if(iespeja == -1) {
			png = izvele[rand.nextInt(izvele.length)];
		}else {
			png = nodots;
		}
		markSeenByEncounterImage(png);
		back.addActionListener(e -> {
			logs.removeAll();
			logs.revalidate();
			logs.repaint();
			triggerRandomPanel(png, "");
		});
		if(poki.size()>0 && fighting) {
			showBattleScreen(logs, png);
			return;
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
			case "WartortleEncounter.png":
				poki.add(new UdensP(
						"Water",
						"Wartortle",
						59,
						63,
						58));
				break;
			case "Elekid1.png":
				poki.add(new ElektriskaisP(
						"Electric",
						"Elekid",
						45,
						63,
						95));
				break;
			case "Int.png":
				poki.add(new ElektriskaisP(
						"Electric",
						"Intars",
						45,
						63,
						95));
				break;
			}
			if(!poki.isEmpty()) {
				Pokemons latest = (Pokemons) poki.get(poki.size() - 1);
				seenPokemon.add(latest.getVards());
				caughtPokemon.add(latest.getVards());
				showStatusMessage("Caught: " + latest.getVards());
			}
			saveProgress();
			iespeja=-1;
        }else {
		    
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
		    secret.setOpaque(false);
		    secret.setContentAreaFilled(false);
		    secret.setBorderPainted(false);
		    
		    secret.addActionListener(e ->{
		    	try {
					secr();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    });
		    JLabel bilde = pokedex(png);
		    if("Int.png".equals(png)) {
			    bilde.setSize(200, 400);
			    bilde.setLocation(250,0);
		    }else {
			    bilde.setSize(200, 200);
			    bilde.setLocation(270,170);
		    }
		    
		    logs.setVisible(true); 
		    main.revalidate();
	        main.repaint();
		    
		    //logs.add(secret);
	        logs.add(begt);
		    logs.add(kert);
		    logs.add(fight);
		    logs.add(bilde);
		    logs.add(backg);
		    logs.add(secret);
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
						saveProgress();
						iespeja=rand.nextInt(3);
						logs.removeAll();
				    	main.remove(logs);
				    	main.revalidate();
						main.repaint();
				    	triggerRandomPanel(png, "pp");
					}
				});
			
				m.addActionListener(ev -> {
					if(MBsk[0]>0) {
						MBsk[0]-=1;
						MediumballSk.setText(String.valueOf(MBsk[0]));
						saveProgress();
						iespeja=rand.nextInt(2);
						logs.removeAll();
				    	main.remove(logs);
				    	main.revalidate();
						main.repaint();
				    	triggerRandomPanel(png, "mm");
					}
				});
				u.addActionListener(ev -> {
					if(UBsk[0]>0) {
						UBsk[0]-=1;
						UltraballSk.setText(String.valueOf(UBsk[0]));
						saveProgress();
						iespeja=rand.nextInt(1);
						logs.removeAll();
				    	main.remove(logs);
				    	main.revalidate();
						main.repaint();
				    	triggerRandomPanel(png, "uu");
					}
				});
				
				
		    });
		    begt.addActionListener(e -> {
	           
	            main.remove(logs);
	            main.revalidate();
	            main.repaint();
	            fighting = false;
	            activeBattle = null;
	            activeBattleEnemy = null;
	            activeBattleEnemyImage = null;
	            Pokedatnis.kust.setVisible(true);
	        });
		    
		    fight.addActionListener(e ->{
		    	logs.removeAll();
		    	logs.revalidate();
				logs.repaint();
				fighting = true;
				activeBattle = null;
				activeBattleEnemy = null;
				activeBattleEnemyImage = null;
				try {
					start();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
				triggerRandomPanel(png,"");
		    });
		}
		
		
	}

	private static void openPokedexWindow() {
		JFrame frame = new JFrame("Pokedex");
		frame.setSize(700, 450);
		frame.setLocation(220, 120);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JTextField search = new JTextField();
		search.setBounds(20, 20, 240, 28);
		frame.add(search);

		JComboBox<String> filter = new JComboBox<>(new String[] {"All", "Seen", "Caught", "Unseen"});
		filter.setBounds(280, 20, 130, 28);
		frame.add(filter);

		JTextArea details = new JTextArea();
		details.setEditable(false);
		details.setLineWrap(true);
		details.setWrapStyleWord(true);
		details.setBounds(20, 70, 640, 260);
		frame.add(details);

		JButton prev = new JButton("Prev");
		prev.setBounds(430, 20, 100, 28);
		frame.add(prev);
		JButton next = new JButton("Next");
		next.setBounds(540, 20, 100, 28);
		frame.add(next);

		final int[] index = {0};
		Runnable render = () -> {
			List<Integer> filtered = getFilteredPokedexIndexes(search.getText(), (String) filter.getSelectedItem());
			if (filtered.isEmpty()) {
				details.setText("No Pokémon matched your filter.");
				return;
			}
			index[0] = PokedexWindowState.normalizeIndex(index[0], filtered.size());
			int dexIndex = filtered.get(index[0]);
			skaits[0] = dexIndex;
			String pokeName = name[dexIndex];
			String seenState = seenPokemon.contains(pokeName) ? "Seen" : "Unseen";
			String caughtState = caughtPokemon.contains(pokeName) ? "Caught" : "Not caught";
			details.setText(
					"#" + (dexIndex + 1) + " " + pokeName + "\n"
					+ "HP: " + hp[dexIndex] + "  ATK: " + atk[dexIndex] + "  SPD: " + spd[dexIndex] + "\n"
					+ "Status: " + seenState + " / " + caughtState + "\n\n"
					+ info[dexIndex]);
		};

		search.addActionListener(e -> {
			index[0] = 0;
			render.run();
		});
		search.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				index[0] = 0;
				render.run();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				index[0] = 0;
				render.run();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				index[0] = 0;
				render.run();
			}
		});
		filter.addActionListener(e -> {
			index[0] = 0;
			render.run();
		});
		prev.addActionListener(e -> {
			index[0]--;
			render.run();
		});
		next.addActionListener(e -> {
			index[0]++;
			render.run();
		});

		render.run();
		frame.setVisible(true);
	}

	private static List<Integer> getFilteredPokedexIndexes(String query, String filter) {
		return PokedexFilter.filterIndexes(name, query, filter, seenPokemon, caughtPokemon);
	}

	private static void showBattleScreen(JPanel logs, String enemyImage) {
		Pokemons playerMon = (Pokemons) poki.get(0);
		if (activeBattle == null || activeBattleEnemy == null || !enemyImage.equals(activeBattleEnemyImage)) {
			activeBattleEnemy = createEncounterPokemon(enemyImage);
			activeBattleEnemyImage = enemyImage;
			if (activeBattleEnemy == null) {
				fighting = false;
				return;
			}
			activeBattle = new BattleSystem(playerMon, activeBattleEnemy);
		}
		Pokemons enemyMon = activeBattleEnemy;
		if (enemyMon == null) {
			fighting = false;
			return;
		}
		JLabel scene = new JLabel(new ImageIcon("bildes/ekra.png"));
		scene.setSize(751, 560);

		String playerImage = getEncounterImageByName(playerMon.getVards());
		if (playerImage != null) {
			JLabel yourMon = pokedex(playerImage);
			yourMon.setSize(200, 200);
			yourMon.setLocation(10, 200);
			scene.add(yourMon);
		}

		JLabel foe = pokedex(enemyImage);
		foe.setSize("Int.png".equals(enemyImage) ? 200 : 200, "Int.png".equals(enemyImage) ? 400 : 200);
		foe.setLocation("Int.png".equals(enemyImage) ? 585 : 540, "Int.png".equals(enemyImage) ? 212 : 200);
		scene.add(foe);

		JTextArea battleLog = new JTextArea("Battle started: " + playerMon.getVards() + " vs " + enemyMon.getVards());
		battleLog.setEditable(false);
		battleLog.setLineWrap(true);
		battleLog.setWrapStyleWord(true);
		battleLog.setBounds(20, 410, 710, 110);
		scene.add(battleLog);

		JButton basic = new JButton("Basic Skill");
		basic.setBounds(300, 200, 140, 32);
		scene.add(basic);
		JButton special = new JButton("Special Skill");
		special.setBounds(300, 242, 140, 32);
		scene.add(special);

		java.awt.event.ActionListener action = e -> {
			boolean useSpecial = e.getSource() == special;
			BattleSystem.TurnResult result = activeBattle.performTurn(useSpecial);
			playerMon.setHP(activeBattle.getPlayerHp());
			enemyMon.setHP(activeBattle.getEnemyHp());
			battleLog.setText(result.log);
			if (result.finished) {
				basic.setEnabled(false);
				special.setEnabled(false);
				fighting = false;
				activeBattle = null;
				activeBattleEnemy = null;
				activeBattleEnemyImage = null;
				if (result.playerWon) {
					showStatusMessage("Battle won against " + enemyMon.getVards());
				} else {
					showStatusMessage("Battle lost against " + enemyMon.getVards());
				}
				saveProgress();
			}
		};
		basic.addActionListener(action);
		special.addActionListener(action);

		logs.removeAll();
		logs.add(scene);
		UIStateManager.refresh(logs);
	}

	private static Pokemons createEncounterPokemon(String imageName) {
		switch(imageName) {
		case "Squirtle112.png":
			return new UdensP("Water", "Squirtle", 44, 48, 43);
		case "WartortleEncounter.png":
			return new UdensP("Water", "Wartortle", 59, 63, 58);
		case "Elekid1.png":
			return new ElektriskaisP("Electric", "Elekid", 45, 63, 95);
		case "Int.png":
			return new ElektriskaisP("Electric", "Intars", 45, 63, 95);
		default:
			return null;
		}
	}

	private static String getEncounterImageByName(String pokemonName) {
		switch(pokemonName) {
		case "Squirtle":
			return "Squirtle112.png";
		case "Wartortle":
			return "WartortleEncounter.png";
		case "Blastoise":
			return "Blastoise12.gif";
		case "Lickitung":
			return "Lick1.gif";
		case "Lickylicky":
			return "lickylicky.gif";
		case "Elekid":
			return "Elekid1.png";
		case "Electabuzz":
			return "electabuzz.gif";
		case "Electivire":
			return "electivire.gif";
		case "Intars":
			return "Int.png";
		default:
			showStatusMessage("Unknown sprite for " + pokemonName + ".");
			return null;
		}
	}

	private static void markSeenByEncounterImage(String imageName) {
		Pokemons p = createEncounterPokemon(imageName);
		if (p != null) {
			seenPokemon.add(p.getVards());
			saveProgress();
		}
	}

	public static void addPokeballs(int count) {
		PBsk[0] += count;
		PokeballSk.setText(String.valueOf(PBsk[0]));
		saveProgress();
	}

	public static void showStatusMessage(String message) {
		if (statusMessage != null) {
			statusMessage.setText(message);
		}
	}

	public static void saveProgress() {
		try {
			GameState state = new GameState();
			state.pokeball = PBsk[0];
			state.mediumball = MBsk[0];
			state.ultraball = UBsk[0];
			state.pokedexIndex = skaits[0];
			state.seen.addAll(seenPokemon);
			state.caught.addAll(caughtPokemon);
			state.playerWorldX = gamePanel.player.worldX;
			state.playerWorldY = gamePanel.player.worldY;
			state.worldItemCollected = gamePanel.worldInteractionManager.isItemCollected();

			for (Object o : poki) {
				if (o instanceof Pokemons) {
					Pokemons p = (Pokemons) o;
					GameState.PokemonData data = new GameState.PokemonData();
					data.type = p.getClass().getSimpleName();
					data.name = p.getVards();
					data.hp = p.getHP();
					data.atk = p.getATK();
					data.spd = p.getSPD();
					state.captured.add(data);
				}
			}
			SaveManager.save(state);
		} catch (Exception e) {
			showStatusMessage("Save failed: " + e.getMessage());
		}
	}

	public static void loadProgress() {
		try {
			GameState state = SaveManager.load();
			if (state == null) {
				return;
			}
			PBsk[0] = state.pokeball;
			MBsk[0] = state.mediumball;
			UBsk[0] = state.ultraball;
			skaits[0] = state.pokedexIndex;
			PokeballSk.setText(String.valueOf(PBsk[0]));
			MediumballSk.setText(String.valueOf(MBsk[0]));
			UltraballSk.setText(String.valueOf(UBsk[0]));

			seenPokemon.clear();
			seenPokemon.addAll(state.seen);
			caughtPokemon.clear();
			caughtPokemon.addAll(state.caught);
			seenPokemon.addAll(caughtPokemon);

			poki.clear();
			for (GameState.PokemonData data : state.captured) {
				if ("UdensP".equals(data.type)) {
					poki.add(new UdensP("Water", data.name, data.hp, data.atk, data.spd));
				} else if ("ElektriskaisP".equals(data.type)) {
					poki.add(new ElektriskaisP("Electric", data.name, data.hp, data.atk, data.spd));
				}
			}

			gamePanel.player.worldX = state.playerWorldX;
			gamePanel.player.worldY = state.playerWorldY;
			gamePanel.worldInteractionManager.restoreItemState(state.worldItemCollected);
			showStatusMessage("Progress loaded");
		} catch (Exception e) {
			showStatusMessage("Load failed: " + e.getMessage());
		}
	}
	
}