package poke;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class pokemon {
	
	//main panel size 751x565
	//main panel location 32x109
	
	public static void main(String[] args) {
		//main frame
		JFrame main = new JFrame();
		main.setLocation(150, 50);
		main.setSize(1244, 700);
		
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
		
		
		
		JPanel Pokemon = new JPanel();
		Pokemon.setSize(260, 165);
		Pokemon.setLocation(915, 90);
	
		ImageIcon bulb = new ImageIcon("bildes/Bulbasaur.png");
		JLabel Bulbasaur = new JLabel(bulb);
		Bulbasaur.setSize(260, 167);
		Pokemon.add(Bulbasaur);
		Pokemon.setOpaque(false);
		
		
		JPanel menu = new JPanel();
		menu.setSize(332, 298);
		menu.setLocation(879, 371);
		menu.setOpaque(false);
		
		
		
		
		
		ImageIcon icon = new ImageIcon("bildes/pokeframe.png");
		JLabel background = new JLabel(icon);
		main.setContentPane(background);
		main.setUndecorated(true);
		
		JButton Stop = new JButton();
		Stop.setSize(1000, 1000);
		main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		main.add(Stop);
		Stop.setLocation(10, 10);
		Stop.setOpaque(false);
		Stop.setContentAreaFilled(false);
		Stop.setBorderPainted(false);
		Stop.addActionListener(e -> System.exit(0));
		
		
		main.add(panel);
		main.add(menu);
		main.add(Pokemon);
		
		
		
		main.setVisible(true);
		
		
	}
	
}