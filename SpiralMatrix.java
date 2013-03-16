/**
 * Practiced on 1/15/2013
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * For example,
 * Given the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) 
	{
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0) return result;
       
        int m = matrix.length;
        int n = matrix[0].length;
       
        for(int layer = 0; layer < Math.min(m, n)/2; ++layer)
        {
            for(int i = layer; i < n-layer-1; ++i)
                result.add(matrix[layer][i]);
           
            for(int i = layer; i < m-layer-1; ++i)
                result.add(matrix[i][n-layer-1]);
               
            for(int i = n-layer-1; i > layer; --i)
                result.add(matrix[m-layer-1][i]);
               
            for(int i = m-layer-1; i > layer; --i)
                result.add(matrix[i][layer]);
        }
       
        if(m < n && m%2 == 1)
            for(int i = m/2; i < n-m/2; ++i)
                result.add(matrix[m/2][i]);
        else if(m > n && n%2 == 1)
            for(int i = n/2; i < m-n/2; ++i)
                result.add(matrix[i][n/2]);
        else if(m == n && m%2 == 1)
            result.add(matrix[m/2][m/2]);
           
        return result;
    }
}
