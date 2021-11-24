public class LifeBoard {
	
	private boolean[][] grid;
	private int generation;
	private int rows; 
	private int cols;
	/** Skapar en spelplan med rows rader och cols kolonner. Spelplanen �r fr�n
	    b�rjan tom, dvs alla rutorna �r tomma och generationsnumret �r 1. */	
	public LifeBoard(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		grid = new boolean[rows][cols];
		generation =1;
		
		
	}

	
	public boolean get(int row, int col) {
		if (row >= rows || col >= cols || row < 0 || col < 0) {
			return false;
		}
		return grid[row][col];
	}

	/** Lagrar v�rdet val i rutan med index row, col */
	public void put(int row, int col, boolean val) {
		grid[row][col] = val;
	}

	/** Tar reda p� antalet rader */
	public int getRows() {
		return rows;
	}

 	/** Tar reda p� antalet kolonner */
	public int getCols() {
		return cols;
	}

	/** Tar reda p� aktuellt generationsnummer */
	public int getGeneration() {
		return generation;
	}

	/** �kar generationsnumret med ett */
	public void increaseGeneration() {
		generation ++;
	}
}