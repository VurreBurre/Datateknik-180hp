import java.util.Random;

public class CardDeck {
	private Card[] theCards;
	private int kortkort = 0;
	int getkortnummer = 51;
	

	public CardDeck() {
		theCards = new Card[52];
		for(int suit= Card.SPADES; suit <= Card.CLUBS; suit++) {
			for(int rank = 1; rank < 14; rank++) {
			theCards[kortkort] = new Card(suit, rank);
			kortkort++;
				
			}
		}
			
		
	}
	
	public void shuffle() {
		getkortnummer= 51;
		Random rand = new Random();
		for(int i = 51; i >=1; i--) {
			int nr = rand.nextInt(i);
				Card help = theCards[nr];
				theCards[nr] = theCards[i];
				theCards[i] = help;
					}
		
	
	}
	public boolean moreCards() {
		
		
		if(getkortnummer >= 0) {
			return true;
		}
	return false;
		
	}
		
	
	public Card getCard() {
		getkortnummer--;
		
		return theCards[getkortnummer +1];
		
	}
}
