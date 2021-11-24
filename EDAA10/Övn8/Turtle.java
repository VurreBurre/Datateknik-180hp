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
 
 
  /** skapar en sk�ldpadda som ritar i ritf�nstret w. 
      Fr�n b�rjan befinner sig sk�ldpaddan i punkten xHome,yHome med pennan 
      lyft och huvudet pekande rakt upp�t i f�nstret, dvs i negativ y-riktning  
  */
  Turtle(SimpleWindow w, int xHome, int yHome) {
	  this.w = w;
	  this.beta = (Math.PI/2);
	  this.xHome =xHome;
	  this.yHome =yHome;
	  pen = false;
	  
  }

  /** s�nker pennan */
  void penDown() {
	  this.pen = true;
  }

  /** lyfter pennan */
  void penUp() {
	  this.pen = false;
  }

  /** g�r rakt fram�t n pixlar i huvudets riktning */
  void forward(int n) {
	  w.moveTo(xHome, yHome);
	   xHome = (int)Math.round(xHome + n *Math.cos(beta));
	   yHome = (int)Math.round(yHome - n *Math.sin(beta));
	  if (pen) {
		  w.lineTo(xHome, yHome);
	  }
	
  }

  /** vrider huvudet beta grader �t v�nster */
  void left(int beta) {
	  this.beta += Math.toRadians(beta);
	  
  }

  /** vrider hvudet beta grader �t h�ger */
  void right(int beta) {
	  this.beta -= Math.toRadians(beta);
  }

  /** g�r till punkten newX,newY utan att rita. 
      Pennans l�ge och huvudets riktning p�verkas inte */
  void jumpTo(int newX, int newY) {
	   //w.moveTo(newX, newY);
		  xHome = newX;
		  yHome = newY;
	  
  }

  /** �terst�ller huvudets riktning till den ursprungliga */
  void turnNorth() {
	  this.beta = (Math.PI/2);
  }

  /** tar reda p� sk�ldpaddans aktuella x-koordinat */
  int getX() {
	  return xHome;
  }

  /** tar reda p� sk�ldpaddans aktuella y-koordinat */
  int getY() {
	  return yHome;
  }
}
