package Game;

public abstract class Piece {
	private String pieceColor;
	private boolean moved;

	public abstract String canMove();
	
	public abstract boolean captured();
}
