/**
 * Practiced on 11/30/2013
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on 
 * the same straight line.
 * 
 * ================================================
 * 1. Find the line for each pair of points, and hash the line
 * 2. A line can be defined as follows:
 *    (1) when parallel to x-axis, use x-intercept + "0" (the "0" means 0 slope)
 *    (2) when parallel to y-axis, use y-intercept + "Inf" (infinite slope)
 *    (3) otherwise use either x-intercept or y-intercept + slope
 * 3. The intercept and the slope are calculated and represented by double
 *    variables. It'll be inaccurate to compare double variables, but it should
 *    be accurate enough if we keep three digits after the decimal mark.
 */

package com.congli.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class MaxPointsOnALine {
	
	public int maxPoints(Point[] points) {
        if (points.length < 2) return points.length;
        HashMap<String, HashSet<Integer>> map = new HashMap<String, HashSet<Integer>>();
        int max_point = 0;
        String hash_str = "";
        HashSet<Integer> set = null;
        for (int i = 0; i < points.length-1; ++i) {
        	for (int j = i+1; j < points.length; ++j) {
        		hash_str = hash(points[i], points[j]);
				if (map.containsKey(hash_str)) {
					set = map.get(hash_str);
					if (!set.contains(i)) {
						set.add(i);
					}
					if (!set.contains(j)) {
						set.add(j);
					}
				} else {
					set = new HashSet<Integer>();
					map.put(hash_str, set);
					set.add(i);
					set.add(j);
				}
				max_point = Math.max(max_point, set.size());
        	}
        }
        return max_point;
    }
	
	public String hash(Point point1, Point point2) {
		int x1 = point1.x;
		int x2 = point2.x;
		int y1 = point1.y;
		int y2 = point2.y;
		
		if (x1 == x2) {
			return x1 + " Inf"; // infinite slope
		} else if (y1 == y2) {
			return y1 + " 0"; // 0 slope
		} else {
			int x_numerator = y1*(x2-x1) + x1*(y1-y2);
			int x_denominator = y1 - y2;
			double x_intercept = (double)(x_numerator) / x_denominator;
			double k = (double)(x_denominator)/(x1 - x2);
			// Keep 3 digits after the decimal mark
			return Math.round(x_intercept*1000)/1000.0 + " " + Math.round(k*1000)/1000.0;
		}		
	}
	
	class Point {
		int x;
		int y;
		Point() {
			x = 0;
			y = 0;
		}
		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
}



