package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImplementation<T> implements ListInterface<T>{

	private int size;
	private Node<T> head;
	private Node<T> end;
	
	LinkedStack<T> stack;
	
	public ListImplementation() {
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public T get(int n) throws NoSuchElementException {
		Node<T> currNode = head;
		
		if (n > size - 1) {
			throw new NoSuchElementException();
		}
		
		if (n < 0) {
			throw new NoSuchElementException();
		}
		
		for (int i = 0; i <= n; i++) {
			currNode = currNode.getNext();
		}
		return currNode.getData();
	}
	
	public ListInterface<T> append(T elem) {
		
		if (elem == null) {
			throw new NullPointerException();
		}
		
		if (head == null) {
			head = new Node<T>(elem, null);
			end = head;
		}
		Node<T> newNode = new Node<T>(elem, null);
		end.setNext(newNode);
		end = newNode;
		
		size++;
		return this;
	}
	
	public Iterator<T> iterator() {
		return new ListIterator<T>(head);
	}
	
}
