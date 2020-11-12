package Game;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Square extends JButton {
	private Piece currPiece;
	private int x;
	private int y;
	
	public Square() {
		currPiece = null;
	}
	
	public Piece getPiece() { return currPiece; }
	public void setPiece(Piece piece) { this.currPiece = piece; }
	public boolean hasPiece() { return currPiece != null; }
}
