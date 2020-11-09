package Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;
import java.util.Stack;

public class Main implements ActionListener{
	JButton start, reset;
	static Board gameBoard;
	
	/*
	 * Creates application
	 */
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	createGUI();
            }
        });
	}
	
	/*
	 * Listens to any actions performed
	 * NOTE: Put Board start/reset funcitonality here
	 */
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start)
        {
        	System.out.println("start");
        }
        else if(e.getSource() == reset)
        {
        	System.out.println("reset");
        }
    }
	
	/*
	 * Creates the frame and the panels for checkers
	 * NOTE: Jack and Landon this is where the Board will be added to the application
	 */
	public static void createGUI() {
		JFrame frame = new JFrame("CPS 240 Checkers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameBoard = Board.getBoard();
		Main gui = new Main();
		frame.setContentPane(gui.createNavPane());
		
		frame.add(gameBoard.getBoard());
		
		frame.setSize(528,575);
		frame.setVisible(true);
	}
	
	/*
	 * Creates the nav bar for starting and reseting the checkerboard
	 */
	public JPanel createNavPane() {
		JPanel navPanel = new JPanel();
		navPanel.setLocation(220, 10);
		navPanel.setSize(150, 100);
       
		start = new JButton("Start");
		start.addActionListener(this);
		start.setPreferredSize(new Dimension(100,30));
       
		reset = new JButton("Reset");
		reset.addActionListener(this);
		reset.setPreferredSize(new Dimension(100,30));
       
		navPanel.add(start);
		navPanel.add(reset);
       
		return navPanel;
	}
}