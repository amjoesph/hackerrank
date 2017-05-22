package ha.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PowerSumRec {
	
	public static void main(String ar[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int key = Integer.parseInt(br.readLine());
		int power = Integer.parseInt(br.readLine());
		int count = 0;
		int limiter = 1;
		while (Math.pow(limiter, power) <= key) {
			limiter++;
		}
//		System.out.println("::" + --limiter);
		Map<String, String> usedkeys = new HashMap<String, String>();
		usedkeys.put("keysUsed", "");
		usedkeys.put("tempKeys", "");
		usedkeys.put("key", ""+ key);
		usedkeys.put("originalKey", ""+ key);
//		limiter = 8;
		for (int i=limiter; i >0; i--) {
			count = powersum(power, limiter, count, usedkeys);
		}
		System.out.println(count);

	}
	
	public static int powersum(int power, int limiter, int count, Map<String, String> usedkeys) {
		
		for (int i=limiter; i >0; i--) {
			String keysUsed = usedkeys.get("keysUsed");
			String tempKeys = usedkeys.get("tempKeys");
			int key = Integer.parseInt(usedkeys.get("key"));
			int poweredNum = (int)Math.pow(i, power);
			
			System.out.println("limiter:" + i + ":*******key:" + key +":poweredNum:" + poweredNum + ":count:" + count + ":keysUsed:" + keysUsed  +":tempKeys:" + tempKeys);

			if (poweredNum == key && keysUsed.indexOf("+"+i +"+") == -1) {
				count++;
				keysUsed += tempKeys+"+";
				keysUsed += i+"+";
				usedkeys.put("keysUsed", keysUsed);
				usedkeys.put("tempKeys", "");
				usedkeys.put("key", usedkeys.get("originalKey"));
				key = Integer.parseInt(usedkeys.get("originalKey"));
				System.out.println("keys used:***********:" + keysUsed +" total.  keys on this round:("+ tempKeys +"+" +i+"):" + key);
				tempKeys = "";

				continue;
			}
			
			int balance = key - poweredNum;
			
			if (balance > 0 && keysUsed.indexOf("+"+ i +"+") == -1) {
				tempKeys +=i+"+";
//				System.out.println("inner loop bal > 0:" + balance + ":tempKeys:" +tempKeys );
				usedkeys.put("key", ""+ balance);
				usedkeys.put("tempKeys", ""+ tempKeys);
			}
			
			count = powersum(power, --i, count, usedkeys);
			
		}
		usedkeys.put("key", usedkeys.get("originalKey"));
		usedkeys.put("tempKeys", "");
		return count;
	}

}
