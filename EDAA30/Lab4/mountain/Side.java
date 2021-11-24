package mountain;

public class Side {
	Point p1;
	Point p2;
	private int distance;
	
	public Side(Point p1, Point p2) {
			this.p1 = p1;
			this.p2 = p2;
			distance =  (int) Math.hypot(p1.getX()-p2.getX(), p1.getY()-p2.getY());
	}
	public Point getP1() {
		return p1;
		
	}
	
	public Point getP2() {
		
		return p2;
	}
	
	
	public int getMid(Point p1,Point p2){
		int distance = (int) Math.hypot(p1.getX()-p2.getX(), p1.getY()-p2.getY());
		return distance;
		
	}
	@Override
	public boolean equals(Object obj) {
		Side side = (Side) obj;
		if (this == obj) {
			return true;
		}else {
			return (((p1 == side.getP1() && p2 == side.getP2()) || ((p2 == side.getP1() && p1 == side.getP2()) )));
			}
	
			
		}
		@Override
	public int hashCode() {
		return p1.hashCode() + p2.hashCode();
	}

}
