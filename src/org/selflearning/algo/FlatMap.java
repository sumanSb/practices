package org.selflearning.algo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMap {
	public static void main(String[] args) throws Exception{
	    Object[] array = { 1, 2, new Object[]{ 3, 4, new Object[]{ 5 }, 6, 7 }, 8, 9, 10 };
	    
        int[] flattenedArray = flatten(array).mapToInt(Integer.class::cast).toArray();
        
        System.out.println(Arrays.toString(flattenedArray));
	}
	
	public static Stream<Object> flatten(Object[] inputArray)  {
		return Arrays.stream(inputArray)
                .flatMap(o -> o instanceof Object[]? flatten((Object[])o): Stream.of(o));
	}
	
}
