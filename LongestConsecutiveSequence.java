/**
 * Practiced on 2/18/2013
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * ============================================
 * One thing need to be careful: Don't use iterator of the hashset to substitute the 
 * second for loop. Otherwise it will have a error, since the elements in the set will
 * be removed, which will conflict the iterator.
 */

package com.congli.leetcode;

import java.util.HashSet;

public class LongestConsecutiveSequence 
{
	public int longestConsecutive(int[] num) 
    {
        if(num.length == 0) return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < num.length; ++i)
        	set.add(num[i]);
        
        int max_length = 0;
        for(int i = 0; i < num.length; ++i)
        {
            int count = 1;
            int curr_num = num[i]+1;
            while(set.contains(curr_num))
            {
                set.remove(curr_num);
                ++curr_num;
                ++count;
            }
            curr_num = num[i]-1;
            while(set.contains(curr_num))
            {
                set.remove(curr_num);
                --curr_num;
                ++count;
            }
            max_length = Math.max(max_length, count);
        }
        return max_length;
    }
}
