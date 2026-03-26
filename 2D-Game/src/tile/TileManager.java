package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {

	GamePanel gp;
	Tile[] tile; //Array of tile
	int mapTileNum [][];
	
	public TileManager(GamePanel gp) {
		super();
		this.gp = gp;
		
		tile = new Tile[10]; //10 kinds of tile
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/worldmap.txt");
//		loadMap("/maps/map.txt");

	}
	
	
	
	
	//Method
	
	
	public void collision() {
		
	}
	
	
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water01.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * Scan the map.txt line-by-line
	 * Divide to each number and get them to
	 * mapTileNum 
	 * */
	public void loadMap(String FilePath) {
		try {
			InputStream is = getClass().getResourceAsStream(FilePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String line = br.readLine(); //read line of text
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");// select number one by one
					
					//col as index for numbers[]
					int num = Integer.parseInt(numbers[col]); 
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
			
			
		}catch(Exception e){
			
		}
	}
	
	
	
	public void draw(Graphics2D g2) {
		
	//Ineffecient***
//		g2.drawImage(tile[0].image, 0, 0,gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 48, 0,gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[2].image, 96, 0,gp.tileSize, gp.tileSize, null);

		int worldCol = 0;
		int worldRow = 0;
		
//		int x = 0;
//		int y = 0;
		
	//Looping through the map
			
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) { //Making the world map the boundary....
			
			//We want to know 3 things (X,Y, TileImage)
			//Extract a tile num stored in mapTileNum
			int tileNum = mapTileNum[worldCol][worldRow]; 
			
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			/*
			 * For Effecient rendering we only render tiles around player and leaving the rest unrenderred
			 * */
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			   worldY - gp.tileSize< gp.player.worldY + gp.player.screenY) {
					
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

			}
			
			
			
//			g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
			worldCol++;
//			x += gp.tileSize;
			
			if(worldCol == gp.maxWorldCol) { //Next Row
				worldCol = 0;
//				x = 0;
				worldRow++; 
//				y+= gp.tileSize;
			}
			
			
		}
		
		
	}
	
	
}











