package org.selflearning.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum {

	public static void main(String[] args) {
		int[] a = { -2,0,0,2,2 };
		ThreeSum o = new ThreeSum();
		List<List<Integer>> lists = o.threeSum(a);
		System.out.println("[");

		for (List<Integer> list : lists) {
			System.out.print("  [");

			for (int item : list) {
				System.out.print("  " + item + ", ");
			}
			System.out.println("], ");
		}
		System.out.println("]");
	}

	public List<List<Integer>> threeSum(int[] a) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(a);
		for (int i = 0; i < a.length - 2; i++) {
			if(i>0 && a[i]==a[i-1]){
                continue;
            }
			int n1 = a[i];
			int j = i + 1;
			int k = a.length - 1;
			while (k > j) {

				
				int sum = a[j] + a[k];
				if (n1 + sum > 0)
					k--;
				else if (n1 + sum < 0)
					j++;
				else {
					result.add(Arrays.asList(n1,a[k],a[j]));
					j++;
					while(j<k && a[j]==a[j-1]) {
						j++;
					}

				}
				// n1 = a[i+1];

			}
		}

		return result;//.stream().distinct().collect(Collectors.toList());

	}

}
