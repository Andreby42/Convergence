package com.convergence.common.structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 链表实现 直接双向 無界 先进后出 
 * 
 * @author andreby
 *
 * @param <Item>
 */
public class NodeLinkedList<Item> implements Iterable<Item> {
	Node<Item> first;
	Node<Item> last;
	  int size = 0;

	public NodeLinkedList() {

	}

	/**
	 * 插入鏈表頭
	 * 
	 * @param item
	 * @return
	 */
	void linkFirst(Item item) {
		Node<Item> next = first;
		Node<Item> newNode = new Node<Item>(item, null, next);
		first = newNode;
		if (next == null) {
			// 這是一個新的鏈表
			first = newNode;
		} else {
			next.pre = newNode;
		}
		size++;
	}

	/**
	 * 插入鏈表尾
	 * 
	 * @param item
	 */
	void linkLast(Item item) {
		Node<Item> lasted = last;
		Node<Item> newNode = new Node<Item>(item, lasted, null);
		last = newNode;
		if (lasted == null) {
			// 這是全新列表加入對尾
			first = newNode;
		} else {
			lasted.next = newNode;
		}
		size++;
	}

	/**
	 * 先进先出
	 * 
	 * @param item
	 */
	void fifoAdd(Item item) {
		addLast(item);
	}

	/**
	 * 先进后出 意爲 壓入
	 * 
	 * @param item
	 */
	void filoAdd(Item item) {
		addFirst(item);
	}

	void remove() {
		// 默認移除第一個元素
		Node<Item> f = first;
		if (first == null) {
			throw new NoSuchElementException("沒有該元素");
		}
		// 拿到第一個指向和元素值
		final Item element = f.item;
		final Node<Item> next = f.next;
		// 設置指向為null,元素值為null
		f.next = null;
		f.item = null;
		// 將原來的第一個的指向設置為第一個元素
		first = next;
		if (next == null)
			last = null;
		else
			next.pre = null;
		size--;
	}

	Item pop() {
		// 默認移除第一個元素
		Node<Item> f = first;
		if (first == null) {
			throw new NoSuchElementException("沒有該元素");
		}
		// 拿到第一個指向和元素值
		final Item element = f.item;
		final Node<Item> next = f.next;
		// 設置指向為null,元素值為null
		f.next = null;
		f.item = null;
		// 將原來的第一個的指向設置為第一個元素
		first = next;
		if (next == null)
			last = null;
		else
			next.pre = null;
		size--;
		return element;
	}

	public void addFirst(Item item) {
		linkFirst(item);
	}

	public void addLast(Item item) {
		linkLast(item);
	}

	public boolean add(Item item) {
		linkFirst(item);
		return true;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	// 定義遍歷器
	private class ListIterator implements Iterator<Item> {
		private Node<Item> current = first;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {
		/**
		 * 构造链表 這種簡單node 的方式太傻逼了
		 * 
		 */
		// Node<String> first = new Node<>();
		// Node<String> second = new Node<>();
		// Node<String> third = new Node<>();
		// Node<String> fourth = new Node<>();
		// Node<String> fifth = new Node<>();
		//
		// first.setNext(second);
		// first.item("h");
		//
		// second.item("e");
		// second.setNext(third);
		//
		// third.item("l");
		// third.setNext(fourth);
		//
		// fourth.item("l");
		// fourth.setNext(fifth);
		//
		// fifth.item("o");
		// fifth.setNext(null);
		// System.out.println(first.item.toString() + first.next.item.toString() +
		// first.next.next.item.toString()
		// + first.next.next.next.item.toString() +
		// first.next.next.next.next.item.toString());
		// // 在表頭插入元素
		// Node<Object> newN = new Node<>();
		//
		// newN.item("good!");
		NodeLinkedList<String> list = new NodeLinkedList<>();
		list.fifoAdd("A");
		list.fifoAdd("B");
		list.fifoAdd("B");
		list.fifoAdd("B");
		list.fifoAdd("B");
		list.fifoAdd("B");
		list.fifoAdd("B");
		list.fifoAdd("B");
		list.fifoAdd("B");
		list.fifoAdd("B");
		list.filoAdd("s");

		// list.remove("A");
		System.out.println(list.size);
		System.out.println(list.toString());
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
		}
	}

	public int size() {
		return this.size;
	}

}
