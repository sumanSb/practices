package org.selflearning.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(41,67,76,64,21,53,32,88,80));
		System.out.println("The unsorted lkist is - >");
		list.forEach(System.out::println);
		sortList(list);

	}
	
	// Insertion sort is better than Selection sort in case the array is already sorted~O(n)

	private static void sortList(ArrayList<Integer> list) {
		int n = list.size();
		
		for(int i =0 ;i<n;i++) {
			int min = i;
			for(int j = i+1;j<n;j++) {
				if (list.get(j) < list.get(min)) {
					min = j;
				}
			}
			// Swapping the array element
			// list.add() will append the element at specified position
			// and shifts the remaining to the right
			int tmp = list.get(i);
			list.set(i, list.get(min));
			list.set(min,tmp);
		}
		System.out.println("The sorted list -> ");
		list.forEach(System.out::println);
		
	}

}
