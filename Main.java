import java.util.Scanner;


public class Main {

	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		
		if (line.equals("NAME?")) {
			System.out.println("JFPDIX");
		}
		
		System.out.println("End.");
		
		scan.close();
		
	}
	
}
