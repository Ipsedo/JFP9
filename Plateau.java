import java.util.ArrayList;

public class Plateau {

	private ArrayList<Player> players;
	private int toursRestants;
	private int lineSize;
	private int columnSize;

	private Cell[][] plateau;

	public enum Move {
		UP, DOWN, LEFT, RIGHT
	};

	private Plateau(ArrayList<Player> players, int tourRestants, int lineSize,
			int columnSize) {
		this.players = players;
		this.toursRestants = tourRestants;
		this.lineSize = lineSize;
		this.columnSize = columnSize;
	}

	public void move(int joueur, Plateau.Move move) {
		if (this.isCorrectMove(joueur, move)) {
			this.players.get(joueur).move(move);
		}
	}

	private boolean isCorrectMove(int joueur, Plateau.Move move) {
		return false;
	}
}
