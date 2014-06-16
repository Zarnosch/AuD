package Blatt_10;

/* Antwort zu a)

|101100|
|030020|
|102201|
|102201|
|020030|
|001101|

Die Werte geben die Anzahl der möglichen Wege, um die Knoten zu erreichen, an.

Antwort zu b)
Wenn die Adjazenzmatrix n-mal (n>2) mit sich selbst multipliziert wird,
kann man an den Werten sehen, wieviele Wege es gibt, um die Knoten in
n schritten zu erreichen.
 */

public class GraphConnectivity {

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

	public static void main(String[] args) {
		int[][] test1 = new int[2][3];
		 int[][] test2 = new int[3][2];
		 
		 test1[0][0] = 3;
		 test1[0][1] = 1;
		 test1[0][2] = 2;
		 test1[1][0] = 3;
		 test1[1][1] = 2;
		 test1[1][2] = 4;
		 
		 test2[0][0] = 3;
		 test2[0][1] = -1;
		 test2[1][0] = 2;
		 test2[1][1] = 4;
		 test2[2][0] = 0;
		 test2[2][1] = -2;
		 
		 System.out.println(AdjMatrix.AdjMatrixToString(test1));
		 System.out.println(AdjMatrix.AdjMatrixToString(test2));
		 
		 System.out.println(AdjMatrix.AdjMatrixToString(matrixMult(test1, test2)));
	}
}