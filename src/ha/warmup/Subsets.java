package ha.warmup;

public class Subsets {

	public static void main(String[] args) {
		String ar[] = {"1","2", "3"};
		int[] ad = {1,2};
		
		System.out.println(getSubsets(ar));
		
		System.out.println("===========");
		
		subSets(ad);

	}
	
	public static StringBuilder getSubsets(String ar[]) {
		StringBuilder results = new StringBuilder();
		results.append(" " + "\n");
		if (ar == null || ar.length == 0) {
			return results;
		}
		
		for (int i=0; i< ar.length; i++) {
			results.append(ar[i] + "\n");
			for (int j=i+1; j< ar.length; j++) {
				results.append(ar[i] + "," +ar[j]  + "\n");
			}
		}
		
		return results;
	}
	
	public static void subSets(int[] given_array) {
		String bString;
		int length = given_array.length;
		String formater = "%" + String.valueOf(length) + "s";
		System.out.println("formater:" + formater + ":" + Math.pow(2, length));
		for (int i = 0; i < Math.pow(2, length); i++) {

			System.out.println("1:::(" + i + "), " + String.format(formater, Integer.toBinaryString(i)));
			System.out.println(
					"2:::(" + i + "), " + String.format(formater, Integer.toBinaryString(i)).replace(" ", "0"));
			bString = String.format(formater, Integer.toBinaryString(i)).replace(" ", "0");
			System.out.print("{ ");
			for (int j = 0; j < length; j++) {
				System.out.println(
						"3::j char:(" + j + ")" + bString.charAt(j));
				if (bString.charAt(j) == '1') {
					System.out.print(String.valueOf(given_array[j]) + " ");
				}
			}
			System.out.print("}\n");
		}
	}	 

}
