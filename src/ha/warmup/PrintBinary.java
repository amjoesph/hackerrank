package ha.warmup;

public class PrintBinary {
	
	public static void main(String ar[]) {
		
		String s = "";
		int num = 3;
		for (int i = 0; i<num; i++) {
			s+="0";
		}
//		binaryPrint(s,"");
		binaryPrint(num,"");
		decimalPrint(num,"");
	}
	
	private static void binaryPrint(String s, String prefix) {
		System.out.println(prefix + s);
		
		for (int i=0; i<s.length(); i++) {
			
		}
	
	}
	
	private static void binaryPrint(int digits, String prefix) {
		
		System.out.println("binaryPrint("+digits+",\""+ prefix + "\")");
		if (digits == 0) {
			System.out.println(prefix);
		} else {
			binaryPrint(digits -1 , prefix + "0");
			binaryPrint(digits -1 , prefix + "1");
		}
	}
	
	private static void decimalPrint(int digits, String prefix) {
		
		if (digits == 0) {
			System.out.println(prefix);
		} else {
			for ( int i =0; i < 10; i++) {
				decimalPrint(digits -1 , prefix + i);
			}
			
		}
	}

}
