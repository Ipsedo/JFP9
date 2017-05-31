import java.util.Scanner;


public class Main {

	public static void main(String args[]) {
		
		Scanner scan;
		String line;
		Plateau p;
		Direction[] m;
		
		// CHeck for the challenge
		if (args.length < 2) {
			return;
		}
		switch (args[1]) {
		
		case "epreuve1":

			
			// Send the name
			scan = new Scanner(System.in);
			line = scan.nextLine();
			scan.nextLine();
			
			if (line.equals("NAME?")) {
				System.out.println("JFPDIX");
			}
			
			p = new Plateau(scan);
			m = p.mouvementsPossibles(0);
			System.out.println(m[(int)(Math.random()*m.length)]);

			scan.close();
			
			break;
			
		case "epreuve2":
			
			// Send the name
			scan = new Scanner(System.in);
			line = scan.nextLine();
			scan.nextLine();
			
			if (line.equals("NAME?")) {
				System.out.println("JFPDIX");
			}

			do {
				p = new Plateau(scan);
				System.out.println(p.getPathToBonus(0));
			} while (p.getNbTour() > 0);

			scan.close();
			
			break;
			
		case "battle":
			
			// TODO
			
			break;
			
		default:
			System.err.println("Error: Incorrect parameter!\nIt should be:\n	- epreuve1\n	- epreuve2\n	- epreuve3\n	- epreuve4\n	- battle");
			
		}
		
	}
	
}
