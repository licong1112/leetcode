/**
 * Practiced on 10/14/2013
 * 
 * Given a string s and a dictionary of words dict, determine if s 
 * can be segmented into a space-separated sequence of one or more 
 * dictionary words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 */

package com.congli.leetcode;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()];
        
        for (int i = 0; i < s.length(); ++i) {
        	if (dict.contains(s.substring(0, i+1))) {
        		dp[i] = true;
        	} else {
        		for (int j = 0; j < i; ++j) {
        			if (dp[j] && dict.contains(s.substring(j+1, i+1))) {
        				dp[i] = true;
        				break;
        			}
        		}
        	}
        }
        return dp[s.length()-1];
    }
}
