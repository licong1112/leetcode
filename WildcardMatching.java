/**
 * Practiced on 2/6/2013
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a")  false
 * isMatch("aa","aa")  true
 * isMatch("aaa","aa")  false
 * isMatch("aa", "*")  true
 * isMatch("aa", "a*")  true
 * isMatch("ab", "?*")  true
 * isMatch("aab", "c*a*b")  false
 * 
 * ==============================================
 * This problem is not difficult to write recursive algorithm, but it's
 * not efficient. To write the O(mn) algorithm, it's complicated. The 
 * basic idea is, whenever you meet "*", store current s and t position for
 * future use, and keep matching by ignoring "*" temporarily. Whenever a 
 * fail-to-match happens, if there is "*" previously, then go back to the 
 * previously stored s and t position, and start matching from s+1 and t.
 * 
 * For detailed discussion, check the code here:
 * http://blog.csdn.net/tingmei/article/details/8049926
 */

package com.congli.leetcode;

public class WildcardMatching {

	public boolean isMatch(String s, String p) {
        int sStart = 0;
        int pStart = 0;
        int sInd = 0;
        int pInd = 0;
        boolean hasStar = false;
        
        while(sInd < s.length())
        {
            if(pInd == p.length())
            {
                if(!hasStar) return false;
                sInd = sStart+1;
                pInd = pStart;
            }
            else
            {
                char sChar = s.charAt(sInd);
                char pChar = p.charAt(pInd);
                if(pChar == '?')
                {
                    ++sInd;
                    ++pInd;
                }
                else if(pChar == '*')
                {
                    hasStar = true;
                        
                    while(pInd < p.length() && p.charAt(pInd) == '*') ++pInd;
                    if(pInd == p.length()) return true;
                    
                    sStart = sInd;
                    pStart = pInd-1;
                }
                else
                {
                    if(sChar != pChar)
                    {
                        if(!hasStar) return false;
                        sInd = sStart+1;
                        pInd = pStart;
                    }
                    else
                    {
                        ++sInd;
                        ++pInd;
                    }
                }
            }
        }

        while(pInd < p.length() && p.charAt(pInd) == '*') ++pInd;
        return pInd == p.length();
    }
}
