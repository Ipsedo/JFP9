import java.util.ArrayList;


public class Plateau {
 
	private ArrayList<Player> players;
	private int toursRestants;
	private int lineSize;
	private int columnSize;
	
	private Cell[][] plateau;
	
	private Plateau(ArrayList<Player> players, int tourRestants, int lineSize, int columnSize) {
		this.players = players;
		this.toursRestants = tourRestants;
		this.lineSize = lineSize;
		this.columnSize = columnSize;
	}
}
