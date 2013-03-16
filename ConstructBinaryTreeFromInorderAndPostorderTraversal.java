/**
 * Practiced on 12/1/2012
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */

package com.congli.leetcode;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0)
            return null;
        
        return helper(inorder, postorder, 0, postorder.length-1, 0);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end, int level)
    {
        
        if(start > end) return null;

        TreeNode root = new TreeNode(postorder[end]);
        
        if(start == end) return root;
        	
        int ind = search(inorder, postorder[end]);
        ind -= level;
        
        TreeNode leftRoot = helper(inorder, postorder, start, ind-1, level);
        TreeNode rightRoot = helper(inorder, postorder, ind, end-1, level+1);
        root.left = leftRoot;
        root.right = rightRoot;
        
        return root;
    }
    
    private int search(int[] array, int key)
    {
    	for(int i = 0; i < array.length; ++i)
    	{
    		if(array[i] == key)
    		{
    			return i;
    		}
    	}
    	return -1;
    }
}
