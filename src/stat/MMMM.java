package stat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MMMM {
	
	public static void main(String ar[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int count = Integer.parseInt(br.readLine());
			String arrayVal = br.readLine();
			br.close();
			mmm(count, arrayVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void mmm(int count, String val) {
		
		String[] vals = val.split(" ");
		int[] nums =  Arrays.stream(vals).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		float fc = count;
		
		float mean = (Arrays.stream(nums).sum())/fc;
		float median = 0f;
		int mode = 0;
		
		if (count % 2 == 0) {
			median = (nums[count/2] + nums[(count/2) - 1])/2.0f;
		} else {
			median = nums[count/2];
		}
		
		Map<String,String> modeCount = new  LinkedHashMap<>(count);
		int k = 0;
		String mval = "";
		for(int j : nums) {
			mval = modeCount.get(String.valueOf(j));
			if (mval == null) {
				modeCount.put(String.valueOf(j), String.valueOf(1));
			} else {
				modeCount.put(String.valueOf(j), String.valueOf(Integer.parseInt(mval) + 1));
			}
		}
		
		int iMode = 0;
		for (String key : modeCount.keySet()) {
			if (Integer.parseInt(modeCount.get(key)) > iMode) {
				iMode = Integer.parseInt(modeCount.get(key));
				mode = Integer.parseInt(key);
			}
		}
		
		System.out.println(mean);
		System.out.println(median);
		System.out.println(mode);
		
	}
}
