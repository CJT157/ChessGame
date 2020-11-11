package Game;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class Board extends JPanel {
	private static Board board;
	private PieceSet[] pieceSets;
	private Square[][] squares;
	
	/**
	 * Sets up the checker board panel.
	 */
	public Board() {
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(500, 500));
	}
	
	/**
	 * Singleton to create board
	 */
	public static Board getBoard() {
		if (board == null) {
			board = new Board();
			board.makeBoard();
		}

		return board;
	}

	public void setSquares(Square[][] squares) {
		this.squares = squares;
	}
	
	/**
	 * Displays squares and checkers on the application
	 */
	public void makeBoard() {
		final int ROWS = 8;
		final int COLS = 8;
		ImageIcon color1 = new ImageIcon(this.getClass().getResource("images/square_white.jpg"));
		ImageIcon color2 = new ImageIcon(this.getClass().getResource("images/square_red.png"));
		ImageIcon tempColor;

		Square[][] squares = new Square[ROWS][COLS];

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				squares[i][j] = new Square();
				squares[i][j].setPreferredSize(new Dimension(57,57));

				if (i % 2 == 0) {
					if (j % 2 == 0) {
						squares[i][j].setIcon(color1);
					} else {
						squares[i][j].setIcon(color2);
					}
				} else {
					if (j % 2 == 0) {
						squares[i][j].setIcon(color2);
					} else {
						squares[i][j].setIcon(color1);
					}
				}

				squares[i][j].setOpaque(true);
				
				board.add(squares[i][j]);
			}
		}

		board.setSquares(squares);
	}
	
	public void resetPieces() {
		
	}
}
