package Blatt_05;

import aud.example.expr.ExpressionParser;
import aud.example.expr.ExpressionTree;
import aud.util.DotViewer;

public class ExampleExpression {

	public static void main(String[] args) {
		String expression1 = "(8+2)*2-(20/2)-(7)";
		String expression2 = "((8-4)*4)-(3/2)+(2)";
		ExpressionParser parser = new ExpressionParser();
		ExpressionTree expTree1 = parser.parse(expression1);
		ExpressionTree expTree2 = parser.parse(expression2);


		System.out.println("Ergebnis 1: " + expTree1.getValue() + "\n");

		System.out.println("Ergebnis 1 in PreOrder: " + expTree1.preorder());
		System.out.println("Ergebnis 1 in InOrder: " + expTree1.inorder());
		System.out.println("Ergebnis 1 in PostOrder: " + expTree1.postorder() + "\n");

		System.out.println("Ergebnis 2 : " + expTree2.getValue() + "\n");

		System.out.println("Ergebnis 2 in PreOrder: " + expTree2.preorder());
		System.out.println("Ergebnis 2 in InOrder: " + expTree2.inorder());
		System.out.println("Ergebnis 2 in PostOrder: " + expTree2.postorder() + "\n");


		DotViewer.displayWindow(expTree1, "(8+2)*12-(20/2)");
		DotViewer.displayWindow(expTree2, "((8-4)*10)-(5/2)");

	}
}