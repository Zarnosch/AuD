package Blatt_04;

import java.util.Iterator;
import java.util.NoSuchElementException;

import aud.DList.BackwardIterator;
import aud.Stack;

public class ForwardList<T> implements Iterable<T>{
	Stack<Node> steak = new Stack<>();
	class Node {
		T data_;
		Node next_ = null;

		public Node(T data, Node next) {
			data_ = data;
			next_ = next;
		}
	}

	Node head_ = null;

	public ForwardList() {
	}
	public boolean empty(){
		return head_ == null;
	}
	public void push_front(T obj) {
		// TODO: implementation
		if(empty()){
			head_ = new Node(obj, null);
			steak.push(head_);
		}
		else{
			Node temp = new Node(obj, head_);
			head_ = temp;
			steak.push(head_);
		}
	}

	public void backTraverse(){
		// TODO: implementation
		while(!steak.is_empty()){
			System.out.print(steak.pop().data_ + ", ");
		}
	}

	public class BackIterator implements java.util.Iterator<T> {

		Node curr_ = null;
		Stack<Node> stack_ = new Stack<Node>();

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !steak.is_empty();
		}

		@Override
		public T next() {
			Node n = steak.pop();
			return n.data_;
		}


		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}		
		// TODO: implementation
		public BackIterator(Node curr) {
			this.curr_ = curr;
			stack_.push(curr);
		}
	}
	
	@Override
	public BackIterator iterator() {
		BackIterator iter = new BackIterator(head_);
		return iter;
	}



	public static void main(String[] args) {
		// TOTO: test
		ForwardList<Integer> listö = new ForwardList<>();
		listö.push_front(1);
		listö.push_front(2);
		listö.push_front(3);
		listö.push_front(4);
		listö.push_front(5);
		//listö.backTraverse();
		for(Integer element : listö){
			System.out.println(element);
		}
	}
	
}
