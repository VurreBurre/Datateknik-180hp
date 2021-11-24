
public class Point {
	private int x;
	private int y;
	private int dx;
	private int dy;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		
		
	}
	public int getX() {
		return this.x;
		
	}
		public int getY() {
			return this.y;
		
	}
		public void move(int dx, int dy) {
				x= x +dx;
				y = y +dy;
			
		}

		public String toString() {
			 
			String stringx = Integer.toString(x);
			
			String stringy = Integer.toString(y);
			return stringx + stringy;
	
		} 
		
		public double distanceTo(Point p) {
			double diffx = Math.abs(p.x - this.x);
			double diffy = Math.abs(p.y - this.y);
			return diffx + diffy;
		}
		}


