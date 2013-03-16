/**
 * Practiced on 12/8/2012
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

package com.congli.leetcode;

public class LongestCommonPrefix {
public String longestCommonPrefix(String[] strs) 
{
    String result = "";
    if(strs.length == 0) return result;  
    
    int smallestLength = Integer.MAX_VALUE;
    for(String str : strs)
    {
    	if(str.isEmpty()) 
    		return result;
    	smallestLength = Math.min(smallestLength, str.length());
    }
         
    for(int i = 0; i < smallestLength; ++i)
    {
        if(!isCommonLetter(strs, i)) 
        	return result;
        result += strs[0].charAt(i);
    }
    return result;
}

private boolean isCommonLetter(String[] strs, int i)
{
    char letter = strs[0].charAt(i);
    for(String str : strs)
    	if(letter != str.charAt(i)) return false;
    return true;
}
}
