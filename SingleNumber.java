/**
 * Practiced on 10/6/2013
 * 
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
package com.congli.leetcode;

public class SingleNumber {
	public int singleNumber(int[] A) {
        int result = A[0];
        for (int i = 1; i < A.length; ++i) {
            result = result ^ A[i];
        }
        return result;
    }
}
