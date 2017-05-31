public class Cell {
	public static char INDESTRUCTIBLE_BLOC = 'X';
	public static char DESTRUCTIBLE_BLOC = 'O';
	public static char DESTRUCTIBLE_BLOC_POWER_BONUS = 'Y';
	public static char DESTRUCTIBLE_BLOC_PRODUC_BONUS = 'Z';
	public static char FREE_CELL = 'G';
	public static char POWER_BONUS = 'H';
	public static char PRODUC_BONUS = 'I';

	private char cellState;

	public Cell(char cellState) {
		this.cellState = cellState;
	}

	public void changeState(char newState) {
		this.cellState = newState;
	}
	
	public char getCellState() {
		return this.cellState;
	}
	
	@Override
	public String toString() {
		return Character.toString(cellState);
	}
	
}
