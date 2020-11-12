package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {
	private final int ROWS = 8;
	private final int COLS = 8;
	private ImageIcon whiteSquare = new ImageIcon(this.getClass().getResource("images/square_white.jpg"));
	private ImageIcon redSquare = new ImageIcon(this.getClass().getResource("images/square_red.png"));
	private ImageIcon regWhitePiece = new ImageIcon(this.getClass().getResource("images/reg_checker_white.png"));
	private ImageIcon regGrayPiece = new ImageIcon(this.getClass().getResource("images/reg_checker_gray.png"));
	private ImageIcon kingWhitePiece = new ImageIcon(this.getClass().getResource("images/king_checker_white.png"));
	private ImageIcon kingGrayPiece = new ImageIcon(this.getClass().getResource("images/king_checker_gray.png"));
	private ImageIcon highlightedSquare = new ImageIcon(this.getClass().getResource("images/highlighted_square.png"));

	private static Board board;
	private PieceSet[] pieceSets;
	private Square[][] squares = new Square[ROWS][COLS];
	
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
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				squares[i][j] = new Square();
				squares[i][j].setPreferredSize(new Dimension(57,57));
				squares[i][j].addActionListener(this);

				if (i % 2 == 0) {
					if (j % 2 == 0) {
						squares[i][j].setIcon(whiteSquare);
					} else {
						squares[i][j].setIcon(redSquare);
					}
				} else {
					if (j % 2 == 0) {
						squares[i][j].setIcon(redSquare);
					} else {
						squares[i][j].setIcon(whiteSquare);
					}
				}

				squares[i][j].setOpaque(true);
				
				board.add(squares[i][j]);
			}
		}
	}
	
	public void resetPieces() {
		for (int i = 0; i < this.ROWS; i++) {
			for (int j = 0; j < this.COLS; j++) {

				if (i < 3 && i % 2 == 0 && j % 2 == 1) {
					squares[i][j].setIcon(regGrayPiece);
				} else if (i < 3 && i % 2 == 1 && j % 2 == 0) {
					squares[i][j].setIcon(regGrayPiece);
				} else if (i > 4 && i % 2 == 1 && j % 2 == 0) {
					squares[i][j].setIcon(regWhitePiece);
				} else if (i > 4 && i % 2 == 0 && j % 2 == 1) {
					squares[i][j].setIcon(regWhitePiece);
				}

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < this.ROWS; i++) {
			for (int j = 0; j < this.COLS; j++) {
				if (e.getSource() == squares[i][j] && squares[i][j].hasPiece()) {
					System.out.println(i + " " + j);
				}
			}
		}
	}
}
