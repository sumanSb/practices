package org.selflearning.algo;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws java.lang.Exception {
		try (Scanner scn = new Scanner(System.in)) {
			int T = scn.nextInt();
			int N = scn.nextInt();
			int[] a = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = scn.nextInt();
			}
			Test cf = new Test();
			while (T > 0) {
				cf.findMinDiff(a);
				T--;
			}
		}

	}

	private void findMinDiff(int[] a) {
		sort(a, 0, a.length - 1);
		for (int k : a) {
			System.out.print(k + "\t");
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length - 1; i++) {
			int diff = a[i + 1] - a[i];
			if (diff < min && diff >= 0)
				min = a[i + 1] - a[i];
		}
		System.out.println(min);
	}

	private void sort(int[] a, int l, int r) {
		if (r - l <= 1)
			return;
		int lower = l + 1;
		int uper = l + 1;
		int p = a[l];
		for (int i = l + 1; i < r; i++) {
			if (a[i] > p) {
				uper++;
			} else {
				int tmp = a[lower];
				a[lower] = a[uper];
				a[uper] = tmp;
				lower++;
				uper++;
			}
		}
		int tmp = a[l];
		a[l] = a[lower - 1];
		a[lower - 1] = tmp;
		lower--;
		sort(a, l, lower);
		sort(a, lower + 1, r);

	}
}
