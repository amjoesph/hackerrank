package ha.warmup;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class LargestStack {
	
	static Stack<Integer> s1 = new Stack<>();
	
	//its a max Heap
	static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
		public int compare(Integer a, Integer b) {
			System.out.println("a:" + a + ":b:" + b  +":compare:" + a.compareTo(b));
			return  b.compareTo(a);
		}
	});
	
	// it's a min heap
	static PriorityQueue<Integer> pq1 = new PriorityQueue<>();
	
	public static void main(String[] args) {
		addToStack(1);
		addToStack(20);
		addToStack(5);
		addToStack(30);
		addToStack(40);
		addToStack(90);
		addToStack(15);
		addToStack(25);
		System.out.println(getLargest());
	}
	
	public static void addToStack(int data) {
		s1.add(data);
		pq.add(data);
	}
	
	public static Integer getLargest() {
		return pq.peek();
	}

}
