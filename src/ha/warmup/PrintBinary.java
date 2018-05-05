package ha.warmup;

public class PrintBinary {
	
	public static void main(String ar[]) {
		
		String s = "";
		int num = 2;
		
//		binaryPrint(s,"");
//		binaryPrint(num,"");
//		binaryPrint(num, 0,"");
		decimalPrint(num,"");
	}
	
	private static void binaryPrint(String s, String prefix) {
		System.out.println(prefix + s);
		
		for (int i=0; i<s.length(); i++) {
			
		}
	
	}
	
	private static void binaryPrint(int digits, String prefix) {
		
//		System.out.println("binaryPrint("+digits+",\""+ prefix + "\")");
		if (digits == 0) {
			System.out.println(prefix);
		} else {
			binaryPrint(digits -1 , prefix + "0");
			binaryPrint(digits -1 , prefix + "1");
		}
	}
	
	private static void binaryPrint(int num, int digits, String prefix) {
		
//		System.out.println("binaryPrint("+digits+",\""+ prefix + "\")");
		if (digits == num) {
			System.out.println(prefix);
		} else {
			binaryPrint(num, digits +1 , prefix + "0");
			binaryPrint(num, digits +1 , prefix + "1");
		}
	}
	
	private static void decimalPrint(int digits, String prefix) {
		
		System.out.println("decimalPrint("+digits+",\""+ prefix + "\")");
		
		if (digits == 0) {
			System.out.println(prefix);
		} else {
			for ( int i =0; i < 10; i++) {
				decimalPrint(digits -1 , prefix + i);
			}
			
		}
	}

}
