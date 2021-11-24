
public class LifeController {

	public static void main(String[] args) {

		LifeBoard board = new LifeBoard(10, 10);
		LifeView window = new LifeView(board);
		Life life = new Life(board);

		while (true) {
			int a = window.getCommand();

			if (a == 1) {
				life.flip(window.getRow(), window.getCol());
				window.update();
			} else if (a == 2) {
				life.newGeneration();
				window.update();
			} else if (a == 3) {
				System.exit(0);
				
			}

		}

	}
}
