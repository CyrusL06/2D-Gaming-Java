package main;

import java.awt.*;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable
{

	//Game screen
	// Screen settings
	final int orginalTileSize = 16; //16x16 tile default size of
	
	//How do we solve the problem of sizing in differnt monitor size??
	final int scale = 3;
	final int tileSize = orginalTileSize * scale; 
	
	//How many tiles can the game display?? 
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; //768 px
	final int screenHeight = tileSize * maxScreenRow; //576px
	
	
	
	//In order to create animation in our game
	//We need time to run in the game as real life "game clock"
	//thus use thread
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread; //implement runnable on top 
	
	
	//Set players default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	
	public GamePanel()
	{
		//set the size of JPanel Class
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		//true, all the drawing of this component will be done in offscreen painting
		//buffer
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void StartGameThread()
	{
		gameThread = new Thread (this); //Instance thread
		gameThread.start(); //auto call run method
		System.out.println("Game STarted");

	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		//THread start this method start
		//Game Loop core of game
		
		while(gameThread != null)
		{
			System.out.println("wdadw");
			
			
			//1. UPDATE: update in for such as character position
			update();
			
			
			//2. DRAW: draw the screen with the updated information
			repaint();
		}
		
	
	}
	
	public void update()
	{
	
		if(keyH.upPressed == true)
		{
			playerY -= playerSpeed;
		} else if (keyH.downPressed == true)
		{
			playerY += playerSpeed;
		} else if (keyH.leftPressed == true)
		{
			playerX -= playerSpeed;
		}else if (keyH.rightPressed == true)
		{
			playerX += playerSpeed;
		}
	}
	
		//this is how you call repaint() components
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, 48, 48);
		g2.dispose();
	}
	
}
