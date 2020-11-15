package Game;



import java.awt.Dimension;

import javax.swing.*;

public class Square extends JButton {
	private Piece currPiece;
	private boolean isHighlight;
	
	/**
	 * Constructor for Square
	 */
	public Square() {
		currPiece = null;
		isHighlight = false;
		setPreferredSize(new Dimension(57,57));
	}
	
	/**
	 * Checks if the square is a highlighted one
	 * @return true if it is, false otherwise
	 */
	public boolean isHighlighted() { return isHighlight; }
	/**
	 * Sets the square to highlighted or not
	 * @param state true if it is, false if its not
	 */
	public void setHighlighted(boolean state) { isHighlight = state; }
	
	public Piece getPiece() { return currPiece; }
	
	public void setPiece(Piece piece) { this.currPiece = piece; }
	
	/**
	 * Checks if there is a piece
	 * @return true if there is a piece, false otherwise
	 */
	public boolean hasPiece() { return currPiece != null; }

	@Override
	public String toString() {
		return "Square [currPiece=" + currPiece + ", isHighlight=" + isHighlight + "]";
	}
	
	
}

