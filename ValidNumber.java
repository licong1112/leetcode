/**
 * Practiced on 1/29/2013
 * 
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 * 
 * ===================================
 * The logic is somehow difficult. Several conditions to check (starting from the first
 * non-blank and non-sign character):
 * 
 * 1. Digit cannot appear after blank: e.g. "10 2" -> false; "1e 2" -> false;
 * 2. Dot cannot appear after dot, e, blank: e.g. "1..2"-> false; "1e.2" -> false;
 * 3. e cannot appear after e, blank, and before any digit appears: e.g. "e1" -> false; "ee" -> false;
 * 4. Sign has to appear after e, nowhere else is allowed.
 * 5. If blank appears, it has to last to the end: e.g. "1  2" -> false; "1   " true;
 * 6. At least one digit has to appear, and if it has e, then at least one digit has to appear
 * 	  after right after e: e.g. "   " -> false; "1e" -> false;
 */

package com.congli.leetcode;

public class ValidNumber {
	public boolean isNumber(String s) 
	{
        if(s == null || s.length() == 0) return false;
        
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ')
            ++i;
        if(i >= s.length()) return false;
        if(s.charAt(i) == '+' || s.charAt(i) == '-') ++i;
        
        boolean hasDot = false;
        boolean hasDigit = false;
        boolean hasE = false;
        boolean hasSign = false;
        boolean hasBlank = false;
        boolean hasDigitAfterE = false;
        
        while(i < s.length())
        {
            char currChar = s.charAt(i);
            if(currChar <= '9' && currChar >= '0')
            {
                if(hasBlank) return false;
                if(hasE) hasDigitAfterE = true;
                else hasDigit = true;
            }
            else
            {
                switch(currChar)
                {
                    case '.':
                        if(hasDot || hasE || hasBlank) return false;
                        hasDot = true;
                        break;
                    case 'e':
                        if(!hasDigit || hasE || hasBlank) return false;
                        hasE = true;
                        break;
                    case '+':
                    case '-':
                        if(hasSign || s.charAt(i-1) != 'e') return false;
                        hasSign = true;
                        break;
                    case ' ':
                        hasBlank = true;
                        break;
                    default:
                        return false;
                }
            }
            ++i;
        }
        return hasDigit && (hasE ? hasDigitAfterE : true);
    }
}
