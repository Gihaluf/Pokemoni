package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class KeyHandler implements KeyListener {
	private Random random = new Random();
	private final int POPUP_CHANCE = 20;
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = true;
			int roll = random.nextInt(POPUP_CHANCE);
			if (roll == 0) { 
				GamePanel.triggerRandomPanel();
				upPressed = false;
	        }
		}
		
		if(code == KeyEvent.VK_S) {
			downPressed = true;
			int roll = random.nextInt(POPUP_CHANCE);
			if (roll == 0) { 
				GamePanel.triggerRandomPanel();
				downPressed = false;

	        }
		}
		
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
			int roll = random.nextInt(POPUP_CHANCE);
			if (roll == 0) { 
				GamePanel.triggerRandomPanel();
				leftPressed = false;
	        }
		}
		
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
			int roll = random.nextInt(POPUP_CHANCE);
			if (roll == 0) { 
				GamePanel.triggerRandomPanel();
				rightPressed = false;
	        }
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
		
		if(code == KeyEvent.VK_S) {
			downPressed = false;
		}
		
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		
	}

}
