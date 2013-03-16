/**
 * Practiced on 12/4/2012
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 * 
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *    \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 *              
 *==================================
 * 
 * The idea is to process left and right branch first. Then, change the left branch to right
 * and connect original right branch to the end of the renewed right branch (which is the original
 * left branch). 
 * 
 * Here we need to keep tracking the end of left branch, such that we can connect the original 
 * right branch to the end of the original left branch in O(1) time. Otherwise we need to take
 * time to search for the end, which is extra cost.
 */

package com.congli.leetcode;

public class FlattenBinaryTreeToLinkedList {

	public void flatten(TreeNode root) 
	{
        helper(root);
    }
    
    private TreeNode helper(TreeNode root)
    {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        if(root.left == null) return helper(root.right);
        if(root.right == null)
        {
            TreeNode leftEnd = helper(root.left);
            root.right = root.left;
            root.left = null;
            return leftEnd;
        }
        
        TreeNode leftEnd = helper(root.left);
        TreeNode rightEnd = helper(root.right);
        
        TreeNode temp = root.right;
            
        root.right = root.left;
        root.left = null;
        leftEnd.right = temp;
        
        return rightEnd;
    }
}
