public class LifeBoard {
	
	private boolean[][] grid;
	private int generation;
	private int rows; 
	private int cols;
	/** Skapar en spelplan med rows rader och cols kolonner. Spelplanen är från
	    början tom, dvs alla rutorna är tomma och generationsnumret är 1. */	
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

	/** Lagrar värdet val i rutan med index row, col */
	public void put(int row, int col, boolean val) {
		grid[row][col] = val;
	}

	/** Tar reda på antalet rader */
	public int getRows() {
		return rows;
	}

 	/** Tar reda på antalet kolonner */
	public int getCols() {
		return cols;
	}

	/** Tar reda på aktuellt generationsnummer */
	public int getGeneration() {
		return generation;
	}

	/** Ökar generationsnumret med ett */
	public void increaseGeneration() {
		generation ++;
	}
}