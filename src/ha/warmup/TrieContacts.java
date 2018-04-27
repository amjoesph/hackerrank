package ha.warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TrieContacts {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int aCount = Integer.parseInt(br.readLine());

	        String[] inputStr = new String[aCount];

	        for (int i = 0; i < aCount; i++) {
	        	inputStr[i] = br.readLine().toLowerCase();
	        }
	        
	        solution(inputStr);

	        br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static Node rootNode = new Node();
	public static void solution(String[] s) {
		for (int i= 0; i< s.length; i++) {
			rootNode.addNode(s[i]);
		}
	}
	
	public static class Node {
		
		private int size = 0;
		private int char_length = 26;
		private Node[] child = new Node[char_length];
		
		public void addNode(String s) {
			addNode(s, 0);
		}
		
		public void addNode(String s, int index) {
			size++;
			
			if (s.length() == index) {
				return;
			}
			
			System.out.println("adding string:" + s + ":char:" +s.charAt(index) +":size:" + size) ;
			
			char ch = s.charAt(index);
			Node _child = getNode(ch);
			if (_child == null) {
				_child = new Node();
				setNode(ch,_child);
			}
			_child.addNode(s, ++index);
		}
		
		public int getCharIndex(char ch) {
			return ch - 'a';
		}
		
		public void setNode(char ch, Node node) {
			this.child[getCharIndex(ch)] = node;
			
		}
		
		public Node getNode(char ch) {
			return this.child[getCharIndex(ch)];
		}
		
		public int findCount(String prefix, int index) {
			
			if (prefix.length() == index) {
				return size;
			}
			
			Node child = getNode(prefix.charAt(index));
			if (child == null ) {
				return 0;
			}
			
			return child.findCount(prefix, index++);
		}
		
		
	}

}
