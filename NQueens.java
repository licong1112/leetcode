/**
 * Practiced on 12/12/2012
 * 
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard such that 
 * no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 
 * ===================================
 * Backtracking is the method. Note how to check if a specific position is valid.
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class NQueens {

	public ArrayList<String[]> solveNQueens(int n) 
	{
        ArrayList<String[]> result = new ArrayList<String[]> ();
        
        int[] colInd = new int[n];
        for(int i = 0; i < colInd.length; ++i) colInd[i] = -1;
        solve(result, colInd, 0);
        return result;
    }
    
    private void solve(ArrayList<String[]> result, int[] colInd, int row)
    {
        if(row == colInd.length)
        {
            String[] strArray = new String[colInd.length];
            for(int i = 0; i < strArray.length; ++i)
            {
            	strArray[i] = "";
                for(int j = 0; j < strArray.length; ++j)
                	strArray[i] += (j == colInd[i]) ? "Q" : ".";
            }
            result.add(strArray);
            return;
        }
        
        for(int col = 0; col < colInd.length; ++col)
        {
            if(isValidStep(colInd, col, row))
            {
                colInd[row] = col;
                solve(result, colInd, row+1);
                colInd[row] = -1;
            }
        }
    }
    
    private boolean isValidStep(int[] colInd, int col, int row)
    {
        for(int r = 0; r < row; ++r)
        {
            if(colInd[r] == col) return false;
            if(Math.abs(colInd[r]-col) == Math.abs(row-r)) return false; // Why?!!!!
        }
        return true;
    }
}
