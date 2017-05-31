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
			System.out.println( "ep1");
			break;
			
		}
		
		scan.close();
		
	}
	
}
