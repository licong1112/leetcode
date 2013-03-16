/**
 * Practiced on 11/29/2012
 * 
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * 
 * ===============================
 * This is a hard problem. The idea is this:
 * 1. For each node, calculate "single side maximum";
 * 2. For each node, calculate the maximum path sum rooted on left/right node
 * 3. The maximum path sum rooted on this node is the maximum of the following quantities:
 *    (1) One of the maximum path sum rooted on left/right node;
 *    (2) This node itself
 *    (3) Maximum sum rooted on left + right + this node
 *    (4) Maximum of left/right + this node
 */

package com.congli.leetcode;

public class BinaryTreeMaxPathSum {
	
	public int maxPathSum(TreeNode root) {
        
		return findMax(root, new int[1]);
    }

    private int findMax(TreeNode node, int[] singleSide)
    {
        if(node == null)
        {
            singleSide[0] = 0;
            return Integer.MIN_VALUE;
        }
        
        int[] singleLeft = new int[1];
        int[] singleRight = new int[1];
        
        int max = Math.max(findMax(node.left, singleLeft), findMax(node.right, singleRight));
        max = Math.max(max, singleLeft[0] + singleRight[0] + node.val);
        max = Math.max(max, node.val);
        max = Math.max(max, Math.max(singleLeft[0], singleRight[0]) + node.val);
        
        singleSide[0] =Math.max(0, Math.max(singleLeft[0], singleRight[0])) + node.val;
        return max;
    }
  
}
