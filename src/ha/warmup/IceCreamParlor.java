package ha.warmup;

import java.util.Arrays;
import java.util.Scanner;

public class IceCreamParlor {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);
		int trips = scan.nextInt();
		int totalCount = 3 * trips;
		String[] iceCream = new String[totalCount];
		scan.nextLine();
		
		for (int i = 0; i < totalCount; i++) {
			String line = scan.nextLine();
			if (line != null || line != "") {
				iceCream[i] = line;
			}
		}
		scan.close();

		int j = 0;
		for (int i = 0; i < trips; i++) {
			getFlavours(Integer.parseInt(iceCream[j++]), Integer.parseInt(iceCream[j++]), iceCream[j++]);
		}
	}
	
	public static void getFlavours(int currency, int flavours, String values) {
		
		int[] tripVal = Arrays.stream(values.split(" ")).mapToInt(Integer::parseInt).toArray(); 
		int start =0;
		int end = 0;
		String result = "";
		for (int j=0; j <tripVal.length; j++ ) {
			start = tripVal[j];
			if (result != "") {
				break;
			}
			for (int i=0; i <tripVal.length; i++ ) {
				end = tripVal[i];
				if (j == i) {
					continue;
				}
				if ((start + end) == currency ) {
					result = (j+1) + " " + (i+1);
					break;
				}
			}
		}
		System.out.println(result);
	}

}
