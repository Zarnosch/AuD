package Blatt_07;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class RangeTree<T extends Comparable<T>> extends SimpleTree<T> implements Iterable<T> {
	public T begin_, end_;

	public RangeTree(T b, T e) {
		super();
		begin_ = b;
		end_ = e;
	}

	public void setRange(T b, T e) {
		// Do not change (used for backend control)
		begin_ = b;
		end_ = e;
	}

	public class TreeIterator implements Iterator<T> {
		Node node = null;
		public TreeIterator(){
			node = findNode(begin_);
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (this.node  != null) && (this.node.data.compareTo(begin_) >= 0) && (this.node.data.compareTo(end_) <=1);
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if (node == null)
				throw new NoSuchElementException();
			T active = (T) node.data;

			Node prev = null;
			boolean found = false;
			while (!found) {		
				if ((node.right != prev) && (node.right != null)) {
					node = node.right;
					while (node.left != null)
						node = node.left;
					found = true;
				} else {
					prev = node;
					node = node.parent;
					if (node == null)
						break;
					if ((node.right != null) && (node.right != prev))
						found = true;
				}

			}
			return active;

		}
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		// TODO: implementation

	}

	public Iterator<T> iterator() {
		return new TreeIterator();
	}

	public Node findNode(T obj) {
		if (root == null)
			return root;
		Node temp = root;
		Node prev = null;
		while (temp != null) {
			int test = temp.data.compareTo(obj);
			if (test == 0) 							
				return temp;
			prev = temp;
			if (test == -1) {
				temp = temp.left;	
			} else if(test == 1){											
				temp = temp.right;
			} 	
		}
		return prev;
	}

	public static void main(String[] args) {
		// TODO: test
		RangeTree<Integer> testbaum = new RangeTree<Integer>(5,7);
		testbaum.insert(9);
		testbaum.insert(5);
		testbaum.insert(3);
		testbaum.insert(7);
		testbaum.insert(13);
		testbaum.insert(11);
		testbaum.insert(15);
		
		for (int element: testbaum ) {
			System.out.println(element);
		}
	}
}