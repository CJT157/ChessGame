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
	private Player playerWhite = new Player(Color.white);
	private Player playerGray = new Player(Color.gray);
	private Player currentTurn = playerWhite;

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
		playerWhite.resetPlayer();
		playerGray.resetPlayer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < this.ROWS; i++) {
			for (int j = (i % 2 == 0 ? 1 : 0); j < this.COLS; j += 2) {
				
				Main.updateTurn(board.getTurn().toString());
				
				// Checking if a Piece Button is pressed
				if (e.getSource() == squares[i][j] && squares[i][j].hasPiece() && squares[i][j].getPiece().getColor().equals(getTurn().getPieceColor())) {
					// Empty and revert the highlighted pieces that may be in possibleMoves
					for (Square plot : possibleMoves) {
						if (plot.hasPiece()) {
							continue;
						} else {
							plot.setHighlighted(false);
							plot.setIcon(redSquare);
						}
					}
					possibleMoves.clear();
					
					// Get all possible moves
					possibleMoves = squares[i][j].getPiece().canMove(this.squares);
					selectedSquare = squares[i][j];
					
					// Change all possible empty squares to highlighted pieces
					for (Square plot : possibleMoves) {
						if (plot.hasPiece()) {
							
						} else {
							plot.setHighlighted(true);
							plot.setIcon(highlightedSquare);
						}
					}
					
				}
				// Checking if a highlighted button is pressed
				else if (e.getSource() == squares[i][j] && squares[i][j].isHighlighted()) {
					
					// Switch current piece button and highlighted button
					selectedSquare.setIcon(redSquare);
					squares[i][j].setPiece(selectedSquare.getPiece());
					
					int xDifference = selectedSquare.getPiece().getX() - i;
					int yDifference = selectedSquare.getPiece().getY() - j;
					
					if ((xDifference == 2 || xDifference == -2) && (yDifference == 2 || yDifference == -2)) {
						if (xDifference < 0 && yDifference < 0) {
							removePiece(squares[i - 1][j - 1].getPiece().getColor());
					  		squares[i - 1][j - 1].setPiece(null);
					  		squares[i - 1][j - 1].setIcon(redSquare);
						} else if (xDifference < 0 && yDifference > 0) {
							removePiece(squares[i - 1][j + 1].getPiece().getColor());
							squares[i - 1][j + 1].setPiece(null);
					  		squares[i - 1][j + 1].setIcon(redSquare);
						} else if (xDifference > 0 && yDifference < 0) {
							removePiece(squares[i + 1][j - 1].getPiece().getColor());
							squares[i + 1][j - 1].setPiece(null);
					  		squares[i + 1][j - 1].setIcon(redSquare);
						} else if (xDifference > 0 && yDifference > 0) {
							removePiece(squares[i + 1][j + 1].getPiece().getColor());
							squares[i + 1][j + 1].setPiece(null);
					  		squares[i + 1][j + 1].setIcon(redSquare);
						}
					} 
					
					squares[i][j].setHighlighted(false);
					selectedSquare.setPiece(null);
					
					// Setting Piece coordinates to new place
					squares[i][j].getPiece().setX(i);
					squares[i][j].getPiece().setY(j);
					
					// Checking for which Icon to change the button to
					if (squares[i][j].getPiece().getColor() == Color.gray) {
						
						if(i == 7  || squares[i][j].getPiece() instanceof KingChecker) {
							squares[i][j].setIcon(kingGrayPiece);
							squares[i][j].setPiece(new KingChecker(Color.gray, i, j));
						} else {
							squares[i][j].setIcon(regGrayPiece);
						}
					} else {
						if(i == 0 || squares[i][j].getPiece() instanceof KingChecker) {
							squares[i][j].setIcon(kingWhitePiece);
							squares[i][j].setPiece(new KingChecker(Color.white, i, j));
						} else {
							squares[i][j].setIcon(regWhitePiece);
						}
					}
					
					
					// Reverting all highlighted buttons
					possibleMoves.remove(squares[i][j]);
					for (Square plot : possibleMoves) {
						if (plot.hasPiece()) {
							continue;
						} else {
							plot.setHighlighted(false);
							plot.setIcon(redSquare);
						}
					}
					possibleMoves.clear();
					
					board.switchTurns();
					
					selectedSquare = null;
					break;
				}
				
				if (playerWhite.getPieceNum() <= 0) {
					Main.updateTurn("Gray Wins!!!!");
				} else if (playerGray.getPieceNum() <= 0) {
					Main.updateTurn("White Wins!!!!");
				}
			}
		}
	}
	
	public void removePiece(Color color) {
		if (color.equals(playerWhite.getPieceColor())) {
			playerWhite.decreasePieces(1);
		} else {
			playerGray.decreasePieces(1);
		}
	}
	
	public Player getTurn() {
		return currentTurn;
	}
	
	public void switchTurns() {
		if (currentTurn.equals(playerWhite)) {
			currentTurn = playerGray;
		} else {
			currentTurn = playerWhite;
		}
	}
}