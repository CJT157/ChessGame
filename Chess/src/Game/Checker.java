package Game;

import java.awt.Color;

public class Checker extends Piece {
	private boolean promoted;
	private Piece promoteTo;
	
	public Checker(Color color) {
		super(color);
	}
	
	@Override
	public Square[] canMove(Square[] currentBoard) {
		Square[] possibleLocations = new Square[4];
		//Use currentLocation to reference currentBoard
		
		//return [i1j1, i2j2]
		return possibleLocations;
	}
	
	@Override
	public boolean captured() {
		
		return false;
	}
}
