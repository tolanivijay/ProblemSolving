package com.linkedlist;

public class Node<E> {

	private E value;
	
	private Node<E> nextNode;
	
	public Node(E elem) {
		this.value = elem;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public Node<E> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<E> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", nextNode=" + nextNode + "]";
	}
}
