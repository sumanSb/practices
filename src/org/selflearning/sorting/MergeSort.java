package org.selflearning.sorting;



public class MergeSort {

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] a = { 4,5,8,1,7,2,6,3,9 };
		System.out.println("Original array -> ");
		ms.printArray(a);
		ms.mergeSort(a,0,a.length-1);
		System.out.println("Sorted Array -> ");
		ms.printArray(a);

	}
	
	void mergeSort(int[] a, int l,int r) {
		int mid ;
		if(r>l) {
			mid = l+(r-l)/2;
			mergeSort(a,l,mid);
			mergeSort(a, mid+1, r);
			merge(a,l,mid,r);
		}
	}

	private void merge(int[] a, int l, int mid, int r) {
		int n1 = mid - l +1;
		int n2 = r-mid;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(int i=0;i<n1;i++)
			L[i] = a[i+l];
		for(int j =0;j<n2;j++)
			R[j] = a[mid+j +1];
		int i =0,j=0,k=l;
		while(i<n1 && j<n2) {
			if(L[i]<R[j])
				a[k++] = L[i++];
			else
				a[k++] = R[j++];
		}
		while(i<n1)
			a[k++] = L[i++];
		while(j<n2)
			a[k++] = R[j++];
	}
	
	private void printArray(int[] a) {
		for(int i:a)
			System.out.print(i+"\t");
		System.out.println();
	}

}
