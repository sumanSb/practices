package org.selflearning.algo;

import java.util.HashMap;
import java.util.Map;

public class MaxSubstringKUniqChar {

	// Given a string and k, find longest substring containing k unique character
	public static void main(String[] args) {
		String s = "abcdbjkkljm";
		int k =3;
		int length = findMaxLength(s,k);
		System.out.println("The longest substring length - > "+length);

	}

	private static int findMaxLength(String s, int k) {
		int max = Integer.MIN_VALUE;
		int n = s.length();
		int l=0,r=0;
		int start = 0;
		int tmp=0;
		Map<Character,Integer> map = new HashMap<>();
		while(r<n) {
			map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
			if(map.size()==k) {
				if(r-l+1>max) {
					max = r-l+1;
					start = l;
				}
			}
			if(map.size()>k) {
				while(map.size()>k) {
					tmp = map.get(s.charAt(l));
					 if(tmp==1) {
						 map.remove(s.charAt(l));
					 }
					 else {
						 map.put(s.charAt(l), tmp-1);
					 }
					 l++;
				}
			}
			r++;
		}
		System.out.println(s.substring(start,start+max));
		return max;
	}

}
