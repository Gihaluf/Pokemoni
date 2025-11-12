package poke;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class pokemon {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setLocation(150, 50);
		frame.setSize(1244, 700);
		
		ImageIcon icon = new ImageIcon("bildes/pokeframe.png");
		JLabel background = new JLabel(icon);
		frame.setContentPane(background);
		frame.setUndecorated(true);
		
		JButton button = new JButton();
		button.setSize(20, 20);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
}