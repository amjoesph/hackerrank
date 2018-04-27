package ha.coding.intrv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Anagram {
	
	public static void main(String ar[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String first = br.readLine();
			String second = br.readLine();
			br.close();
			System.out.println("first:" + first);
			System.out.println("second:" + second);
			
			System.out.println(numberNeeded(first, second));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	final static int LETTERS_LIMIT = 26;
	
	public static int numberNeeded(String first, String second) {
		
		int charcount[] = getCharCount(first);
		int charcount2[] = getCharCount(second);

		return getAnagramCount(charcount, charcount2);
	}
	
	
	public static int[] getCharCount(String stringToMap) {
		int [] charcount = new int[LETTERS_LIMIT];
		if (stringToMap == null || stringToMap.trim().length() == 0) {
			return charcount;
		}
		
		int offset = (int) 'a';
		
		for(char c : stringToMap.toCharArray()) {
			int charCode = (int) c;
			charcount[charCode - offset]++;
		}

		return charcount;
	}
	
	public static int getAnagramCount(int charcount[], int charcount2[]) {
		int count = 0;
		
		for(int i = 0; i< charcount.length; i++) {
			int diff = charcount[i] - charcount2[i];
			count+= (diff < 0) ? diff * -1: diff;
		}
		return count;
	}

}
