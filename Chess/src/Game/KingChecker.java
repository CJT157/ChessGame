package Game;

import java.awt.*;
import java.util.ArrayList;

public class KingChecker extends Piece {

	public KingChecker(Color pieceColor, int x, int y) {
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
		
		int x = this.x;
		int y = this.y;
		
		// Checking for possible locations west of a piece
		for(int i = -1; i < 2; i+=2) {
			try {
				if (currentBoard[x + i][y - 1].hasPiece() && !currentBoard[x + (2 * i)][y - 2].hasPiece() && currentBoard[x + i][y - 1].getPiece().getColor() != this.getColor()) {
					possibleMoves.add(currentBoard[x + i][y - 1]);
					possibleMoves.add(currentBoard[x + (2 * i)][y - 2]);
				} else {
					possibleMoves.add(currentBoard[x + i][y - 1]);
				}
			} catch (Exception e) {
	
			}
			
			// Checking for possible locations east of a piece
			try {
				if (currentBoard[x + i][y + 1].hasPiece() && !currentBoard[x + (2 * i)][y + 2].hasPiece() && currentBoard[x + i][y + 1].getPiece().getColor() != this.getColor()) {
					possibleMoves.add(currentBoard[x + i][y + 1]);
					possibleMoves.add(currentBoard[x + (2 * i)][y + 2]);
				} else {
					possibleMoves.add(currentBoard[x + i][y + 1]);
				}
			} catch (Exception e) {
				
			}
		}
		
		return possibleMoves;
	}
}
