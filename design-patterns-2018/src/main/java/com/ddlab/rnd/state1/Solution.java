package com.ddlab.rnd.state1;// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int value = -1;
        for( int i = 1 ; i < 100000; i++) {
//            List intList = Arrays.asList(A);
            //https://stackoverflow.com/questions/1073919/how-to-convert-int-into-listinteger-in-java
            List<Integer> intList = new ArrayList<>();
            for( int j = 0 ; j < A.length ; j++) {
                intList.add(A[j]);
            }
      System.out.println(intList);
//            Integer i1 = new Integer(i);
            if( !(intList.contains(i))) {
//        System.out.println(i+"---"+(intList.contains( new Integer(i))));
                value = i;
                break;
            }
        }
        return value;
    }
    
    public static void main(String[] args) {
         int A[] = new int[]{1, 3, 6, 4, 1, 2};
         Solution sol = new Solution();
         int val = sol.solution(A);
         System.out.println(val);//Output should be 5
    }
}