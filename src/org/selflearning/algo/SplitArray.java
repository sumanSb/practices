package org.selflearning.algo;

public class SplitArray {

	public static void main(String[] args) {
		
		SplitArray sa = new SplitArray();
		int[] a = {7,2,3,9,1,0,8,6,5,4};
		int splitSize = 3;
		System.out.println("Input Array");
		sa.printArray(a);
		System.out.println("Output Array");
		sa.split(a,splitSize);
		
		
	}

	private void split(int[] a, int splitSize) {
		int count =0;
		int j =0;
		int[] n = new int[splitSize];
		while(count<=splitSize && j<=a.length) {
			count++;
			j++;
			if(count == splitSize) {
			for(int i = 0;i<splitSize;i++){
				n[i] = a[j-splitSize+i];
			}
			count=0;
			
			printArray(n);
			}
		}
		
	}

	private void printArray(int[] n) {
		for(int i:n) {
			System.out.print(i+"\t");
		}
		System.out.println();
		
	}

}
