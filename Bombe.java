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
	
	public boolean isInDanger(Player player){
		if(this.i == player.getI()){
			if(this.j+this.power>= player.getJ() && this.j-this.power<=player.getJ()){
				return true;
			}
		}else if(this.j == player.getJ()){
			if(this.i+this.power>= player.getJ() && this.i-this.power<=player.getJ()){
				return true;
			}
		}
		return false;
	}
}