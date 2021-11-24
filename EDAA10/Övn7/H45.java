import java.util.Random;

//import se.lth.cs.p.ovn.turtle.Turtle;
import se.lth.cs.window.SimpleWindow;

public class H45 {

	public static void main(String[] args) {

		SimpleWindow w = new SimpleWindow(600,600,"Square");
	    Random rand = new Random();
	    Turtle t = new Turtle(w,250,250);
	    Turtle t2 = new Turtle(w, 350, 350);
	    double t1x = t.getX();
	    double t1y = t.getY();
	    double t2x = t2.getX();
	    double t2y = t2.getY();
	    t.penDown();
	    t2.penDown();
	    
	    
	    
	    while (Math.sqrt(Math.pow(t2x - t1x, 2) + Math.pow(t2y - t1y, 2)) > 50) {
	    	
	    	int steg = 1 + rand.nextInt(10);
	    	int vinkel = -179 + rand.nextInt(360); 
	    	t.forward(steg);
	    	t.right(vinkel);
	    	steg = 1 + rand.nextInt(10);
	    	vinkel = -179 + rand.nextInt(360);
	    	t2.forward(steg);
	    	t2.right(vinkel);
	    SimpleWindow.delay(1);
	    	t1x = t.getX();
	    	t1y = t.getY();
	    	t2x = t2.getX();
	    	t2y = t2.getY();
	    	System.out.println(t.getX() - t2.getY());
	    }
	}

}
