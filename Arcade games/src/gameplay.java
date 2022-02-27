//ISU Assignment 
/*Programmer Name: Simrat 
Date: Friday January 19
Purpose: to create a gameplay class for brick breaker game where the majority of the game will be coded*/

//import java packages 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class gameplay extends JPanel implements KeyListener, ActionListener{
	
	//set variables 
	private boolean play =false ;
	private int score =0;
	
	//number of bricks in game 
	private int totalBricks =36; 
	
	//timer 
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 310;
	
	//ball position variables 
	private int ballposX = 120;
	private int ballposY = 350;
	
	//ball direction variables 
	private int ballXdirection = -1;
	private int ballYdirection = -2; 
	
	private MapGenerator map; 
	
	public gameplay() {
		
		//create object 
		map = new MapGenerator (4, 9); 
		
		//detects key stroke 
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		//add timer 
		timer = new Timer (delay, this);
		timer.start();
	}
	
	//add function for graphics
	public void paint (Graphics g) {
		
		//background of game 
		g.setColor(Color.DARK_GRAY);
		g.fillRect(1,1, 692, 592);
		
		//drawing map
		map.draw((Graphics2D)g);
		
		//scores 
		g.setColor(Color.white);
		g.setFont(new Font("chiller", Font.BOLD, 25));
		g.drawString(""+score,  590, 30);
		
		//pedel 
		g.setColor(Color.white);
		g.fillRect(playerX, 550, 100, 8);
		
		//the ball 
		g.setColor(Color.red);
		g.fillOval(ballposX, ballposY, 25, 15);
		
		//if user wins 
		if(totalBricks <=0) {
			play = false;
			ballXdirection = 0;
			ballYdirection = 0;
			g.setColor(Color.white);
			
			//display you won
			g.setFont(new Font("chiller", Font.BOLD, 30));
			g.drawString("You Won!  SCORE : "+ score,  160, 310);
			
			//display enter to restart
			g.setFont(new Font("chiller", Font.BOLD, 20));
			g.drawString("Press Enter to Restart",  200, 350);
		}
		
		//if game is over 
		if (ballposY>570) {
			play = false;
			ballXdirection = 0;
			ballYdirection =0;
			g.setColor(Color.white);
			g.setFont(new Font("serif", Font.BOLD, 35));
			g.drawString("Game Over! SCORE: "+score,  160, 310);
			
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Press Enter to Restart",  200, 350);
		}
		
		g.dispose();
	}

	@Override
	//if user clicks an arrow (starts the game) 
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if (play) {
			
			//detecting pedel 
			if(new Rectangle(ballposX, ballposY, 30, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
				
				//allows the ball to bounce off of the pedel 
				ballYdirection = -ballYdirection;
			}
			
			A: for (int i=0; i<map.map.length; i++) {
				for (int j=0; j<map.map[0].length; j++) {
					if(map.map[i][j]>0) {
						int brickX=j * map.brickWidth +80;
						int brickY =i * map.brickHeight +50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight; 
						
						//create rectangle around brick 
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle (ballposX, ballposY, 20, 20);
						Rectangle brickRect = rect; 
						
						//if the ball touches the brick(get rid of the brick and add a score of 2 for each brick) 
						if (ballRect.intersects(brickRect)){
							map.setBrickValue(0, i, j);
							totalBricks--;
							score += 2;
							 
							if (ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
								ballXdirection= -ballXdirection;
							}
							else {
								ballYdirection = - ballYdirection;
							}
							
							break A; 
						}
					}
				}
			}
			
			ballposX += ballXdirection;
			ballposY += ballYdirection;
			
			//changing ball direction (bouncing off walls) 
			if (ballposX <0) {
				ballXdirection = -ballXdirection;
			}
			if (ballposY <0) {
				ballYdirection = -ballYdirection;
			}
			if (ballposX > 670) {
				ballXdirection = -ballXdirection;
			}
		}
		
		repaint(); 
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	//use key reader to move the pedal
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (playerX>=600) {
				playerX = 600;
			}
			else {
				moveRight();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (playerX<10) {
				playerX = 10;
			}
			else {
				moveLeft();
			}
		}
		//if user clicks enter 
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!play) {
				play = true ;
				ballposX = 120;
				ballposY = 350;
				ballXdirection = -1;
				ballYdirection =-2;
				playerX =310;
				score =0;
				totalBricks = 36;
				map = new MapGenerator(4,9);
				
				repaint(); 
			}
		}
	}
	//create method to turn right 
	public void moveRight() {
		play = true;
		playerX+=15;
	}
	//create method to turn left 
	public void moveLeft() {
		play = true;
		playerX-=15;
	}


}//end of program 



