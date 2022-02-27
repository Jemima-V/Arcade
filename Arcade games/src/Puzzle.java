//ISU Assignment 
/*Programmer Name: Sabirah 
Date: Friday January 17
Purpose: to create a increasing order puzzle game */
import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;

public class Puzzle extends JFrame implements ActionListener{  

// initializing all JButton variables
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;  


public Puzzle(){  

	
super("PUZZLE GAME");  

		//printing instructions
		System.out.println();
		System.out.println("WELCOME TO PUZZLE!");
		System.out.println("Here's how to play:");
		System.out.println("1. There are 8 numbers on the window, the goal of the game is to get these 8 numbers in numerical order!");
		System.out.println("2. To do this use your mouse to click on any number, if there is an empty space directly around that number it will move to that empty space");
		System.out.println("3. Continue to move the numbers around, and swaping the spots with the empty space until the numbers are all in order");
		System.out.println("4. Once the numbers are in order you win! Once you select \"ok\" the game will reset");
		System.out.println("5. You may play again if you would like to or you can exit and try another game in our escape room!");
		System.out.println("ENJOY!!!");
		System.out.println();

		
		
//Creating new JButtons and their labels
 b1=new JButton("1");  
 b2=new JButton(" ");  
 b3=new JButton("3");  
 b4=new JButton("4");  
 b5=new JButton("5");  
 b6=new JButton("6");  
 b7=new JButton("7");  
 b8=new JButton("8");  
 b9=new JButton("2");  
 
 //changing color 
 b1.setBackground(Color.ORANGE);
 b1.setOpaque(true);
 b2.setBackground(Color.ORANGE);
 b2.setOpaque(true);
 b3.setBackground(Color.ORANGE);
 b3.setOpaque(true);
 b4.setBackground(Color.ORANGE);
 b4.setOpaque(true);
 b5.setBackground(Color.ORANGE);
 b5.setOpaque(true);
 b6.setBackground(Color.ORANGE);
 b6.setOpaque(true);
 b7.setBackground(Color.ORANGE);
 b7.setOpaque(true);
 b8.setBackground(Color.ORANGE);
 b8.setOpaque(true);
 b9.setBackground(Color.ORANGE);
 b9.setOpaque(true);
 
//Setting Boundaries for JButton Locations 
 b1.setBounds(10,30,100,100);  
 b2.setBounds(130,30,100,100);  
 b3.setBounds(250,30,100,100);  
 b4.setBounds(10,150,100,100);  
 b5.setBounds(130,150,100,100);  
 b6.setBounds(250,150,100,100);  
 b7.setBounds(10,275,100,100);  
 b8.setBounds(130,275,100,100);  
 b9.setBounds(250,275,100,100);  
  
 
//Adding action listener to all JButtons
add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);add(b9);  
b1.addActionListener(this);  
b2.addActionListener(this);  
b3.addActionListener(this);  
b4.addActionListener(this);  
b5.addActionListener(this);  
b6.addActionListener(this);  
b7.addActionListener(this);  
b8.addActionListener(this);  
b9.addActionListener(this);  
  
  
//Formation of canvas
setSize(390,490);  
setLayout(null);  
setVisible(true);  
setBackground(Color.ORANGE);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
}//end of constructor  


@SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent e){  
 
//Adds functionality to button 1 for movement and checks for order arrangement
if(e.getSource()==b1){  
String s=b1.getLabel();  
if(b2.getLabel().equals(" ")){ b2.setLabel(s); b1.setLabel(" ");}  
else if(b4.getLabel().equals(" ")){ b4.setLabel(s); b1.setLabel(" ");}  
 }//end of if  
 
//Adds functionality to button 3 for movement and checks for order arrangement
if(e.getSource()==b3){  
String s=b3.getLabel();  
if(b2.getLabel().equals(" ")){ b2.setLabel(s); b3.setLabel(" ");}  
else if(b6.getLabel().equals(" ")){ b6.setLabel(s); b3.setLabel(" ");}  
 }//end of if  
 
//Adds functionality to button 2 for movement and checks for order arrangement
if(e.getSource()==b2){  
String s=b2.getLabel();  
if(b1.getLabel().equals(" ")){ b1.setLabel(s); b2.setLabel(" ");}  
else if(b3.getLabel().equals(" ")){ b3.setLabel(s); b2.setLabel(" ");}  
else if(b5.getLabel().equals(" ")){ b5.setLabel(s); b2.setLabel(" ");}  
 }//end of if  
 
//Adds functionality to button 4 for movement and checks for order arrangement
if(e.getSource()==b4){  
String s=b4.getLabel();  
if(b1.getLabel().equals(" ")){ b1.setLabel(s); b4.setLabel(" ");}  
else if(b7.getLabel().equals(" ")){ b7.setLabel(s); b4.setLabel(" ");}  
else if(b5.getLabel().equals(" ")){ b5.setLabel(s); b4.setLabel(" ");}  
 }//end of if  
 
//Adds functionality to button 5 for movement and checks for order arrangement
if(e.getSource()==b5){  
String s=b5.getLabel();  
if(b2.getLabel().equals(" ")){ b2.setLabel(s); b5.setLabel(" ");}  
else if(b4.getLabel().equals(" ")){ b4.setLabel(s); b5.setLabel(" ");}  
else if(b6.getLabel().equals(" ")){ b6.setLabel(s); b5.setLabel(" ");}  
else if(b8.getLabel().equals(" ")){ b8.setLabel(s); b5.setLabel(" ");}  
 }//end of if  
  
//Adds functionality to button 6 for movement and checks for order arrangement
if(e.getSource()==b6){  
String s=b6.getLabel();  
if(b9.getLabel().equals(" ")){ b9.setLabel(s); b6.setLabel(" ");}  
else if(b3.getLabel().equals(" ")){ b3.setLabel(s); b6.setLabel(" ");}  
else if(b5.getLabel().equals(" ")){ b5.setLabel(s); b6.setLabel(" ");}  
  
 }//end of if  
//Adds functionality to button 7 for movement and checks for order arrangement
if(e.getSource()==b7){  
String s=b7.getLabel();  
if(b4.getLabel().equals(" ")){ b4.setLabel(s); b7.setLabel(" ");}  
else if(b8.getLabel().equals(" ")){ b8.setLabel(s); b7.setLabel(" ");}  
  
 }//end of if  

//Adds functionality to button 8 for movement and checks for order arrangement
if(e.getSource()==b8){  
String s=b8.getLabel();  
if(b7.getLabel().equals(" ")){ b7.setLabel(s); b8.setLabel(" ");}  
else if(b9.getLabel().equals(" ")){ b9.setLabel(s); b8.setLabel(" ");}  
else if(b5.getLabel().equals(" ")){ b5.setLabel(s); b8.setLabel(" ");}  
  
 }//end of if  
 
//Adds functionality to button 9 for movement and checks for order arrangement
if(e.getSource()==b9){  
String s=b9.getLabel();  
if(b6.getLabel().equals(" ")){ b6.setLabel(s); b9.setLabel(" ");}  
else if(b8.getLabel().equals(" ")){ b8.setLabel(s); b9.setLabel(" ");}  

//If all code is arranged in order from least to greatest then output winning message
if(b1.getLabel().equals("1")&&b2.getLabel().equals("2")&&b3.getLabel().equals("3")) 

	JOptionPane.showMessageDialog(Puzzle.this,"FIRST ROW COMPLETED!"); 
	
	if(b1.getLabel().equals("1")&&b2.getLabel().equals("2")&&b3.getLabel().equals("3")&&b4.getLabel().equals("4")&&b5.getLabel().equals("5")  &&b6.getLabel().equals("6")) 
	
	JOptionPane.showMessageDialog(Puzzle.this,"SECOND ROW COMPLETED!");  
 
		if (b1.getLabel().equals("1")&&b2.getLabel().equals("2")&&b3.getLabel().equals("3") &&b4.getLabel().equals("4")&&b5.getLabel().equals("5")  &&b6.getLabel().equals("6") &&b7.getLabel().equals("7")&&b8.getLabel()  .equals("8")&&b9.getLabel().equals(" ")) 
		
	    JOptionPane.showMessageDialog(Puzzle.this,"YOU WIN!");}
  
} 
 
   
  
public static void main(String[] args){  
new Puzzle();  
}//end of main  
  
}//end of class 

