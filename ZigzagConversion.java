/**
 * Practiced on 2/6/2013
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * =========================================
 * Check out the following observation:
 * 
 * row = 2
 * 0 2 4 6
 * 1 3 5 7
 * 
 * row = 3
 * 0   4   8
 * 1 3 5 7 9
 * 2   6   10
 * 
 * row = 4
 * 0     6       12
 * 1   5 7    11 13
 * 2 4   8 10    14
 * 3     9       15
 * 
 * row = 5
 * 0       8           16
 * 1     7 9        15 17
 * 2   6   10    14    18
 * 3 5     11 13       19
 * 4       12          20
 * 
 * 1. Each "zigzag" has 2*rowNum-2 elements. E.g.: when row = 5, each zigzag has 8 elements
 *    (0-7, 8-15, etc.)
 * 2. Except the first and the last row, each row has two elements in each zigzag. E.g.,
 *    when row=5, the 2nd row has (1, 7) in the first zigzag, and (9, 15) in the second zigzag.
 *    The first element must be rowInd + multiple*zigzagSize, and the second element's rule
 *    can be similarly observed.
 * 
 */

package com.congli.leetcode;

public class ZigzagConversion {

	public String convert(String s, int nRows) {
        if(nRows <= 1) return s;
        StringBuilder sBuilder = new StringBuilder();
        int zigSize = 2*nRows-2;
        
        for(int i = 0; i < nRows; ++i)
        {
            for(int base = i; base < s.length(); base += zigSize)
            {
                sBuilder.append(s.charAt(base));
                int add = base+zigSize-2*i;
                if(i != 0 && i != nRows-1 && add < s.length())
                    sBuilder.append(s.charAt(add));
            }
        }
        
        return sBuilder.toString();
    }
}
