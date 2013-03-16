/**
 * Practiced on 1/8/2013
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * ============================================
 * Check here: http://leetcode.com/2010/04/searching-element-in-rotated-array.html
 */

package com.congli.leetcode;

public class SearchInRotatedArray {
	public int search(int[] A, int target) 
	{
        if(A.length == 0) return -1;
        
        int start = 0;
        int end = A.length-1;
        int mid = 0;
        while(start <= end)
        {
            mid = start + (end-start)/2;
            if(A[mid] == target) return mid;
            if(A[start] <= A[mid])
            {
                if(A[start] <= target && target < A[mid])
                    end = mid-1;
                else
                    start = mid+1;
            }
            else
            {
                if(A[mid] < target && target <= A[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }
}
