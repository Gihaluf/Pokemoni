package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JDialog;
import javax.swing.JPanel;

import entity.Player;
import poke.Pokedatnis;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7709054431452894800L;
	//SCREEN SETTING
	final int originalTileSize=2; //16x16 tile
	final int scale = 16 ;
	
	public final int tileSize = originalTileSize * scale; //48*48
	public final int maxScreenCol = 20;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;  //960pix
	public final int screenHeight = tileSize * maxScreenRow; //576pix
	
	//WORLD SETTINGS
	public final int maxWorldCol = 35;
	public final int maxWorldRow = 22;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	//FPS
	int FPS=60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	static Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public Player player = new Player(this,keyH);	
	
	public GamePanel(){
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS; //0.01666 
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gameThread != null) {
			
			update();
	
			 
			

			repaint();
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void update(){
		
		player.update();
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics g2 = (Graphics2D)g;
		
		tileM.draw((Graphics2D) g2);
		
		player.draw(g2);
		
		g2.dispose();
	}

	public static void triggerRandomPanel(){
		
		Pokedatnis.kust.setVisible(false);
		Pokedatnis.kust.dispose();
		
		JDialog logs = new JDialog();
	    JPanel kert = new JPanel(new BorderLayout());
	    
	    logs.add(kert);
	    
	    logs.setSize(751, 565);
	    logs.setLocation(32, 109);
	    
	    
	    logs.setVisible(true); 
	    
	}
}




