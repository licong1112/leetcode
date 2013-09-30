/**
 * Practiced on 12/9/2012
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle 
 * containing all ones and return its area.
 * 
 * =============================
 * The idea is not easy to think of.
 * 
 * 1. Suppose we have given matrix
 * 		0 1 1 0 1
 * 		1 1 0 1 0
 * 		0 1 1 1 0
 * 		1 1 1 1 0
 * 		1 1 1 1 1
 * 2. Build the count matrix, which calculates how many 1's each 1 has above:
 * 		0 1 1 0 1
 * 		1 2 0 1 0
 * 		0 3 1 2 0
 * 		1 4 2 3 0
 * 		2 5 3 4 1
 * 3. Then, for each row of count matrix, treat it as a histogram, and find the maximum area
 * 	  given by the histogram.
 * 4. Find the maximum of the maximum area found by each row.
 */

package com.congli.leetcode;

import java.util.Stack;

public class MaximalRectangle {
	
	public int maximalRectangle(char[][] matrix) 
	{
	    if(matrix == null || matrix.length==0) return 0;
	    int[] count1 = new int[matrix[0].length];
	    
	    for(int j = 0; j < matrix[0].length; ++j)
	    	count1[j] = matrix[0][j] - '0';
	    
	    int result = 0;
	    for(int i = 1; i < matrix.length; ++i)
	    {
	    	result = Math.max(result, processRow(count1));
	    	int[] count2 = new int[matrix[0].length];
	        for(int j = 0; j < matrix[0].length; ++j)
	        	count2[j] = matrix[i][j] == '0' ? 0 : count1[j]+1;
	        count1 = count2;
	    }
	    result = Math.max(result, processRow(count1));
	    
	    return result;
	}
	
	private int processRow(int[] array)
	{
	    Stack<Integer> stack = new Stack<Integer>();
	    int[] lengthToRight = new int[array.length];
	    stack.push(0);
	    for(int i = 1; i < array.length; ++i)
	    {
	        while(!stack.isEmpty() && array[stack.peek()] > array[i])
	        {
	            lengthToRight[stack.peek()] = i-stack.peek();
	            stack.pop();
	        }
	        stack.push(i);
	    }
	    while(!stack.isEmpty())
	    {
	        lengthToRight[stack.peek()] = array.length-stack.peek();
	        stack.pop();
	    }
	
	    int[] lengthToLeft = new int[array.length];
	    stack.push(array.length-1);
	    for(int i = array.length-2; i >= 0; --i)
	    {
	        while(!stack.isEmpty() && array[stack.peek()] > array[i])
	        {
	            lengthToLeft[stack.peek()] = stack.peek()-i-1;
	            stack.pop();
	        }
	        stack.push(i);
	    }
	    while(!stack.isEmpty())
	    {
	        lengthToLeft[stack.peek()] = stack.peek();
	        stack.pop();
	    }
	    
	    int result = 0;
	    for(int i = 0; i < array.length; ++i)
	    {
	        result = Math.max(result, array[i]*(lengthToLeft[i]+lengthToRight[i]));
	    }
	    return result;
	}
}
