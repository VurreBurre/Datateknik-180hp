import java.util.ArrayList;

import se.lth.cs.window.SimpleWindow;


public class ShapeList {
	private ArrayList<Shape> list;
	private Shape shape;

	public ShapeList() {
		list = new ArrayList<Shape>();
	
	}
	
	public void insert(Shape s) {
		list.add(s);
		
	}
	public void draw(SimpleWindow w) {
		
		
	}
	
	public Shape findHit(int xc, int yc) {
		
		
		return null;
		
	}

}
