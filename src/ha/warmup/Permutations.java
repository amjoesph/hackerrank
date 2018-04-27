package ha.warmup;

import java.util.ArrayList;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "ant";
		getPermutations("",name);
	}
	
	public static void getPermutations(String prefix, String word) {
		
		int n = word.length();
		
		if (n == 0) {
			System.out.println(prefix);
		}
		
		for (int i = 0; i<n; i++) {
			getPermutations(prefix + word.charAt(i), word.substring(0, i) + word.substring(i+1, n));
		}
	}
	
	public static int getPermutations(String prefix, String word, int counter) {
		
		int n = word.length();
		
		if (n == 0) {
			System.out.println(prefix);
			counter++;
			System.out.println(counter);
			return counter;
		}
		
		for (int i = 0; i<n; i++) {
			counter = getPermutations(prefix + word.charAt(i), word.substring(0, i) + word.substring(i+1, n), counter );
		}
		return counter;
	}
}
