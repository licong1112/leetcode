/**
 * Practiced on 12/8/2012
 * 
 * Given a string containing just the characters '(' and ')', find the length of the 
 * longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", 
 * which has length = 4.
 * 
 * ======================================
 * Below is an implementation of O(n) algorithm. A clearer way to implement it is to build
 * a class with char and its corresponding index. Then we only need one stack.
 */

package com.congli.leetcode;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) 
    {
        Stack<Character> stackChar = new Stack<Character>();
        Stack<Integer> stackIndex = new Stack<Integer>();

        int result = 0;
        
        for(int i = 0; i < s.length(); ++i)
        {
            char currChar = s.charAt(i);
            if(currChar == '(')
            {
                stackChar.push(currChar);
                stackIndex.push(i);
            }
            else
            {
                if(!stackChar.isEmpty() && stackChar.peek() == '(') 
                {
                    stackChar.pop();
                    stackIndex.pop();
                    
                    int length = stackChar.isEmpty() ? (i+1) : (i-stackIndex.peek());
                    result = length > result ? length : result;
                }
                else
                {
                    stackChar.push(currChar);
                    stackIndex.push(i);
                }
            }
        }
        return result;
    }
}
