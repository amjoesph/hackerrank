package ha.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Day1_Quartile {
	
	public static void main(String ar[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int count = Integer.parseInt(br.readLine());
			String arrayVal = br.readLine();
			br.close();
			
			quartiles(count, arrayVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void quartiles(int count, String val) {
		
		String[] vals = val.split(" ");
		int[] nums =  Arrays.stream(vals).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		
//		System.out.println("Numbers read:" + val);

		int q1 = 0;
		int q2 = 0;
		int q3 = 0;
		int sum = count;
		int mid = sum/2;
		
		if (sum % 2 == 1 ) {
			q2 = nums[mid] ;
		} else{
			q2 = (nums[mid] + nums[mid - 1])/2 ;
		}
		
		int lmid = mid;
		if (lmid % 2 == 0) {
			q1 = (nums[lmid/2] + nums[lmid/2  - 1])/2;
		} else {
			q1 = nums[lmid/2];
		}
		
		
		int umid = count - (mid);
		
		if (count % 2 == 1) {
			umid = count - (mid + 1);
		}
		
		int uindex = mid + umid/2;
		if (umid % 2 == 0) {
			
			if (count % 2 == 1) {
				q3 = (nums[uindex] + nums[uindex + 1])/2;
			} else {
				q3 = (nums[uindex] + nums[uindex - 1])/2;				
			}
		} else {
			q3 = nums[uindex];
		}
		System.out.println(q1);
		System.out.println(q2);
		System.out.println(q3);
		
			
		
//		mid = sum/4;
//		
//		if (sum % 4 == 0 ) {
//			q1 = nums[mid] ;
//		} else{
//			q1 = (nums[mid] + nums[mid - 1])/2 ;
//		}
//		
//		mid = (sum * 3)/4;
//		
//		if (sum % 4 == 0 ) {
//			q3 = nums[mid] ;
//		} else{
//			q3 = (nums[mid] + nums[mid + 1])/2 ;
//		}
	}
}
