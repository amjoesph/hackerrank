package ha.warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiagonalSum {
	
	public static void main(String ar[]) {
		try {
			
			String ab ="I-39";
			System.out.println(ab.substring(ab.indexOf("-") + 1));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String val = "";
			String diag[] = null;
			val =  br.readLine();
			int k = Integer.parseInt(val);

			diag = new String[k];
			
			for (int i = 0; i < k; i++) {
				val =  br.readLine();
				diag[i] = val;
			}

			int asum =0;
			int bsum =0;
			String tmp[] = null;
			int j = diag.length -1 ;
			
			for (int i =0; i< diag.length; i++) {
				tmp = diag[i].split(" ");
				asum+=Integer.parseInt(tmp[i]);
				bsum+=Integer.parseInt(tmp[j--]);
			}
			
			int diff = asum - bsum ;
			if (diff < 0) {
				diff = diff * -1;
			}
			System.out.println(diff);
			
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}
	}
	
}
