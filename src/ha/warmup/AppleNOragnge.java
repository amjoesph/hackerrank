package ha.warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AppleNOragnge {
	
	public static void main(String ar[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String position = br.readLine();
		String treePosition = br.readLine();
		br.readLine();
		String applePosition = br.readLine();
		String orangePosition = br.readLine();
		int acount = 0;
		int ocount =0;
		
		int nums[] = Arrays.stream(position.split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int tStart = nums[0];
		int tEnd = nums[1];
		
		int nums1[] = Arrays.stream(treePosition.split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int aStart = nums1[0];
		int oStart = nums1[1];
		
		int[] aPositions = Arrays.stream(applePosition.split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] oPositions = Arrays.stream(orangePosition.split(" ")).mapToInt(Integer::parseInt).toArray();
		
		boolean _start = true;
		int i = 0;
		int val = 0;
		while (_start) {
			if ( i < aPositions.length) {
				val = aPositions[i] + aStart ;
				if (val >= tStart && val <= tEnd ) {
					acount++;
				}
			}
			if ( i < oPositions.length) {
				val = oPositions[i] + oStart ;
				if (val >= tStart && val <= tEnd ) {
					ocount++;
				}
			} 
			
			if (i > aPositions.length && i > oPositions.length) {
				_start = false;
			}
			i++;
		}
		
		System.out.println(acount);
		System.out.println(ocount);

	}

}
