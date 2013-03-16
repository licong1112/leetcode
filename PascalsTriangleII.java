/**
 * Practiced on 12/16/2012
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class PascalsTriangleII {
	
	public ArrayList<Integer> getRow(int numRows) 
	{
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(numRows < 0) return result;
	    
	    result.add(1);
	    if(numRows == 0) return result;
	    
	    for(int row = 1; row <= numRows; ++row)
	    {
	        ArrayList<Integer> rowArray = new ArrayList<Integer>();
	        rowArray.add(1);
	        for(int j = 1; j < row; ++j)
	        {
	            rowArray.add(result.get(j-1) + result.get(j));
	        }
	        rowArray.add(1);
	        result = rowArray;
	    }
	    return result;
    }
}
