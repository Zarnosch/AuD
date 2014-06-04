package Blatt_04;

/* 
Antwort zu Teil a)
Berechnet die Quersumme
 */
import aud.Stack;
public class RecursionToStack {

	public static int whatStack(int n) {
		// TODO: implementation
		if(n < 0){
		return n;
		}
		int temp = 0;
		Stack<Integer> stack = new Stack<>();
		while (n > 0){
			stack.push(n%10);
			n = n/10;
		}
		while (!stack.is_empty()){
			temp += stack.pop();
		}
		return temp;

	}


	public static void main(String args[]) {
		// TODO: test
		System.out.println(whatStack(93));
	}

}