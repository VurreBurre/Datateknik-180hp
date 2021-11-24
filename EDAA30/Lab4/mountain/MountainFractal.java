package mountain;

import java.util.HashMap;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class MountainFractal extends Fractal{
		private Point p1, p2, p3;
		private double distance;
		private double dev;
		private Side side;
		private HashMap<Side, Point> map = new HashMap<Side, Point>();
		
		
		
	public MountainFractal(Point p1,Point  p2,Point  p3, double dev) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.dev = dev;
		distance = Math.hypot(p1.getX()-p2.getX(), p1.getY()-p2.getY());
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Fractal Maountain";
	}

	@Override
	public void draw(TurtleGraphics turtle) {
		turtle.moveTo(turtle.getWidth() / 2.0 - distance / 2.0,
				turtle.getHeight() / 2.0 + Math.sqrt(3.0) * distance / 4.0);

		fractalTriangle(turtle, order, p1, p2, p3, dev);
		
	}
	
	private void fractalTriangle(TurtleGraphics turtle, int order, Point p1, Point p2, Point p3,double dev) {
		if (order ==0) {
			turtle.moveTo(p1.getX(), p1.getY());
			turtle.forwardTo(p2.getX(), p2.getY());
			turtle.forwardTo(p3.getX(), p3.getY());
			turtle.forwardTo(p1.getX(), p1.getY());
					
		}else {	
			Point AB = midPoint(p1,p2, dev);
			Point BC = midPoint(p2, p3, dev);
			Point CA = midPoint(p3, p1, dev);
			fractalTriangle(turtle, order-1, p1, AB, CA, dev/2);
			fractalTriangle(turtle, order-1, AB, p2, BC, dev/2);
			fractalTriangle(turtle, order-1, BC, CA, p3, dev/2);
			fractalTriangle(turtle, order -1, AB, BC, CA, dev/2);
		}
	}
	private Point midPoint(Point p1, Point p2, double dev){
		Side side = new Side(p1, p2);

			if (map.containsKey(side)) {
			return	map.remove(side);
			}
			else {
				Point p = new Point((p1.getX() + p2.getX())/2, ((p1.getY() + p2.getY())/2) +(int) RandomUtilities.randFunc(dev));
				map.put(side, p);
				return p;
			}
	}
	
	
	
	
	
	
	

}
