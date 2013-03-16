/**
 * Practiced on 12/13/2012
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically 
 * next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible 
 * order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding 
 * outputs are in the right-hand column.
 * 
 * 1,2,3 ¡ú 1,3,2
 * 3,2,1 ¡ú 1,2,3
 * 1,1,5 ¡ú 1,5,1
 * 
 * =================================
 * The idea needs some smart observation:
 * 1. Scan from the end to start, find the first point where the array is decreasing. Call it i.
 * 2. Start from i and scan to right, find the first number that is smaller than array[i-1]. Call it j.
 * 3. Change array[i-1] with array[j-1].
 * 4. Reverse array[i...n].
 * 
 * For example: [2,2,7,5,4,3,2,2,1]
 * The first decreasing point is array[2], where array[2] > array[1]. So i = 2.
 * The first number after array[2] that is smaller than array[1] is array[6]. So j = 6.
 * Now swap array[1] with array[5]: [2,3,7,5,4,2,2,2,1].
 * Reverse array[2...n]: [2,3,1,2,2,2,4,5,7].
 * 
 * Why this works?
 */

package com.congli.leetcode;

public class NextPermutation {
	public void nextPermutation(int[] num) 
	{
        if(num == null || num.length == 0) return;
        
        int i = num.length-1;
        while(i > 0 && num[i] <= num[i-1]) 
            --i;
            
        if(i == 0)
        {
            reverse(num, i, num.length-1);
            return;
        }
        
        int j = i;
        while(j < num.length && num[j] > num[i-1])
            ++j;
        
        swap(num, i-1, j-1);   
        reverse(num, i, num.length-1);
    }
    
    private void swap(int[] num, int i, int j)
    {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    private void reverse(int[] num, int i, int j)
    {
        while(i < j)
            swap(num, i++, j--);
    }
}
