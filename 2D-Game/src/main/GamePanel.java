package main;

import java.awt.*;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable
{
	
//REPEAT THIS
	//IF FPS Is 30, 30 times per second...
	//1. UPDATE: update infromation such as character info
	//2. DRAW: draw the screen with updated movment
	
	

	/*Game screen*/
	// Screen settings
	final int orginalTileSize = 16; //16x16 tile default size of
	//How do we solve the problem of sizing in differnt monitor size??
	final int scale = 3;//4
	public final int tileSize = orginalTileSize * scale; 
	
	//How many tiles can the game display?? 
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; //768 px
	public final int screenHeight = tileSize * maxScreenRow; //576px
	
	//FPS
	int FPS = 100;
	
	//WORLD SETTINGS
	public final int maxWorldCol = 48;
	public final int maxWorldRow = 48;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	//In order to create animation in our game
	//We need time to run in the game as real life "game clock"
	//thus use thread
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread; //implement runnable on top 
	public Player player = new Player(this,keyH);
	
	TileManager tileM = new TileManager(this); //Instantiate Tiles
	
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
		System.out.println("Game Started");

	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub

		//1seconds as calculation
		double drawInterval = 1_000_000_000/FPS; // 1/60 => we draw the screen every 0.01667 second
		double nextDrawTime = System.nanoTime() + drawInterval; //Curr time + drawInterval later
		
		//When internal hit this time ->  draw the screen again
		
		
		while(gameThread != null)
		{
//			System.out.println("The game loop is running");
			
			
			long currentTime = System.nanoTime();
			System.out.println(currentTime);
			
			//1. UPDATE: update in for such as character position
			update();
			//2. DRAW: draw the screen with the updated information
			repaint();
									//0.0167 - 0.2 = 0.1833
			double remainingDrawTime = nextDrawTime - System.nanoTime(); 
			
			//Pause the game loop wont do anyhting until over
			try {
				//but sleep accepts it as millisecong so conversion needed
				remainingDrawTime = remainingDrawTime / 1000000;
				//true
				if(remainingDrawTime < 0) {
					//turns 0
					remainingDrawTime=0;
				}
				
				Thread.sleep((long) remainingDrawTime);
				
				//When over
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	}
	
	public void update()
	{
		player.update();
	
//		if(keyH.upPressed == true)
//		{
//			playerY -= playerSpeed;
//		} else if (keyH.downPressed == true)
//		{
//			playerY += playerSpeed;
//		} else if (keyH.leftPressed == true)
//		{
//			playerX -= playerSpeed;
//		}else if (keyH.rightPressed == true)
//		{
//			playerX += playerSpeed;
//		}
	}
	
		//this is how you call repaint() components
			//Draw objects on the screen
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		//Set color using drawing object
//		g2.setColor(Color.white);
//		//Draw Rectangle in the screen
//		g2.fillRect(playerX, playerY, 48, 48);
		
		tileM.draw(g2);
		
		player.draw(g2);
		g2.dispose(); 
	}
	
}
