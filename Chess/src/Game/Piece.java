package Game;

import java.awt.Color;
import java.util.ArrayList;

// Checker and King

public abstract class Piece {
	protected Color pieceColor;
	protected int x;
	protected int y;
	
	/**
	 * Constructor for a piece
	 * @param pieceColor color of the piece
	 * @param x row number
	 * @param y column number
	 */
	public Piece(Color pieceColor, int x, int y) {
		this.pieceColor = pieceColor;
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the color of the piece
	 * @return the color of the piece
	 */
	public Color getColor() {
		return pieceColor;
	}
	
	/**
	 * Getters and setters for the row and column information
	 */
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }

	public abstract ArrayList<Square> canMove(Square[][] currentBoard);
}
