package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("2D Adventure");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack(); // cause the window to be sized to to fit pref size and layout of gamePanel
		
	
		
		window.setLocationRelativeTo(window); //window set at the center of screen
		window.setVisible(true);
		
//		Checks if the game loop is running
		gamePanel.StartGameThread();
	}

}
