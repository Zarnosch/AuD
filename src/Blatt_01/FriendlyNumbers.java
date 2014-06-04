package Blatt_01;

public class FriendlyNumbers {
	
	
	public static int sumFacTailRec(int n){
		return sumFacTailRec_(n, n-1, 1);
	}
	
	public static int sumFacTailRec_(int n, int c, int d){
		if(c == 1){
			return d;
		}
		else if(n % (c) == 0){
			d += c;
			return sumFacTailRec_(n, c-1, d );
		}
		else return sumFacTailRec_(n, c-1, d);
	}
	
	
	public static void main(String[] args) {
		System.out.println(sumFacTailRec(220));
	}
}
