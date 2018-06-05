package com.convergence.common.structure;

public class Node<Item> {
	
	 Item item;
	
	 Node<Item> next;
	
	 Node<Item> pre;

	 
	 
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Node(Item item, Node<Item> next) {
		super();
		this.item = item;
		this.next = next;
	}

	public Node(Item item, Node<Item> next, Node<Item> pre) {
		super();
		this.item = item;
		this.next = next;
		this.pre = pre;
	}

	public Item getItem() {
		return item;
	}
	
	public Item item() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Node<Item> getNext() {
		return next;
	}

	public void setNext(Node<Item> next) {
		this.next = next;
	}

	public Node<Item> getPre() {
		return pre;
	}

	public void setPre(Node<Item> pre) {
		this.pre = pre;
	}
	
	

}
