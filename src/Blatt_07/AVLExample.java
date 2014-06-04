package Blatt_07;


import Blatt_05.IntBinTree;
import aud.AVLTree;
import aud.BinaryTree;
import aud.example.expr.ExpressionTree;
import aud.util.DotViewer;
import aud.util.SingleStepper;
import aud.util.SingleStepperDemo;

/*****************
answer a)
Ein AVL-Baum ist ein binärer Baum, dessen Teilbäume
einen maximalen Höhenunterschied von 1 haben.
Man muss binäre Bäume ausgleichen, damit man mit logarythmischen Aufwand mit diesen arbeiten kann.
Ansonsten würde der Baum einer Liste ähneln und der Aufwand würde O(n) werden nicht O(log n)

answer b)
Es wird die 14 eingefügt, als Wurzel.
Danach die 15, als rechtes Kind der 14
Danach die 17, als rechtes Kind der 15
!AVL-Eigenschaft verletzt, rotieren (rechtsseitig)
Wurzel 15, linkes Kind der 15 ist die 14, rechtes Kind die 17
Danach die 7, als linkes Kind der 14
Danach die 5, als linkes Kind der 7
!AVL-Eigenschaft verletzt, rotieren (linksseitig)
Wurzel 15, linkes Kind 7, rechtes kind der 7 wird die 14, linkes Kind der 7 wird die 5
Danach 10 einfügen, als linkes Kind der 14
!AVL-Eigenschaft verletzt, rotieren (Links Rechts)
14 Wurzel, 7 linkes Kind der 14, 15 rechtes Kind der 14...
5 linkes Kind der 7, 10 rechtes Kind der 7, 17, rechtes Kind der 15
Danach 16 einfügen, als linkes Kind 15

 *********************/
public class AVLExample {
	public static void main(String[] args) {
		// TODO: Test with DotViewer and SingleStepper
		AVLTree<String,Object> tree=new AVLTree<String,Object> ();
		SingleStepper app = new SingleStepper("single Stepper");
	
		String[] keys={"n","o","q","g","e","j","p"};
		for (String key : keys) {
			System.out.println("insert '"+key+"'");
			tree.insert(key,null);
//			System.out.println(tree);
//			System.out.println(tree.toText());
			tree.checkConsistency();
			app.halt(key);

		}
		DotViewer.displayWindow(tree, "(14,15,17,7,5,10,16)");
	}
}