/**
 * Practiced on 12/10/2012
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 
 * ============================================
 * The idea is simple. Sort the interval array based on its start value. Then merge one by one.
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) 
	{
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals.size() == 0 || intervals == null) return result;
        
        sort(intervals, 0, intervals.size()-1);
        
        result.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); ++i)
        {
            if(intervals.get(i).start <= result.get(result.size()-1).end)
            	result.get(result.size()-1).end = Math.max(intervals.get(i).end, result.get(result.size()-1).end);
            else
            	result.add(intervals.get(i));
        }
        return result;
    }
    
    private void sort(ArrayList<Interval> intervals, int start, int end)
    {
        if(start >= end) return;
        
        int mid = start + (end - start) / 2;
        
        sort(intervals, start, mid);
        sort(intervals, mid+1, end);
        merge(intervals, start, mid, end);
    }
    
    private void merge(ArrayList<Interval> intervals, int start, int mid, int end)
    {
        ArrayList<Interval> temp = new ArrayList<Interval>();
        int aInd = start;
        int bInd = mid+1;
        
        for(int i = 0; i <= end-start; ++i)
        {
            if(aInd <= mid && bInd <= end)
            {
                if(intervals.get(aInd).start < intervals.get(bInd).start)
                	temp.add(intervals.get(aInd++));
                else
                	temp.add(intervals.get(bInd++));
            }
            else if(aInd <= mid)
            	temp.add(intervals.get(aInd++));
            else
            	temp.add(intervals.get(bInd++));
        }
        
        for(int i = 0; i < temp.size(); ++i)
        	intervals.set(start++, temp.get(i));
    }
}
