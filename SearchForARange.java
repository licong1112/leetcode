/**
 * Practiced on 1/8/2013
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */

package com.congli.leetcode;

public class SearchForARange {
	public int[] searchRange(int[] A, int target) 
	{
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(A.length == 0) return result;
        
        int leftStart = 0;
        int leftEnd = A.length-1;
        int leftMid = 0;
        while(leftStart <= leftEnd && A[leftStart] != target)
        {
        	// When leftEnd > leftStart, leftMid must be smaller than leftEnd.
        	// We need this property.
            leftMid = leftStart + (leftEnd-leftStart)/2;
            if(A[leftMid] < target)
                leftStart = leftMid+1;
            else if(A[leftMid] > target)
                leftEnd = leftMid-1;
            else
                leftEnd = leftMid;
        }
        if(leftStart > leftEnd) return result;
        
        int rightStart = leftStart;
        int rightEnd = A.length-1;
        int rightMid = 0;
        while(rightStart <= rightEnd && A[rightEnd] != target)
        {
        	// When rightEnd > rightStart, rightMid must be greater than rightStart.
        	// We need this property. This is why "+1" is needed.
        	// Otherwise, if A = {1, 3} and target = 1, we will get infinite loop
            rightMid = rightStart + (rightEnd-rightStart)/2 + 1;
            if(A[rightMid] > target)
                rightEnd = rightMid-1;
            else
                rightStart = rightMid;
        }
        
        result[0] = leftStart;
        result[1] = rightEnd;
        return result;
    }
}
