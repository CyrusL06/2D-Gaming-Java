package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener
{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int src = e.getKeyCode(); //Check the specidif keyKode
		
		if (src == KeyEvent.VK_W)
		{
			upPressed = true;
			
		}
		if (src == KeyEvent.VK_S)
		{
			downPressed = true;
		}
		if (src == KeyEvent.VK_A)
		{
			leftPressed = true;
		}
		if (src == KeyEvent.VK_D)
		{
			rightPressed = true;
		}
			
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int src = e.getKeyCode();
		if (src == KeyEvent.VK_W)
		{
			upPressed = false;
		}
		if (src == KeyEvent.VK_S)
		{
			downPressed = false;
		}
		if (src == KeyEvent.VK_A)
		{
			leftPressed = false;
		}
		if (src == KeyEvent.VK_D)
		{
			rightPressed = false;
		}
	}

}
