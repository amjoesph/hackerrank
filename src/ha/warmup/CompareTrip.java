package ha.warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CompareTrip {
	
	public static void main(String ar[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String arrayVal = "";
			String aT = "";
			String bT = "";
			for (int i = 0; i < 2; i++) {
				arrayVal =  br.readLine();
				if (i == 0) {
					aT = arrayVal;
				} else if (i ==1) {
					bT = arrayVal;
				}
			}
			System.out.println(compareT(aT, bT));
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}
	}
	
	public static String compareT(String art, String brt) {
		if (art == null || brt == null) {
			return "";
		}
		
		String a[] = art.split(" ");
		String b[] = brt.split(" ");
		
		int aCount = 0;
		int bCount = 0;
		
		for (int i =0; i < a.length; i++) {
			if (Integer.parseInt(a[i]) > Integer.parseInt(b[i])) {
				aCount++;
			} else if (Integer.parseInt(a[i]) < Integer.parseInt(b[i])) {
				bCount++;
			}
		}
		
		return aCount + " " + bCount;
		
	}

}
