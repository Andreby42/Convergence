package com.convergence.common.structure;
/**
 * 
 * @author andreby
 * 鏈表實現棧
 * @param <Item>
 */
public class Stack<Item> {
	private NodeLinkedList<Item> nodes= new NodeLinkedList<>();

	private  int size = nodes.size();

	public boolean isEmpty() {
		return nodes.first == null;
	}

	public int size() {
		return nodes.size();
	}

	/**
	 * push方法
	 */
	public void push(Item item) {
		nodes.filoAdd(item);
	}

	/**
	 * pop方法
	 */

	public Item pop() {
		return nodes.pop();
	}

	public static void main(String[] args) {
		Stack<Object> stack = new Stack<>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		stack.push("E");
		stack.push("F");
		stack.push("G");
		System.out.println(stack.size());
		String pop = (String) stack.pop();
		System.out.println(stack.size());
		
		System.out.println(pop);

	}

}
