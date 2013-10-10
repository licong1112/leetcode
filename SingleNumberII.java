/**
 * Practiced on 10/10/2013
 * 
 * Given an array of integers, every element appears three times except for one. 
 * Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it 
 * without using extra memory?
 */

package com.congli.leetcode;

public class SingleNumberII {
	public int singleNumber(int[] A) {
        int[] bit = new int[32]; // Count how many times does '1' appear in each bit.
        for (int i = 0; i < A.length; ++i) {
        	for (int j = 0; j < 32; ++j) {
        		if (((A[i] >> j) & 1) == 1) {
        			++bit[j];
        		}
        	}
        }
        
        int result = 0;
        for (int i = 0; i < 32; ++i) {
        	if (bit[i] != 0 && bit[i] % 3 != 0) {
        		result = (result | (1 << i));
        	}
        }
        return result;
    }
}
