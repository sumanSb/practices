package org.selflearning.algo;

import java.util.HashSet;
import java.util.Set;

public class MisssingElement {

	public static void main(String[] args) {
		int[] array = {1};
		int n = findMis(array);
		System.out.println("Output = > "+n);
		
	}

	private static int findMis(int[] A) {
		 Set<Integer> set = new HashSet<>();
	        for(int i : A){
	            if(i>0){
	                set.add(i);
	            }
	        }
	        if(set.size()==0){
	            return 1;
	        }
	        for( int i =1;i<=A.length+1;i++){
	            if(!set.contains(i)){
	                return i;
	            }
	        }
	        return 0;
	}
	

}
