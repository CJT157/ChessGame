package Game;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Checker extends Piece {

	public Checker(Color pieceColor, int x, int y) {
		super(pieceColor, x, y);
	}
	
	/**
	 * Finds the possible moves the regular checker selected can make to the left
	 */
	public ArrayList<Square> checkLeft(Square[][] currentBoard, ArrayList<Square> possibleMoves, int x, int y) {
		int modifier = (pieceColor == Color.white ? -1 : 1);
		x += modifier;
		
		try {
			if (currentBoard[x][y - 1].hasPiece() && !currentBoard[x + modifier][y - 2].hasPiece() && currentBoard[x][y - 1].getPiece().getColor() != this.getColor()) {
				possibleMoves.add(currentBoard[x][y - 1]);
				possibleMoves.add(currentBoard[x + modifier][y - 2]);
			} else {
				possibleMoves.add(currentBoard[x][y - 1]);
			}
		} catch (Exception e) {

		}
		
		return possibleMoves;
	}
	
	/**
	 * Finds the possible moves the regular checker selected can make to the right
	 */
	public ArrayList<Square> checkRight(Square[][] currentBoard, ArrayList<Square> possibleMoves, int x, int y) {
		int modifier = (pieceColor == Color.white ? -1 : 1);
		x += modifier;
		
		try {
			if (currentBoard[x][y + 1].hasPiece() && !currentBoard[x + modifier][y + 2].hasPiece() && currentBoard[x][y + 1].getPiece().getColor() != this.getColor()) {
				possibleMoves.add(currentBoard[x][y + 1]);
				possibleMoves.add(currentBoard[x + modifier][y + 2]);
			} else {
				possibleMoves.add(currentBoard[x][y + 1]);
			}
		} catch (Exception e) {
			
		}
		
		return possibleMoves;
	}
}
