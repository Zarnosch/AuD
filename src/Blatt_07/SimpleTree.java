package Blatt_07;

public class SimpleTree<T extends Comparable<T>> {

	public class Node {

		T data = null;
		Node left = null;
		Node right = null;
		Node parent = null;

		public Node() {
		}

		public Node(T data_, Node left_, Node right_, Node parent_) {
			data = data_;
			left = left_;
			right = right_;
			parent = parent_;
		}
	}

	public Node root = new Node();
	private String output = "";

	public SimpleTree() {

	}

	private void setBackRoot() { //da die Wurzel staendig veraendert wird, simple Funktion zur Rueckkehr zur "eigentlichen" Wurzel

		while (root.parent != null) {

			root = root.parent;
		}
	}

	public void insert(T obj) {

		if (root.data == null)
			root = new Node(obj, null, null, null); //falls leerer Baum -> obj wird neue Wurzel

		else if (obj.compareTo(this.root.data) > 0) { //falls das Objekt groesser als der gerade betrachtete Knoten ist, wird nach rechts abgestiegen

			if (root.right == null) // wenn sich rechts kein weiterer Knoten befindet, wird dort eingefuegt
				root.right = new Node(obj, null, null, root);

			else {
				root = root.right; //falls sich rechts ein weiterer Knoten befindet, wird weiter rekursiv vorgegangen
				insert(obj);
			}
		} else if (obj.compareTo(this.root.data) == 0) //Errormeldung, wenn Knoten bereits vorhanden
			System.err.println("Knoten mit dem Wert " + obj
					+ " bereits vorhanden!\n");

		else {//falls das Objekt kleiner als der gerade betrachtete Knoten ist, wird nach links abgestiegen
			if (root.left == null) // wenn sich links kein weiterer Knoten befindet, wird dort eingefuegt
				root.left = new Node(obj, null, null, root);

			else {
				root = root.left; //falls sich links ein weiterer Knoten befindet, wird weiter rekursiv vorgegangen
				insert(obj);
			}
		}

		setBackRoot(); //zurueck zur eigentlichen Wurzel
	}

	public String toString() {

		return toString_(root);
	}

	private String toString_(Node node) {

		if (node != null) { //Inorder-Traversierung zur Ueberpruefung der Sortiertheit

			toString_(node.left);
			output += node.data + " ";
			toString_(node.right);
		}

		return output;

	}

	public boolean search(T obj) {

		if(root.data==null)
			return false;

		else{

			if (root.data.compareTo(obj) == 0) { // falls Knoten gefunden wurde, wird wahr zurueckgegeben und root zurueckgesetzt
				setBackRoot();
				return true;
			}

			else if (root.data.compareTo(obj) > 0) {
				if (root.left == null) { //falls das zu ueberpruefende Objekt kleiner als der aktuelle Knoten ist, aber links kein weiteres Kind ist, wird falsch zurueckgegeben
					setBackRoot();
					return false;
				} else {
					root = root.left; //ansonsten wird weiter nach links gegangen
					return search(obj);
				}

			}

			else {
				if (root.right == null) { //falls das zu ueberpruefende Objekt groesser als der aktuelle Knoten ist, aber rechts kein weiteres Kind ist, wird falsch zurueckgegeben

					setBackRoot();
					return false;
				} else {
					root = root.right;	//ansonsten wird weiter nach rechts gegangen
					return search(obj);
				}
			}
		}
	}

	public static void main(String[] args) {

		SimpleTree<Integer> test = new SimpleTree<Integer>();
		test.insert(2);
		test.insert(3);
		test.insert(1);
		test.insert(4);
		test.insert(5);
		test.insert(5); //Knoten mit dem Wert 5 bereits vorhanden!

		System.out.println(test.toString()); //1 2 3 4 5 
		System.out.println(test.search(0)); //false
		System.out.println(test.search(3)); //true

	}

}