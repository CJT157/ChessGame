package Game;

public class KingChecker extends Piece {

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
