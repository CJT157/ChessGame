package Game;

import java.awt.Dimension;

import javax.swing.*;

public class Square extends JButton {
	private Piece currPiece;
	private boolean isHighlight;
	
	public Square() {
		currPiece = null;
		isHighlight = false;
		setPreferredSize(new Dimension(57,57));
	}
	
	public boolean isHighlighted() { return isHighlight; }
	public void setHighlighted(boolean state) { isHighlight = state; }
	
	public Piece getPiece() { return currPiece; }
	
	public void setPiece(Piece piece) { this.currPiece = piece; }
	
	public boolean hasPiece() { return currPiece != null; }
}
