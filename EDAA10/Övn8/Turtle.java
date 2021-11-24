package ovn8;
import se.lth.cs.window.SimpleWindow;

public class Turtle {
private SimpleWindow w;
 private int xHome;
 private int yHome;
 private boolean pen;
 private double beta;
 private int newX;
 private int newY;
 
 
  /** skapar en sköldpadda som ritar i ritfönstret w. 
      Från början befinner sig sköldpaddan i punkten xHome,yHome med pennan 
      lyft och huvudet pekande rakt uppåt i fönstret, dvs i negativ y-riktning  
  */
  Turtle(SimpleWindow w, int xHome, int yHome) {
	  this.w = w;
	  this.beta = (Math.PI/2);
	  this.xHome =xHome;
	  this.yHome =yHome;
	  pen = false;
	  
  }

  /** sänker pennan */
  void penDown() {
	  this.pen = true;
  }

  /** lyfter pennan */
  void penUp() {
	  this.pen = false;
  }

  /** går rakt framåt n pixlar i huvudets riktning */
  void forward(int n) {
	  w.moveTo(xHome, yHome);
	   xHome = (int)Math.round(xHome + n *Math.cos(beta));
	   yHome = (int)Math.round(yHome - n *Math.sin(beta));
	  if (pen) {
		  w.lineTo(xHome, yHome);
	  }
	
  }

  /** vrider huvudet beta grader åt vänster */
  void left(int beta) {
	  this.beta += Math.toRadians(beta);
	  
  }

  /** vrider hvudet beta grader åt höger */
  void right(int beta) {
	  this.beta -= Math.toRadians(beta);
  }

  /** går till punkten newX,newY utan att rita. 
      Pennans läge och huvudets riktning påverkas inte */
  void jumpTo(int newX, int newY) {
	   //w.moveTo(newX, newY);
		  xHome = newX;
		  yHome = newY;
	  
  }

  /** återställer huvudets riktning till den ursprungliga */
  void turnNorth() {
	  this.beta = (Math.PI/2);
  }

  /** tar reda på sköldpaddans aktuella x-koordinat */
  int getX() {
	  return xHome;
  }

  /** tar reda på sköldpaddans aktuella y-koordinat */
  int getY() {
	  return yHome;
  }
}
