package Game;

import java.awt.Color;

public class Player {
	private Color pieceColor;
	private int pieceNum;
	
	/**
	 * Constructor for player
	 * @param pieceColor the color of the player
	 */
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
	
	public void decreasePieces(int pieces) {
		this.pieceNum -= pieces;
	}

	public void resetPlayer() {
		this.pieceNum = 12;
	}
	
	/**
	 * Returns the current players color to get the turn string
	 */
	@Override
	public String toString() {
		if (this.pieceColor.equals(Color.white)) {
			return "White's Turn";
		} 
		return "Gray's Turn";
	}
}
