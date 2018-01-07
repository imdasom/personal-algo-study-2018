package ex0106.main.java;

public class BinaryTree {

	private Node root;
	private String LEVEL_EXPRESSION = "-";

	public BinaryTree() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insertMiddleNode(String parent, String child) {
		if (isEmpty()) {
			root = new Node(parent);
		}
		Node parentNode = findNode(parent);
		parentNode.insertChild(new Node(child));
	}

	public Node findNode(String data) {
		Node targetNode = findNode(root, data);
		System.out.print(targetNode == null ? "탐색실패\n" : "");
		return targetNode;
	}

	private Node findNode(Node curNode, String data) {
		if (curNode == null) {
			return null;
		}
		if (curNode.data.equals(data)) {
			return curNode;
		}
		Node leftNode = findNode(curNode.leftChild, data);
		if (leftNode != null) {
			return leftNode;
		}
		Node rightNode = findNode(curNode.rightChild, data);
		if (rightNode != null) {
			return rightNode;
		}
		return null;
	}

	public void printPreOrder() {
		printPreOrder(root, "");
	}

	private void printPreOrder(Node curNode, String levelExpression) {
		if(curNode == null) {
			return;
		}
		System.out.println(levelExpression + curNode.data);
		printPreOrder(curNode.leftChild, levelExpression + LEVEL_EXPRESSION);
		printPreOrder(curNode.rightChild, levelExpression + LEVEL_EXPRESSION);
	}
}

class Node {
	public String data;
	public Node leftChild;
	public Node rightChild;

	public Node(String data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	public void insertChild(Node node) {
		if (leftChild == null) {
			leftChild = node;
		} else if (rightChild == null) {
			rightChild = node;
		} else {
			System.out.println("자식노드를 삽입할 수 없습니다.");
		}
	}
}
