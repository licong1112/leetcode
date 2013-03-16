/**
 * Practiced on 1/24/2013
 * 
 * Given an array of integers, find two numbers such that they add up to 
 * a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that 
 * they add up to the target, where index1 must be less than index2. Please 
 * note that your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */

package com.congli.leetcode;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) 
	{
        int[] result = new int[2];
        if(numbers == null || numbers.length <= 1) return result;
       
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
       
        for(int i = 0; i < numbers.length; ++i)
            map.put(i, numbers[i]);
       
        for(int i = 0; i < numbers.length; ++i)
        {
            if(map.containsValue(target-numbers[i]))
            {
                int j = i+1;
                while(numbers[j] != (target-numbers[i]))
                    ++j;
               
                result[0] = i+1;
                result[1] = j+1;
                break;
            }
        }
        return result;
    }
}
