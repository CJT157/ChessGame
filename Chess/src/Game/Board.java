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
		Board myObj = new Board();
		myObj.create();
		System.out.print("need to be able to get the peaces ");
	}
	public void startBoard() {
		//I do the same job as resetBoard but I get my own method OwO
		resetBoard();
		
	}
	
	private void create() {
		frame.getCanvas();

		// TODO: DECLARE A 2D ARRAY OF Square(S) HERE
		// TODO: MAKE THE ARRAY 8 BY 8
		final int DIMX = 8;
		//change mepls
		final int temp = 40;
		Square [][] checkerBoard = new Square[DIMX][];
		//CircleOld [][] checkerBoard = new CircleOld[DIMX][];

		String color;
		for(int i = 0; i < checkerBoard.length; i++) {
			checkerBoard[i] =new Square[checkerBoard.length];
			for(int j = 0; j < checkerBoard[i].length; j++) {
				if((i + j) % 2 == 1) {
					color = "black";
					checkerBoard[i][j] = new Square(temp, j * temp + temp, i * temp + temp, color);

				}
				else {
					color = "red";
					checkerBoard[i][j] = new Square(temp, j * temp + temp, i * temp + temp, color);
				}
				
				checkerBoard[i][j].makeVisible();

			}
		}
	} 
}
