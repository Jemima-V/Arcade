//ISU Assignment 
/*Programmer Name: Simrat 
Date: Monday January 13
Purpose: to create a main class for the brickbreaker game*/

import javax.swing.JFrame;

//creating a method of main
public class Main {
	
	public Main() {
		
		//printing instructions
		System.out.println();
		System.out.println("WELCOME TO BRICK BREAKER!!");
		System.out.println("Here's how to play:");
		System.out.println("1. To start use the arrow keys to move the bar at the bottom of the window, this will begin the game");
		System.out.println("2. Use the bar to bounce the ball onto the bricks and break them, make sure you dont let the ball touch the bottom of the window!");
		System.out.println("3. If the ball touches the bottom of the window or you break all the bricks the game is over");
		System.out.println("4.  After this you can exit and try another game in our escape room!");
		System.out.println("ENJOY!!!");
		System.out.println();
		
		//creating JFrame 
				JFrame frame=new JFrame();
				
				//create object 
				gameplay gameplay = new gameplay();
				
				//set size 
				frame.setBounds(10,10, 700, 600);
				//title of window 
				frame.setTitle("BREAK THE BRICKS!");
				//cannot resize 
				frame.setResizable(false);
				//window can be seen
				frame.setVisible(true);
				//game closes when exit is clicked 
				//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
				//adding class gameplay to run the game 
				frame.add(gameplay);
	}

	//creating this method to call this class into the main menu
	public static void main(String[] args) {
		new Main();
	}

}//end of main class 


