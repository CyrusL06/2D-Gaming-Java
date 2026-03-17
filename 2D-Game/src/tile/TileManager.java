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
		mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
		
		getTileImage();
		loadMap();
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
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * Scan the map.txt line-by-line
	 * Divide to each number and get them to
	 * mapTileNum 
	 * */
	public void loadMap() {
		try {
			InputStream is = getClass().getResourceAsStream("/maps/worldmap.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
				String line = br.readLine(); //read line of text
				
				while(col < gp.maxScreenCol) {
					String numbers[] = line.split(" ");// select number one by one
					
					//col as index for numbers[]
					int num = Integer.parseInt(numbers[col]); 
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxScreenCol) {
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

		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
	//Looping through the map
		while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
			
			//Extract a tile num stored in mapTileNum
			int tileNum = mapTileNum[col][row]; 
			
			g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
			
//			g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
			col++;
			x += gp.tileSize;
			
			if(col == gp.maxScreenCol) { //Next Row
				col = 0;
				x = 0;
				row++; 
				y+= gp.tileSize;
			}
			
			
		}
		
		
	}
	
	
}











