public class Player {

	private String name;
	private int productivity;
	private int power;
	private int score;
	private int nbCodeSource;
	private int linePos;
	private int columnPos;

	public Player(String name, int productivity, int power, int score,
			int nbCodeSource, int linePos, int columnPos) {
		this.name = name;
		this.productivity = productivity;
		this.power = power;
		this.score = score;
		this.nbCodeSource = nbCodeSource;
		this.linePos = linePos;
		this.columnPos = columnPos;
	}

	public void move(Direction move) {
		this.linePos += move.dJ();
		this.columnPos += move.dI();
	}
	
	public int getLine() {
		return this.linePos;
	}
	
	public int getColumn() {
		return this.columnPos;
	}
}
