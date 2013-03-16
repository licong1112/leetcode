/**
 * Practiced on 1/8/2013
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * 
 * =========================================
 * 1. Binary search the last column, such that we find a row "r" that satisfies
 *    matrix[r][0] <= target <= matrix[r][columnSize]
 * 2. Binary search in row "r".
 * 3. Time complexity is thus O(logm + logn).
 */

package com.congli.leetcode;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) 
	{        
        if(matrix.length == 0) return true;
        int R = matrix.length;
        int C = matrix[0].length;
        
        int rowStart = 0;
        int rowEnd = R-1;
        int row = 0;
        while(rowStart <= rowEnd)
        {
            row = rowStart + (rowEnd-rowStart)/2;
            if(matrix[row][C-1] == target) return true;
            if(matrix[row][C-1] < target)
                rowStart = row+1;
            else
            {
                if(matrix[row][0] == target) return true;
                if(matrix[row][0] > target)
                    rowEnd = row-1;
                else
                    return searchInRow(matrix[row], target);
            }
        }
        return false;
    }
    
    private boolean searchInRow(int[] array, int target)
    {
        int start = 0;
        int end = array.length-1;
        if(array[start] == target || array[end] == target) return true;
        
        int index = 0;
        while(start <= end)
        {
            index = start + (end-start)/2;
            if(array[index] == target) return true;
            if(array[index] < target)
                start = index+1;
            else
                end = index-1;
        }
        return false;
    }
}
