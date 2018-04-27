package ha.warmup.backtracking;

public class Permutation {
	
	public static void main(String ar[]) {
		String s = "ant1";
		permute(s);
		System.out.println("==============");
		getPermutations("", s);
	}
	
	private static void _permuteWorker(String provided, String selected) {
		
		if ("".equals(provided)) {
			System.out.println(selected);
		} else {
			int providedLength = provided.length();
			for (int i =0; i < providedLength; i++) {
//				System.out.println("!!!!char:" + provided.charAt(i));
				char c = provided.charAt(i);
				selected += c;
				
				provided = provided.substring(0, i) +  provided.substring(i+1);
//				System.out.println("provided:" + provided + ":i:" + i);
				permuteWorker(provided, selected);
				
//				System.out.println(">>provided:" + provided +  ":selected:" + selected  + ":i:" + i + ":char:" + c);
				provided = c + provided;
				selected = selected.substring(0, selected.length() - 1);
//				System.out.println("<< AFTER provided:<<" + provided +  ":selected:" + selected  + ":i:" + i + ":char:" + c);
				
			}
		}
	}
	
	/**
	 * above method ... without assignment to char variable  and without sysout
	 */
	private static void permuteWorker(String provided, String selected) {
		
		if ("".equals(provided)) {
			System.out.println(selected);
		} else {
			int providedLength = provided.length();
			for (int i =0; i < providedLength; i++) {
				permuteWorker(provided.substring(0, i) +  provided.substring(i+1), selected + provided.charAt(i));
			}
		}
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
	
	
	public static void permute(String s) {
		if (s == null || s.length() == 1 ) {
			System.out.println(s);
			return;
		}
		permuteWorker(s,"");
	}

}
