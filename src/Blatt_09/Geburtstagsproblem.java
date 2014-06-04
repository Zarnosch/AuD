package Blatt_09;


public class Geburtstagsproblem {
	public static int party(int k) {
		double durchschnitt = 0;
		double personen = 0;
		while(durchschnitt < 0.5){ // 50%
			durchschnitt += personen/k;
			personen++;
		}
		return (int)personen;
	}

	public static int party2(int k) {
		double durchschnitt = 0;
		double personen = 0;
		while(durchschnitt < 1){ // 100%
			durchschnitt += Math.pow(personen/k, k);
			personen++;
		}
		return (int)personen;
	}

	public static void main(String[] args) {
		int test = party(365);
		System.out.println(test);
		int test2 = party2(365);
		System.out.println(test2);
	}
}
