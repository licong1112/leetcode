/**
 * Practiced on 12/9/2012
 * 
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node 
 * down to the farthest leaf node.
 */

package com.congli.leetcode;

public class MaximumDepthOfBinarytree {

	public int maxDepth(TreeNode root) 
	{
        if(root == null) return 0;
        
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
