//ISU Assignment 
/*Programmer Name: jessica 
Date: Friday January 17
Purpose: to create a class for user inputs  */
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class User extends GlobalPosition{
	
	

	private String playerimage = "/images/Player.png.png";
	private int velX = 0, velY = 0, speed = 5;
	public static final int WIDTH = 800, HEIGHT = 480;
	public static final String TITLE = "DODGER GAME";
	
	int counter;
	
	private ArrayList<Meteor> m = Controller.getMeteorBounds();
	
	public User(int x, int y) {
		super(x, y);
	}

	public void update(JFrame frame) {
		x += velX;
		y += velY;
		
		//Collision with outside
		if (x < 0) {
			x = 0;
		}
		if (x > 700) {
			x = 700;
		}
		if (y < 0) {
			y = 0;
		}
		if (y > 385) {
			y = 385;
		}
		Collision(frame);
		touchSpaceShip();
	}
	public void Collision(JFrame frame) {
		//Detect meteors
		for(int i = 0; i < m.size(); i ++) {
			if(getBounds().intersects(m.get(i).getBounds())) {
				counter++;
				if(counter == 1) {
					System.out.println("COLLISION!!");
					System.out.println("GAME OVER. BETTER LUCK NEXT TIME!");
					//JFrame frame = new JFrame();
					//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					//System.exit(0);
					frame.dispose();
					
					
					}
			}
		}
	}
	
	public void touchSpaceShip() {
		if(getBounds().intersects(getBurgerBounds())) {
			counter++;
			if(counter == 1) {
			System.out.println("YOU WIN!!\nCLICK THE X BUTTON AT THE TOP RIGHT-HAND CORNER TO EXIT.");
			Game.STATE State = Game.STATE.MENU;
				}
			}
		}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		//Key controls for user's character
		if (key == KeyEvent.VK_LEFT) {
			velX = -speed;
			velY = 0;
		}
		if (key == KeyEvent.VK_UP) {
			velX = 0;
			velY = -speed;
		}
		if (key == KeyEvent.VK_RIGHT) {
			velX = speed;
			velY = 0;
		}
		if (key == KeyEvent.VK_DOWN) {
			velX = 0;
			velY = speed;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		velY = 0;
		velX = 0;
	}
	
	public Rectangle getBounds() {
		//Player's boundaries
		return new Rectangle(x, y, 81, 63);
	}
	
	public Rectangle getBurgerBounds() {
		//Burger boundaries
		return new Rectangle(750, 215, 50, 50);
	}
	
	public void draw(Graphics2D g2d) {
		//Calling in the player's image
		g2d.drawImage(getPlayerImage(), x, y, null);
	}
	
	public Image getPlayerImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getImage();
	}
}
