package org.wissen.dsAndAlgo.Sorting;

public class NutsAndBoltProb {

	public static void main(String[] args) {
		char[] nuts = {'^','&','%','@','#','$'};
		char[] bolts = {'$','@','^','&','#','%'};
		System.out.println("Nuts Array -> ");
		printArray(nuts);
		matchPairs(nuts,bolts,0,nuts.length-1);
		System.out.println("Matched Pairs -> ");
		printArray(bolts);
		printArray(nuts);

	}

	private static void matchPairs(char[] nuts, char[] bolts, int i, int j) {
		if(i<j) {
			int p = partition(nuts,i,j,bolts[i]);
			partition(bolts,i,j,nuts[p]);
			matchPairs(nuts, bolts, i, p-1);
			matchPairs(nuts, bolts, p+1, j);
		}
		
	}

	private static int partition(char[] a, int left, int right, char p) {
		int l=left;
		for(int i = left;i<right;i++) {
			if(a[i]<p) {
				swap(a,l,i);
				l++;
			}
			else if(a[i]==p) {
				swap(a,l,right);
				i--;
			}
		}
		swap(a,l,right);
		return l;
	}

	private static void swap(char[] a, int l, int right) {
		char tmp=a[l];
		a[l] = a[right];
		a[right]=tmp;
		
	}

	private static void printArray(char[] a) {
		for(char c : a) {
			System.out.print(c+"\t");
		}
		System.out.println();
		
	}

}
