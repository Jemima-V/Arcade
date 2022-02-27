//ISU Assignment 
/*Programmer Name: jessica, jemima, simrat, sabirah 
Date: Friday January 17
Purpose: to create main menu for all games */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EscapeRoomMainMenu extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800, HEIGHT = 480;
	public static final String TITLE = "MAIN MENU";

	public Rectangle startButton = new Rectangle(WIDTH / 2 - 145, 280, 250, 50);
	public Rectangle beginnerButton = new Rectangle(WIDTH - 700, 150, 250, 50);
	public Rectangle advancedButton = new Rectangle(WIDTH - 700, 250, 250, 50);
	public Rectangle exitButton = new Rectangle(WIDTH / 2 - 145, 350, 250, 50);

	public static void main(String args[]) {
		//creating j frame 
		JFrame frame = new JFrame();
		frame.pack();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(new EscapeRoomMainMenu());
		frame.setVisible(true);
	}
	
	public static enum STATE{
		MENU,
		GAMES_MENU,
		EXIT, 
	};

	public static STATE State = STATE.MENU;
	
	//adding mouse listener 
	public EscapeRoomMainMenu(){
		addMouseListener(this);
	}
	
	//adding graphics 
	public void paint(Graphics g) {
		super.paint(g);
		//Calling in background image
		Graphics2D g2d = (Graphics2D) g;
		
		//background of menu 
		if(State == STATE.MENU) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.BLACK);
			g.fillRect(WIDTH - 750, 30, 700, 390);
			//Main menu
			Font fnt0 = new Font("arial", Font.BOLD, 50);
			Font fnt1 = new Font("arial", Font.BOLD, 20);
	
			//font of menu 
			g.setFont(fnt0);
			g.setColor(Color.WHITE);
			g.drawString("ESCAPE ROOM", 210, 150);
			g.setFont(fnt1);
			g.drawString("BY: JESSICA, JEMIMA, SIMRAT, AND SABIRAH", 180, 200);
			
			//Background of start button
			g.setColor(Color.WHITE);
			g.fillRect(WIDTH / 2 - 135, 280, 230, 50);
			//Background of exit button
			g.setColor(Color.WHITE);
			g.fillRect(WIDTH / 2 - 135, 350, 230, 50);
			
			//Text for start button
			g.setColor(Color.BLACK);
			g.drawString("START", startButton.x + 90, startButton.y + 35);
			//Text for exit button
			g.setColor(Color.BLACK);
			g.drawString("EXIT", exitButton.x + 100, exitButton.y + 35);
			
			g2d.draw(exitButton);
			g2d.draw(startButton);
			repaint();
		}else if(State == STATE.GAMES_MENU) {
			//Game selection menu
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.BLACK);
			g.fillRect(WIDTH - 750, 30, 700, 390);
			
			Font fnt1 = new Font("arial", Font.BOLD, 30);
			Font fnt2 = new Font("arial", Font.BOLD, 18);
	
			//Title
			g.setFont(fnt1);
			g.setColor(Color.WHITE);
			g.drawString("SELECT A ROOM", 120, 220);
			
			//ColourMatch
			g.setFont(fnt2);
			g.setColor(Color.PINK);
			g.fillRect(500, 50, 210, 40);
			g.setColor(Color.WHITE);
			g.drawString("Colour Match", 550, 75);
			
			//Login Game
			g.setFont(fnt2);
			g.setColor(Color.PINK);
			g.fillRect(500, 100, 210, 40);
			g.setColor(Color.WHITE);
			g.drawString("Login Game", 550, 125);
			
			//Puzzle Game
			g.setColor(Color.ORANGE);
			g.fillRect(500, 150, 210, 40);
			g.setColor(Color.WHITE);
			g.drawString("Puzzle Game", 550, 175);
			
			//Whack-A-Mole
			g.setColor(Color.ORANGE);
			g.fillRect(500, 200, 210, 40);
			g.setColor(Color.WHITE);
			g.drawString("Whack-A-Mole", 540, 225);
			
			//Brick Breaker
			g.setColor(Color.RED);
			g.fillRect(500, 250, 210, 40);
			g.setColor(Color.WHITE);
			g.drawString("Brick Breaker", 545, 275);
			
			//Trivia Game
			g.setColor(Color.RED);
			g.fillRect(500, 300, 210, 40);
			g.setColor(Color.WHITE);
			g.drawString("Trivia", 575, 325);
			
			//Meteor Attack Game
			g.setColor(Color.BLUE);
			g.fillRect(500, 350, 210, 40);
			g.setColor(Color.WHITE);
			g.drawString("Meteor Attack", 540, 380);
			repaint();
		}else if(State == STATE.EXIT) {
			System.out.println("Game exiting...");
			System.exit(0);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int mx = e.getX();
		int my = e.getY();
		
		//Start button
		if(mx >= 265 && mx <= 475) {
			if(my >= 280 && my <= 330) {
				//Clicking on the start button
				EscapeRoomMainMenu.State = EscapeRoomMainMenu.STATE.GAMES_MENU;
			}
			else if (my >= 350 && my <= 400) {
				//Clicking on exit button
				EscapeRoomMainMenu.State = EscapeRoomMainMenu.State.EXIT;
			}
		}

		//Games from rooms 
		if(mx >= 500 && mx <= 710) {
			//Colour Match button
			if(my >= 50 && my <= 90) {
				new ColourMatch();
			}
			//Login Game button
			else if(my >= 100 && my <= 140) {
				new Login();
			}
			//Puzzle Game
			else if(my >= 150 && my <= 190) {
				new Puzzle();
			}
			//Whack-A-Mole
			else if(my >= 200 && my <= 240) {
				new WackAMole();
			}
			//Brick Breaker
			else if(my >= 250 && my <= 290) {
				new Main();
			}
			//Trivia Game
			else if(my >= 300 && my <= 340) {
				new Trivia();
			}
			//Meteor Attack Game
			else if(my >= 350 && my <= 400) {
				MainClass mainClass = new MainClass();
				mainClass.getClass();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}
}