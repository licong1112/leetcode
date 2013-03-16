/**
 * Practiced on 12/7/2012
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.

 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {

	private static final String[] letterSet = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public ArrayList<String> letterCombinations(String digits) {
        
        ArrayList<String> result = new ArrayList<String>();   
        String currString = "";
        helper(digits, 0, currString, result);
        return result;
    }
    
    private void helper(String digits, int level, String currString, ArrayList<String> result)
    {
        if(level >= digits.length()) 
        {
            result.add(currString);
            return;
        }
        
        int digitInt = digits.charAt(level)-'0';
        for(int i = 0; i < letterSet[digitInt].length(); ++i)
        {
            currString += letterSet[digitInt].charAt(i);
            helper(digits, level+1, currString, result);
            currString = currString.substring(0, currString.length()-1);
        }
    }
}
