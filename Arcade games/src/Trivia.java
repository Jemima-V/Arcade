//ISU Assignment 
/*Programmer Name: Simrat  
Date: Friday January 17
Purpose: to create a quiz style trivia game */

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Trivia implements ActionListener{

	
	//JFrame
		JFrame frame;
		//radio buttons 
		JRadioButton radioButton1,radioButton2,radioButton3,radioButton4;
		//J button (Submit and next) 
		JButton button1,button2;
		//J Labels 
		JLabel label1,label2;
		//button group 
		ButtonGroup buttongroup;
		// array of questions 
		String question[]={"1.What language do they speak in Brazil?" ,
				"2.How many black squares are there on a chess board?" ,
				"3.What is the most common medical condition?" ,
				"4.What was President Yeltsin’s first name?" ,
				"5.In which decade did people last see Halley’s Comet?" , 
				"6.How many books are there in the New Testament?",
				"7.How many players make up a Basketball team?", 
				"8.Who was the Roman god of sleep?",
				"9.In what year was the Piper Alpha disaster?",
				"10.Which musical instrument did Pablo Casals play?"};
		//array for option 1 
		String option1[]={"English","27", "Cancer", "Boris", "1920s", "38", "7", "Promea","1922", "Flute"};
		// array for option 2
		String option2[]={"Spanish","32" , "Caries", "Curtis", "1980s", "27", "6", "Zuess", "1987", "Cello"};
		//array for option 3
		String option3[]={"Italian","15" , "Arthritis", "Meese", "1970s", "22", "5", "Roma", "1986", "Piano"};
		//array for option 4
		String option4[]={"Portuguese","31", "Asthma", "Borden", "1950s", "21", "4", "Somnus", "1999", "Guitar"};
		//array for answers 
		String answer[]={"Portuguese","32", "Caries", "Boris", "1980s", "27", "5", "Somnus", "1986", "Cello"};
		int counter;
		
		Trivia()
		{
			
			//printing instructions
			System.out.println();
			System.out.println("WELCOME TO TRIVIA!");
			System.out.println("Here's how to play:");
			System.out.println("1. Select your answer to the given question");
			System.out.println("2. Select \"Check\" to see if your answer is correct");
			System.out.println("3. You can select \"Next\" to move on to the next question");
			System.out.println("4. There are 10 questions! Once you complete them all you can exit and try another game in our escape room!");
			System.out.println("ENJOY!!!");
			System.out.println();
			
			
			//creating JFrame 
			frame=new JFrame();
			frame.setLayout(null);
			frame.setSize(700,700);
			Container c=frame.getContentPane();
			c.setBackground(Color.red);
			
			//create Label 1
			label1=new JLabel(question[0]);
			label1.setBounds(50,50,700,30);
			frame.add(label1);
			label1.setFont(new Font("serif",Font.BOLD,25));
		
			//create radio button 1
			radioButton1=new JRadioButton(option1[0]);
			radioButton1.setBounds(200,120,100,30);
			frame.add(radioButton1);
		
			//create radio button 2
			radioButton2=new JRadioButton(option2[0]);
			radioButton2.setBounds(450,120,100,30);
			frame.add(radioButton2);
			
			//create radio button 3 
			radioButton3=new JRadioButton(option3[0]);
			radioButton3.setBounds(200,200,100,30);
			frame.add(radioButton3);
			
			//create radio button 4 
			radioButton4=new JRadioButton(option4[0]);
			radioButton4.setBounds(450,200,100,30);
			frame.add(radioButton4);
			
			//creating group for radio buttons 
			buttongroup =new ButtonGroup();
			buttongroup.add(radioButton1);
			buttongroup.add(radioButton2);
			buttongroup.add(radioButton3);
			buttongroup.add(radioButton4);
			
			//listening to which radio button is pressed 
			radioButton1.addActionListener(this);
			radioButton2.addActionListener(this);
			radioButton3.addActionListener(this);
			radioButton4.addActionListener(this);
		
			//creating button 1 (submit option) 
			button1=new JButton("Check");
			button1.setBounds(200,400,100,30);
			frame.add(button1);
		
			//creating button 2 (Next option) 
			button2=new JButton("Next");
			button2.setBounds(350,400,100,30);
			frame.add(button2);
			
			//listening to which button is pressed 
			button1.addActionListener(this);
			button2.addActionListener(this);
			frame.setVisible(true);
					
		
		}
		
		//going to contrustor 
		public static void main(String s[])
		{
			new Trivia();
			
		}
		
		
		
		// if mouse is clicked 
		public void actionPerformed(ActionEvent e)
		{
			//if button 1 is pressed 
			if(e.getSource()==button1)
			{
				//if any specific radio button is pressed 
				String pressed="";
				
				
				if(radioButton1.isSelected())
					pressed=radioButton1.getText();
				if(radioButton2.isSelected())
					pressed=radioButton2.getText();
				if(radioButton3.isSelected())
					pressed=radioButton3.getText();
				if(radioButton4.isSelected())
					pressed=radioButton4.getText();	
				//if answer is correct display right 
				if(pressed.equals(answer[counter]))
					JOptionPane.showMessageDialog(frame,"Right Answer");
					
					
				//if answer is wrong display wrong 
				else
					JOptionPane.showMessageDialog(frame,"Wrong Answer");
			}
			
			//if button 2 is pressed 
			if (e.getSource()==button2)
			{
				//counter 
				counter++;
				//says the new question 
				label1.setText(question[counter]);
				//options 
				radioButton1.setText(option1[counter]);
				radioButton2.setText(option2[counter]);
				radioButton3.setText(option3[counter]);
				radioButton4.setText(option4[counter]);
				
				//get it to reset to 1 every time there is a new question 
				radioButton1.setSelected(true);
				radioButton2.setSelected(false);
				radioButton3.setSelected(false);
				radioButton4.setSelected(false);
				
				if (counter==9) {	
					//getting rid of the next button on question 10 
					button2.setVisible(false);
					
					//create another label for the end to display 
					label2=new JLabel("THE END!");

					label2.setBounds(300,500,700,30);
					frame.add(label2);
					label2.setFont(new Font("serif",Font.BOLD,25));
					
					frame.add(label2);
					
				}
					

				}

			}
		}
