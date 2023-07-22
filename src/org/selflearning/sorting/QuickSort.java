package org.selflearning.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = { 4, 0, 1, 3, 5, 7, 6 };
		System.out.println("Original array -> ");
		printArray(array);
		sort(array, 0, array.length - 1);
		System.out.println("Sorted Array -> ");
		printArray(array);

	}

	private static void sort(int[] a, int left, int right) {
		if (left < right) {
			int pivot = partition(a, left, right);// partition index which is sorted
			sort(a, left, pivot - 1);// recursively sorting each part divided by partition index
			sort(a, pivot + 1, right);

		}

	}

	private static int partition(int[] a, int left, int right) {
		int l=left,r=right;
		int pivot = a[l];
		for( int i =left;i<r;i++) {
			if(a[i]<pivot) {//4, 0, 1, 3, 5, 7, 6
				swap(a,i,l);
				l++;
			}
			else if(a[i]==pivot) {//6, 0, 1, 3, 5, 7, 4
				swap(a,i,r);
				i--;
			}
		}
		swap(a,l,r);
		return l;
	}

	private static void swap(int[] a, int l, int r) {
		int tmp = a[l];
		a[l] = a[r];
		a[r] = tmp;
		
	}

	private static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + "\t");
		}
		System.out.println();

	}

}
