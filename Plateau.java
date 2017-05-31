import java.util.ArrayList;
import java.util.Scanner;

public class Plateau {

	private Cell[][] plateau;
	private int nbPlayer;
	private String nbTour;
	private Player[] joueurs;
	private int L;
	private int C;

	public Plateau(Scanner scan) {
		this.inti(scan);
	}

	public void inti(Scanner scan) {

		String line = scan.nextLine();
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
			lineCut = line.split("\\|");
			for (int j = 0; j < this.C; j++) {
				this.plateau[i][j] = new Cell(lineCut[j + 1].toCharArray()[0]);
			}
		}
		scan.nextLine();
	}

	public void move(int joueur, Direction move) {
		if (this.isCorrectMove(joueur, move)) {
			this.joueurs[joueur].move(move);
		}
	}

	private boolean isCorrectMove(int joueur, Direction move) {
		return false;
	}

	public Direction[] mouvementsPossibles(int joueur) {
		ArrayList<Direction> tmp = new ArrayList<Direction>();
		for (Direction d : Direction.getAllDirection()) {
			if (this.plateau[this.joueurs[joueur].getI() + d.dI()][this.joueurs[joueur]
					.getJ() + d.dJ()].getCellState() == Cell.FREE_CELL
					|| this.plateau[this.joueurs[joueur].getI() + d.dI()][this.joueurs[joueur]
							.getJ() + d.dJ()].getCellState() == Cell.POWER_BONUS
					|| this.plateau[this.joueurs[joueur].getI() + d.dI()][this.joueurs[joueur]
							.getJ() + d.dJ()].getCellState() == Cell.PRODUC_BONUS) {
				tmp.add(d);
			}
		}
		return tmp.toArray(new Direction[tmp.size()]);
	}
	
	@Override
	public String toString() {
		String r = "";
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < C; j++) {
				r += plateau[i][j] + "|";
			}
			r += "\n";
		}
		return r;
	}
	
}
