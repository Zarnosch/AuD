package Blatt_05;

import aud.*;
import aud.util.*;  // because of DotViewer, SingleStepper;
import java.util.Iterator;

public class IntBinTree extends BinaryTree<Integer> {
	public IntBinTree(int data) {
		super(data);
	}	
	public IntBinTree(int data, IntBinTree left, IntBinTree right) {
		super(data, left, right);
	}
	//height
	public int height(){		
		return  this.heightRec_(this.getRoot());
	}

	public int heightRec_(BinaryTree<Integer> tempTree){
		int t1 = 1;
		int t2 = 1;
		if(tempTree.getLeft() != null){
			t1 += heightRec_(tempTree.getLeft());
		}
		if(tempTree.getRight() != null){
			t2 += heightRec_(tempTree.getRight());
		}	
		return t1 > t2 ? t1 : t2;
	}
	
	public int nodeCount(){		
		return  1 + this.nodeCount_(this.getRoot());
	}

	public int nodeCount_(BinaryTree<Integer> tempTree){
		int t1 = 0;
		int t2 = 0;
		if(tempTree.getLeft() != null){
			t1 = 1 + heightRec_(tempTree.getLeft());
		}
		if(tempTree.getRight() != null){
			t2 = 1 + heightRec_(tempTree.getRight());
		}	
		return t1 + t2;
	}
	
	//path
	public int maxPath() {
		return this.maxPathRec_(this.getRoot());
	}

	public int maxPathRec_(BinaryTree<Integer> tempTree){
		int t1 = tempTree.getData();
		int t2 = tempTree.getData();
		if(tempTree.getLeft() != null){
			t1 += maxPathRec_(tempTree.getLeft());
		}
		if(tempTree.getRight() != null){
			t2 += maxPathRec_(tempTree.getRight());
		}	
		return t1 > t2 ? t1 : t2;
	}
	
	//summ
	public int maxSum() {
		return maxSumRec_(this.getLeft()) > maxSumRec_(this.getRight()) ? maxSumRec_(this.getLeft()) : maxSumRec_(this.getRight());			
	}
	
	public int maxSumRec_(BinaryTree<Integer> tempTree){
		int t1 = 0;
		int t2 = 0;
		if(tempTree.getLeft() != null){
			t1 += maxSumRec_(tempTree.getLeft());
		}
		if(tempTree.getRight() != null){
			t2 += maxSumRec_(tempTree.getRight());
		}	
		return t1 + t2 + tempTree.getData();
	}

	public static void main(String[] args) {
		// TODO: test
		IntBinTree minusAcht = new IntBinTree(-8);
		IntBinTree vier = new IntBinTree(4);
		IntBinTree sechs = new IntBinTree(6);
		IntBinTree minusElf = new IntBinTree(-11);
		IntBinTree eins = new IntBinTree(1);
		IntBinTree fünf = new IntBinTree(5);
		IntBinTree sieben = new IntBinTree(7);
		IntBinTree zehn = new IntBinTree(10);
//		IntBinTree sechzehn = new IntBinTree(25);

		minusAcht.setLeft(vier);
		minusAcht.setRight(eins);
		vier.setLeft(sechs);
		vier.setRight(minusElf);
		eins.setLeft(fünf);
		eins.setRight(sieben);
		sechs.setLeft(zehn);
//		sieben.setLeft(sechzehn);


		System.out.println("Maximale Höhe: " + minusAcht.height());
		System.out.println("Maximaler Pfad: " + minusAcht.maxPath());
		System.out.println("Maximal Summe: " + minusAcht.maxSum());
		System.out.println("Node Anzahl: " + minusAcht.nodeCount());
	}
}
