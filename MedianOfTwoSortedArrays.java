/**
 * Practiced on 12/9/2012
 * 
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * ========================================
 * The discussion in the site: http://www.leetcode.com/2011/03/median-of-two-sorted-arrays.html
 * is misleading. It is claimed there that it is not easy to adapt "find the k-th element in two
 * sorted array" algorithm, since m+n could be even, which will cause problem. However, this is 
 * not a problem.
 * 
 * The following is the method of using "find the k-th element in two sorted array" algorithm.
 * We only need to change the algorithm a little bit to deal with the even m+n situation. 
 * To see details of "find the k-th element in two sorted array" algorithm, see:
 * http://www.leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html
 * Note that the link above does not have correct implementation. Its code
 * 
 * if (Bj_1 < Ai && Ai < Bj)
 *     return Ai;
 * else if (Ai_1 < Bj && Bj < Ai)
 *     return Bj;
 *     
 * should be
 *     
 * if (Bj_1 <= Ai && Ai <= Bj)
 *     return Ai;
 * else if (Ai_1 <= Bj && Bj <= Ai)
 *     return Bj;
 * 
 * Otherwise it will fail on the test case A = {1}, B = {1, 1, 1}, k = 2.
 * 
 * Note that the following algorithm has the same spirit of Sophie's algorithm given in
 * http://www.leetcode.com/2011/03/median-of-two-sorted-arrays.html#comment-1053
 * The only difference is that, in Sophie's algorithm, she only consider the shorter array. When
 * it is found that the median is not in the shorter array, then the algorithm goes to look for
 * the longer array.
 * 
 * The following algorithm looks in both arrays simultaneously. But if you look at it carefully,
 * both algorithms have similar format.
 * 
 * Since each iteration we eliminate one part of either A or B, thus the complexity is O(logm + logn).
 * Note that the problem asks for O(log(m+n)) complexity. It is not difficult to verify it:
 * 
 * O(logm + logn) = O(log(m+n) + log(m+n)) = O(2log(m+n)) = O(log(m+n)).
 * 
 * Sophie's algorithm has the same complexity: In the worst case, it has to do binary search on the
 * shorter array first, and then do binary search on the longer array. Thus O(logm + logn).
 */

package com.congli.leetcode;

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int A[], int B[]) {
        
        if(A.length==0 || A == null)
        	return (B.length % 2 == 0) ? (B[B.length/2-1] + B[B.length/2])/2.0 : B[B.length/2]/1.0;
        
        if(B.length==0 || B == null)
        	return (A.length % 2 == 0) ? (A[A.length/2-1] + A[A.length/2])/2.0 : A[A.length/2]/1.0;
        
        int ALength = A.length;
        int BLength = B.length;
        int k = (ALength+BLength)%2==1 ? (ALength+BLength)/2+1 : ((ALength+BLength)/2);
        return findKthSmallest(A,0, ALength-1, B, 0, BLength-1, k);
    }
    
    private double findKthSmallest(int A[], int aStart, int aEnd, int B[], int bStart, int bEnd, int k)
    {

    	int m = aEnd - aStart + 1; // Number of under considered elements in a[] 
		int n = bEnd - bStart + 1; // Number of under considered elements in b[]
		
		int i = (int)((double) m/(m+n)*(k-1)); // Starting point of a[]
		int j = k - i - 1; // i + j = k-1      // Starting point of b[]
		
		// Boundary cases
		int ai_1 = i == 0 ? Integer.MIN_VALUE : A[aStart + i-1]; 
		int bj_1 = j == 0 ? Integer.MIN_VALUE : B[bStart + j-1];
		int ai = (i == aEnd - aStart + 1) ? Integer.MAX_VALUE : A[aStart + i];
		int bj = (j == bEnd - bStart + 1) ? Integer.MAX_VALUE : B[bStart + j];
     
	    if (bj_1 <= ai && ai <= bj)
	    {
	   	    if((A.length+B.length)%2 == 1) return (double)ai;
		    if(aStart+i == A.length-1) return (ai+bj)/2.0;
		    return (ai+(Math.min(A[aStart+i+1], bj)))/2.0;
	    }
	    else if (ai_1 <= bj && bj <= ai)
	    {
		    if((A.length+B.length)%2 == 1) return (double)bj;
		    if(bStart+j == B.length-1) return (ai+bj)/2.0;
		    return (bj+(Math.min(B[bStart+j+1], ai)))/2.0;
	    }
	    
	    if(ai < bj) return findKthSmallest(A, aStart+i+1, aEnd, B, bStart, bStart+j, k-i-1);
	    else return findKthSmallest(A, aStart, aStart+i, B, bStart+j+1, bEnd, k-j-1);
    }
}
