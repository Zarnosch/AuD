package Blatt_06;

import aud.*;
import aud.example.expr.*;
import aud.example.expr.Number;
import aud.util.*;

public class Differentiation {

   public static ExpressionTree differentiate(BinaryTree<AtomicExpression> t, String var) {
	   ExpressionTree tempTree = null;
	   if(t.getData().getType() == AtomicExpression.Type.OpPlus){
		   return new ExpressionTree(new Plus(), differentiate(t.getLeft(), var), differentiate(t.getRight(), var));		   
	   }
	   if(t.getData().getType() == AtomicExpression.Type.OpMinus){
		   return new ExpressionTree(new Minus(), differentiate(t.getLeft(), var), differentiate(t.getRight(), var));
	   }
	   if(t.getData().getType() == AtomicExpression.Type.OpTimes){
		   return new ExpressionTree(new Plus(), new ExpressionTree(new Times(), differentiate(t.getLeft(), var), (ExpressionTree) t.getRight())
		   , new ExpressionTree(new Times(), (ExpressionTree) t.getLeft(),differentiate(t.getRight(), var)));
	   }
	   return tempTree;
	   
   }
   
   public static void main(String[] args) {
      // TODO: test
	   String str = ("(2+3)");
	   ExpressionTree tree = new ExpressionTree(new Plus());
	   ExpressionTree left = new ExpressionTree(new Number(2));
	   ExpressionTree right = new ExpressionTree(new Number(3));
	   tree.setLeft(left);
	   tree.setRight(right);
	   ExpressionTree lulz = differentiate(tree, str);
	   DotViewer.displayWindow(lulz, str);
   }
}
