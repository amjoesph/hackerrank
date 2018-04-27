package ha.warmup;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MaximumSumArray {
	
	public static int[] maximumSum(int[] arr) {
		int result[] = new int[arr.length];
		
		int maxValue = arr[0];
		int startPos = 0;
		int endPos = 0;
		int tempStartPos = 0;
		int sumStored = 0;
		
		for (int i = 1; i < arr.length; i++ ) {
			if (arr[i] + maxValue > maxValue) {
				if (maxValue == 0) {
					tempStartPos = i;
				}
				maxValue = arr[i] + maxValue;
			} else if (maxValue > sumStored) {
				startPos = tempStartPos;
				endPos = i -1;
				sumStored = maxValue;
				maxValue = 0;
			} else {
				maxValue = 0;
			}
		}
		
		int i = 0;
		for (int j = startPos; j<= endPos; j++) {
			result[i] = arr[j];
			i++;
		}
		
		return result;
	}
	
    public static void main(String args[]) {
        int arr[] = {1,2,-4,-5,3,5,-2,5,2,1,-6,1,6};
        
        int result[] = maximumSum(arr);
        System.out.println("sum:" + Arrays.stream(result).sum());
        System.out.println(Arrays.stream(result).boxed().filter(a -> a > 0).collect(Collectors.toList()));
        
    }

}
