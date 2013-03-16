/**
 * Practiced on 12/4/2012
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * =========================================
 * For detailed discussion, see http://tianrunhe.wordpress.com/2012/07/15/finding-the-1st-missing-positive-int-in-an-array-first-missing-positive/
 * 
 * The while loop needs some careful thinking:
 * 1. We keep swapping the i-th element of array, until it becomes "illegal" (the if condition is satisfied)
 * 2. Then we ++i;
 * 
 * Why this makes sense? When we do ++i, it means either array[i] is "illegal" 
 * or array[i] is already in the right place.
 * 
 * If array[i] is illegal, it doesn't matter where it will be moved. 
 * Therefore even though we may move array[i] to other places in next iterations, it is fine, 
 * since no matter where it is put, it will be illegal.
 * 
 * If array[i] is already in the right place, due to the condition "array[array[i]-1] == array[i]",
 * it will never be moved again in the future (if you think of it carefully).
 * 
 * On the other hand, if array[i] is both legal and is not in the right place, then we should keep
 * putting array[i] to the right place.
 */

package com.congli.leetcode;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] array) 
	{
        if(array == null || array.length == 0) return 1;
        
        int i = 0;
        while(i < array.length)
        {
            if(array[i] <= 0 || array[i] >= array.length || array[array[i]-1] == array[i])
                ++i;
            else
                swap(array, i, array[i]-1);     
        }
        
        for(int j = 0; j < array.length; ++j)
        {
            if(array[j] != j+1)
                return j+1;
        }
        return array.length+1;
    }
    
    private void swap(int[] array, int a, int b)
    {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
