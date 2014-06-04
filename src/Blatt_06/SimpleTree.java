package Blatt_06;

import aud.Stack;

public class SimpleTree <T extends Comparable<T>>{

	private Node root_;
	private Node parent_;
	public SimpleTree() {
		root_ = null;
		parent_ = root_;
	}
	public void insert(T obj) {
		Node temp = new Node(obj);
		if(root_.getRight_() == null){
			root_.setRight_(temp);
			root_.getRight_().setParent_(root_);
			parent_ = root_.getRight_();
		}
		else insert_(obj);

	}
	private void insert_(T obj){
		if(obj.compareTo((T) parent_.getData_()) == 1){
			if(parent_.getLeft_() == null){
				parent_.setLeft_(new Node(obj));
				parent_.getLeft_().setParent_(parent_);
			}
			parent_ = parent_.getLeft_();
			insert_(obj);
		}
		else if(obj.compareTo((T) parent_.getData_()) == -1){
			if(parent_.getRight_() == null){
				parent_.setRight_(new Node(obj));
				parent_.getRight_().setParent_(parent_);
			}
			parent_ = parent_.getRight_();
			insert_(obj);
		}
		else if(obj.compareTo((T)parent_.getData_()) == 0){
			System.out.println("Element existiert schon! " + obj + "\n");
		}

	}

    public boolean search(T obj) {
    	if (root_ == null)
    		return false;
    		Node n = root_;
    		while (n != null) {
    		int res = ((T) n.getData_()).compareTo(obj);
    		if (res == 0)
    		return true;
    		if (res > 0) {
    		n = n.getLeft_();
    		} else {
    		n = n.getRight_();
    		}
    		}
    		return false;
    }

	public String toString() {
		String str = "";
		parent_ = root_;
		if(parent_.getRight_() != null){
			str += "," + parent_.getRight_().getData_();
		}
		return toString_(str);
	}
	private String toString_(String str){
		if(parent_.getLeft_() != null){
			str += "," + parent_.getLeft_().getData_();
		}
		if(parent_.getRight_() != null){
			str += "," + parent_.getRight_().getData_();
		}
		return str;
	}

	public static void main(String[] args) {
		SimpleTree<Integer> kopf = new SimpleTree<Integer>();
		kopf.insert(5);
		System.out.println(kopf.toString());
		SimpleTree<Integer> tree = new SimpleTree<Integer>();
		int r = 8;
		System.out.println(tree.toString());
		System.out.println("Contains 7: " + tree.search(7));
		System.out.println("Contains 8: " + tree.search(8));
		System.out.println("Contains 9: " + tree.search(9));
	}
}
