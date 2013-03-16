/**
 * Practiced on 12/7/2012
 * 
 * Given n non-negative integers representing the histogram's bar height where 
 * the width of each bar is 1, find the area of largest rectangle in the histogram.
 * 
 * For example,
 * Given height = [2,1,5,6,2,3],
 *                6
 *             5  ___
 *            ___|___|
 *           | x | x |     3
 *     2     | x | x | 2  ___
 *    ___  1 | x | x |___|   |
 *   |   |___| x | x |   |   |
 *   |___|___|_x_|_x_|___|___| 
 *   
 * return 10.
 * 
 * =================================
 * 
 * This problem is not easy. But the idea could be clear: 
 * For each height[i], we need to find how long the horizontal line with height height[i] could be.
 * 
 * To achieve this target, we separately calculate the length of the line to the left of height[i],
 * and to the right of height[i].
 * 
 * Take the calculation of the length of the line to the right of height[i] as an example, here is
 * how we proceed it:
 * 
 * lengthToRight = [0, 0, 0, 0, 0, 0]
 * i = 0: stack: (0)
 * i = 1: height[i] < height[i-1], so pop stack and get 0. This means the line of height[0] can be
 * 		  drawn to the index i = 1. Therefore we set lengthToRight[0] = 1. Push 1 into stack.
 * 
 * lengthToRight = [1, 0, 0, 0, 0, 0], stack: (1).
 * 
 * i = 2: height[i] > height[i-1], so push 2 into stack: stack: (1, 2).
 * i = 3: height[i] > height[i-1], so push 3 into stack: stack: (1, 2, 3).
 * i = 4: height[i] < height[i-1], so pop stack and get 3. Thus the line of height[3] can be drawn 
 * 		  to the index i = 4. Therefore lengthToRight[3] = (4-3=1).
 * 		  Keep popping stack, get 2, since height[2] > height[4]. This means the line of height[4]
 * 		  can be drawn to the index i = 4. Therefore lengthToRight[2] = (4-2=2).
 * 		  Stop popping, since height[1] < height[4]. Push 4 into stack.
 * 
 * lengthToRight = [1, 0, 2, 1, 0, 0], stack: (1, 4).
 * 
 * i = 5: height[i] > height[i-1], so push 5 into stack. stack: (1, 4, 5).
 * 
 * Now the stack has 1, 4, 5. It means the line of height[1] can be drawn to the end of right.
 * Therefore, we have lengthToRight[1] = (height.length-1=5). 
 * Similarly, we have lengthToRight[4] = (height.length-4=2).
 * Similarly, we have lengthToRight[5] = (height.length-5=1).
 * 
 * Now we are done in calculating the lengthToRight: [1, 5, 2, 1, 2, 1]. 
 * 
 * Then we use similar strategy to calculate the length of each line of height[i] that is drawn
 * to the left.
 * 
 * After we calculate these quantities, we can calculate the area based on each height[i]. Then
 * we can easily get the maximum.
 * 
 * The time complexity should be O(n). 
 */

package com.congli.leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public int largestRectangleArea(int[] height) 
	{ 
        if(height == null || height.length == 0) return 0;
        if(height.length == 1) return height[0];
        
        // Build lengthToRight
        int[] lengthToRight = new int[height.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        
        for(int i = 1; i < height.length; ++i)
        {
            if(height[i] < height[i-1]) 
            {
            	// The if statement can be deleted, and just keep the below while loop.
            	// The reason is that, height[i-1] is always located at the peek(), if
            	// you think carefully.
                while(!stack.isEmpty() && height[stack.peek()] > height[i])
                {
                    lengthToRight[stack.peek()] = (i-stack.peek());
                    stack.pop();
                }
                
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty())
        {
            lengthToRight[stack.peek()] = (height.length-stack.peek());
            stack.pop();
        }
        
        // Build lengthToLeft
        int[] lengthToLeft = new int[height.length];
        stack.push(height.length-1);
        for(int i = height.length-2; i >= 0; --i)
        {
            if(height[i] < height[i+1])
            {
            	// The above if statement can be deleted. The reason is similar
            	// to the above for loop.
                while(!stack.isEmpty() && height[stack.peek()] > height[i])
                {
                    lengthToLeft[stack.peek()] = (stack.peek()-i-1);
                    stack.pop();
                }
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty())
        {
            lengthToLeft[stack.peek()] = stack.peek();
            stack.pop();
        }
        
        // Calculate the maxArea
        int maxArea = 0;
        for(int i = 0; i < height.length; ++i)
        {
            maxArea = Math.max(height[i] * (lengthToLeft[i] + lengthToRight[i]), maxArea);
        }
        return maxArea;
    }
}
