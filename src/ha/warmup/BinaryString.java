package ha.warmup;

import java.util.ArrayList;
import java.util.List;

public class BinaryString {
	
	public static void main(String ar[]){
		
		String toTest = "1??0?1?1";
		binaryCombinations(toTest);
	}
	
	public static String binaryCombinations(String str) {
		
		String[] occur = getWildChardOccurence(str);
		
/*		for (int i= 0; i < occur.length; i++) {
			System.out.println("indes:" + i + "()"+ occur[i] +":len:"+occur.length);
		}
*/		
		char[] updatedChar = str.toCharArray();
		for (int i= 0; i < occur.length; i++) {
			updatedChar[Integer.parseInt(occur[i])]='0';
		} 
		
		String updatedStr = new String(updatedChar);
		System.out.println("uo:"+ updatedStr);
		for (int i= occur.length; i > 0; i--) {
			getCombinations(updatedStr.toCharArray(), occur, i);
			
		}
		
		return "";
	}
	
	public static void getCombinations(char[] chr, String[] occur, int i) {
//		System.out.println("posi:" + i);
		char[] updatedChar = chr;
		String updatedStr = new String(chr);
		for (int j=i-1; j < occur.length; j++) {
//			System.out.println("::"+j +"::"+occur[j]);
			updatedChar[Integer.parseInt(occur[j])]='1';
			
			System.out.println("guo:"+new String(updatedChar));
		}
		
		if (occur.length >= 3 && (occur.length - 2) >= i ){
//			System.out.println("run this...:" + i);
			updatedChar = updatedStr.toCharArray();
			int startPosi = occur.length - 3;
//			System.out.println(updatedStr+":" + startPosi);
			updatedChar[Integer.parseInt(occur[startPosi])]='1';

			for (int k = startPosi +2; k < occur.length; k++) {
				updatedChar[Integer.parseInt(occur[k])]='1';
				System.out.println("cguo:"+new String(updatedChar));
			}
		}
		
	}
	
	public static String[] getWildChardOccurence(String str) {
		
		List<String> occur = new ArrayList<String>();
		
		for (int i=0; i < str.length(); i++) {
			if (str.charAt(i) == '?') {
				occur.add(""+i);
			}
		}
		return occur.toArray(new String[occur.size()]);
	}
}
