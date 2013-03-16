/**
 * Practiced on 12/4/2012
 * 
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * 
 * =========================================
 * A very smart observation:
 * n = 2: {0, 1, 3, 2}
 * n = 3: {0, 1, 3, 2, 6, 7, 5, 4}
 * Therefore 6, 7, 5, 4 are just 2, 3, 1, 0 add (1 << 2), correspondingly.
 * This can be observed by the definition of gray code.
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class GrayCode {
	
	public ArrayList<Integer> grayCode(int n) 
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        helper(n, result);
        return result;
    }
    
    private void helper(int n, ArrayList<Integer> result)
    {
        if(n == 0)
        {
            result.add(0);
            return;
        }
        
        helper(n-1, result);
        
        ArrayList<Integer> newLevel = new ArrayList<Integer>();
        for(int i = result.size()-1; i >= 0; --i)
        	newLevel.add(result.get(i) | 1 << (n-1)); // Important observation
        
        for(Integer num : newLevel)
            result.add(num);
    }
}
