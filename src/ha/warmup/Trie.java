package ha.warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Trie {
	
	public static void main(String ar[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int aCount = Integer.parseInt(br.readLine());

	        String[] inputStr = new String[aCount];

	        for (int i = 0; i < aCount; i++) {
	        	inputStr[i] = br.readLine();
	        }
	        
	        solution(inputStr);

	        br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void solution(String[] inputStr) {
		// add construct trie
//		buildTrie(inputStr);
		// find the contact
	}
	
	
	public static class Node {
		private static int char_length = 26;
		Node[] childtren = new Node[26];
		
		private Node getNode() {
			
			return null;
		}
		
		private void setNode(Node a) {
			
		}
		
		private void addNode() {
			
		}
		
		public int findCount(String s, int index) {
			
			return 0;
		}
	}

}
