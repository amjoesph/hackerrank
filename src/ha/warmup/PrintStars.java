package ha.warmup;

public class PrintStars {

	public static void main(String[] args) {
		printStars(5);
		System.out.println(mystery(648));

	}
	
	public static void printStars(int num) {
		
		if (num == 1) {
			System.out.println("*");
		} else {
			System.out.println("*");
			printStars(num -1 );
		}
		
	}
	
	public static int mystery(int n){
		if (n < 10) {
			return n;
		} else {
				int a = n/10;
				int b = n%10;
				return mystery(a + b);
		}
	}

}
