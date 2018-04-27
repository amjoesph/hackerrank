package ha.warmup;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackQueue {
	
	static Stack<String> s1 = new Stack<>();
	static Stack<String> s2 = new Stack<>();
	
	
	public static void main (String a[]) throws Exception {
		addToStack("1");
		addToStack("2");
		addToStack("3");
		System.out.println(pop());
		System.out.println(pop());
		addToStack("4");
		addToStack("5");
		addToStack("6");
		System.out.println(pop());
		System.out.println(pop());
	}
	
	private static void addToStack(String s) {
		s1.add(s);
	}
	
	private static String pop() throws EmptyStackException  {
		if (s2.isEmpty()) {
			while (! s1.isEmpty()) {
				s2.add(s1.pop());
			}
		}
		return s2.pop();
	}
 }
