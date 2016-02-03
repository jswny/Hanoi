package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ListIterator<E> implements Iterator<E> {
	// TODO (1) choose appropriate attributes
	Node<E> head = null;

	// Constructors
	public ListIterator(Node<E> node) {
		// TODO (2) choose appropriate parameters and do the initialization
		this.head = node;
	}

	@Override
	public boolean hasNext() {
		if (head == null) {
			return false;
		}
		
		if (head.getNext() == null) {
			return false;
		}
		return true;
	}

	@Override
	public E next() {
		if (hasNext()) {
			head = head.getNext();
		} else {
			throw new NoSuchElementException("No next item to get.");
		}
//		E temp = head.getData();
//		head = head.getNext();
//		return temp;
		return head.getData();
		
	}

	// Leave this one alone.
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
