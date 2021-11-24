
public class Tarningspel {
	

	public static void main(String[] args) {
		Die d = new Die();
		int poang1 = 0;
		int poang2 = 0;
		
		
		
		while (!(poang1 > 100 || poang2 > 100)) {
			d.roll();
			poang1 += d.getResult();
			System.out.println(poang1);
			
			if (poang1 < 100) {
				d.roll();
				poang2 += d.getResult();
				System.out.println(poang2);
			}
		
			
			
			
			
		}if (poang1 > 100) {
			System.out.println("spelare 1 vann");
		}else {
			System.out.println("spelare 2 vann");
		}
		
	}

}
