package data.structures.priorityqueue;

/**
 * MAX HEAP Priority Queue
 * @author manthoni
 *
 */
public class PriorityQueue {
	
	
	private Task[] heap;
	int currentSize = 0;
	
	public PriorityQueue(int capacity){
		heap = new Task[capacity];
		
	}
	
	/**
	 * add root
	 * add child
	 * @param task
	 */
	public void addTask(Task task) {
		if (heap[0] == null) {
			heap[0] = task;
			currentSize++;
			return;
		}
		
		if (currentSize == heap.length) {
			Task[] heapTemp = new Task[currentSize * 2];
			int j = 0;
			for (Task t2 : heap) {
				heapTemp[j++] = t2;
			}
			heap = heapTemp;
			heapTemp = null;
		}
		
		heap[currentSize++] = task;		
		
		// now sort the priority
		boolean _continue = true;
		int currentIndex = currentSize - 1;
		int parentIndex = 0;
		
		while (_continue) {
			parentIndex = Math.floorDiv(currentIndex-1,2);
			if (parentIndex < 0) {
				parentIndex = 0;
			}
			Task currentTask = heap[currentIndex];
			Task parentTask = heap[parentIndex];
			if (currentTask.getPriority() <= parentTask.getPriority() ) {
				_continue = false;
			} else {
				heap[parentIndex] = currentTask;
				heap[currentIndex] = parentTask;
				currentIndex = parentIndex;
			}
		}
	}
	
	public static void main (String a[]) {
		
		PriorityQueue pq = new PriorityQueue(5);
		Task t1 = new Task("one",25);
		Task t2 = new Task("two",10);
		Task t3 = new Task("three",15);
		Task t4 = new Task("four",35);
		Task t5 = new Task("five",45);
		Task t6 = new Task("six",40);
		Task t7 = new Task("seven",55);
		
		pq.addTask(t1);
		pq.addTask(t2);
		pq.addTask(t3);
		pq.addTask(t4);
		pq.addTask(t5);
		pq.addTask(t6);
		pq.addTask(t7);
		
		System.out.println(pq.toString());

		
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Task task : heap) {
			if (task != null) {
				builder.append("{");
				builder.append(task.getData());
				builder.append(",");
				builder.append(task.getPriority());
				builder.append("},  ");
			}
		}
		
		return builder.toString();
	}
	
	

}
