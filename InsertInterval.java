/**
 * Practiced on 12/5/2012
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * ==================================
 * Not difficult. Just complicated.
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class InsertInterval 
{
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) 
	{
        if(newInterval == null) return intervals;
        if(intervals == null)
        {
            ArrayList<Interval> result = new ArrayList<Interval>();
            result.add(newInterval);
            return result;
        }
        if(intervals.size() == 0)
        {
            intervals.add(newInterval);
            return intervals;
        }
        
        // Case 1: [[3, 5] [6, 7]]   [1, 2]   
        if(newInterval.end < intervals.get(0).start)
        {
            intervals.add(0, newInterval);
            return intervals;
        }
        
        // Case 2: [[3, 5] [6, 7]]   [8, 9]   
        if(newInterval.start > intervals.get(intervals.size()-1).end)
        {
            intervals.add(newInterval);
            return intervals;
        }
        
        
        // Complicated other cases starting here
        int newStart = 0;
        int startDeleteInd = 0;
        
        for(int i = 0; i < intervals.size(); ++i)
        {
            if(newInterval.start <= intervals.get(i).start)
            {
                newStart = newInterval.start;
                startDeleteInd = i;
                break;
            }
            else if(newInterval.start <= intervals.get(i).end)
            {
                newStart = intervals.get(i).start;
                startDeleteInd = i;
                break;
            }
        }
        
        int newEnd = 0;
        int endDeleteInd = 0;
        
        for(int i = 0; i < intervals.size(); ++i)
        {
            if(newInterval.end < intervals.get(i).start)
            {
                newEnd = newInterval.end;
                endDeleteInd = i-1;
                break;
            }
            else if(newInterval.end <= intervals.get(i).end)
            {
                newEnd = intervals.get(i).end;
                endDeleteInd = i;
                break;
            }
            else if(newInterval.end > intervals.get(i).end && i == intervals.size()-1)
            {
                newEnd = newInterval.end;
                endDeleteInd = i;
                break;
            }
        }
        
        // Build result
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        for(int i = 0; i < startDeleteInd; ++i)
        {
            result.add(intervals.get(i));
        }
        result.add(new Interval(newStart, newEnd));
        for(int i = endDeleteInd+1; i < intervals.size(); ++i)
        {
            result.add(intervals.get(i));
        }
        
        return result;
    }
}
