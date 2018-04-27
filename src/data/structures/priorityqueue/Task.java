package data.structures.priorityqueue;

public class Task {
	String data = "";
	int priority = 0;
	
	public Task(String data, int priority) {
		this.data = data;
		this.priority = priority;
	}
	
	public String getData() {
		return this.data;
	}
	
	public int getPriority() {
		return this.priority;
	}
}
