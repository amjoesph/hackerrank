package ha.warmup;

import java.util.Scanner;

public class RecursiveDigit {
	
	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		scan.close();
		
		String lines[] = line.split(" "); 
		int res = 0;
		for (char c : lines[0].toCharArray()) {
			res = res + Integer.parseInt(""+c);
			res = res %9;
		}
		
		res = (res * Integer.parseInt(lines[1])) % 9;
		res = (res == 0)?9:res;
		
		System.out.println(res);
		
	}

}
