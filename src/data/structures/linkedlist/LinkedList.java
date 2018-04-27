package data.structures.linkedlist;

public class LinkedList {
	Node headNode = null;
	
	public void append(Node node) {
		if (headNode == null) {
			this.headNode = node;
			return;
		}
		
		Node lastNode = headNode;

		while(lastNode.getNextNode() != null) {
			lastNode = lastNode.getNextNode();
		}
		lastNode.setNextNode(node);

	}
	
	public void delete(Node node) {
		/*
		 *  1. Deleting root/head node
		 *  2. Deleting tail node
		 *  3. Deleting node in the middle
		 */
		
		if ( headNode != null && headNode.getData().equals(node.getData()) ) {
			headNode = headNode.getNextNode();
		}
		
		
		Node lastNode = headNode;
		boolean _continue = true;
		while(_continue) {
			if (lastNode.getNextNode() == null) {
				_continue = false;
			} else if (lastNode.getNextNode().getData().equals(node.getData())) {
				_continue = false;
				lastNode.setNextNode(lastNode.getNextNode().getNextNode());
			} else {
				lastNode = lastNode.getNextNode();
			}
		}
		
	}
	
	public Node getIndex(int index) {
		
		if (headNode == null) {
			return null;
		}
		
		int counter = -1;
		Node lastNode = headNode;
		Node toReturn = null;
		
		while(lastNode.getNextNode() != null) {
			counter++;
			if  (counter == index) {
				toReturn = lastNode;
			} else {
				lastNode = lastNode.getNextNode();
			}
		}
		return toReturn;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		Node lastNode = headNode;
		builder.append(lastNode.getData());
		builder.append(" --> ");
		while(lastNode.getNextNode() != null) {
			lastNode = lastNode.getNextNode();
			builder.append(lastNode.getData());
			builder.append(" --> ");
		}
		
		return builder.toString();
		
	}

}
