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
		
		for (int i = 0; i < 8; i++) {
			for (int j = (i % 2 == 0 ? 1 : 0); j < 8; j += 2) {
				
			}
		}
		
		return possibleMoves;
	}
	
	@Override
	public boolean captured() {
		
		return false;
	}
}
