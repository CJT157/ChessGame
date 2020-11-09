package Game;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Board extends JPanel{
	private static Board board;
	private PieceSet[] pieceSets;
	private Square[][] squares;
	
	/**
	 * Sets up the checker board panel.
	 */
	public Board()
	{
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(500, 500));
		this.squares = getBoardColors();
	}
	
	/**
	 * Singleton to create board
	 */
	public static Board getBoard() {
		if (board == null) {
			board = new Board();
		}
		
		return board;
	}

	/**
	 * Displays squares and checkers on the application
	 */
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);

		int x = 0, y = 0;
		int width = getWidth();
		int height = getHeight();
		
		int boxWidth = width/squares.length; // assumes it is a square
		int boxHeight = height/squares.length;

		page.setColor(Color.white);
		
		for (int row = 0; row < squares.length; row++)
		{
			for (int col = 0; col < squares[row].length; col++)
			{
				page.setColor(squares[row][col].getColor());
				page.fillRect(x, y, boxWidth, boxHeight);
				/**
				 * HEY ADD ACTION TO DRAW A PIECE
				 * GOOD LUCK
				 */
				x += boxWidth;
			}
			x = 0;
			y += boxHeight;
		}
	}
	
	/**
	 * Creates a 2d array of squares to display on the application
	 */
	public Square[][] getBoardColors() {
		Square[][] board = new Square[8][8];
		for (int row = 0; row < board.length; row++)
		{
		   for (int col = 0; col < board[row].length; col++)
		   {
		       if(row % 2 == col%2)
		    	   board[row][col] = new Square(Color.red);
		       else {
		    	   board[row][col] = new Square(Color.white);
		    	   if (row < 3) {
		    		   //board[row][col].setPiece(redpiece);
		    	   } else if (row > 4) {
		    		   //board[row][col].setPiece(blackpiece);
		    	   }
		       }
		    }
		}
		return board;
	}
}
