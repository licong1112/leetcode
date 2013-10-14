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
