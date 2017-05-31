public class Player {

	private String name;
	private int productivity;
	private int power;
	private int score;
	private int nbCodeSource;
	private int i;
	private int j;

	public Player(String name, int productivity, int power, int score,
			int nbCodeSource, int linePos, int columnPos) {
		this.name = name;
		this.productivity = productivity;
		this.power = power;
		this.score = score;
		this.nbCodeSource = nbCodeSource;
		this.i = columnPos;
		this.j = linePos;
	}

	public void move(Direction move) {
		this.i += move.dI();
		this.j += move.dJ();
	}
	
	public int getI() {
		return this.i;
	}
	
	public int getJ() {
		return this.j;
	}
}
