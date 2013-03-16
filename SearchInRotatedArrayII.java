/**
 * Practiced on 1/8/2013
 * 
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * =================================
 * In this case, if A[start] = A[mid], we cannot tell if left side of mid is sorted or not.
 * For example, if A = {1, 3, 1, 1, 1}, then A[mid] = 1 = A[start], but the left side is not sorted.
 * So in this scenario, we have to separately consider the left and right side.
 * Therefore, the worst case is O(n), such as A = {1, 1, 1, 1, 1, 1, 1, 3, 1}, "3" is detected after
 * the previous "1"'s are all visited.
 */


package com.congli.leetcode;

public class SearchInRotatedArrayII {

	public boolean search(int[] A, int target) {
        if(A.length == 0) return false;
        
        return helper(A, 0, A.length-1, target);
    }
    
    private boolean helper(int[] A, int start, int end, int target)
    {
        int mid = 0;
        while(start <= end)
        {
            mid = start + (end-start)/2;
            if(A[mid] == target) return true;
            if(A[start] < A[mid])
            {
                if(A[start] <= target && target < A[mid])
                    end = mid-1;
                else
                    start = mid+1;
            }
            else if(A[start] > A[mid])
            {
                if(A[mid] < target && target <= A[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
            else
            {
                if(helper(A, start, mid-1, target)) return true;
                return helper(A, mid+1, end, target);
            }
        }
        return false;
    }
}
