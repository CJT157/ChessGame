package Game;

import java.awt.Color;
import java.util.ArrayList;

// Checker and King

public abstract class Piece {
	protected Color pieceColor;
	protected int x;
	protected int y;
	
	public Piece(Color pieceColor, int x, int y) {
		this.pieceColor = pieceColor;
		this.x = x;
		this.y = y;
	}

	public Color getColor() {
		return pieceColor;
	}
	
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }

	public abstract ArrayList<Square> canMove(Square[][] currentBoard);
	public abstract boolean captured();
}
