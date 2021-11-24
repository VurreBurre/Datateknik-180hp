package ovn8;
import java.util.Random;

import se.lth.cs.window.SimpleWindow;

public class RacingEvent {
private RaceTrack track;
private Turtle p1;
private Turtle p2;
private Random rand = new Random();


	public RacingEvent(RaceTrack track, Turtle p1, Turtle p2) {
		this.p1 = p1;
		this.p2 = p2;
		
		this.track = track;
		

	}
	
	public void run() {
		
			
		
		while((p1.getY() > track.getyFinish() && p2.getY() > track.getyFinish())) {
			
		int steg = rand.nextInt(2);
		p1.penDown();
		p2.penDown();
		p1.forward(steg);
		steg =  rand.nextInt(2);
		p2.forward(steg);
	    SimpleWindow.delay(10);
	   
	    if (p1.getY() <= track.getyFinish()) {
			System.out.println("Turtle 1 vann!");
			
		} else if (p2.getY() <= track.getyFinish()) {
			System.out.println("Turtle 2 vann!");
		}

	} 
	}
}
