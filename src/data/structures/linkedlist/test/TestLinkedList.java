package data.structures.linkedlist.test;

import data.structures.linkedlist.LinkedList;
import data.structures.linkedlist.Node;

public class TestLinkedList {
	
	public static void main(String a[]) {
		
		LinkedList linkedList = new LinkedList();
		Node n1 = new Node("one");
		Node n2 = new Node("two");
		Node n3 = new Node("three");
		Node n4 = new Node("four");
		
		linkedList.append(n1);
		linkedList.append(n2);
		linkedList.append(n3);
		linkedList.append(n4);
		
		System.out.println(linkedList.toString());
		
		Node n5 = new Node("five");
		linkedList.append(n5);
		
		System.out.println(linkedList.toString());
		
		Node nget = linkedList.getIndex(1);
		
		System.out.println("nget:" + nget.getData());
		
		linkedList.delete(n1);
		System.out.println("After removing head node");
		System.out.println(linkedList.toString());
		
		linkedList.delete(n3);
		System.out.println("After removing middle node");
		System.out.println(linkedList.toString());
		
	}

}
