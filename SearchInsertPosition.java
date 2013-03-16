/**
 * Practiced on 1/9/2013
 * 
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 * 
 * ===========================
 * The only difference between this problem and binary search is the last return statement.
 */

package com.congli.leetcode;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) 
	{
        if(A.length == 0) return 0;
        
        int start = 0;
        int end = A.length-1;
        int mid = 0;
        while(start <= end)
        {
            mid = start + (end-start)/2;
            if(A[mid] == target) return mid;
            if(A[mid] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return end+1;
    }
}
