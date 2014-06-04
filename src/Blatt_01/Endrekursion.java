package Blatt_01;

public class Endrekursion {
	/* Endrekursion: eine Endrekursive Methode ruft eine Rekursive Methode auf,
	 * die den Wert für eine Abbruchbedingung mit liefert
	 */
	
	
	public static int pot2TailRec(int n){
		return pot2TailRec_(n, 2);
	}
	
	public static int pot2TailRec_(int n, int c){
		if( n < 0){
			return 0;
		}
		else if (n == 0){
			return 1;
		}
		else if (n == 1){
			return c;
		}
		else{
			return (pot2TailRec_(n-1, c*2));
		}
	}
	
	public static void main(String[] args) {
		System.out.println(pot2TailRec(5) + "");
	}
}
