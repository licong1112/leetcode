/**
 * Practiced on 1/22/2013
 * 
 * Given an array of words and a length L, format the text such that each line 
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words 
 * as you can in each line. Pad extra spaces ' ' when necessary so that each line 
 * has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If 
 * the number of spaces on a line do not divide evenly between words, the empty 
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space 
 * is inserted between words.
 * 
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * Corner Cases:
 * A line other than the last line might contain only one word. What should you do in this case?
 * In this case, that line should be left-justified.
 * 
 * =================================
 * This is not a difficult problem, it's just complicated. Need clear mind to solve it.
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class TextJustification {

	public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        
        if(words.length == 0) return result;
        int start = 0;
        while(start < words.length)
        {
            int end = findEnd(words, L, start);
            if(end == start)
                result.add(buildSingleWord(words[start], L));
            else if(end != words.length-1)
                result.add(buildMultipleWords(words, start, end, L));
            else
                result.add(buildLastLine(words, start, L));
            start = end+1;
        }
        return result;
    }
    
    private String buildSingleWord(String str, int L)
    {
        StringBuilder sb = new StringBuilder(str);
        for(int i = str.length(); i < L; ++i)
            sb.append(" ");
        return sb.toString();
    }

    private String buildMultipleWords(String[] words, int start, int end, int L)
    {
        int count = 0;
        for(int i = start; i <= end; ++i)
            count += (words[i].length());
        
        int numMoreGap = (L-count) % (end-start);
        int gapLength = (L-count) / (end-start);
        
        StringBuilder sb = new StringBuilder(words[start]);
        int index = start+1;
        
        for(int i = 1; i <= numMoreGap; ++i)
        {
            for(int j = 1; j <= gapLength; ++j)
                sb.append(" ");
            sb.append(" "); // One more gap is added.
            sb.append(words[index++]);
        }
        while(index <= end)
        {
            for(int j = 1; j <= gapLength; ++j)
                sb.append(" ");
            sb.append(words[index++]);
        }
        return sb.toString();
    }

    private String buildLastLine(String[] words, int start, int L)
    {
        StringBuilder sb = new StringBuilder();
        int i = start;
        while(i < words.length-1)
        {
            sb.append(words[i++]);
            sb.append(" ");
        }
        sb.append(words[i]);

        for(int j = sb.length(); j < L; ++j)
            sb.append(" ");
        return sb.toString();
    }

    private int findEnd(String[] words, int L, int start)
    {
        if(start == words.length-1) return start;
        int count = 0;
        int i = start;
        while(i < words.length)
        {
            count += words[i].length();
            if(count+i-start > L) break;
            ++i;
        }
        return i-1;
    }
}
