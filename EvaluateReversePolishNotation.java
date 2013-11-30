/**
 * Practiced on 11/30/2013
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

package com.congli.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
        	if (!isOperator(token)) {
        		stack.push(Integer.parseInt(token));
        	} else {
        		int num1 = stack.pop();
        		int num2 = stack.pop();
        		if (token.equals("+")) {
        			stack.push(num2 + num1);
        		} else if (token.equals("-")) {
        			stack.push(num2 - num1);
        		} else if (token.equals("*")) {
        			stack.push(num2 * num1);
        		} else {
        			stack.push(num2 / num1);
        		}
        	}
        }
        return stack.peek();
    }
	
	public boolean isOperator (String str) {
		if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
			return true;
		}
		return false;
	}
}
