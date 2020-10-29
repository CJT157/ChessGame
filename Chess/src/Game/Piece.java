package Game;

public abstract class Piece {
	private String pieceColor;
	private boolean moved;
	private Square currentLocation;

	public abstract Square[] canMove(Square[] currentBoard);
	
	public abstract boolean captured();
}
