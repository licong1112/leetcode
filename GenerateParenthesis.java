/**
 * Practiced on 12/4/2012
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 * For example, given n = 3, a solution set is:

 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class GenerateParenthesis {

	public ArrayList<String> generateParenthesis(int n) 
	{
        ArrayList<String> result = new ArrayList<String>();
        helper(result, 0, 0, n, new char[2*n]);
        
        return result;
    }
    
    private void helper(ArrayList<String> result, int leftNum, int rightNum, int n, char[] str)
    {
        if(leftNum == n && rightNum == n)
        {
            result.add(new String(str));
            return;
        }
        
        if(leftNum < n)
        {
            str[leftNum+rightNum] = '(';
            helper(result, leftNum+1, rightNum, n, str);
        }
        
        if(rightNum < leftNum)
        {
            str[leftNum+rightNum] = ')';
            helper(result, leftNum, rightNum+1, n, str);
        }
    }
}
