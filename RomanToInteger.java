/**
 * Practiced on 1/4/2013
 * 
 * Given a Roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * ==================================
 * Need to notice the rule of addition. See the for-loop for the logic.
 */

package com.congli.leetcode;

import java.util.HashMap;

public class RomanToInteger {
	private static HashMap<Character, Integer> map;
    
	public int romanToInt(String s) 
	{        
	    buildMap();
	    if(s.length() == 1) return map.get(s.charAt(0));
	    
	    int result = 0;
	    for(int i = s.length()-1; i > 0; --i)
	    {
	        int currNum = map.get(s.charAt(i));
	        int nextNum = map.get(s.charAt(i-1));
	        
            result += currNum;
	        if(currNum > nextNum)
	        {
	            result -= nextNum;
	            --i;
	        }    
	    }
	    if(map.get(s.charAt(0))>=map.get(s.charAt(1))) 
	    	result += map.get(s.charAt(0));
	    return result;
	}
    
    private static void buildMap()
    {
        map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
    }
}
