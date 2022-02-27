//ISU Assignment 
/*Programmer Name: jemima  
Date: Friday January 17
Purpose: to create a login game  */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;


public class Login extends JFrame implements ActionListener {

	//initializing variables
   JFrame window;
   JPanel panel;
   JLabel user_label, password_label, message, ins1, ins2, note, note2, note3, note4, quote, quote2, filler, filler2, login_panel, filler3, filler4, filler5, login_ins;
   JTextField userName_text;
   JPasswordField password_text;
   JButton login_button, cancel;
   
   
   
   int lives=0;
   
   final String INS1 = "<html>YOU MUST HACK<br> INTO THIS COMPUTER!</html>";
   final String INS2 = "<html>LOOK AROUND FOR<br> CLUES TO LOGIN!</html>";
   final String NOTE = "    TO DO LIST: ";
   final String NOTE2 = "    1. Get cat food for su";
   final String NOTE3 = "    2. Call mom (Lisa)";
   final String NOTE4 = "    3. Submit hit list";
   final String QUOTE = "   QUOTE OF THE DAY:";
   final String QUOTE2 = "    You Must Give To Receive";
   
   String fillers [] = {" "," "," "," "};
   
   
   Login() {
	   
	 //printing instructions
	System.out.println();
	System.out.println("WELCOME TO THE LOGIN HACKER GAME!!");
	System.out.println("Here's how to play:");
	System.out.println("1. To start look around the window to find clues about the owner of the computer");
	System.out.println("2. Use these clues to try and hack into the computer");
	System.out.println("3. You will have 3 chances to try to hack into the computer before it locks");
	System.out.println("4. Once the computer is locked, or you have sucessfully guessed the username and password the window will close");
	System.out.println("5. Once the window closes you can restart the game by selecting it again in the main menu or try another game in our escape room!");
	System.out.println("ENJOY!!!");
	System.out.println();
	
	   
	// creating and initializing image objects
	ImageIcon pic = new ImageIcon("loginImages/trees.jpg");
	JLabel trees = new JLabel(pic);
	trees.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	   
	ImageIcon cat = new ImageIcon("loginImages/cat.jpg");
	JLabel su = new JLabel(cat);
	su.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	
	//setting up JFrame
	JFrame window = new JFrame();	  
	
	  //Instructions and clues
	  ins1 = new JLabel(INS1);
	  ins2 = new JLabel(INS2);
	  note = new JLabel(NOTE);
	  note2 = new JLabel(NOTE2);
	  note3 = new JLabel(NOTE3);
	  note4 = new JLabel(NOTE4);
	  quote = new JLabel(QUOTE);
	  quote2 = new JLabel(QUOTE2);
	  filler = new JLabel(fillers[0]);
	  filler2 = new JLabel(fillers[1]);
	  filler3 = new JLabel(fillers[2]);
	  filler4 = new JLabel(fillers[3]);
	 
      // User name Label
      user_label = new JLabel("     Name: ");
      userName_text = new JTextField();

      // Password Label
      password_label = new JLabel("     Password: ");
      password_text = new JPasswordField();

      // login button and panel
      login_panel = new JLabel("    LOGIN HERE:	 ");
      login_ins = new JLabel(" 3 Invalid choices allowed");
      login_button = new JButton("LOGIN");
      
      
      //creating/designing panels
      login_panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
      login_ins.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
      note.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
      quote.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
      
      ins1.setFont(new Font("Courier", Font.BOLD, 16));
	  ins1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	  ins1.setBackground(Color.CYAN);
	  
	  ins2.setFont(new Font("Courier", Font.BOLD, 16));
	  ins2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	  ins2.setBackground(Color.CYAN);
	  
	  //creating the screen with all the JPanels and Pictures
      panel = new JPanel(new GridLayout(10, 1));
      panel.add(ins1);
      panel.add(ins2);
      panel.add(note);
      panel.add(quote);
      panel.add(note2);
      panel.add(quote2);
      panel.add(note3);
      panel.add(trees);
      panel.add(note4);
      panel.add(su);
      panel.add(filler3);
      panel.add(filler4);
      panel.add(login_panel);
      panel.add(login_ins);

      panel.add(user_label);
      panel.add(userName_text);
      panel.add(password_label);
      panel.add(password_text);

      message = new JLabel();
      panel.add(message);
      panel.add(login_button);
      login_button.setBackground(Color.CYAN);
      
      panel.setBackground(Color.PINK);
     
      
      
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Adding the Action listener
      login_button.addActionListener(this);
      
      
      //setting layout of main panel / adding main panel to frame
      window.getContentPane().add(panel, BorderLayout.CENTER);
      window.setTitle("Welcome Mr.Alvin!");
      window.setSize(500,600);
      window.setVisible(true);

      
   }
   public static void main(String[] args) {
      new Login();
   }

   //@Override
   public void actionPerformed(ActionEvent ae)  {
	  
	   	  // getting data from the user
	      String userName = userName_text.getText();
	      String password = password_text.getText();
	      
	      // conditions when incorrect/correct password is entered
	      
	      if (userName.trim().equalsIgnoreCase("Alvin") && password.trim().equalsIgnoreCase("Lisa")) 
	      {
	         //message.setText("You are in Mr.Alvin's computer! You Win!");
	         JOptionPane.showMessageDialog(panel, "You are in Mr.Alvin's computer! You Win!");
	         window.dispose();
	      } 
	      
	      else
	      {
	    	  switch(lives) {
			
	    	  case 0:
	    	  {
	    		//message.setText(" Invalid login. Please try again!");
		    	  JOptionPane.showMessageDialog(panel, " Invalid login. Please try again!");
		    	  lives++;
		    	  break;
	    	  }
	    	  
	    	  case 1:
	    	  {
	    		//message.setText(" Invalid login. Please try again!");
		    	  JOptionPane.showMessageDialog(panel, " Invalid login. Please try again!");
		    	  lives++;
		    	  break;
	    	  }
	    	  
	    	  case 2:
	    	  {
		    	  //message.setText(" COMPUTER LOCKED! YOU LOSE!");
		    	  JOptionPane.showMessageDialog(panel, "COMPUTER LOCKED! YOU LOSE!");
		    	  login_button.setBackground(Color.BLACK);
		    	  window.dispose();
		    	  break;
		    	 
		    	 
			  }	  
	    	  
	    	  
	    	  }//end of switch case
	    	  
	    	   
	    	 
	      }
	      
      
    	  
      }
   }