package Game;

import java.awt.Color;

public class Player {
	private Color pieceColor;
	private int pieceNum;
	
	public Player(Color pieceColor) {
		this.pieceColor = pieceColor;
		this.pieceNum = 12;
	}

	public Color getPieceColor() {
		return pieceColor;
	}

	public void setPieceColor(Color pieceColor) {
		this.pieceColor = pieceColor;
	}
	
	public int getPieceNum() {
		return pieceNum;
	}

	public void setPieceNum(int pieceNum) {
		this.pieceNum = pieceNum;
	}
	
	public void decreasePieces(int pieceNum) {
		this.pieceNum -= pieceNum;
	}

	public void resetPlayer() {
		this.pieceNum = 12;
	}
	
	@Override
	public String toString() {
		if(this.pieceColor.equals(Color.white)) {
			return "White's Turn";
		} else {
			return "Grays Turn";
		}
	}
}
