/**
 * Practiced on 2/5/2013
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 * but "(]" and "([)]" are not.
 */

package com.congli.leetcode;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) 
	{
        if(s == null || s.length() < 2) return false;
       
        Stack<Character> stack = new Stack<Character>();
       
        for(int i = 0; i < s.length(); ++i)
        {
            char currChar = s.charAt(i);
            if(isRight(currChar))
            {
                if(stack.isEmpty()) return false;
                if(!isMatch(stack.pop(), currChar)) return false;
            }
            else
                stack.push(currChar);
        }
        return stack.isEmpty();
    }
   
    private boolean isRight(char c)
    {
        return c == ')' || c == ']' || c == '}';
    }
   
    private boolean isMatch(char c1, char c2)
    {
        switch(c1)
        {
            case '(':
                return c2 == ')';
            case '[':
                return c2 == ']';
            case '{':
                return c2 == '}';
        }
        return true;
    }
}
