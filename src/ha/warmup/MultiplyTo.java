package ha.warmup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplyTo {

	public static void main(String[] args) {
		int ad[] = {1,2,4,6,8,5,40,-1};
		int sumTo = 30;
		
		int result[] = new int[2];
		
		result = findNumbers(ad,sumTo);
		System.out.println(result[0] + "x" +  result[1]);
	}
	
	public static int[] findNumbers(int ad[], int sum) {
		int result[] = new int[2];
		List<Integer> listNum = Arrays.stream(ad).boxed().collect(Collectors.toList());
		for (int i : ad) {
			if (sum % i  == 0) {
				int divisor = sum / i;
				if (listNum.contains(divisor)) {
					result[0] = i;
					result[1] = divisor;
					break;
				}
			}
		}
		return result;
	}
}
