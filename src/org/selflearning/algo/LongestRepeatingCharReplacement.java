package org.selflearning.algo;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

public class LongestRepeatingCharReplacement {

	public static void main(String[] args) {
		String s = "AABABBA";
		int k = 1;
		int l =  lengthOfLongestPossibleSubstringAfterMakingKCharacterReplacement(s,k);
		System.out.println(l);

	}

	private static int lengthOfLongestPossibleSubstringAfterMakingKCharacterReplacement(String s, int k) {
		int max = Integer.MIN_VALUE;
		int l =0;
		int r =0;
		int maxRepeat =0;
		Map<Character,Integer> map = new HashMap<>();
		while(r<s.length()) {
			map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
			maxRepeat = Math.max(map.get(s.charAt(r)), maxRepeat);// This actually implies the number of character which we cannot replace
			if(r-l+1-maxRepeat >k) {
				map.put(s.charAt(l),map.get(s.charAt(l))-1);
				l++;
			}
			max = Math.max(max, r-l+1);
			r++;
		}
		return max;
	}

}
