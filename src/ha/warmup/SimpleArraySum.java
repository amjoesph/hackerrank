package ha.warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimpleArraySum {

	public static void main(String ar[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String arrayVal = "";
			for (int i = 0; i < 2; i++) {
				arrayVal =  br.readLine();
				System.out.println(arrayVal);
			}
			System.out.println(simpleSum(arrayVal));
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}
	}
	
	public static long simpleSum(String arrayVal) {
		long sum = 0;
		
		if (arrayVal == null || arrayVal.length() == 0) {
			return sum;
		}
		
		String arr[] = arrayVal.split(" ");
		
		for (String s : arr) {
			sum+=Integer.parseInt(s);
		}
		
		return sum;
	}
}
