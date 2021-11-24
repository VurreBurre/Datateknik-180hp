package ovn8;
import java.util.Random;

import se.lth.cs.window.SimpleWindow;

public class TrutleRace {

	public static void main(String[] args) {
		RaceTrack track = new RaceTrack(600, 200);
		SimpleWindow w = new SimpleWindow(800, 800, "TurtleRace");
		Turtle player1 = new Turtle(w, 250, 600);
		Turtle player2 = new Turtle(w, 450, 600);
		RacingEvent event = new RacingEvent(track, player1, player2);
	
	
		
		
		track.WindowSize(800, 800);
		track.draw(w);
		w.waitForMouseClick();
		event.run();
	
		
	}

}
