/**
 * Practiced on 12/16/2012
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class PathSumII {
	
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) 
	{
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(root, sum, result, list);
        return result;
    }
    
    private void helper(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list)
    {
        if(root == null) return;
        if(root.left == null && root.right == null)
        {
            if(sum == root.val)
            {
                ArrayList<Integer> newList = (ArrayList<Integer>)list.clone();
                newList.add(root.val);
                result.add(newList);
            }
            return;
        }
        
        list.add(root.val);
        helper(root.left, sum-root.val, result, list);
        helper(root.right, sum-root.val, result, list);
        list.remove(list.size()-1);
    }
}
