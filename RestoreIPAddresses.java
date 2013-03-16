/**
 * Practiced on 1/2/2013
 * 
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * For example:
 * Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class RestoreIPAddresses {

	public ArrayList<String> restoreIpAddresses(String s) 
	{ 
        ArrayList<String> result = new ArrayList<String>();
        helper(s, result, "", 0);

        return result;
    }
    
    private void helper(String s, ArrayList<String> result, String str, int level)
    {
    	if(s.isEmpty()) return;
        if(level == 3)
        {
            if(isValid(s))
                result.add(str+"."+s);
            return;
        }
        
        for(int i = 0; i < Math.min(3, s.length()); ++i)
        {
            if(isValid(s.substring(0, i+1)))
            {
                String newString = level == 0 ? str+s.substring(0, i+1) : str+"."+s.substring(0, i+1);
                helper(s.substring(i+1), result, newString, level+1);
            }
        }
    }
    
    private boolean isValid(String s)
    {
    	if(s.length() > 3) return false;
    	if(s.charAt(0) == '0' && s.length() > 1) return false;
        int val = Integer.parseInt(s);
        if(val >= 0 && val <= 255) return true;
        return false;
    }
}
