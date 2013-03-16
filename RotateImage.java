/**
 * Practiced on 1/7/2013
 * 
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place?
 * 
 * ===============================
 * Just need to be very careful. Not difficult. The idea is the follows:
 * 
 * Suppose we have four elements to be moved:
 * 
 * 1    2
 * 
 * 3    4
 * 
 * 1. Store 1 to another place, called "temp";
 * 2. Put 3 to 1
 * 3. Put 4 to 3
 * 4. Put 2 to 4.
 * 5. Put temp to 2.
 * 
 * Just repeat this procedure layer by layer, and in each layer do this element by element.
 */

package com.congli.leetcode;

public class RotateImage {
	public void rotate(int[][] matrix) 
	{
        int n = matrix.length;
        for(int layer = 0; layer < n/2; ++layer)
        {
            for(int j = layer; j < n-layer-1; ++j)
            {
                int temp = matrix[layer][j];
                matrix[layer][j] = matrix[n-j-1][layer];
                matrix[n-j-1][layer] = matrix[n-layer-1][n-j-1];
                matrix[n-layer-1][n-j-1] = matrix[j][n-layer-1];
                matrix[j][n-layer-1] = temp;
            }
        }
    }
}
