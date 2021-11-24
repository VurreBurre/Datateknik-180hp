import se.lth.cs.window.*;
//import se.lth.cs.p.ovn.turtle.Turtle;


public class DrawSquare {

  public static void main(String[] args) {
    SimpleWindow w = new SimpleWindow(600,600,"Square");
    
    Turtle t = new Turtle(w,100,200);
    t.penDown();
    for (int k=1; k<=4; k++) {
      t.right(90);
      t.forward(300);
      
    }
      while (true) {
    	  t.penDown();
		w.waitForMouseClick();
		int a  = w.getMouseX();
		int b = w.getMouseY();
		t.jumpTo(a, b);
		for (int i = 1; i <=4; i++) {
			t.right(90);
		      t.forward(300);
		}
      }
      }


  }