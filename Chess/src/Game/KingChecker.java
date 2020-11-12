package Game;

import java.awt.*;

import javax.swing.ImageIcon;

public class KingChecker extends Piece {

	public KingChecker(Color pieceColor, int x, int y) {
		super(pieceColor, x, y);
	}

	@Override
	public Square[][] canMove(Square[][] currentBoard) {
		ImageIcon highlightedSquare = new ImageIcon(this.getClass().getResource("images/highlighted_square.png"));
		if (!currentBoard[this.x + 1][this.y - 1].hasPiece()) {
			currentBoard[this.x + 1][this.y - 1].setIcon(highlightedSquare);
		} 
		if (!currentBoard[this.x + 1][this.y + 1].hasPiece()) {
			currentBoard[this.x + 1][this.y + 1].setIcon(highlightedSquare);
		}
		if (!currentBoard[this.x - 1][this.y - 1].hasPiece()) {
			currentBoard[this.x - 1][this.y - 1].setIcon(highlightedSquare);
		} 
		if (!currentBoard[this.x - 1][this.y + 1].hasPiece()) {
			currentBoard[this.x - 1][this.y + 1].setIcon(highlightedSquare);
		}
		return currentBoard;
	}

	@Override
	public boolean captured() {
		
		return false;
	}
}
