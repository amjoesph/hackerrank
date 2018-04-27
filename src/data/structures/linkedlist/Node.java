package data.structures.linkedlist;

public class Node {
	
	String data = "";
	
	Node next = null;
	
	public Node(String data) {
		this.data = data;
	}
	
	public String getData() {
		return this.data;
	}
	
	public Node getNextNode() {
		return this.next;
	}
	
	public void setNextNode(Node next) {
		this.next = next;
	}

}
