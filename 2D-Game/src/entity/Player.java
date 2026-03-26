package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	
	public Player(GamePanel gp, KeyHandler keyH) {
		super();
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2- (gp.tileSize/2);
		
		
		setDefaultValue();
		getPlayerImage("player2");
	}
	
	public void getPlayerImage(String FilePath) {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/" +FilePath+"/g_21.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/" +FilePath+ "/g_22.png"));
		 right1 = ImageIO.read(getClass().getResourceAsStream("/" +FilePath+ "/g_31.png"));
	   	 right2 = ImageIO.read(getClass().getResourceAsStream("/"+FilePath+ "/g_32.png"));
		  left1 = ImageIO.read(getClass().getResourceAsStream("/"+FilePath+"/g_42.png"));
		  left2 = ImageIO.read(getClass().getResourceAsStream("/"+FilePath+"/g_41.png"));
		  down1 = ImageIO.read(getClass().getResourceAsStream("/"+FilePath+"/g_12.png"));
		  down2 = ImageIO.read(getClass().getResourceAsStream("/"+FilePath+"/g_1.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setDefaultValue() {
		//Starting position when started
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		speed = 3;
		direction = "down";
		
		
		
	}

	public void update() { //Gets call 60 times per second
		
		if(keyH.upPressed == true || keyH.downPressed == true || 
				keyH.leftPressed == true || keyH.rightPressed == true) {
			
		
			if(keyH.upPressed == true)
			{
				direction = "up";
				worldY -= speed;
			} else if (keyH.downPressed == true)
			{
				direction = "down";
				worldY += speed;
			} else if (keyH.leftPressed == true)
			{
				direction = "left";
				worldX -= speed;
			}else if (keyH.rightPressed == true)
			{
				direction = "right";
				worldX += speed;
			}
			
			//
			spriteCounter++;
			if(spriteCounter > 15) { //if it hits to 10 it changes sprite
				if(spriteNum == 1) { //Player image changes every 10 frames
					spriteNum = 2;
				}else if (spriteNum == 2) {
					spriteNum =1;
				}
				spriteCounter = 0;

			}
			
		}
	}
	
	public void draw(Graphics gp) {
//		g.setColor(Color.white);
//		//Draw rectangle using tile dimensions from the GamePanel reference.
//		g.fillRect(x, y, this.gp.tileSize, this.gp.tileSize);
//		
//		
		
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image=up1;
			}if(spriteNum ==2) {
				image=up2;
			}
			break;
		case"down":
			if(spriteNum ==1) {
				image=down1;
			}if(spriteNum ==2) {
				image=down2;
			}
			break;
		case "left":
			if(spriteNum ==1) {
				image = left1;
			}if(spriteNum ==2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum ==1) {
				image = right1;
			}if(spriteNum ==2) {
				image = right2;
			}
			break;
		}
		
		gp.drawImage(image, screenX, screenY, this.gp.tileSize, this.gp.tileSize, null);
		
		
	}

}
