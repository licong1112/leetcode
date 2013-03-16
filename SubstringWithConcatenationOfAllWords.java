/**
 * Practiced on 1/19/2013
 * 
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of each word 
 * in L exactly once and without any intervening characters.
 * 
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * (order does not matter).
 * 
 * ================================
 * It's not difficult to come up with the idea. Need to be careful how to use the
 * hashmap. Also, not easy to write the appropriate code to pass the long test.
 */

package com.congli.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class SubstringWithConcatenationOfAllWords {
	
	public ArrayList<Integer> findSubstring(String S, String[] L) 
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(S == null || S.length() == 0) return result;
        if(L == null || L.length == 0) return result;
        
        HashMap<String, Integer> map = initMap(L);
        int strLength = L[0].length();
        
        for(int i = 0; i <= S.length()-strLength*L.length; ++i) // Important for early stop
        {
            String subStr = S.substring(i, i+strLength);
            if(map.containsKey(subStr))
            {
                if(L.length == 1)
            		result.add(i);
            	else
            	{
                    map.put(subStr, map.get(subStr)-1);
                    if(helper(S, L, map, i+strLength)) // Check if there is match starting from i
                        result.add(i);
                    map = initMap(L);
            	}
            }
        }
        return result;
    }
    
    private boolean helper(String S, String[] L, HashMap<String, Integer> map, int start)
    {
        int i = start;
        int strLength = L[0].length();
        int numWords = L.length-1;
        String subStr = "";
        
        while(i <= S.length()-strLength)
        {
            subStr = S.substring(i, i+strLength);
            if(!map.containsKey(subStr) || map.get(subStr) <= 0) return false;

            map.put(subStr, map.get(subStr)-1);
            --numWords;
            i += strLength;
            if(numWords == 0) return true;
        }
        return false;
    }
    
    private HashMap<String, Integer> initMap(String[] L)
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(String str : L)
        {
            if(map.containsKey(str))
                map.put(str, map.get(str)+1);
            else
                map.put(str, 1);   
        }
        return map;
    }
}
