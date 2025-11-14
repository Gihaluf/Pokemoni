package poke;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class pokemon {
	
	//panel size 751x565
	//panel location 32x109
	
	public static void main(String[] args) {
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
		
		JPanel Info = new JPanel();
		
		
		JFrame main = new JFrame();
		main.setLocation(150, 50);
		main.setSize(1244, 700);
		
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
		
		
		
		main.setVisible(true);
		
		
	}
	static void timer(int n){
        try {
            Thread.sleep(n);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
   }
	
}