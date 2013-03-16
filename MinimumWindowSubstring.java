/**
 * Practiced on 12/11/2012
 * 
 * Given a string S and a string T, find the minimum window in S which will contain 
 * all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always be 
 * only one unique minimum window in S.
 * 
 * =========================================
 * The idea is not difficult:
 * 1. Scan S from the beginning to find the first position end such that [start, end] contains all
 * 	  elements in T.
 * 2. Keep scanning toward the end. Every time when end meets S[start], move
 *    start forward such that only one S[end] appears in [start, end]. At the same time, remove
 *    all duplicated elements that appears between [start, end]. For example:
 *    
 *    S = "adebbeceabc" T = "abc"
 *    
 *    First S[start, end] = "adebbec". Then after end move to the position of the next "a", we move
 *    start forward until only one b is contained in [start, end], so that S[start, end] = "becea".
 *    
 *    By doing so, we always keep that [start, end] contains all elements in T, and there is only one
 *    S[start] and one S[end] appears in the range [start, end].
 *    
 * It is VERY tricky to implement this algorithm!! Need to dig into the following code.
 */

package com.congli.leetcode;

public class MinimumWindowSubstring {

	public String minWindow(String S, String T) 
    {
        int[] countS = new int[256];
        int[] countT = new int[256];
        
        for(int i = 0; i < T.length(); ++i)
        {
            countS[(int)T.charAt(i)]++;
            countT[(int)T.charAt(i)]++;
        }
        
        int start = 0;
        int minStart = start;
        int minSize = Integer.MAX_VALUE;
        int count = T.length();
        
        for(int end = 0; end < S.length(); ++end)
        {
            if(countT[(int)S.charAt(end)] > 0)
            {
                 --countS[(int)S.charAt(end)];
                 if(countS[(int)S.charAt(end)] >= 0)
                    --count;
            }
            
            if(count == 0)
            {
            	boolean isStop = false;
            	
                while(!isStop)
                {
                    if(countT[(int)S.charAt(start)] > 0)
                    {
                    	if(countS[(int)S.charAt(start)] < 0)
                    		++countS[(int)S.charAt(start)];
                    	else
                    		break;
                    }
                    ++start;
                }
                int newSize = end-start+1;
                if(minSize > newSize)
                {
                    minSize = newSize;
                    minStart = start;
                }
            }
        }
        if(minSize == Integer.MAX_VALUE) return new String();
        return S.substring(minStart, minStart+minSize);
    }
}
