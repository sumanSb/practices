package org.selflearning.algo;

public class GCD {

	public static void main(String[] args) {
		int n1 = 210;
		int n2 = 45;
		int gcd = findGCD(n1,n2);
		System.out.println("The GCD of "+n1+" and "+n2+" is -> "+gcd);

	}

	private static int findGCD(int n1, int n2) {
	int r =0;
		while(n1%n2 !=0) {
			r = n1%n2;
			n1 = n2;
			n2 =r;
		}
		return n2;
	}

}
