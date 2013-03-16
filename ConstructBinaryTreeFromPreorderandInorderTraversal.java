/**
 * Practiced on 12/2/2012
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 */

package com.congli.leetcode;

public class ConstructBinaryTreeFromPreorderandInorderTraversal {

	public TreeNode buildTree(int[] preorder, int[] inorder) 
	{
        return helper(preorder, inorder, 0, preorder.length-1, 0);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end, int level)
    {
        if(start > end) return null;
        
        TreeNode root = new TreeNode(preorder[start]);
        
        if(start == end) return root;
        
        int ind = search(inorder, preorder[start]);
        ind += level;
        
        TreeNode leftRoot = helper(preorder, inorder, start+1, ind, level+1);
        TreeNode rightRoot = helper(preorder, inorder, ind+1, end, level);
        
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
