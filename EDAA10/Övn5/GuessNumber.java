import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {
		
		int guess = 0;
		int counter = 0;

		Scanner scan = new Scanner(System.in);
		System.out.println("Skriv in min och max");
		int min = scan.nextInt();
		int max = scan.nextInt();
		NumberGenerator g = new NumberGenerator(min, max);
		g.drawNbr();
		while (!(g.isEqual(guess))) {
			counter ++;
			System.out.println("Gissa ett tal från " + g.getMin() + " till " + g.getMax());
			guess = scan.nextInt();
			if (g.isBiggerThan(guess)) {
				System.out.println("Talet är större, \nantal försök: " + counter);

			} else  if(!(g.isEqual(guess))){
				System.out.println("Talet är mindre, \nantal försök: " + counter);
			}

		}
		System.out.println("Grattis du gissade rätt! \nAntal försök: " + counter) ;

	}

}
