
public class Registrering {

	public static void main(String[] args) {

		Die d1 = new Die(), d2 = new Die();
		int [] result = new int[13];
		
		for (int k = 0; k <=1000; k++) {
			
			d1.roll();
			d2.roll();
			int dots = d1.getResult() + d1.getResult();
			
			result[dots]++;//dots har ett värde ex 8 och matchar result[8] och plussar det som är där inne med 1, därför ++
			
			
		}
	}

}
