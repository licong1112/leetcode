/**
 * Practiced on 12/17/2012
 * 
 * The set [1,2,3,бн,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * 
 * =============================================
 * The algorithm works as follows (take n = 4, k = 6) as an example
 * 1. k = k-1 = 5. list = {1, 2, 3, 4}
 * 2. k / 3! = 5/6 = 0; string += list[0] = "1"; list.remove(0) => list = {2, 3, 4}
 * 	  k = k % 3! = 5;
 * 3. k / 2! = 5/2 = 2; string += list[2] = "14"; list.remove(2) => list = {2, 3}
 * 	  k = k % 2! = 1;
 * 4. k / 1! = 1; string += list[1] = "143"; list.remove(1) => list = {2}
 * 	  k = k % 1! = 0;
 * 5. level = 0, get out of the while loop. Since list has {2}, then
 * 	  string += list{0} = {1432}.
 */

package com.congli.leetcode;

import java.util.LinkedList;

public class PermutationSequence {

	public String getPermutation(int n, int k) 
	{
        k = k-1;
        
        int[] factorial = new int[n];
        factorial[0] = 1;
        String result = "";
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        for(int i = 1; i < n; ++i)
        {
            factorial[i] = (i+1) * factorial[i-1];
            list.add(i+1);
        }
        
        int level = n-1;
        while(level != 0 && (k / factorial[level-1] != 0 || k % factorial[level-1] != 0))
        {
            int numInd = k / factorial[level-1];
            result += Integer.toString(list.get(numInd));
            list.remove(numInd);
            k %= factorial[level-1];
            level--;
        }
        
        while(!list.isEmpty())
        {
            result += Integer.toString(list.get(0));
            list.remove(0);
        }
        
        return result;
    }
}
