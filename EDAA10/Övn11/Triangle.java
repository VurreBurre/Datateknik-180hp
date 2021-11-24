import se.lth.cs.window.SimpleWindow;

public class Triangle extends Shape{
private int side;
	public Triangle(int x, int y, int side) {
		super(x,y);
		this.side = side;
	}

	@Override
	public void draw(SimpleWindow w) {
		double y=0;
		double realY;
		y = Math.pow(side, 2)-Math.pow(side/2, 2);
		realY =Math.sqrt(y);
		
		
		w.moveTo(super.x, super.y);
		w.lineTo(super.x+=(side/2), super.y -=realY);
		w.lineTo(super.x+=(side/2), super.y +=realY);
		w.lineTo(super.x-=side, super.y);
		
		
	}

}
