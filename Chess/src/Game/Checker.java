package Game;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Checker extends Piece {
	private boolean promoted;
	private Piece promoteTo;

	public Checker(Color pieceColor, int x, int y) {
		super(pieceColor, x, y);
	}
	
	@Override
	public Square[][] canMove(Square[][] currentBoard) {
		ImageIcon highlightedSquare = new ImageIcon(this.getClass().getResource("images/highlighted_square.png"));
		int x = this.x;
		
		if (this.pieceColor == Color.gray) {
			x += 1;
		} else {
			x -= 1;
		}
		
		try {
			if (!currentBoard[x][this.y - 1].hasPiece()) {
				currentBoard[x][this.y - 1].setHighlighted(true);
				currentBoard[x][this.y - 1].setIcon(highlightedSquare);
			} 
		} catch (Exception e) {
			
		}
		try {
			if (!currentBoard[x][this.y + 1].hasPiece()) {
				currentBoard[x][this.y + 1].setHighlighted(true);
				currentBoard[x][this.y + 1].setIcon(highlightedSquare);
			}
		} catch (Exception e) {
			
		}

		return currentBoard;
	}
	
	@Override
	public boolean captured() {
		
		return false;
	}
}
