package Blatt_03;

public class RNode {

	private	int data = Integer.MAX_VALUE ;
	private	RNode prev = null ; // previous node
	private	RNode next = null ; // next node

	public RNode () {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public String toText(){
		String str ="";
		str += "Der Wert dieses Nodes ist: " + this.getData() + "\n";
		str += "Die nächste Node ist: " + this.getNext() + "\n";
		str += "Die vorhergehende Node ist: " + this.getPrev() + "\n";
		return str;
	}
	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public RNode getPrev() {
		return prev;
	}


	public void setPrev(RNode prev) {
		this.prev = prev;
	}


	public RNode getNext() {
		return next;
	}


	public void setNext(RNode next) {
		this.next = next;
	}

	public boolean has_before(){
		if(this.prev != null){
			return true;
		}
		else return false;
	}

	public static void insert_before(RNode n, RNode position){
		n.setNext(position);
		position.getPrev().setNext(n);
		n.setPrev(position.getPrev());
		position.setPrev(n);
	}

	public static RNode find(RNode ring, int x){
		RNode funghi = null;
		RNode temp = ring;
		while(temp != ring.getNext()){
			if(ring.getData() == x){
				funghi = ring;
				return funghi;
			}
			else{
				ring = ring.getNext();
			}
		}
		return funghi;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RNode firstNode = new RNode();
		RNode secondNode = new RNode();
		RNode thirdNode = new RNode();
		
		thirdNode.setData(3);
		firstNode.setData(1);
		secondNode.setData(2);
		
		firstNode.setNext(secondNode);
		secondNode.setPrev(firstNode);
		firstNode.setPrev(secondNode);
		secondNode.setPrev(firstNode);
		
		insert_before(thirdNode, secondNode);
		System.out.println(thirdNode.toText());
	}

}
