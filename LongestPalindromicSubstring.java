/**
 * Practiced on 12/8/2012
 * 
 * Given a string S, find the longest palindromic substring in S. You may assume that 
 * the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 
 * ===============================
 * The following method that I derived uses DP, and is O(n^2) time complexity and O(n) space complexity.
 * 
 * Suppose we have string "abbac":
 * 
 * 1. Calculate array1[]. Each element array[i] gives the length of string[i], which is 1. So
 * 	  array1 determines if {1, 2, 3, 4, 5} positions of string is palindrome.
 * 2. Calculate array2[]. Each element array[i] gives the length of string[i] to string[i+1], which is 2.
 *    However, if string[i] != string[i+1], then array[i] = 0. So array2 determines if
 *    {12, 23, 34, 45} positions of string is palindrome.
 * 3. Calculate array3[]. It supposes to determine if {13, 24, 35} positions of string is palindrome.
 * 	  How to do it? Since array1 knows if position {2} is palindrome, then if it is and string[1] == string[3],
 *    then the string in the range {13} must be palindrome.
 * 4. Now we have calculated array3. What is useful for the next step is array2 and array3. So we set
 *    array1 = array2, array2 = array3. The original array1 is deleted then. 
 *    Now array1 determines if {12, 23, 34, 45} positions of string is palindrome.
 *    And array2 determines if {13, 24, 35} positions of string is palindrome.
 * 5. Build the new array3 to determin3 if {14, 25} positions of string is palindrome by using the same
 *    strategy above.
 * 
 * At any time we store only three arrays, thus the space complexity is O(3n) = O(n).
 * 
 * However, the space complexity can be O(1). See detailed discussion:
 * http://www.leetcode.com/2011/11/longest-palindromic-substring-part-i.html
 * 
 */

package com.congli.leetcode;

public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        if(s.length() == 1) return s;
        
        int[] array1 = new int[s.length()];
        int[] array2 = new int[s.length()-1];
        
        int max = 0;
        String result = "";
        
        for(int i = 0; i < array1.length; ++i)
            array1[i] = 1;
        
        for(int i = 0; i < array2.length; ++i)
        {
            if(s.charAt(i) == s.charAt(i+1))
            {
            	array2[i] = 2;
                max = 2;
                result = s.substring(i, i+2);
            }
        }
            
        for(int i = 2; i < s.length(); ++i)
        {
            int[] array3 = new int[array2.length-1];
            for(int j = 0; j < s.length()-i; ++j)
            {
                array3[j] = (array1[j+1] > 0 && s.charAt(j) == s.charAt(j+i)) ? array1[j+1]+2 : 0;
                if(max < array3[j])
                {
                    max = array3[j];
                    result = s.substring(j, j+i+1);
                }
            }
            array1 = array2;
            array2 = array3;
        }
        return result;
    }

}
