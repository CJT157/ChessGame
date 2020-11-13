package Game;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Checker extends Piece {
	private boolean promoted;
	private Piece promoteTo;

	public Checker(Color pieceColor, int x, int y) {
		super(pieceColor, x, y);
	}
	
	@Override
	public ArrayList<Square> canMove(Square[][] currentBoard) {
		ArrayList<Square> possibleMoves = new ArrayList<Square>();
		
		// How this should work
		/*
		 * Takes initial location of piece (x, y)
		 * recursively (fucking disgusting) check down/up to the right and left
		 * first looks for two open spaces
		 * if pieces are in either, recursion to check for more for double jumping
		 * (use a separate method for recursion)
		 */
		
		int x = (pieceColor == Color.white ? -1 + this.x : 1 + this.x);
		int y = this.y;
		
		try {
			if (currentBoard[x][y - 1].hasPiece() ) {
				// Recursive stuffs if time
			} else {
				possibleMoves.add(currentBoard[x][y - 1]);
			}
		} catch (Exception e) {

		}
		
		try {
			if (currentBoard[x][y + 1].hasPiece()) {
				// Recursive stuffs if time
			} else {
				possibleMoves.add(currentBoard[x][y + 1]);
			}
		} catch (Exception e) {

		}
		
		return possibleMoves;
	}
	
	@Override
	public boolean captured() {
		
		return false;
	}
}
