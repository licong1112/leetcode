/**
 * Practiced on 11/28/2012
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock 
 * before you buy again).
 * 
 * ==================================
 * Spent quite a bit time on it.
 * The idea is to find the best partition of the array, such that the max sum of each partition
 * is maximized.
 * Therefore we need to note how to calculate the max profit in each partition.
 */

package com.congli.leetcode;

public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) 
	{
	    if(prices == null || prices.length == 0) return 0;
	    
	    int[] maxProfitAhead = new int[prices.length];
	    int[] maxProfitAfter = new int[prices.length];
	    
	    int maxAhead = 0;
	    int maxAfter = 0;
	    
	    int currentIndAhead = 0;
	    int currentIndAfter = prices.length-1;
	    
	    int result = 0;
	    for(int i = 0; i < prices.length; ++i)
	    {
	        if(prices[currentIndAhead ] > prices[i])
	        {
	            currentIndAhead = i;
	        }
	        maxProfitAhead[i] = Math.max(maxAhead, prices[i] - prices[currentIndAhead ]);
	        maxAhead = maxProfitAhead[i];
	    }
	    
	    for(int i = prices.length-1; i >= 0; --i)
	    {
	        if(prices[currentIndAfter] < prices[i])
	        {
	            currentIndAfter = i;
	        }
	        maxProfitAfter[i] = Math.max(maxAfter, prices[currentIndAfter] - prices[i]);
	        maxAfter = maxProfitAfter[i];
	        int profit = maxProfitAhead[i] + maxProfitAfter[i];
	        if(result < profit)
	        {
	            result = profit;
	        }
	    }
	    return result;
	}
}
