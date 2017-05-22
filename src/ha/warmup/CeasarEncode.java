package ha.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CeasarEncode {
	
	public static void main(String ar[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String val = br.readLine();
		int k = Integer.parseInt(br.readLine());
		encodeCesar(val,k);
	}
	
	public static void encodeCesar(String str, int key) {
		String encodedStr = "";
		int code = 0;
		for (char c : str.toCharArray()) {
			code = (int)c;
			if (code >=65 && code <= 90) {
				code += key;
				while (code > 90) {
					code = 64 + (code - 90);
				}
				encodedStr+=(char)code;
			} else if (code >= 97 && code <= 122)  {
				code += key;
				while (code > 122) {
					code = 96 + (code - 122);
				}
				encodedStr+=(char)code;
			} else {
				encodedStr+=c;
			}
		}
		System.out.println(encodedStr);
	}
}
