package Blatt_10;

import java.util.*;
public class AdjMatrix{

	public  static int inDegree(int k, int[][] m){  
		int temp = 0;
		k = k-1;
		for(int i = 0; i < m[k].length; i++){
			if(m[k][i] != 0){
				temp++;
			}
		}
		return temp;
	}

	public  static int outDegree(int k, int[][] m){  
		int temp = 0;
		k = k-1;
		for(int i = 0; i < m[k].length; i++){
			if(m[i][k] != 0){
				temp++;
			}
		}
		return temp;
	}

	public  static List<Integer> adjacent(int k, int[][] m){
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		for(int i = 0; i < m.length; i++){
			if(m[k][i] != 0){
				tempList.add(i);
			}
		}
		for(int j = 0; j < m.length; j++){
			if(m[j][k] != 0){
				tempList.add(j);
			}
		}

		return tempList;
	}

	public static boolean hasTriangle(int[][] m) {
		boolean temp = false;
		for (int i = 0; i < m.length; i++){
			List<Integer> adjacentsOfI = adjacent(i,m); 
			for (Integer j : adjacentsOfI){				
				List<Integer> adjacentsOfJ = adjacent(j,m); 
				for (Integer k : adjacentsOfJ){			
					List<Integer> adjacentsOfK = adjacent(k,m); 
					for (Integer l : adjacentsOfK){			
						if (i != j && i != k && i == (int)l){		
							temp = true;
							break;
						}
					}
					if (temp == true){
						break;
					}
				}
				if (temp == true){
					break;
				}
			}
			if (temp == true){
				break;
			}
		}
		return temp;
	}


	public static int[][] EdgeListToAdjMatrix (int[] EdgeList, boolean isDirectional){
		// O(n)   n := Edges
		int NumVertices = EdgeList[0];
		int[][] AdjMatrix_ = new int[NumVertices][NumVertices];
		for(int i = 2; i < EdgeList.length -1; i+=2){
			int Node1 = EdgeList[i];
			int Node2 = EdgeList[i+1];

			AdjMatrix_[Node1-1][Node2-1] = 1;
			//for undirected Graphs they are connected in both ways 1 -> 2 and 2 -> 1
			if(isDirectional == false){
				AdjMatrix_[Node2-1][Node1-1] = 1;
			}			
		}
		return AdjMatrix_;
	}

	public static ArrayList<Integer>[] EdgeListToAdjList (int[] EdgeList){
		int NumVertices = EdgeList[0];
		ArrayList<Integer>[] AdjList = new ArrayList[NumVertices+1];
		for(int i = 2; i < EdgeList.length - 1; i += 2){
			int Node1 = EdgeList[i];
			if(AdjList[Node1] == null){
				AdjList[Node1] = new ArrayList<Integer>();
			}
			AdjList[Node1].add(EdgeList[i+1]);
		}

		return AdjList;
	}

	public static String AdjMatrixToString(int[][] a) {

		String aString;     
		aString = "";
		int column;
		int row;

		for (row = 0; row < a.length; row++) {
			for (column = 0; column < a[0].length; column++ ) {
				aString = aString + " " + a[row][column];
			}
			aString = aString + "\n";
		}

		return aString;
	}


	public static String AdjListToString(ArrayList<Integer>[] AdjList) {

		String temp= "";
		String seperator = " -> ";
		for (int i= 0; i < AdjList.length; i++) {
			if(AdjList[i] != null){
				temp += i + seperator + AdjList[i].toString() + "\n";
			}
		}
		return temp;
	}
	
	public static int[][] matrixMult(int[][] a, int[][] b) {
		//O (n^3)
		int[][] ergebnismatrix = null;
		if (a[0].length == b.length) {
			int zeilenm1 = a.length;
			int spaltenm1 = a[0].length;
			int spaltenm2 = b[0].length;

			ergebnismatrix = new int[zeilenm1][spaltenm2];

			for (int i = 0; i < zeilenm1; i++) {
				for (int j = 0; j < spaltenm2; j++) {
					ergebnismatrix[i][j] = 0;
					for (int k = 0; k < spaltenm1; k++) {
						ergebnismatrix[i][j] += a[i][k] * b[k][j];
					}
				}
			}
		} else {
			int zeilen = a.length;
			int spalten = b[0].length;

			ergebnismatrix = new int[zeilen][spalten];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					ergebnismatrix[i][j] = 0;
				}
			}
		}
		return ergebnismatrix;
	}

	public static int[][] matrixAdd(int[][] a, int[][] b) {
		int[][] ergebnismatrix = null;
		if (a[0].length == b.length) {
			int zeilenm1 = a.length;
			int spaltenm1 = a[0].length;
			int spaltenm2 = b[0].length;

			ergebnismatrix = new int[zeilenm1][spaltenm2];

			for (int i = 0; i < zeilenm1; i++) {
				for (int j = 0; j < spaltenm2; j++) {
					ergebnismatrix[i][j] = a[i][j] + b[i][j];
				}
			}
		} else {
			int zeilen = a.length;
			int spalten = b[0].length;

			ergebnismatrix = new int[zeilen][spalten];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					ergebnismatrix[i][j] = 0;
				}
			}
		}
		return ergebnismatrix;
	}	


	public static void main(String args[]) {
		//EdgeList
		int[] EdgeList1 = {5, 8, 1, 2, 1, 3, 1, 4, 1, 5, 2, 4, 2, 5, 3, 4, 4, 5};
		int[] EdgeList2 = {2, 1};
		//AdjMatrix Test
		int[][] AdjMatrixTest1 = AdjMatrix.EdgeListToAdjMatrix(EdgeList1, true);
		int[][] AdjMatrixTest2 = AdjMatrix.EdgeListToAdjMatrix(EdgeList2, true);
		System.out.println(AdjMatrixToString(AdjMatrixTest1));
		//AdjList Test
		ArrayList[] AdjListTest = AdjMatrix.EdgeListToAdjList(EdgeList1);
		System.out.println(AdjListToString(AdjListTest));
		//AdjMatrix inDegree Test
		System.out.println(inDegree(5, AdjMatrixTest1));
		//AdjMatrix outDegree Test
		System.out.println(outDegree(5, AdjMatrixTest1));
		//AdjMatrix List of directed Nodes of Node k Test
		System.out.println(adjacent(4, AdjMatrixTest1).toString());
		//Has Triangle Test
		System.out.println(hasTriangle(AdjMatrixTest1));
		// Add and Multiply testing
		System.out.println(AdjMatrixToString(matrixAdd(matrixMult(AdjMatrixTest1, AdjMatrixTest1), matrixMult(AdjMatrixTest1, AdjMatrixTest1))));
	}
}