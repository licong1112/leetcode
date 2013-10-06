/**
 * Practiced on 10/6/2013
 * 
 * There are N children standing in a line. Each child is assigned a rating value.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */

package com.congli.leetcode;

public class Candy {
	public int candy(int[] ratings) {
        int size = ratings.length;
		int[] left = new int[size];
		int[] right = new int[size];
		
		for (int i = 1; i < size; ++i) {
			left[i] = ratings[i] > ratings[i-1] ? left[i-1]+1 : 0;
			right[size-i-1] = ratings[size-i-1] > ratings[size-i] ? right[size-i]+1 : 0;
		}
		
		int total = 0;
		for (int i = 0; i < size; ++i) {
			total += Math.max(left[i], right[i]);
		}
		return total + size;
    }
}
