/**
 * Practiced on 12/10/2012
 * 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note:
 * You may assume that A has enough space to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * 
 * =============================
 * The idea is simple:
 * 
 * 1. Move all elements of A to the end.
 * 2. Start merge: every time put the smaller element to the front of A array.
 */

package com.congli.leetcode;

public class MergeSortedArray {

	public void merge(int A[], int m, int B[], int n) 
	{
        if(A == null)
        {
            A = B;
            return;
        }

        int index = m+n-1;
        for(int i = m-1; i >= 0; --i)
        	A[index--] = A[i];
        
        int aInd = n;
        int bInd = 0;
        
        for(int i = 0; i < m+n; ++i)
        {
            if(aInd < m+n && bInd < n)
            	A[i] = A[aInd] < B[bInd] ? A[aInd++] : B[bInd++];
            else 
            	A[i] = (aInd < m+n) ? A[aInd++] : B[bInd++];
        }
    }
}
