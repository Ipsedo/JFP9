
public class Player {

	private String name;
	private int productivity;
	private int power;
	private int score;
	private int nbCodeSource;
	private int linePos;
	private int columnPos;
	
	public Player(String name, int productivity, int power, int score, int nbCodeSource, int linePos, int columnPos) {
		this.name = name;
		this.productivity = productivity;
		this.power = power;
		this.score = score;
		this.nbCodeSource = nbCodeSource;
		this.linePos = linePos;
		this.columnPos = columnPos;
	}
}