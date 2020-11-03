package Game;

import java.awt.Rectangle;



public class Square {
	private int x;
	private int y;
	private int size;
	private boolean isVisible;
	private String color;
	
	Square(int size, int x, int y, String color){
		this.size = size;
		this.x = x;
		this.y = y;
		this.color = color;
		
	}

	protected void draw() {
	// TODO Auto-generated method stub
	if(isVisible) {
		frame canvas = frame.getCanvas();
		canvas.draw(this, color, new Rectangle(x, y, 40, 40));
		
	}
	}
	public void makeVisible()
	{
		isVisible = true;
		draw();
	}
}