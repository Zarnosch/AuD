package Blatt_03;

public class MyCircle<T> {
	class Node {
		T data_ = null;
		Node next_ = null;
		Node prev_ = null;

		Node(T obj, Node prv, Node nxt) {
			data_ = obj;
			prev_ = prv;
			next_ = nxt;
		}
	}
	protected Node head_ = null;
	public MyCircle() {
		// do not change
		head_ = null;
	}
	public T front() {
		return head_.data_;
	}
	public String toString() {
		// do not change (because of backend-control)
		if (empty())
			return "[]";
		String rv = "[";
		Node node = head_;
		do{
			rv += node.data_.toString();
			if (node.next_ != head_)
				rv += ",";
			node = node.next_;
		}while(node != head_);
		rv += "]";
		return rv;
	}
	public int size() {
		// TODO: Implementation
		Node node = this.head_;
		int counter = 0;
		while(this.head_.next_ != node){
			counter++;
			node = node.next_;
		}
		return counter;
	}
	public boolean empty() {
		// TODO: Implementation
		if(this.head_ == null){
			return false;
		}
		else return true;
	}

	public void push_back(T obj) {
		// TODO: Implementation
		if(this.front() == null){
			Node node = new Node(obj, head_, head_);
			head_.next_ = node;
			head_.prev_ = node;
		}
		else{
			Node node = new Node(obj, head_.prev_, head_);
			head_.next_.prev_ = node;
			head_.next_ = node;
		}
	}
	public void pop_front() {
		// TODO: Implementation
		if(head_.next_ != null){
			head_.next_.prev_ = head_.prev_;
			head_.prev_.next_ = head_.next_;
			head_.data_ = null;
		}
	}

	public static void main(String[] args) {
		MyCircle<Integer> kreis = new MyCircle<>();
		kreis.push_back(2);
		kreis.push_back(3);
		System.out.println(kreis.toString());
	}
}
