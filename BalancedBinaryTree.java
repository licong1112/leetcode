/**
 * Given a binary tree, determine if it is height-balanced.

 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * 
 * =================================
 * 1/13/2013 update:
 * The previous method is O(n^2). A better O(n) solution is provided below.
 */
package com.congli.leetcode;

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root, 0);
    }
    
    private boolean isBalancedHelper(TreeNode root, int currentHeight)
    {
        if(root == null) return true;
        
        int leftHeight = getHeight(root.left, currentHeight);
        int rightHeight = getHeight(root.right, currentHeight);
        
        if(leftHeight - rightHeight <= 1 && leftHeight - rightHeight >= -1)
        {
            return isBalancedHelper(root.left, currentHeight+1) && isBalancedHelper(root.right, currentHeight+1);
        }
        else
        {
            return false;
        }
    }
    
    private int getHeight(TreeNode node, int height)
    {
        if(node == null) return height;
        return Math.max(getHeight(node.left, height+1), getHeight(node.right, height+1));
    }
    
    
    ////////////////////////////////////////////////////
    ////////////////////////////////////////////////////
    
    public boolean isBalancedONTimeComplexity(TreeNode root) {
        if(root == null) return true;
        return helper(root)!= -1;
    }

    private int helper(TreeNode root)
    {
        if(root == null) return 0;
        
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        
        if(leftHeight >= 0 && rightHeight >= 0 && Math.abs(leftHeight - rightHeight) <= 1)
            return Math.max(leftHeight, rightHeight)+1;
        return -1;
    }
}

