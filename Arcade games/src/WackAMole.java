//ISU Assignment 
/*Programmer Name: Sabirah 
Date: Friday January 17
Purpose: to create a wack a mole game  */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WackAMole implements ActionListener {
	//Labeling the spaces and adding color to whack-a-mole buttons when hit/missed
	private static final String OFF_STRING = "   ";
	private static final String UP_STRING = ":)";
	private static final String DOWN_STRING = ":(";
	private static final Color OFF_COLOR = Color.ORANGE;
	private static final Color UP_COLOR = Color.GREEN;
	private static final Color DOWN_COLOR = Color.RED;

	//Initializing all variables and buttons
	private static int count = 10;
	private static int score;
	private JButton startButton;
	private JButton[] buttons;
	private JLabel timeLabel, scoreLabel;
	private JTextArea timeArea;
	private JTextArea scoreArea;
	private static Random random = new Random();

	public WackAMole() {
		
		//printing instructions
		System.out.println();
		System.out.println("WELCOME TO WACK A MOLE!");
		System.out.println("Here's how to play:");
		System.out.println("1. Select \"Start\" to begin the game");
		System.out.println("2. Green smiley faces will pop up on the window, use your mose to click on them!");
		System.out.println("3. Once you click on them they will turn to red angry faces, and your score will increase");
		System.out.println("4. You have 20 seconds to wack the moles, once these 20 seconds are over the game will restart!");
		System.out.println("5. You may play again if you would like to or you can exit and try another game in our escape room!");
		System.out.println("ENJOY!!!");
		System.out.println();
		
		//Creating font type
		Font font = new Font(Font.MONOSPACED, Font.BOLD, 14);

		// Creating window pop-up
		JFrame frame = new JFrame("WHACK-A-MOLE GAME");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel pane = new JPanel();

		// Labeling the actual JButtons
		startButton = new JButton("BEGIN");
		pane.add(startButton);
		startButton.addActionListener(this);

		timeLabel = new JLabel("Time Remaining:");
		pane.add(timeLabel);

		//Setting the Location of JButton of Time Area
		timeArea = new JTextArea(1, 5);
		timeArea.setEditable(false);
		pane.add(timeArea);
		timeArea.setVisible(true);

		scoreLabel = new JLabel("Score:");
		pane.add(scoreLabel);

		//Setting the Location of JButton of Score Area
		scoreArea = new JTextArea(1, 5);
		scoreArea.setEditable(false);
		pane.add(scoreArea);
		scoreArea.setVisible(true);

		//Creating array for all buttons at it's initial state(Before game starts)
		buttons = new JButton[25];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(OFF_STRING);
			buttons[i].setOpaque(true);
			buttons[i].setFont(font);
			buttons[i].setBackground(OFF_COLOR);
			pane.add(buttons[i]);
			buttons[i].addActionListener(this);
		}

		frame.setContentPane(pane);
		frame.setVisible(true);

	}
	// Main Class
	public static void main(String[] args) {
		new WackAMole();
	}

	public static class MoleThread extends Thread {
		JButton button;

		MoleThread(JButton button) {
			this.button = button;
			// if statement for when count is -1 either have color up(green) or have color down (red)
			if (count > -1) {
				if (button.getText().equals(OFF_STRING)) {
					button.setText(UP_STRING);
					button.setBackground(UP_COLOR);

				} else {
					button.setText(OFF_STRING);
					button.setBackground(OFF_COLOR);
				}
			}
		}

		public void run() {
			// while loop for randomizing location of when color up (green) and color down (red) will appear
			while (count > -1) {
				int randomSleepTime = random.nextInt(4000);
				synchronized (button) {
					if (button.getText().equals(OFF_STRING)) {
						button.setText(UP_STRING);
						button.setBackground(UP_COLOR);

					} else {
						button.setText(OFF_STRING);
						button.setBackground(OFF_COLOR);
					}

				}
				// Thread.sleep function used to randomize the paused execution time when color up (green) and color down (red) will not run
				try {
					Thread.sleep(randomSleepTime);
				} catch (InterruptedException e) {
					
					throw new AssertionError(e);
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
				}

			}
			// if statement for when count is equal to 1, all buttons will become off string and game will end
			if (count == -1) {
				button.setText(OFF_STRING);
				button.setBackground(OFF_COLOR);
			
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Creating array of mole Threads
		Thread[] moleThread = new Thread[buttons.length];

		if (e.getSource() == startButton) {
			startButton.setEnabled(false);

			// creating timer, and starting timer
			Thread timerThread = new Thread(new Runnable() {

				@Override
				public void run() {
					// While-loop for countdown timer
					while (count > -1) {

						try {

							timeArea.setText("" + count);
							count--;
							Thread.sleep(1000);
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// Starting point of where Count, Score, timeArea, and ScoreArea will commence
					count = 10;
					score = 0;
					timeArea.setText("" + count);
					scoreArea.setText("" + score);
					startButton.setEnabled(true);
				}
			});

			timerThread.start();
			// For-loop for randomization of Mole number
			for (int i = 0; i < moleThread.length; i++) {
				int randomMoleNum = random.nextInt(buttons.length);
				JButton button = buttons[randomMoleNum];
				moleThread[i] = new MoleThread(button);
				moleThread[i].start();

			}
		}
		// For-loop to keep track of score
		for (int i = 0; i < buttons.length; i++) {
			if (e.getSource() == buttons[i]) {
				if (count > 0) {
					if (buttons[i].getText().equals(UP_STRING)) {
						score++;
						scoreArea.setText("" + score);
						if (score == 20) {
							buttons[i].setText(DOWN_STRING);
							buttons[i].setBackground(DOWN_COLOR);
						}
						

					}
				}
			}

		}
	}
}


