package Game;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Square extends JButton implements ActionListener {
	private Piece currPiece;
	
	public Square() {
		currPiece = null;
	}
	
	public Piece getPiece() {
		return currPiece;
	}
	
	public void setPiece(Piece piece) {
		this.currPiece = piece;
	}

	public boolean hasPiece() {
		return currPiece != null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
