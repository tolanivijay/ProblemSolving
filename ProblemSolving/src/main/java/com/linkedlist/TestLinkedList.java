package com.linkedlist;

/* To create a linkedList, all we need to create a node which as
 * address to its next node as in the example mentioned.
 * 
 */
public class TestLinkedList {
	
	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(10);list.add(5);list.add(3);list.add(2);
		
		System.out.println("Size is "+list.size());
		list.showNodes();
		int index = 2;
		System.out.println("Index at "+ index +" is "+ list.getAt(index));
		
		list.addAt(8, 2);
		System.out.println("After adding ---------");
		System.out.println("Size is "+list.size());
		list.showNodes();
		
	}

}
