package Game;

import java.awt.Color;

public class Square {
	private Color color;
	private Piece currPiece;
	
	public Square(Color color) {
		this.color = color;
		currPiece = null;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
