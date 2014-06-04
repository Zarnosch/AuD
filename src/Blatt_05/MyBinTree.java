package Blatt_05;

import aud.*;
import aud.util.*;  // because of DotViewer, SingleStepper
public class MyBinTree<T> extends BinaryTree<T>{
	public MyBinTree(T data) {
		super(data);
	}
	public MyBinTree(T data,MyBinTree<T> left,MyBinTree<T> right){
		super(data, left, right);
	}
	
	public int height(){		
		return  this.heightRec_(this.getRoot());
	}

	public int heightRec_(BinaryTree<T> binaryTree){
		int t1 = 1;
		int t2 = 1;
		if(binaryTree.getLeft() != null){
			t1 += heightRec_(binaryTree.getLeft());
		}
		if(binaryTree.getRight() != null){
			t2 += heightRec_(binaryTree.getRight());
		}	
		return t1 > t2 ? t1 : t2;
	}

	public int maxWidth(){
		// TODO: Implementation
		Stack<Integer> steak = new Stack<>();
		int[] width = new int[this.height()];
		int tempWidth = Integer.MIN_VALUE;
		for(int k = 0; k < this.height(); k++){
			width[k] = 0;
		}		

		maxWidthRec_(this.getRoot(), steak);
		while(!steak.is_empty()){			
			width[steak.pop()] +=1 ;
		}
		for(int j = 0; j < this.height(); j++){
			if(width[j] > tempWidth){
				tempWidth = width[j];
			}
		}
		for(int p = 0; p < this.height(); p++){
			if(width[p] == 1){
				System.out.println("Ebene " + (p+1) + " hat: " + width[p] + " Element!");
			}
			else System.out.println("Ebene " + (p+1) + " hat: " + width[p] + " Elemente!");
		}
		return tempWidth -1;
	}

	public void maxWidthRec_(BinaryTree<T> tempTree, Stack<Integer> steak){
		int depth = 0;
		BinaryTree<T> tempTree2 = tempTree;
		while(tempTree2.getParent() != null){
			tempTree2 = tempTree2.getParent();
			depth += 1;			
		}
		steak.push(depth);
		if(tempTree.getLeft() != null){
			maxWidthRec_(tempTree.getLeft(), steak);
		}
		if(tempTree.getRight() != null){
			maxWidthRec_(tempTree.getRight(), steak);
		}	
	}

	public static void main(String[] args) {
		// TODO: test
		MyBinTree<Integer> minusAcht = new MyBinTree<Integer>(-8);
		MyBinTree<Integer> vier = new MyBinTree<Integer>(4);
		MyBinTree<Integer> sechs = new MyBinTree<Integer>(6);
		MyBinTree<Integer> minusElf = new MyBinTree<Integer>(-11);
		MyBinTree<Integer> eins = new MyBinTree<Integer>(1);
		MyBinTree<Integer> fünf = new MyBinTree<Integer>(5);
		MyBinTree<Integer> sieben = new MyBinTree<Integer>(7);
		MyBinTree<Integer> zehn = new MyBinTree<Integer>(10);
		MyBinTree<Integer> sechzehn = new MyBinTree<Integer>(16);

		minusAcht.setLeft(vier);
		minusAcht.setRight(eins);
		vier.setLeft(sechs);
		vier.setRight(minusElf);
		eins.setLeft(fünf);
		eins.setRight(sieben);
		sechs.setLeft(zehn);
		zehn.setLeft(sechzehn);
		
		System.out.println("Die Höhe des Baumes beträgt: " + minusAcht.height());
		System.out.println("Die Ebene mit den meißten Elementen ist: " + minusAcht.maxWidth());
	}
}