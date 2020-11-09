package Game;

import java.awt.Color;

// Checker and King

public abstract class Piece {
	private Color pieceColor;
	private boolean moved;
	
	public Color getColor() {
		return pieceColor;
	}
	public void setColor(Color color) {
		this.pieceColor = color;
	}

	public abstract Square[] canMove(Square[] currentBoard);
	
	public abstract boolean captured();
}
