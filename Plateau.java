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
	
	public void inti(Scanner scan){
		
		String line = scan.nextLine();
		System.out.println(line);
		String[] lineCut = line.split(" ");
		this.nbPlayer = lineCut[0];
		this.nbTour = lineCut[1];
		this.joueures = new Player[this.nbPlayer];
		for(int i=0;i<this.nbPlayer;i++){
			line = scan.nextLine();
			lineCut = line.split(" ");
			this.joueures[i] = new Player(lineCut[0],lineCut[1],lineCut[2],lineCut[3],lineCut[4],lineCut[5],lineCut[6]);
		}
		line = scan.nextLine();
		lineCut = line.split(" ");
		this.L = lineCut[0];
		this.C = lineCut[1];
		this.plateau = new Plateau[this.L][this.C];
		for(int i=0;i<this.L; i++){
			line = scan.nextLine();
			lineCut = line.split("|");
			for(int j = 0;j<this.C; j++){
				this.plateau[i][j] = new Cell(lineCut[j+1]);
			}
		}
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
