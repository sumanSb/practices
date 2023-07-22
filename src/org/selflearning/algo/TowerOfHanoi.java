package org.selflearning.algo;

public class TowerOfHanoi {

	public static void main(String[] args) {
		int num =2;
		// Shifting the disk from tower A to tower B via Tower C
		String a = "A";
		String b = "B";
		String c = "C";
		towerOfHanoi(num,a,b,c);

	}

	private static void towerOfHanoi(int num, String a, String b, String c) {
		if(num==0)
			return;
		towerOfHanoi(num-1,a,c,b);
		System.out.println("Moving disc "+num+" from Tower "+a+" to Tower "+b);
		towerOfHanoi(num-1, c, b, a);
		
	}

}
