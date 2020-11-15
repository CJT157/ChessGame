package Game;

import java.awt.*;
import java.util.ArrayList;

public class KingChecker extends Piece {

	public KingChecker(Color pieceColor, int x, int y) {
		super(pieceColor, x, y);
	}

	/**
	 * Finds the possible moves the king checker selected can make
	 */
	@Override
	public ArrayList<Square> checkLeft(Square[][] currentBoard, ArrayList<Square> possibleMoves, int x, int y) {
		// Checks both ahead and behind the piece
		for (int i = -1; i < 2; i += 2) {
			try {
				// Checking for possible locations west of a piece
				if (currentBoard[x + i][y - 1].hasPiece() && !currentBoard[x + (2 * i)][y - 2].hasPiece() && currentBoard[x + i][y - 1].getPiece().getColor() != this.getColor()) {
					possibleMoves.add(currentBoard[x + i][y - 1]);
					possibleMoves.add(currentBoard[x + (2 * i)][y - 2]);
				} else {
					possibleMoves.add(currentBoard[x + i][y - 1]);
				}
			} catch (Exception e) {
	
			}
		}
		return possibleMoves;
	}

	/**
	 * Finds the possible moves the king checker selected can make
	 */
	@Override
	public ArrayList<Square> checkRight(Square[][] currentBoard, ArrayList<Square> possibleMoves, int x, int y) {
		// Checks both ahead and behind the piece
		for (int i = -1; i < 2; i += 2) {
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
