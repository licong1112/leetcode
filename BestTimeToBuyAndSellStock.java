/**
 * Practiced on 11/26/2012
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */

package com.congli.leetcode;

public class BestTimeToBuyAndSellStock {
	
	public int maxProfit(int[] prices) 
    {
        if(prices == null || prices.length == 0) return 0;
        
        int result = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; ++i)
        {
            if(min > prices[i])
            {
                min = prices[i];
            }

            int difference = prices[i] - min;
            if(result < difference)
            {
                result = difference;
            }  
        }
        return result;
    }

}
