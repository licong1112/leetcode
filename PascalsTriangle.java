/**
 * Practiced on 12/16/2012
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class PascalsTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) 
	{
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if(numRows <= 0) return result;
	    
	    ArrayList<Integer> one = new ArrayList<Integer>();
	    one.add(1);
	    result.add(one);
	    
	    if(numRows == 1) return result;
	    
	    for(int row = 2; row <= numRows; ++row)
	    {
	        ArrayList<Integer> rowArray = new ArrayList<Integer>();
	        rowArray.add(1);
	        for(int j = 1; j < row-1; ++j)
	        {
	            rowArray.add(result.get(result.size()-1).get(j-1) + result.get(result.size()-1).get(j));
	        }
	        rowArray.add(1);
	        result.add(rowArray);
	    }
	    return result;
	}
}
