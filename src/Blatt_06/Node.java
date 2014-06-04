package Blatt_06;

public class Node<T extends Comparable<T>>{
	private T data_;
	private Node left_ = null;
	private Node right_ = null;
	private Node parent_ = null;
	public Node(){
	}
	public Node(T data){
		this.setData_(data);
	}
	public Node(T data, Node left, Node right){
		this.setData_(data);
		this.setLeft_(left);
		this.setRight_(right);
		this.setParent_(null);
	}
	public Node(T data, Node left, Node right, Node parent){
		this.setData_(data);
		this.setLeft_(left);
		this.setRight_(right);
		this.setParent_(parent);
	}
	public T getData_() {
		return data_;
	}
	public void setData_(T data_) {
		this.data_ = data_;
	}
	public Node getLeft_() {
		return left_;
	}
	public void setLeft_(Node left_) {
		this.left_ = left_;
	}
	public Node getRight_() {
		return right_;
	}
	public void setRight_(Node right_) {
		this.right_ = right_;
	}
	public Node getParent_() {
		return parent_;
	}
	public void setParent_(Node parent_) {
		this.parent_ = parent_;
	}
	
}