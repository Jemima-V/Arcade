//ISU Assignment 
/*Programmer Name: jessica 
Date: Friday January 17
Purpose: to create key inputs  */

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	User u;
	
	public KeyInput(User u) {
		this.u = u;
	}
	
	public void keyPressed(KeyEvent e) {
		u.keyPressed(e);
	}
	
	public void keyReleased (KeyEvent e) {
		u.keyReleased(e);
	}

}
