
public class Frog {
	private int x;
	private int y;
	
	
	public Frog(int x,int y){
		x = 0;
		y = 0;
		
	} public int getX(){
		return x;
		
		
	}public int getY(){
		return y;
		
	}public void jumpNorth(){
		y =+ 1;
		
	}public void jumpEast(){
		x +=1;
		
		
	}public void jumpSouth(){
		y =- 1;
		
		
	}public void jumpWest(){
		x =- 1;
	}

}
