package Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;
import java.util.Stack;

public class Main implements ActionListener{
	JButton start, reset;
	
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
		
		Board gameBoard = Board.getBoard();

		Main gui = new Main();
		gui.makeBoard(gameBoard);
		frame.setContentPane(gui.createNavPane());
		
		frame.add(gameBoard);
		
		frame.setSize(528,585);
		frame.setVisible(true);
	}

	/**
	 * Displays squares and checkers on the application
	 */
	public void makeBoard(Board board)
	{
		final int ROWS = 8;
		final int COLS = 8;
		ImageIcon color1 = new ImageIcon(this.getClass().getResource("images/square_white.jpg"));
		ImageIcon color2 = new ImageIcon(this.getClass().getResource("images/square_red.png"));
		ImageIcon tempColor;

		Square[][] squares = new Square[ROWS][COLS];

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				squares[i][j] = new Square();
				board.add(squares[i][j]);

				if (i % 2 == 1) {
					tempColor = color1;
					color1 = color2;
					color2 = tempColor;
				}

				if (j % 2 == 0) {
					squares[i][j].setIcon(color1);
				} else {
					squares[i][j].setIcon(color2);
				}

				squares[i][j].setOpaque(true);
			}
		}

		board.setSquares(squares);
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