package Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
	JButton reset;
	static Board board = Board.getBoard();
	
	/*
	 * Creates application
	 */
	public static void main(String args[]) {
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
		if(e.getSource() == reset)
        {
        	board.resetPieces();
        }
    }
	
	/*
	 * Creates the frame and the panels for checkers
	 * NOTE: Jack and Landon this is where the Board will be added to the application
	 */
	public static void createGUI() {
		JFrame frame = new JFrame("CPS 240 Checkers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Main gui = new Main();
		frame.setContentPane(gui.createNavPane());
		
		frame.add(board);
		
		frame.setSize(528,585);
		frame.setVisible(true);
		frame.setResizable(false);
		board.resetPieces();
	}
	
	
	/*
	 * Creates the nav bar for starting and reseting the checkerboard
	 */
	public JPanel createNavPane() {
		JPanel navPanel = new JPanel();
		navPanel.setLocation(220, 10);
		navPanel.setSize(150, 100);
       
		reset = new JButton("Reset");
		reset.addActionListener(this);
		reset.setPreferredSize(new Dimension(100,30));
		
		navPanel.add(reset);
       
		return navPanel;
	}
}