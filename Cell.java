public class Cell {
    public static char INDESTRUCTIBLE_BLOC = 'X';
    public static char DESTRUCTIBLE_BLOC = 'O';
    public static char DESTRUCTIBLE_BLOC_POWER_BONUS = 'Y';
    public static char DESTRUCTIBLE_BLOC_PRODUC_BONUS = 'Z';
    public static char FREE_CELL = 'G';
    public static char POWER_BONUS = 'H';
    public static char PRODUC_BONUS = 'I';
 
    private char cellState;
    private int i;
    private int j;
    private Cell dijkstraPredecesseur;
    private int poidsDijkstra;
 
    public Cell(char cellState, int i, int j) {
        this.cellState = cellState;
        this.i = i;
        this.j = j;
    }
 
    public void changeState(char newState) {
        this.cellState = newState;
    }
   
    public void setWeightDijkstra(int weight) {
        this.poidsDijkstra = weight;
    }
   
    public void setPredecesseurDijkstra(Cell predecesseur) {
        this.dijkstraPredecesseur = predecesseur;
    }
   
    public int getWeight() {
        return this.poidsDijkstra;
    }
   
    public Cell getPredecesseur() {
        return this.dijkstraPredecesseur;
    }
 
    public char getCellState() {
        return this.cellState;
    }
 
    public int getI() {
        return this.i;
    }
 
    public int getJ() {
        return this.j;
    }
   
    public Direction getDirection(Cell c) {
    	
        int dI = c.i - this.i;
        int dJ = c.j - this.j;
        if(dI > 0) {
            return Direction.DOWN;
        } else if(dI < 0) {
            return Direction.UP;
        } else if(dJ > 0) {
            return Direction.RIGHT;
        } else if(dJ < 0) {
            return Direction.LEFT;
        }
        return Direction.NOP;
    }
 
    @Override
    public String toString() {
        return Character.toString(cellState);
    }
}