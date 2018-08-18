package com.linkedlist;

public class MyLinkedList<E> {

	private Node<E> headNode;
	
	private int size = 0;
	
	public void add(E elem) {
		Node<E> node = new Node<E>(elem);
		transverseAndAdd(node);
	}
	
	public void showNodes() {
		if (headNode == null) {
			return;
		}
		System.out.println(headNode);
		Node<E> currentNode = headNode;
		while (currentNode.getNextNode() !=null) {
			currentNode = currentNode.getNextNode();
			System.out.println(currentNode);
		}
	}
	
	public Node<E> getAt(int index) {
		if (index >= size) {
			System.out.println("Invalid index, cannot get "+index);
			return null;
		}else {
			Node<E> currentNode = headNode;
			int counter = 1;
			while (index > counter) {
				currentNode = currentNode.getNextNode();
				counter++;
			}
			return currentNode;
		}
	}
	
	public void addAt(E elem, int index) {
		if (index >= size) {
			System.out.println("Invalid index, cannot add "+index);
		}else {
			Node<E> node = getAt(index-1);
			if (node !=null) {
				Node<E> newNode = new Node<E>(elem);
				Node<E> nextNode = node.getNextNode();
				newNode.setNextNode(nextNode);
				node.setNextNode(newNode);
				size++;
			}
		}
	}
	
	public int size() {
		return size;
	}
	
	
	private void transverseAndAdd(Node<E> node) {
		if (headNode == null) {
			headNode = node;
		}else {
			Node<E> currentNode = headNode;
			while (currentNode.getNextNode() !=null) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(node);
		}
		
		size++;
	}
	
}
