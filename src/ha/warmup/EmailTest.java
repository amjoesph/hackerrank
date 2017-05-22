package ha.warmup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailTest {
	
	public static void main(String ar[]) {
		String regx = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		String inputString = "mpsamemb1@gmail.com";
		
		Pattern pattern = Pattern.compile(regx);
	    Matcher matcher = pattern.matcher(inputString);
	    
	    System.out.println("testing:" + matcher.matches());
		
	}

}
