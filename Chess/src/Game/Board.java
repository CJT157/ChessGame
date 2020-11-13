package Game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
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
	private Square[][] squares = new Square[ROWS][COLS];
	private ArrayList<Square> possibleMoves = new ArrayList<Square>();
	private Square selectedSquare = new Square();

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
			for (int j = (i % 2 == 0 ? 1 : 0); j < this.COLS; j += 2) {

				if (i < 3 && i % 2 == 0 && j % 2 == 1) {
					squares[i][j].setIcon(regGrayPiece);
					squares[i][j].setPiece(new Checker(Color.gray, i, j));
				} else if (i < 3 && i % 2 == 1 && j % 2 == 0) {
					squares[i][j].setIcon(regGrayPiece);
					squares[i][j].setPiece(new Checker(Color.gray, i, j));
				} else if (i > 4 && i % 2 == 1 && j % 2 == 0) {
					squares[i][j].setIcon(regWhitePiece);
					squares[i][j].setPiece(new Checker(Color.white, i, j));
				} else if (i > 4 && i % 2 == 0 && j % 2 == 1) {
					squares[i][j].setIcon(regWhitePiece);
					squares[i][j].setPiece(new Checker(Color.white, i, j));
				} else {
					squares[i][j].setIcon(redSquare);
					squares[i][j].setPiece(null);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < this.ROWS; i++) {
			for (int j = (i % 2 == 0 ? 1 : 0); j < this.COLS; j += 2) {
				
				if (e.getSource() == squares[i][j] && squares[i][j].hasPiece()) {
					// For anyone that looks at this before I get to it
					// Currently pieces show the two open spaces
					// But this needs to be refactored to send a list of all possible spaces and then handle changeing them here
					// Pretty sure Couch said that and if so please tell me "I told you so"
					// but that needs to happen
					// I think an arrayList will make this easiest if we want to expand to double/triple jumps
					// but as of now you can move pieces
					possibleMoves = squares[i][j].getPiece().canMove(this.squares);
					selectedSquare = squares[i][j];
					
					for (Square plot : possibleMoves) {
						plot.setHighlighted(true);
						plot.setIcon(highlightedSquare);
					}

				} else if (e.getSource() == squares[i][j] && squares[i][j].isHighlighted()) {
					selectedSquare.setIcon(redSquare);
					squares[i][j].setPiece(selectedSquare.getPiece());
					squares[i][j].setHighlighted(false);
					selectedSquare.setPiece(null);
					
					squares[i][j].getPiece().setX(i);
					squares[i][j].getPiece().setY(j);
					
					if (squares[i][j].getPiece().getColor() == Color.gray) {
						squares[i][j].setIcon(regGrayPiece);
					} else {
						squares[i][j].setIcon(regWhitePiece);
					}
					
					possibleMoves.remove(squares[i][j]);
					for (Square plot : possibleMoves) {
						plot.setHighlighted(false);
						plot.setIcon(redSquare);
					}
					
					selectedSquare = null;
					break;
				}
			}
		}
	}
}