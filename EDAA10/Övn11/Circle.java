import se.lth.cs.window.SimpleWindow;

public class Circle extends Shape{
	private int rad;

	public Circle(int x, int y, int side) {
		super(x,y);
		rad = side;
		
	}

	@Override
	public void draw(SimpleWindow w) {
		w.moveTo(super.x, super.y);
		w.moveTo(super.x +=rad, super.y);
		for (int i = 0; i <360; i++) {
			double x =  (Math.cos(Math.toRadians(i)) * rad);
			
			double y =  (Math.sin(Math.toRadians(i)) * rad);
			
			 int xx = (int) Math.round(x);
			 int yy = (int) Math.round(y);
			w.lineTo( super.x + xx ,super.y  + yy);
		}
		
		
	}

}
