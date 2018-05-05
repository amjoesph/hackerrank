package ha.trees;

import java.util.LinkedList;

public class BST {
	
	Node root;
	
	
	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		
		if (root == null) {
			root = newNode;
			return;
		}
		
		Node parentNode = root;
		boolean _continue = true;
		
		while(_continue) {
			if (key < parentNode.key) {
				if (parentNode.leftChild == null) {
					parentNode.leftChild = newNode;
					_continue = false;
				} else {
					parentNode = parentNode.leftChild;
				}
			}  else {
				if (parentNode.rightChild == null) {
					parentNode.rightChild = newNode;
					_continue = false;
				} else {
					parentNode = parentNode.rightChild;
				}
			}
		}
	}
	
	/**
	 * Inorder   : Left  -> Root ->  Right
	 */
	public void inOrderTraversal(Node focusNode) {
		
		if (focusNode != null) {
			inOrderTraversal(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraversal(focusNode.rightChild);
		}
	}
	
	/**
	 * PreOrder  : Root  -> Left ->  Right
	 */
	public void preOrderTraversal(Node focusNode) {
		
		if (focusNode != null) {
			System.out.println(focusNode);
			preOrderTraversal(focusNode.leftChild);
			preOrderTraversal(focusNode.rightChild);
		}
	}

	/**
	 * PostOrder : Left  -> Right ->  Root
	 */
	public void postOrderTraversal(Node focusNode) {
		
		if (focusNode != null) {
			postOrderTraversal(focusNode.leftChild);
			postOrderTraversal(focusNode.rightChild);
			System.out.println(focusNode);
		}
		
	}
	
	
	public Node findNode(int key) {
		Node focusNode = root;
		
		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}
			
			if (focusNode == null) {
				return null;
			}
		}
		
		return focusNode;
	}
	
	
	public void deleteNode(int key) {
		Node focusNode = root;
		Node parent = root;
		
		boolean isLeftChild = true;
		
		while (focusNode.key != key) {
			parent = focusNode;
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
				isLeftChild = true;
			} else {
				focusNode = focusNode.rightChild;
				isLeftChild = false;
			}
			
			if (focusNode == null) {
				return;
			}
			
		}
		
		if (focusNode.leftChild == null && focusNode.rightChild == null) {
			if (focusNode == parent) {
				focusNode = null;
			} else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		}
		
	}
	
	
	public void depthFirstSearch(Node focusNode) {
		
		if (focusNode != null) {
			System.out.println(focusNode);
			preOrderTraversal(focusNode.leftChild);
			preOrderTraversal(focusNode.rightChild);
		}
		
	}
	
	
	public void breadthFirstSearch(LinkedList<Node> list) {

		boolean _continue = true;
		int level = 0;
		String _key = "" + list.getFirst().key;
		while (_continue ) {
			Node focusNode = list.pollFirst();
			System.out.print(focusNode.key + "   ");
			if (!"".equals(_key) && Integer.parseInt(_key) == focusNode.key ) {
				_key = "";
				if (level % 2 == 0) {
					System.out.print("\n");
				}
				level++;
			}
			if (focusNode.leftChild != null) {
				if ("".equals(_key)) {
					_key = "" + focusNode.leftChild.key;
				}
				list.add(focusNode.leftChild);
			}
			
			if (focusNode.rightChild != null) {
				if ("".equals(_key)) {
					_key = "" + focusNode.leftChild.key;
				}
				list.add(focusNode.rightChild);
			}
			
			if (list.size() == 0) {
				_continue = false ;
			}

		}
		
	}
	
	
	private boolean checkBST(Node node, int min, int max) {
		
		if (node == null) {
			return true;
		}
		
		if (node.key < min || node.key > max) {
			return false;
		}
		
		return checkBST(node.leftChild, min, node.key -1) && checkBST(node.rightChild, node.key + 1, max);
		
		
	}
	
	
	private boolean checkBST(Node root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	/****
	 * 
	 * 				50
	 *             / \
	 *            /   \
	 *          25    75  
 	 *         /\       \ 
	 *        /  \       \
	 *      15    30    85
	 * 
	 */

	public static void main(String[] args) {
		BST tree = new BST();
		
		tree.addNode(50, "Boss");
		tree.addNode(25, "Vice Pre");
		tree.addNode(15, "Office Manager");
		tree.addNode(30, "Secretary");
		tree.addNode(75, "Sales Manager");
		tree.addNode(85, "Salesman");
		
		tree.inOrderTraversal(tree.root);
		System.out.println("\n PRE ORDER \n ");
		tree.preOrderTraversal(tree.root);
		System.out.println("\n  POST ORDER \n ");
		tree.postOrderTraversal(tree.root);
		
		System.out.println("\n  FIND NIDE \n ");
		System.out.println(tree.findNode(30));
		
		System.out.println("\n  DFS \n ");
		tree.depthFirstSearch(tree.root);
		
		System.out.println("\n  BFS \n ");
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(tree.root);
		tree.breadthFirstSearch(list);
		
		
		System.out.println("\n  check BST \n ");
		System.out.println(tree.checkBST(tree.root));
	}
	
}


class Node {
	
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	Node (int key, String name) {
		this.key = key;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "key:" + key +":name:" + name;
	}
	
}
