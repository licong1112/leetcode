/**
 * Practiced on 12/12/2012
 * 
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 * =========================
 * I don't see the difference between this question and the previous one.
 */

package com.congli.leetcode;

public class NQueensII {
	
	public int totalNQueens(int n) 
	{
        int[] colInd = new int[n];
        for(int i = 0; i < colInd.length; ++i) colInd[i] = -1;
        return solve(colInd, 0);
    }
    
    private int solve(int[] colInd, int row)
    {
        if(row == colInd.length)
        	return 1;
        
        int sum = 0;
        for(int col = 0; col < colInd.length; ++col)
        {
            if(isValidStep(colInd, col, row))
            {
                colInd[row] = col;
                sum += solve(colInd, row+1);
                colInd[row] = -1;
            }
        }
        return sum;
    }
    
    private boolean isValidStep(int[] colInd, int col, int row)
    {
        for(int r = 0; r < row; ++r)
        {
            if(colInd[r] == col) return false;
            if(Math.abs(colInd[r]-col) == Math.abs(row-r)) return false;
        }
        return true;
    }
}
