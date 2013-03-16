/**
 * Practiced on 1/9/2013
 * 
 * Given an array with n objects colored red, white or blue, sort them so that objects of 
 * the same color are adjacent, with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total 
 * number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * ==========================================
 * This problem is not easy. Something need to be careful:
 * 
 * 1. When A[i] == 2, swap it with A[twoInd]. However, A[twoInd] could be 0. Then after swap, it
 *    is possible that A[i] = 0, while A[i-1] = 1. Therefore, we need to check A[i] again. This is
 *    why when A[i] == 2, we need the --i statement.
 * 2. When A[i] == 0, A[zeroInd] must be 1. If it is not, then it is 2, but if it is 2, it has already
 *    been put to A[twoInd]. So A[zeroInd] must be 1. After swap, A[zeroInd+1] is either 1, or 2. In
 *    either case, we can safely move i to i+1. This is why we don't need --i in this case.
 */

package com.congli.leetcode;

public class SortColors {
	public void sortColors(int[] A) 
	{
        if(A.length <= 1) return;
        int zeroInd = 0;
        int twoInd = A.length-1;

        for(int i = 0; i <= twoInd; ++i)
        {
            if(A[i] == 2)
            {
                swap(A, i, twoInd--);
                i--;
            }
            else if(A[i] == 0)
            	swap(A, i, zeroInd++);
        }
    }
	
	private void swap(int[] A, int a, int b)
    {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
