package Blatt_04;

import org.junit.Test;

import aud.BinaryTree;
import junit.*;
public class BuildBinTree {
	public void binaryTreeTest(){
		BinaryTree<Integer> first = new BinaryTree<Integer>(-8);
		BinaryTree<Integer> second = new BinaryTree<Integer>(4);
		BinaryTree<Integer> third = new BinaryTree<Integer>(6);
		BinaryTree<Integer> fourth = new BinaryTree<Integer>(-11);
		BinaryTree<Integer> fifth = new BinaryTree<Integer>(1);
		BinaryTree<Integer> sixth = new BinaryTree<Integer>(5);
		BinaryTree<Integer> sevend = new BinaryTree<Integer>(7);
		
		first.setLeft(second);
		first.setRight(fifth);
		second.setLeft(third);
		second.setRight(fourth);
		fifth.setLeft(sixth);
		fifth.setRight(sevend);
		System.out.println("Inorder: " + first.inorder());
		System.out.println("Preorder: " + first.preorder());
		System.out.println("Postorder: " + first.postorder());
		System.out.println("Levelorder: " + first.levelorder());
	}

	
	public static void main(String[] args) {
		// TODO: test
		 org.junit.runner.JUnitCore.main("Blatt_04.BuildBinTree");
	}
}
