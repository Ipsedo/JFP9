import java.util.ArrayList;
import java.util.Scanner;

public class Plateau {

	private Cell[][] plateau;
	private int nbPlayer;
	private int nbTour;
	private Player[] joueurs;
	private int L;
	private int C;
	private ArrayList<Bombe> BombeTab;

	public Plateau(Scanner scan) {
		this.inti(scan);
	}

	public void inti(Scanner scan) {

		String line = scan.nextLine();
		String[] lineCut = line.split(" ");
		this.nbPlayer = Integer.parseInt(lineCut[0]);
		this.nbTour = Integer.parseInt(lineCut[1]);
		this.joueurs = new Player[this.nbPlayer];
		for (int i = 0; i < this.nbPlayer; i++) {
			line = scan.nextLine();
			lineCut = line.split(" ");
			this.joueurs[i] = new Player(lineCut[0],
					Integer.parseInt(lineCut[1]), Integer.parseInt(lineCut[2]),
					Integer.parseInt(lineCut[3]), Integer.parseInt(lineCut[4]),
					Integer.parseInt(lineCut[5]), Integer.parseInt(lineCut[6]),
					Integer.parseInt(lineCut[7]));
		}
		line = scan.nextLine();
		lineCut = line.split(" ");
		this.L = Integer.parseInt(lineCut[0]);
		this.C = Integer.parseInt(lineCut[1]);
		this.plateau = new Cell[this.L][this.C];
		this.BombeTab = new ArrayList<Bombe>();
		for (int i = 0; i < this.L; i++) {
			line = scan.nextLine();
			lineCut = line.split("\\|");
			for (int j = 0; j < this.C; j++) {
				
				String[] cell  = lineCut[j + 1].split("/");
				this.plateau[i][j] = new Cell((cell[0]).toCharArray()[0], i, j);
				if(cell.length>1){
					for(int k=1;k<cell.length;k++){
						String[] celltmp = cell[k].split(",");
						this.BombeTab.add(new Bombe(Integer.parseInt(celltmp[0]), Integer.parseInt(celltmp[1]), Integer.parseInt(celltmp[2]),i,j));
					}
				}
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

		int newI = joueurs[joueur].getI() + move.dI();
		int newJ = joueurs[joueur].getJ() + move.dI();
		
		if (plateau[newI][newJ].getCellState() == Cell.FREE_CELL ||
				plateau[newI][newJ].getCellState() == Cell.POWER_BONUS ||
				plateau[newI][newJ].getCellState() == Cell.PRODUC_BONUS) {
			return true;
		}
		
		return false;
	}
	
	public Direction goInSafePlace(int joueur) {    	
    	Player p = this.joueurs[joueur];
    	
    	for(Bombe b : this.BombeTab) {
    		if(p.getI() > 0 && b.isInDanger(p.getI() - 1, p.getJ()) && this.isCorrectMove(joueur, Direction.UP)) {
    			return Direction.UP;
    		} else if(p.getI() < this.plateau.length - 1 && b.isInDanger(p.getI() + 1, p.getJ()) && this.isCorrectMove(joueur, Direction.DOWN)) {
    			return Direction.DOWN;
    		} else if(p.getJ() > 0 && b.isInDanger(p.getI(), p.getJ() - 1) && this.isCorrectMove(joueur, Direction.LEFT)) {
    			return Direction.LEFT;
    		} else if(p.getJ() < this.plateau[p.getI()].length && b.isInDanger(p.getI(), p.getJ() + 1) && this.isCorrectMove(joueur, Direction.RIGHT)) {
    			return Direction.RIGHT;
    		}
    	}
    	
    	for(Bombe b : this.BombeTab) {
    		int dX = b.getI() - p.getI();
    		int dY = b.getJ() - p.getJ();
    		if(Math.abs(dX) > Math.abs(dY)) {
    			if(dX > 0 && this.isCorrectMove(joueur, Direction.DOWN)) {
    				return Direction.DOWN;
    			} else if(this.isCorrectMove(joueur, Direction.UP)) {
    				return Direction.UP;
    			}
    		} else {
    			if(dY > 0 && this.isCorrectMove(joueur, Direction.RIGHT)) {
    				return Direction.RIGHT;
    			} else if(this.isCorrectMove(joueur, Direction.LEFT)) {
    				return Direction.LEFT;
    			}
    		}
    	}
    	return Direction.NOP;
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
	
	public int getNbTour() {
		return nbTour;
	}
	
	public Cell findH(){
		for(int i=0;i<this.L;i++){
			for(int j=0;j<this.C;j++){
				if(this.plateau[i][j].getCellState() == 'H'){
					return this.plateau[i][j];
				}
			}
		}
		return null;
	}
	
	public Direction[] CheminDeLanco(){
		Cell bonbon = this.findH();
		ArrayList<Direction> tmp = new ArrayList<Direction>();
		
		if(this.joueurs[0].getI()>bonbon.getI()){
			Direction d = Direction.UP;
			if (this.plateau[this.joueurs[0].getI() + d.dI()][this.joueurs[0]
					.getJ() + d.dJ()].getCellState() == Cell.FREE_CELL
					|| this.plateau[this.joueurs[0].getI() + d.dI()][this.joueurs[0]
							.getJ() + d.dJ()].getCellState() == Cell.POWER_BONUS
					|| this.plateau[this.joueurs[0].getI() + d.dI()][this.joueurs[0]
							.getJ() + d.dJ()].getCellState() == Cell.PRODUC_BONUS) {
				tmp.add(d);
			}
		}
		if(this.joueurs[0].getI()<bonbon.getI()){
			Direction d = Direction.DOWN;
			if (this.plateau[this.joueurs[0].getI() + d.dI()][this.joueurs[0]
					.getJ() + d.dJ()].getCellState() == Cell.FREE_CELL
					|| this.plateau[this.joueurs[0].getI() + d.dI()][this.joueurs[0]
							.getJ() + d.dJ()].getCellState() == Cell.POWER_BONUS
					|| this.plateau[this.joueurs[0].getI() + d.dI()][this.joueurs[0]
							.getJ() + d.dJ()].getCellState() == Cell.PRODUC_BONUS) {
				tmp.add(d);
			}
		}
		if(this.joueurs[0].getJ()>bonbon.getJ()){
			Direction d = Direction.LEFT;
			if (this.plateau[this.joueurs[0].getI() + d.dI()][this.joueurs[0]
					.getJ() + d.dJ()].getCellState() == Cell.FREE_CELL
					|| this.plateau[this.joueurs[0].getI() + d.dI()][this.joueurs[0]
							.getJ() + d.dJ()].getCellState() == Cell.POWER_BONUS
					|| this.plateau[this.joueurs[0].getI() + d.dI()][this.joueurs[0]
							.getJ() + d.dJ()].getCellState() == Cell.PRODUC_BONUS) {
				tmp.add(d);
			}
		}
		if(this.joueurs[0].getJ()<bonbon.getJ()){
			Direction d = Direction.RIGHT;
			if (this.plateau[this.joueurs[0].getI() + d.dI()][this.joueurs[0]
					.getJ() + d.dJ()].getCellState() == Cell.FREE_CELL
					|| this.plateau[this.joueurs[0].getI() + d.dI()][this.joueurs[0]
							.getJ() + d.dJ()].getCellState() == Cell.POWER_BONUS
					|| this.plateau[this.joueurs[0].getI() + d.dI()][this.joueurs[0]
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
	private ArrayList<Cell> findVoisins(Cell c) {
		ArrayList<Cell> tmp = new ArrayList<>();
		for (Direction d : Direction.getAllDirection()) {
			int i = c.getI() + d.dI();
			int j = c.getJ() + d.dJ();
			if (i >= 0 && i < this.plateau.length && j >= 0 && j < this.plateau[i].length &&
					(this.plateau[i][j].getCellState() == Cell.FREE_CELL
						|| this.plateau[i][j].getCellState() == Cell.POWER_BONUS
						|| this.plateau[i][j].getCellState() == Cell.PRODUC_BONUS)) {
				tmp.add(this.plateau[i][j]);
			}
		}
		return tmp;
	}
   
    private void initDijkstra(int i, int j) {
        for(Cell[] cL : this.plateau) {
            for(Cell c : cL) {
                c.setPredecesseurDijkstra(null);
                c.setWeightDijkstra(Integer.MAX_VALUE);
            }
        }
        this.plateau[i][j].setWeightDijkstra(0);
    }
   
    private Cell findMinDijkstra(ArrayList<Cell> frontiere) {
        int min = Integer.MAX_VALUE;
        Cell res = frontiere.get(0);
        for(Cell c : frontiere) {
            if(c.getWeight() < min) {
                min = c.getWeight();
                res = c;
            }
        }
        return res;
    }
   
    private void majDistDijkstra(Cell s1, Cell s2) {
        if(s2.getWeight() > s1.getWeight() + 1) {
            s2.setWeightDijkstra(s1.getWeight() + 1);
            s2.setPredecesseurDijkstra(s1);
        }
    }
   
      
    private String dijkstra(int iInit, int jInit, int iFinal, int jFinal) {
        this.initDijkstra(iInit, jInit);
        ArrayList<Cell> ens = new ArrayList<>();
        for(int i = 0; i < this.plateau.length; i++) {
            for(int j = 0; j < this.plateau[i].length; j++) {
                ens.add(this.plateau[i][j]);
            }
        }
        while(!ens.isEmpty()) {
            Cell s1 =  this.findMinDijkstra(ens);
            ens.remove(s1);
            ArrayList<Cell> voisins = this.findVoisins(s1);
            for(Cell s2 : voisins) {
                this.majDistDijkstra(s1, s2);
                if(s2.getI() == iFinal && s2.getJ() == jFinal) {
                    Cell parent = s2.getPredecesseur();
                    while(parent.getPredecesseur() != null) {
                        s2 = parent;
                        parent = s2.getPredecesseur();
                    }
                    System.out.println("Dji");
                    return this.plateau[iInit][jInit].getDirection(s2).toString();
                }
            }
        }
        
        // If dijiksdktrta failed then we call Lanco
        Direction[] ds = CheminDeLanco();
        
        if (ds.length == 0) {
        	
        	// Put a bomb
        	return "DEPLOY";
        	
        } else {
        	return ds[(int)(Math.random()*ds.length)].toString();
        }
    }
   
    public String getPathToBonus(int joueur) {
        int iInit = this.joueurs[joueur].getI();
        int jInit = this.joueurs[joueur].getJ();
        int iBonusPuissance = 0;
        int jBonusPuissance = 0;
        for(int i = 0; i < this.plateau.length; i++) {
            for(int j = 0; j < this.plateau[i].length; j++) {
                if(this.plateau[i][j].getCellState() == Cell.POWER_BONUS || this.plateau[i][j].getCellState() == Cell.PRODUC_BONUS) {
                    iBonusPuissance = i;
                    jBonusPuissance = j;
                }
            }
        }
        return this.dijkstra(iInit, jInit, iBonusPuissance, jBonusPuissance);
    }
    
    public ArrayList<Bombe> getNbBombe() {
    	return BombeTab;
    }
	
}