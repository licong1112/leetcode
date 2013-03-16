/**
 * Practiced on 12/19/2012
 * 
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") ¡ú false
 * isMatch("aa","aa") ¡ú true
 * isMatch("aaa","aa") ¡ú false
 * isMatch("aa", "a*") ¡ú true
 * isMatch("aa", ".*") ¡ú true
 * isMatch("ab", ".*") ¡ú true
 * isMatch("aab", "c*a*b") ¡ú true
 * 
 * =====================================
 * Careful consideration is needed. It is not super hard to write the code, but it's hard
 * to pass the judge large. See the important sentence below.
 * 
 * I hate this problem!
 */

package com.congli.leetcode;

public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
    	if(s.isEmpty()) return checkEmpty(p);
        if(p.isEmpty()) return s.isEmpty();
        char sChar = s.charAt(0);
        char pChar = p.charAt(0);
        
        if(p.length()==1 || (!s.equals("") && p.charAt(1) != '*'))
            return (sChar == pChar || pChar == '.') && isMatch(s.substring(1), p.substring(1));
        
        if(sChar == pChar || pChar == '.')
        {
            if(isMatch(s.substring(1), p) || isMatch(s, p.substring(2)))
                return true;
            return false; // This return is important for early termination, otherwise you cannot pass judge large
        }
        if(isMatch(s, p.substring(2))) return true;
        return false; 
    }
    
    private boolean checkEmpty(String p) 
    {
        if (p.length()%2 != 0) 
            return false;   
 
        for (int i = 1; i < p.length(); i+=2) // E.g. s = "", p = "c*c*". Should return true.
            if (p.charAt(i) != '*')
                return false;

        return true;
    }
}
