/**
 * Practiced on 12/27/2012
 * 
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * ==================================
 * The problem is not hard. The code I wrote is clean, but the logic is not easy to follow.
 * For a more logical but more complex code, see the commented function.
 */

package com.congli.leetcode;

public class RemoveDuplicatesFromSortedArrayII {

	public int removeDuplicates(int[] A) 
	{
        if(A == null || A.length == 0) return 0;
        
        int count = 1;
        int result = 1;
        int start = 1;
        
        for(int i = 1; i < A.length; ++i)
        {
            if(A[i] != A[i-1] || (A[i] == A[i-1] && count < 2))
            {
                ++result;
            	count = A[i] != A[i-1] ? 1 : count+1;
                A[start++] = A[i]; // Be careful, this statement HAS TO be put after the previous one! 
                				   // Otherwise this statement will change A, and lead to wrong judgment
                				   // for A[i] != A[i-1].
            }
        }
        return result;
    }
	
	/*public int removeDuplicates(int[] A) 
	{
        if(A == null || A.length == 0) return 0;
        
        int count = 1;
        int result = 1;
        int start = 1;
        
        for(int i = 1; i < A.length; ++i)
        {
            if(A[i] != A[i-1])
            {
                A[start++] = A[i];
                count = 1;
                ++result;
            }
            else if(count < 2)
            {
                A[start++] = A[i];
                ++count;
                ++result;
            }
        }
        return result;
    }*/
	

}
