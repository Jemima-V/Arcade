//ISU Assignment 
/*Programmer Name: jessica 
Date: Friday January 17
Purpose: to create main game frame */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Game extends JPanel implements ActionListener, MouseListener{
	
	JFrame gameFrame;

	private static final long serialVersionUID = 1L;
	Timer gamelooptimer;
	
	public Rectangle playButton = new Rectangle(WIDTH / 2 - 130, 150, 250, 50);
	public Rectangle instructionsButton = new Rectangle(WIDTH / 2 - 130, 250, 250, 50);
	
	//Images for background
	private String background = "/images/StarBackground.png";
	private String burger = "/images/burger.png";
	
	//Objects
	User u;
	Controller c;
	
	public static enum STATE{
		MENU,
		GAME,
		INSTRUCTIONS
	};
	
	public static STATE State = STATE.MENU;
	public static final int WIDTH = 800, HEIGHT = 480;
	public static final String TITLE = "METEOR ATTACK";
	
	public Game(JFrame frame) {
		State  = STATE.MENU;
		gameFrame = frame;
		
		setFocusable(true);
		
		//timer 
		gamelooptimer = new Timer(10, this);
		gamelooptimer.start();
		
		u = new User(0,200);
		c = new Controller();
		//add metoers 
		c.addMeteor(new Meteor(110,50));
		c.addMeteor(new Meteor(400,200));
		c.addMeteor(new Meteor(280,0));
		c.addMeteor(new Meteor(480,100));	
		
		addKeyListener(new KeyInput(u));
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		//Calling in background image
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(getBackgroundImage(), 0, 0, this);
		
		if(State == STATE.GAME) {
			//Calling in object images for game
			g2d.drawImage(getBurgerImage(), 600, 100, this);
			u.draw(g2d);
			c.draw(g2d);
			
		}else if(State == STATE.MENU) {
			//Game menu
			Font fnt0 = new Font("arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.WHITE);
			g.drawString("METEOR ATTACK", 180, 107);
			
			//Background of buttons
			g.setColor(Color.BLACK);
			g.fillRect(WIDTH / 2 - 130, 150, 250, 50);
			g.setColor(Color.BLACK);
			g.fillRect(WIDTH / 2 - 130, 250, 250, 50);
			
			//Text for buttons
			Font fnt1 = new Font("arial", Font.BOLD, 30);
			g.setFont(fnt1);
			
			g.setColor(Color.WHITE);
			g.drawString("PLAY", playButton.x + 80, playButton.y + 35);
			g.setColor(Color.WHITE);
			g.drawString("INSTRUCTIONS", instructionsButton.x + 13, instructionsButton.y + 35);
			g2d.draw(playButton);
			g2d.draw(instructionsButton);

		}else if(State == STATE.INSTRUCTIONS) {
			//Instruction menu
			g.setColor(Color.BLACK);
			g.fillRect(WIDTH - 750, 30, 700, 390);
			
			Font fnt1 = new Font("arial", Font.BOLD, 30);
			Font fnt2 = new Font("arial", Font.BOLD, 18);
	
			//Title
			g.setFont(fnt1);
			g.setColor(Color.WHITE);
			g.drawString("HOW TO PLAY", 290, 90);
			
			g.setColor(Color.WHITE);
			g.fillRect(WIDTH / 2 - 130, 380, 250, 50);
			g.setColor(Color.BLACK);
			g.drawString("PLAY", playButton.x + 80, playButton.y + 270);

			//Instructions for game
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString("Use the arrow keys on the bottom right of your keyboard to move the space", 70, 160);
			g.drawString("alien. The goal of the game is to make it to the other side, without touching", 70, 195);
			g.drawString("any meteors. If your character hits a meteor, they will die and the game will", 70, 230);
			g.drawString("end!", 70, 270);
			g.drawString("To continue to the game, click on the play button below. Good luck!", 70, 360);
			
			g.setColor(Color.BLACK);
			g.fillRect(WIDTH / 2 - 130, 450, 250, 50);
			
			repaint();
		}
	}
	//burger image 
	private Image getBurgerImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(burger));
		return i.getImage();
	}

	//background image 
	public Image getBackgroundImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
	}
	
	public void actionPerformed(ActionEvent e) {
		u.update(gameFrame);
		c.update();
		repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		//play button
		if(mx >= WIDTH / 2 -130 && mx <= WIDTH / 2 + 230) {
			if(my >= 150 && my <= 250) {
				//Clicking on the play button
				Game.State = Game.STATE.GAME;
			}
			if(my >= 250 && my <= 300) {
				//Clicking on instructions button
				Game.State = Game.State.INSTRUCTIONS;
			}
			if(my >= 400 && my <= 450) {
				//Instructions to game
				Game.State = Game.STATE.GAME;
			}
		}	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	//clears main menu to add the board 
		
}
