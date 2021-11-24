
public class Life {
	private LifeBoard board;

	public Life(LifeBoard board) {
		this.board = board;

	}

	public void newGeneration() {
		board.increaseGeneration();
		boolean[][] newBoard = new boolean[board.getRows()][board.getCols()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {

				int antal = getNeighbours(board, i, j);
				System.out.println(antal);
				if (antal == 2 || antal == 3) {
					newBoard[i][j] = board.get(i, j);
				} else if (antal >= 4 || antal <= 1) {
					newBoard[i][j] = false;

				}

				if (!board.get(i, j)) {
					antal = getNeighbours(board, i, j);
					if (antal == 3) {
						newBoard[i][j] = true;
					}
				}
			}
		}
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				board.put(i, j, newBoard[i][j]);
			}
		}

	}

	private int getNeighbours(LifeBoard board, int row, int col) {

		int antal = 0;
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {

				if (board.get(i, j)) {
					antal++;
				}
			}
		}
		if (board.get(row, col)) {
			antal--;
		}

		return antal;

	}

	public void flip(int row, int col) {
		if (board.get(row, col)) {
			board.put(row, col, false);
		} else if (!(board.get(row, col))) {
			board.put(row, col, true);
		}
	}

}
