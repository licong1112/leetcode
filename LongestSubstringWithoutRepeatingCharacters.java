/**
 * Practiced on 12/8/2012
 * 
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * =================================
 * The algorithm works like this:
 * 0. Define hashset set.
 * 1. i = 0, set = {a}
 * 2. i = 1, set = {a, b}
 * 3. i = 2, set = {a, b, c}
 * 4. i = 3, set = {b, c, a}
 * 5. i = 4, set = {c, a, b}
 * 6. i = 5, set = {a, b, c}
 * 7. i = 6, set = {c, b}
 * 8. i = 7, set = {b}
 */

package com.congli.leetcode;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) 
    {
        if(s == null || s.length() == 0) return 0;
        
        HashSet<Character> set = new HashSet<Character>();
        int maxLength = 0;
        int length = 0;
        int start = 0;
        
        for(int i = 0; i < s.length(); ++i)
        {
            if(set.contains(s.charAt(i)))
            {
                while(set.contains(s.charAt(i)))
                {
                    set.remove(s.charAt(start++));
                    --length;
                }
            }
            set.add(s.charAt(i));
            ++length;
            maxLength = maxLength < length ? length : maxLength;
        }
        return maxLength;
    }
}
