/**
 * Practiced on 1/9/2013
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * 
 * =========================================================
 * The constant space solution is as follows:
 * 1. First detect if the first row and column has 0. If has, mark it.
 * 2. Start from the second row and second column, if matrix[i][j] = 0, set the first element
 * 	  in the i-th row and j-th column to be 0. These 0's are markers! 
 * 3. Start from the second row and second column, if the first element of the i-th row or the
 *    j-th column is 0, then kill the entire row or column.
 * 4. If the first column is marked as to be killed, kill it. So as the first row.
 * 
 * The reason we need to explicitly mark the first row and column, is because if we don't, when
 * we kill the other rows/columns, we may get wrong information. For example, if the matrix is:
 * 
 * 1 2 3 5
 * 4 3 1 4
 * 0 1 0 4
 * 1 2 1 3
 * 0 0 1 1
 * 
 * After step 2:
 * 0 2 0 5
 * 4 3 1 4
 * 0 1 0 4
 * 1 2 1 3
 * 0 0 1 1
 * 
 * Then if we do step 3 from the first row, we will kill the first row, which we shouldn't. 
 * Since the marker are set on the first row and column, then the information of whether kill
 * the first row/column will be destroyed. So we need to explicitly store it.
 * 
 * A better idea stated by peking2: only use the first row! See the second function that I write below.
 */

package com.congli.leetcode;

public class SetMatrixZero {
	public void setZeroes(int[][] matrix) 
    {
        if(matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean killFirstRow = false;
        boolean killFirstCol = false;
        
        //Detect if kill first column
        for(int i = 0; i < m; ++i)
        {
            if(matrix[i][0] == 0)
            {
                killFirstCol = true;
                break;
            }   
        }
        
        // Detect if kill first row
        for(int j = 0; j < n; ++j)
        {
            if(matrix[0][j] == 0)
            {
                killFirstRow = true;
                break;
            }
        }
        
        // Set markers
        for(int i = 1; i < m; ++i)
        {
            for(int j = 1; j < n; ++j)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        // Kill rows and columns starting the second row/column
        for(int i = 1; i < m; ++i)
        {
            if(matrix[i][0] == 0)
            {
                for(int j = 1; j < n; ++j)
                    matrix[i][j] = 0;
            }
        }
        
        for(int j = 1; j < n; ++j)
        {
            if(matrix[0][j] == 0)
            {
                for(int i = 1; i < m; ++i)
                    matrix[i][j] = 0;
            }
        }
        
        if(killFirstRow)
        {
            for(int j = 0; j < n; ++j)
                matrix[0][j] = 0;
        }
        
        if(killFirstCol)
        {
            for(int i = 0; i < m; ++i)
                matrix[i][0] = 0;
        }
    }
	
	/////////////////////////////////////////////
	public void setZeroesPeking2(int[][] matrix) 
    {
        if(matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean killFirstRow = false;
        
        for(int j = 0; j < n; ++j)
        {
            if(matrix[0][j] == 0)
            {
                killFirstRow = true;
                break;
            }
        }
        
        // Only use the first row as markers
        for(int i = 1; i < m; ++i)
        	for(int j = 0; j < n; ++j)
            	if(matrix[i][j] == 0)
                	matrix[0][j] = 0;
        
        // Kill all rows but the first row.
        for(int i = 1; i < m; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(matrix[i][j] == 0)
                {
                    killRow(matrix, i);
                    break;
                }
            }
        }
        
        // Kill columns based on the markers in the first row
        for(int j = 0; j < n; ++j)
        {
            if(matrix[0][j] == 0)
                killCol(matrix, j);
        }
        
        if(killFirstRow)
        {
            for(int j = 0; j < n; ++j)
                matrix[0][j] = 0;
        }
    }
    
    private void killRow(int[][] matrix, int row)
    {
        int n = matrix[0].length;
        for(int j = 0; j < n; ++j)
            matrix[row][j] = 0;
    }
    
    private void killCol(int[][] matrix, int col)
    {
        int m = matrix.length;
        for(int i = 0; i < m; ++i)
            matrix[i][col] = 0;
    }
}
