package org.selflearning.algo;

public class MinElemengtInSortedArray {
	public static void main(String[] args) {
		int[] array = {4,5,6,7,1,2,3};//1,2,3,4,5,6,7
		int n = array.length-1;
		int min = findMin(array,0,n);
		System.out.println("The min is -> "+min);
	}

	private static int findMin(int[] array, int l, int r) {
		if(l==r) {
			return array[l];
		}
		if(l>r) {
			return array[0];
		}
		int mid = l+(r-l)/2;
		if(array[mid]<array[mid-1]) {
			return array[mid];
		}
		if(array[mid]<array[r]) {
			return findMin(array, l, mid-1);
		}
		return findMin(array, mid+1, r);
	}

}
