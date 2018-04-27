package ha.coding.intrv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
	
	public static void main(String ar[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int aCount = Integer.parseInt(br.readLine());

	        int[] a = new int[aCount];

	        for (int aItr = 0; aItr < aCount; aItr++) {
	            int aItem = Integer.parseInt(br.readLine());
	            a[aItr] = aItem;
	        }

	        runningMedian(a);


	        br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static PriorityQueue<Integer> lowers = new PriorityQueue<Integer>( new Comparator<Integer>() {
		public int compare (Integer a, Integer b) {
			return -1 * a.compareTo(b);
		}
	});
	
	static PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
	
	
	public static void addNumbers(int k) {
		
		if (lowers.size() == 0 || k < lowers.peek()) {
			lowers.add(k);
		} else {
			highers.add(k);
		}
	}
	
	public static void rebalancePQ() {
		
		PriorityQueue<Integer> maxHeap = null;
		PriorityQueue<Integer> minHeap = null;
		
		if (lowers.size() > highers.size() ) {
			maxHeap = lowers;
			minHeap = highers;
		} else {
			maxHeap = highers;
			minHeap = lowers;
		}
		
		if (maxHeap.size() - minHeap.size() >= 2) {
			minHeap.add(maxHeap.poll());
		}
	}
	
	public static double getMedian() {

		if (lowers.size() == highers.size()) {
			return (double) (lowers.peek() + highers.peek())/2;
		} else if (lowers.size() > highers.size()) {
			return lowers.peek();
		} else {
			return highers.peek();
		}
		
	}
	
	static void runningMedian(int[] a) {
		
		for (int i=0; i<a.length; i++) {
			addNumbers(a[i]);
			rebalancePQ();
			System.out.println(getMedian());
		}
		
	}

}
