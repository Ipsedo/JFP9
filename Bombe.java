public class Bombe {
	
	private int player;
	private int power;
	private int nbTour;
	private int i;
	private int j;
	
	public Bombe(int player, int power, int nbTour, int i, int j){
		this.i=i;
		this.j=j;
		this.player=player;
		this.power=power;
		this.nbTour=nbTour;
	}
	
	public boolean isInDanger(int i, int j){
		if(this.i == i){
			if(this.j+this.power>= j && this.j-this.power<=j){
				return true;
			}
		}else if(this.j == j){
			if(this.i+this.power>= i && this.i-this.power<=i){
				return true;
			}
		}
		return false;
	}
	
	public int getI() {
		return this.i;
	}
	
	public int getJ() {
		return this.j;
	}
}