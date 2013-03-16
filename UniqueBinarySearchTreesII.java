/**
 * Practiced on 1/29/2013
 * 
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *    
 * ==================================================
 * DP is another way, but it takes much space.
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class UniqueBinarySearchTreesII {
	public ArrayList<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
   
    private ArrayList<TreeNode> helper(int start, int end)
    {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end)
        {
            result.add(null);
            return result;
        }
        if(start == end)
        {
            result.add(new TreeNode(start));
            return result;
        }
       
        for(int i = start; i <= end; ++i)
        {
            ArrayList<TreeNode> leftNodes = helper(start, i-1);
            ArrayList<TreeNode> rightNodes = helper(i+1, end);
           
            for(TreeNode left : leftNodes)
            {
                for(TreeNode right : rightNodes)
                {
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = left;
                    newNode.right = right;
                    result.add(newNode);
                }
            }
        }
        return result;
    }
}
