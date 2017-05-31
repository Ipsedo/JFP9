import java.util.Scanner;


public class Main {

	public static void main(String args[]) {
		
		// Send the name
		
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		
		if (line.equals("NAME?")) {
			System.out.println("JFPDIX");
		}
		
		// CHeck for the challenge
		if (args.length < 2) {
			return;
		}
		switch (args[1]) {
		
		case "epreuve1":
			
			Plateau p = new Plateau(scan);
			
			Direction[] m = p.mouvementsPossibles(0);
			
			System.out.println(m[(int)(Math.random()*m.length)]);
			
			break;
			
		}

		scan.close();
		
	}
	
}
