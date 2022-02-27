//ISU Assignment 
/*Programmer Name: jessica 
Date: Friday January 17
Purpose: to add meteors */

import java.awt.Graphics2D;
import java.util.ArrayList;

//controller class
public class Controller {
	
	static ArrayList<Meteor> m = new ArrayList<Meteor>();
	
	Meteor TempMeteor;
	
	public Controller() {
		//Collection of meteors
		//addMeteor(new Meteor(110,50));
		//addMeteor(new Meteor(400,200));
		//addMeteor(new Meteor(280,0));
		//addMeteor(new Meteor(480,100));
	}
	
	//graphics 
	public void draw(Graphics2D g2d) {
		for(int i = 0; i < m.size(); i++) {
			TempMeteor = m.get(i);
			TempMeteor.draw(g2d);
		}
	}
	
	//updating meteors 
	public void update() {
		for(int i = 0; i < m.size(); i++) {
			TempMeteor = m.get(i);
			TempMeteor.update();
		}
	}
	
	//adding meteors 
	public void addMeteor(Meteor meteor) {
		//if (m.size() < 4) {
			m.add(meteor);
		//}
	}
	//removing meteors 
	public void removeMeteor(Meteor meteor) {
		m.remove(meteor);
	}
	//array 
	public static ArrayList<Meteor> getMeteorBounds(){
		return m;
	}
}
