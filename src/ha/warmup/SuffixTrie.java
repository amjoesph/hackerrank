package ha.warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SuffixTrie {

	public static void main(String ar[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int aCount = Integer.parseInt(br.readLine());

	        String[] inputStr = new String[aCount];

	        for (int i = 0; i < aCount; i++) {
	        	inputStr[i] = br.readLine();
	        }
	        SuffixTrie st = new SuffixTrie();
	        st.solution(inputStr);

	        br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Node trie = new Node();
	
	public void solution(String[] inputStr) {
		
		for (String s  : inputStr) {
			addSuffix(s);
		}
	}
	
	
	public void addSuffix(String s) {
		Node curr = trie;
		
		for (int i=s.length()-1; i>-1; i--) {
			System.out.println("i:" +i +":length:" + s.length());
			for (int j =i; j< s.length(); j++) {
				Character ch = s.charAt(j);
				System.out.println("char:" + ch);
				if (! curr.children.containsKey(ch)) {
					curr.count++;
					Node node = new Node();
					System.out.println("sub:" + s.substring(j));
					node.suffix = s.substring(i);
					if (j + 1 == s.length()) {
						node.wordEnd = true;
					}
					curr.children.put(ch, node);
				}
				curr = curr.children.get(ch);	

			}
		}
	}
	
	class Node {
		Map<Character, Node> children = null;
		int count = 0 ;
		String suffix;
		boolean wordEnd = false;
		
		Node() {
			children = new HashMap<Character,Node>();
		}
		
		public int findCount(String s, int index) {
			
			return 0;
		}
	}

}
