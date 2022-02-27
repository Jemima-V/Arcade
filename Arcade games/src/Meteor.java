//ISU Assignment 
/*Programmer Name: jessica 
Date: Friday January 17
Purpose: to create meteors */

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Meteor extends GlobalPosition {

	//Meteor images
	public static String image = "/images/Meteor.png.png";
	
	int speed = 5;
	
	public Meteor(int x, int y) {
		super(x, y);
	}

	//changing speed of meteors 
	public void update() {
		y += speed;
		if(y > Game.HEIGHT-32) {
			speed = -5;
		}
		if(y < 0) {
			speed = 5;
		}
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 47, 94);
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getMeteorImage(), x, y, null);
	}
	
	public Image getMeteorImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(image));
		return i.getImage();
	}
}
