import java.util.ArrayList;
import java.util.Scanner;

public class Plateau {

	private Cell[][] plateau;
	private int nbPlayer;
	private String nbTour;
	private Player[] joueurs;
	private int L;
	private int C;

	public enum Move {
		UP, DOWN, LEFT, RIGHT
	};

	public Plateau(Scanner scan) {
		this.inti(scan);
	}

	public void inti(Scanner scan) {

		String line = scan.nextLine();
		System.out.println(line);
		String[] lineCut = line.split(" ");
		this.nbPlayer = Integer.parseInt(lineCut[0]);
		this.nbTour = lineCut[1];
		this.joueurs = new Player[this.nbPlayer];
		for (int i = 0; i < this.nbPlayer; i++) {
			line = scan.nextLine();
			lineCut = line.split(" ");
			this.joueurs[i] = new Player(lineCut[0],
					Integer.parseInt(lineCut[1]), Integer.parseInt(lineCut[2]),
					Integer.parseInt(lineCut[3]), Integer.parseInt(lineCut[4]),
					Integer.parseInt(lineCut[5]), Integer.parseInt(lineCut[6]));
		}
		line = scan.nextLine();
		lineCut = line.split(" ");
		this.L = Integer.parseInt(lineCut[0]);
		this.C = Integer.parseInt(lineCut[1]);
		this.plateau = new Cell[this.L][this.C];
		for (int i = 0; i < this.L; i++) {
			line = scan.nextLine();
			lineCut = line.split("|");
			for (int j = 0; j < this.C; j++) {
				this.plateau[i][j] = new Cell(lineCut[j + 1].toCharArray()[0]);
			}
		}
	}

	public void move(int joueur, Plateau.Move move) {
		if (this.isCorrectMove(joueur, move)) {
			this.joueurs[joueur].move(move);
		}
	}

	private boolean isCorrectMove(int joueur, Plateau.Move move) {
		return false;
	}
	
	public Plateau.Move[] mouvementsPossibles(int joueur) {
		ArrayList<Plateau.Move> tmp = new ArrayList<Plateau.Move>();
		return tmp.toArray(new Plateau.Move[tmp.size()]);
	}
}