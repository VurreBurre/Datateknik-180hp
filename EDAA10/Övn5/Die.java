import java.util.Random;

public class Die {
	private Random rand;
	private int diceroll;
	

	public Die () {
		rand = new Random();
		roll();
	}
	
	public void roll() {
		diceroll = 1+ rand.nextInt(6);
		
	}
	
   public int getResult() {
	return diceroll;
}
}
