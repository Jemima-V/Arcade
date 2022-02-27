/* Name:Jessica B
 * Date: 1/1/2020
 * Purpose: Main class for meteor attack game
 */

import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainClass {
	
	public static final int WIDTH = 800, HEIGHT = 480;
	public static final String TITLE = "METEOR ATTACK";
	
	public MainClass() {
		//Setting up game window
		JFrame frame = new JFrame();
		frame.pack();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(new Game(frame));
		frame.setVisible(true);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			
		    @Override
		    public void windowClosing(WindowEvent e) {
		        if (JOptionPane.showConfirmDialog(frame, 
		            "Are you sure you want to close this window?", "Close Window?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        	//frame.getContentPane().removeAll();
		    		//frame.repaint();
		    		frame.dispose();
		    		//Game.STATE State = Game.STATE.MENU;
		        }
		    }
		});
	}
	public static void main(String args[]) {
		new MainClass();
		}
	}
