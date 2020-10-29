package Game;

public class Board {
	private Board board;
	private PieceSet[] pieceSets;
	private Square[][] squares;
	
	public Board() {
		
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public Square[][] getCurrentLayout() {
		return this.squares;
	}
	
	public void resetBoard() {
		
	}
}
