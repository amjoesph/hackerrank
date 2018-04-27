package ha.warmup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieAutocomplete {
	
	private Node trie;
	
	
	public TrieAutocomplete(String[] dict) {
		trie = new Node("");
		for (String s : dict) {
			insertWord(s);
		}
	}
	
	private void insertWord(String s) {
		Node curr = trie;
		for (int i=0; i<s.length(); i++) {
			if (!curr.children.containsKey(s.charAt(i))){
				curr.count++;
				curr.children.put( s.charAt(i), new Node(s.substring(0, i+1)) );
			}
			curr = curr.children.get(s.charAt(i));
			if (i == s.length()-1) {
				curr.isWord = true;
			}
		}
	}
	
	public List<String> getWordsForPrefix(String prefix) {
		List<String> results = new ArrayList<String>();
		Node curr = trie;
		for (int i=0; i<prefix.length(); i++) {
			if (!curr.children.containsKey(prefix.charAt(i))){
				return results;
			} else {
				curr = curr.children.get(prefix.charAt(i));
			}
		}
		
		
		findAllChildWords(curr, results);
		return results;
	}
	
	private void findAllChildWords(Node node, List<String> results) {
		if (node.isWord) {
			results.add(node.prefix);
		}
		for (Character c: node.children.keySet()) {
			findAllChildWords(node.children.get(c), results);
		}
	}
	
	public int findCount(String prefix) {
		Node curr = trie;
		for (int i=0; i<prefix.length(); i++) {
			if (!curr.children.containsKey(prefix.charAt(i))){
				return curr.count;
			} else {
				curr = curr.children.get(prefix.charAt(i));
			}
		}
		
		return curr.count;

	}
	
	public static void main(String ar[]) {
		String[] keys = {"Gany", "Gail", "Gayle","Gordon","Ganga"};
		TrieAutocomplete trieac = new TrieAutocomplete(keys);
		
		String prefix = "Gan";
		
		System.out.println("count:" + trieac.findCount(prefix));
		System.out.println(trieac.getWordsForPrefix(prefix));
		
	}

}


class Node {
	
	String prefix;
	int count;
	HashMap<Character, Node> children;
	boolean isWord;
	
	public Node(String prefix) {
		this.prefix = prefix;
		this.children = new HashMap<Character, Node>();
	}
	
	public int getCount() {
		return this.count;
	}
}
