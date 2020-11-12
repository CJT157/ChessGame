package Game;

import javax.swing.*;

public class Square extends JButton {
	private Piece currPiece;
	private boolean isHighlight;
	private int x;
	private int y;
	
	public Square() {
		currPiece = null;
		isHighlight = false;
	}
	
	public boolean isHighlighted() { return isHighlight; }
	public Piece getPiece() { return currPiece; }
	public void setPiece(Piece piece) { this.currPiece = piece; }
	public boolean hasPiece() { return currPiece != null; }
}
