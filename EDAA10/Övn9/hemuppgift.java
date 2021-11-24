
public class hemuppgift {
	
	

	public static void main(String[] args) {
		 int fail = 0;
		 double success =0;
		 int k;
		CardDeck deck = new CardDeck();
		
			for (k = 0; k < 1000000; k++) {
				deck.shuffle();
				
				int klocka =1;
				while (deck.moreCards()) {
					Card card = deck.getCard();
					if (klocka == 4) {
						klocka = klocka -3;
					}
				if (klocka ==1 && card.getRank() == 1) {
					fail++;
					break;
					
				}else if (klocka  == 2 && card.getRank() == 2) {
					fail++;
					break;
					
					
					
				}else if (klocka ==3 && card.getRank()== 3) {
					fail++;
					break;
				
			}else {
				klocka++;
			}	
		}
		
		}
			success = k -fail;
			double procent = (success/k); 
			System.out.println("failed: " + fail + " success: " + success + "procent " + procent);
			
		
		
	}

}
