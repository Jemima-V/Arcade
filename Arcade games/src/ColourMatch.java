 /* Name:Jemima V
 * Date: 1/3/2020
 * Purpose: Colour card matching game
 */


//Importing all needed classes
import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class ColourMatch implements ActionListener {
	
	
	//Initializing JFrame, JPanels, JButtons, variables
	
	//Main JFrame
	JFrame frame = new JFrame("Memory Game!!");
	

	//JPanels
	JPanel field = new JPanel();
	JPanel menu = new JPanel();
	JPanel menu2 = new JPanel();
	JPanel menu3 = new JPanel();
	JPanel start_screen = new JPanel();
	JPanel end_screen = new JPanel();
	JPanel ins_screen = new JPanel();
	

	//JButtons
	JButton btn[] = new JButton[20]; //Create 20 "Colour Cards"
	JButton start = new JButton("Start");
    JButton exit = new JButton("Exit");
    JButton ins = new JButton("Instructions");
    JButton goBack = new JButton("Back");
    JButton playAgain = new JButton("PLAY AGAIN!");

    //Random to randomize "Card" order
    Random rand = new Random();
    
    
    boolean incorrect = false;
	Boolean game_exit = false;
	Boolean shown = true;
	boolean cond= true;
	
	int level=0;
	JLabel winner;
	int initialSelection;
	int incorrectMatch;
	
	String[] board;
	Color[] boardColor;
	
	String[] colorText = {"Red","Green","Blue", "Yellow", "Orange", "Purple", "Pink", "Cyan", "Grey", "Black"};		
	Color[] colors = {Color.RED,Color.GREEN,Color.BLUE, Color.YELLOW, Color.ORANGE, Color.MAGENTA, Color.PINK, Color.CYAN, Color.LIGHT_GRAY, Color.BLACK};	

	
	JLabel label = new JLabel("Enter level from 1 to 10");
	JLabel welcome = new JLabel("WELCOME TO COLOUR MATCH!!!");
	JTextField text = new JTextField(5);
	JLabel win = new JLabel("YOU WIN!!!");
	
	JTextArea instructions = new JTextArea("To begin, type in a level and select start\nWhen the game begins, the screen will be filled\nwith pairs of buttons.\nYou must memorize their placement.\nOnce you press any button, they will all clear. \nYour goal is to click the matching buttons in a row.\nWhen you match them all, you win!\n GOOD LUCK!");
	
	//Main Game layout/menu
	public ColourMatch(){
		
		start.setBackground(Color.CYAN);
		exit.setBackground(Color.CYAN);
		ins.setBackground(Color.CYAN);
	
		initialSelection = colorText.length*2;
		incorrectMatch = colorText.length*2;
		
		frame.setSize(500,300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start_screen.setLayout(new BorderLayout());
		start_screen.setBackground(Color.PINK);
		
		welcome.setFont(new Font("Courier", Font.BOLD, 24));
	    welcome.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    welcome.setBackground(Color.PINK);
		
		menu.setBackground(Color.PINK);
		menu2.setBackground(Color.PINK);
		menu3.setBackground(Color.CYAN);


		start_screen.add(menu, BorderLayout.CENTER);
		start_screen.add(menu2, BorderLayout.SOUTH);
		start_screen.add(menu3, BorderLayout.NORTH);
		
		menu3.add(welcome);

		menu.add(label);
		menu.add(text);

		start.addActionListener(this);
		start.setEnabled(true);
		
		exit.addActionListener(this);
		exit.setEnabled(true);
		
		ins.addActionListener(this);
		ins.setEnabled(true);
		
		menu2.add(start);
		//menu2.add(exit);
		menu2.add(ins);

		
		frame.add(start_screen, BorderLayout.CENTER);
		frame.setVisible(true);
	}	
	
	
	//Setting up game based on level chosen
	public void setUpGame(int level){
		
		clearMain();
		
		//Creating empty arrays
		board = new String[2*level]; 	//board = [,,,,,,]
		boardColor = new Color[2*level]; 	//board = [,,,,,,]
		
		//Setting up "Cards"
		for(int i=0;i<(level*2);i++)
		{
			btn[i] = new JButton("");
			btn[i].setBackground(Color.LIGHT_GRAY);
			btn[i].addActionListener(this);
			btn[i].setEnabled(true);
			field.add(btn[i]);
		}
		
		//Setting up colours for cards based on level chosen
		for(int i=0;i<level;i++)
			{
				//creating 2 cards of the same Colour in random spots
				for(int z=0;z<2;z++)
				{
					//When random chooses index that is already filled while loop will cause random to pick index again
					while(cond==true)
					{	
						//Setting up random spots for cards
						//y is the index of the array
						int y = rand.nextInt(level*2);
						
						//null checks for empty value of board[y] 
						if(board[y]== null)
						{ 
							//Creating buttons
							btn[y].setText(colorText[i]);
							btn[y].setForeground(Color.WHITE);
							btn[y].setBackground(colors[i]);
							
							//Creating board behind
							board[y]=colorText[i];
							boardColor[y]=colors[i];
														
							break;
						}//End of if 
					}//End of While
				}//End of 2nd for	
			}//End of 1st for
		
		
		createBoard();
		
	}
	
	
	//Creating (showing) the board
	public void createBoard()
	{
		field.setLayout(new BorderLayout());
		start_screen.add(field, BorderLayout.CENTER);
		field.setLayout(new GridLayout(5,4));
		field.setBackground(Color.PINK);
		
	}
	
	//Setting all boxes blank
	public void hideField(int level)
	{
		for(int i=0;i<(level*2);i++)
		{
			btn[i].setText("");		
			btn[i].setBackground(Color.GRAY); 
		}
		
		//hide field will only be called when shown is true, making it false continues game to card selection
		shown=false;
	}
	
	//Showing selected card OR hiding incorrect match
	public void checkSpot(int i)
	{
		if(board[i]!="done")
		{
			//shows the colour of the selected card
			if(btn[i].getText()== "")
			{
				//Sets board value underneath to the button
				btn[i].setText(board[i]);
				btn[i].setForeground(Color.WHITE);
				btn[i].setBackground(boardColor[i]); 
			} 
			
			//If match is incorrect card will return to grey (after 1st and 2nd card selection)
			else 
			{
				btn[i].setText("");
				btn[i].setBackground(Color.GRAY); 
			}
		}
	}
	
	
	//Shows all the cards at the beginning
	public void showField(int level){
		for(int i=0;i<(level*2);i++)
		{
			btn[i].setText(colorText[i]);
			btn[i].setBackground(boardColor[i]);
			btn[i].setForeground(Color.WHITE);
			
		}
		
		shown=true;
	}
	
	
	//checks if every spot is labeled as done
	public void checkWin(){
		boolean winner = true;
		for(int i=0;i<(level*2);i++)
		{
			//checks if whole board is done
			if (board[i]!="done")
			winner = false;
		}
		if (winner==true) {
			winner();
		}
	}
	
	//End of game screen
	public void winner(){
		
			JPanel three = new JPanel();
			JPanel four = new JPanel();
			JPanel five = new JPanel();
		
			start_screen.remove(field);
			start_screen.add(end_screen);
			end_screen.setLayout(new BorderLayout());
			
			win.setFont(new Font("Courier", Font.BOLD, 24));
		    win.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		    win.setBackground(Color.CYAN);
		    
		    end_screen.add(three, BorderLayout.NORTH);
		    end_screen.add(four, BorderLayout.CENTER);
		    end_screen.add(five, BorderLayout.SOUTH);
			end_screen.setBackground(Color.PINK);
			
			three.add(win);
			four.add(playAgain);
			//five.add(exit);
			
			playAgain.setBackground(Color.CYAN);
			
			three.setBackground(Color.PINK);
			four.setBackground(Color.PINK);
			//five.setBackground(Color.PINK);
			
//			three.setLayout(new FlowLayout(FlowLayout.CENTER));
//		
//			end_screen.add(three, BorderLayout.NORTH);
//			
//			three.setBackground(Color.PINK);
//			
//			three.add(playAgain);
			
			playAgain.addActionListener(this);
			playAgain.setEnabled(true);
			
	}
	
	//clears main menu to add the board 
	public void clearMain(){
		start_screen.remove(menu);
		start_screen.remove(menu2);
		start_screen.remove(menu3);
		start_screen.revalidate();
		start_screen.repaint();
	}
	
	
	public void actionPerformed(ActionEvent click){
		JButton source = (JButton) click.getSource();
		if(incorrect == true)
		{
			checkSpot(incorrectMatch);
			checkSpot(initialSelection);

			initialSelection=colorText.length*2;
			incorrectMatch=colorText.length*2;
			incorrect= false;
		}
		
		//setting the instruction screen
		if(source==ins){
			clearMain();
	        
			start_screen.add(ins_screen, BorderLayout.NORTH);
			
			JPanel one = new JPanel();
			one.setLayout(new FlowLayout(FlowLayout.CENTER));
			JPanel two = new JPanel();
			two.setLayout(new FlowLayout(FlowLayout.CENTER));
			ins_screen.setLayout(new BorderLayout());
			ins_screen.add(one, BorderLayout.NORTH);
			ins_screen.add(two, BorderLayout.SOUTH);
			
			goBack.setBackground(Color.CYAN);
			one.setBackground(Color.PINK);
			two.setBackground(Color.PINK);
			
			one.add(instructions);
			two.add(goBack);
			goBack.addActionListener(this);
			goBack.setEnabled(true);
			
		}
		
		//back to main screen
		if(source==goBack || source == playAgain){
		    frame.dispose();  
		    goToMainScreen();
		}
		
		//start sets level and calls method to set up game
		if(source==start)
		{ 
			//Anything that is not a integer will catch and display "invalid" message
			try {
				level = Integer.parseInt(text.getText());			
			} catch (Exception e){
				
		JOptionPane.showMessageDialog(frame, "Please enter a number from 1-10" );
						
			}
			
			if (level > 10 || level <1 ) 
				JOptionPane.showMessageDialog(frame, "Please enter a number from 1-10");
			
			else
				setUpGame(level);
		} 
			
		
		else {
			//Exit game
			if(source==exit)
			{
				System.exit(0);
			}
			
			
		//gameplay when a button is pressed
		for(int i =0;i<(level*2);i++)
		{
			if(source==btn[i])
			{
				if(shown == true )
				{
					//if it is the first time field is hid
					hideField(level);
				}
				
				//saves initial selection and compares 2nd selection
				else
				{
					checkSpot(i);
					if(initialSelection>=(level*2))
					{
						initialSelection=i;
					}
					
					else 
					{
						//When match is incorrect
						if((board[initialSelection]!=board[i])||(initialSelection==i))
						{
							incorrectMatch=i;
							incorrect =true;
						}
						
						//When match is correct
						else 
						{
							board[i]="done";
							board[initialSelection]="done";
							checkWin();
							initialSelection=(level*2);
						}
						
					}//End of else
				}//End of else
				
			}//End of if
			
			
		}//End of for
		
		}
	}//End of actionPreformed
		
	public void goToMainScreen(){
		new ColourMatch();
	}
	
	public static void main(String[] args) {
		
		// Calling the main game 
		new ColourMatch();
		
	}//End of Main Method
	
}//END OF PROGRAM
