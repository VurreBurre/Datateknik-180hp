import se.lth.cs.window.SimpleWindow;

public class Square extends Shape{
	private int side;
	
	

	public Square(int x, int y, int side) {
		super(x,y);
		this.side = side;
		
	
	}

	@Override
	public void draw(SimpleWindow w) {
		
		w.moveTo(super.x, super.y);
		w.lineTo(super.x, super.y+=side);
		w.lineTo(super.x+=side, super.y);
		w.lineTo(super.x, super.y-=side);
		w.lineTo(super.x-=side, super.y);
		
		
	}
	
	

	

}
