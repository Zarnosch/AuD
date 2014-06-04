package Blatt_03;
import java.util.NoSuchElementException;


public class MySList implements Iterable<Integer> {

	Node<Integer> head_ = null;

	public MySList() {
		this.head_ = null;
	}

	public MySList(Integer data) {
		this.head_ = new Node<Integer>(data);
	}

	public MySList(Node<Integer> node) {
		this.head_ = node;
	}

	public boolean empty() {
		return this.head_ == null;
	}

	@Override
	public String toString() {
		String retStr = "";
		for (Integer data: this) {
			retStr += " -> " + data;
		}
		return retStr;
	}

	public void push_back(Integer data) {
		if (empty()) {
			this.head_ = new Node<Integer>(data);
		} 
		else {
			Node<Integer> node = this.head_;
			while (node.next_ != null) {
				node = node.next_;
			}
			node.next_ = new Node<Integer>(data);
		}
	}

	public Iterator iterator() {
		return new Iterator(this.head_);
	}
}


  class Node<T> {

	Node<T> next_ = null;
	T data_ = null;

	public Node() {}

	public Node(T data) {
		this.data_ = data;
	}

	public Node getNext_() {
		return next_;
	}

	public void setNext_(Node next_) {
		this.next_ = next_;
	}

	public T getData_() {
		return data_;
	}

	public void setData_(T data_) {
		this.data_ = data_;
	}

	public String toString() {
		return this.data_.toString();
	}

}

 class Iterator implements java.util.Iterator<Integer> {
	Node<Integer> node_ = null;

	public Iterator(Node<Integer> node) {
		this.node_ = node;
	}

	@Override
	public boolean hasNext() {
		return this.node_ != null;
	}

	@Override
	public Integer next() {
		if (node_ == null) {
			throw new NoSuchElementException();
		}
		Integer data = this.node_.data_;
		this.node_ = this.node_.next_.next_;
		return data;
	}
	
	public static void main(String[] args) {
		// TODO: test
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}

