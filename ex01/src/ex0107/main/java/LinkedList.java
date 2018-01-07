package ex0107.main.java;

public class LinkedList {

	private Node rootNode;
	private int size;
	private Node lastNode;

	public LinkedList() {
		this.rootNode = null;
		this.lastNode = null;
	}

	public boolean isEmpty() {
		return rootNode == null;
	}

	public int size() {
		return size;
	}

	private void insertRoot(Node newNode) {
		rootNode = newNode;
		lastNode = newNode;
		size++;
	}

	private void insertFirst(Node newNode) {
		newNode.link = rootNode;
		rootNode = newNode;
		size++;
	}

	private void insertNext(Node preNode, Node newNode) {
		newNode.link = preNode.link;
		preNode.link = newNode;
		size++;
	}

	private void insertLast(Node newNode) {
		lastNode.link = newNode;
		lastNode = newNode;
		size++;
	}

	private Node getNode(int index) {
		Node node = rootNode;
		for (int i = 0; i < index; i++) {
			if (node == null) {
				throw new IndexOutOfBoundsException();
			} else {
				node = node.link;
			}
		}
		return node;
	}

	public void insertMiddleNode(int index, int data) {
		if (isEmpty()) {
			insertRoot(new Node(data));
		} else if (size == index + 1) {
			insertLast(new Node(data));
		} else {
			insertNext(getNode(index - 1), new Node(data));
		}
	}

	public void insertLastNode(int data) {
		if (isEmpty()) {
			insertRoot(new Node(data));
		} else {
			insertLast(new Node(data));
		}
	}

	public void printList() {
		Node node = rootNode;
		System.out.print("ROOT");
		while (node != null) {
			System.out.print(" > " + node.data);
			node = node.link;
		}
		System.out.println();
	}

}

class Node {
	public Node link;
	public int data;

	public Node(Node link, int data) {
		this.link = link;
		this.data = data;
	}

	public Node(int data) {
		this(null, data);
	}
}