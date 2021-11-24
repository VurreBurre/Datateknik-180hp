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
			System.out.println("Gissa ett tal fr�n " + g.getMin() + " till " + g.getMax());
			guess = scan.nextInt();
			if (g.isBiggerThan(guess)) {
				System.out.println("Talet �r st�rre, \nantal f�rs�k: " + counter);

			} else  if(!(g.isEqual(guess))){
				System.out.println("Talet �r mindre, \nantal f�rs�k: " + counter);
			}

		}
		System.out.println("Grattis du gissade r�tt! \nAntal f�rs�k: " + counter) ;

	}

}
