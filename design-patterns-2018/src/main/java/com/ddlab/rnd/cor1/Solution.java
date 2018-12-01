package com.ddlab.rnd.cor1;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public static List<Integer> getIntList( int[] A ) {
        List<Integer> intList = new ArrayList<Integer>();
        for( int i = 0 ; i < A.length; i++)
           intList.add(A[i]);
     return intList;
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        int value = -1;
        List<Integer> intList = getIntList(A);
        for( int i = 1 ; i < 10; i++) {
            if( !intList.contains( new Integer(i)) ) {
                value = i;
                break;
            }

        }
        return value;
    }

  public static void main(String[] args) {
        int[] A = new int[]{1, 3, 6, 4, 1, 2};
    System.out.println( new Solution().solution( A));
//    List<Integer> intList = getIntList(A);
//    System.out.println(intList.contains(new Integer(5)));
  }
}