/**
 * Practiced on 1/15/2013
 * 
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example,
 * Given n = 3,
 * 
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */

package com.congli.leetcode;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) 
	{
        int[][] result = new int[n][n];
        int count = 1;
       
        for(int layer = 0; layer < n/2; ++layer)
        {
            for(int i = layer; i < n-layer-1; ++i)
                result[layer][i] = count++;
          
            for(int i = layer; i < n-layer-1; ++i)
                result[i][n-layer-1] = count++;
              
            for(int i = n-layer-1; i > layer; --i)
                result[n-layer-1][i] = count++;
              
            for(int i = n-layer-1; i > layer; --i)
                result[i][layer] = count++;
        }
       
        if(n%2 == 1)
            result[n/2][n/2] = count;
        return result;
    }
}
