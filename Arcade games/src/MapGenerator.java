//ISU Assignment 
/*Programmer Name: Simrat 
Date: Friday January 17
Purpose: to create the map for the brick breaker game (creating the bricks)  */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
	
	//set variables 
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	
	public MapGenerator(int row, int col) {
		//instantiate 2Darray 
		map = new int [row][col];
		
		//use for loops
		for (int i=0; i <map.length; i++ ) {
			for (int j=0; j<map[0].length; j++) {
				map [i][j]=1;
			}
		}
		
		brickWidth = 540/col;
		brickHeight =200/row;
	}

	//use method to create bricks 
	public void draw (Graphics2D g) {
		//using counter 
		for (int i=0; i <map.length; i++ ) {
			for (int j=0; j<map[0].length; j++) {
				if (map[i][j]>0) {
					g.setColor(Color.pink);
					g.fillRect(j * brickWidth + 90, i * brickHeight + 60, brickWidth, brickHeight);
					
					//adding extra bricks (pink ones) 
					g.setColor(Color.red);
					g.fillRect(j*brickWidth + 100, i * brickHeight + 80, brickWidth, brickHeight);
				
					//create white border 
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.white);
					
					//create and draw rectangle 
					g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
					
					//create and draw rectangle 2nd time  
					g.drawRect(j * brickWidth + 90, i * brickHeight + 65, brickWidth, brickHeight);
				}
	
			}
		}
	}
	
	//use another method 
	public void setBrickValue(int value, int row, int col) {
		map[row][col] = value;
		
	}
	
}//end of program 


