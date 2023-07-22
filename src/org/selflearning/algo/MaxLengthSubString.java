package org.selflearning.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxLengthSubString {

	public static void main(String[] args) {
		String s = "abcaeebc";
		int res = getMaxSubString(s);
		System.out.println("The O/P -> "+res);

	}

	private static int getMaxSubString(String s) {
		Map<Character,Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int r = 0,l =0;
        int max =0;
        while(r<c.length){
           // if(map.containsKey(c[r])){//abba
               l = Math.max(map.getOrDefault(c[r],0)+1,l);
            //}
               map.put(c[r],r);
            max = Math.max(r-l+1,max);
                r++;
        }

        return max;
        
	}
	
	

}
