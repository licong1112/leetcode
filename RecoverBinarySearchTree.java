/**
 * Practiced on 12/19/2012
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * 
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * 
 * ==================================
 * The idea is easy, but it is difficult to write the code which use O(1) space. 
 * 1. Maintain a TreeNode[] swapNodes, which stores the nodes that should be swapped.
 * 2. Maintain TreeNode lastVisited, to keep track the last visited node.
 */

package com.congli.leetcode;

public class RecoverBinarySearchTree {
	
	public static void main(String[] args)
	{
		RecoverBinarySearchTree test = new RecoverBinarySearchTree();

		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(3);
		TreeNode right = new TreeNode(1);
		root.left = left;
		root.right = right;
		
		test.recoverTree(root);
	}
	
	public void recoverTree(TreeNode root) 
	{
        TreeNode[] swapNodes = new TreeNode[2];
        helper(root, swapNodes, null);
        
        if(swapNodes[0] != null)
        {
            int temp = swapNodes[0].val;
            swapNodes[0].val = swapNodes[1].val;
            swapNodes[1].val = temp;
        }
    }
    
	private TreeNode helper(TreeNode root, TreeNode[] swapNodes, TreeNode lastVisited)
    {
        if(root == null) return lastVisited;
        
        TreeNode leftLastVisited = helper(root.left, swapNodes, lastVisited);
        if(leftLastVisited != null && root.val < leftLastVisited.val)
        {
            if(swapNodes[0] == null)
                swapNodes[0] = leftLastVisited;
            swapNodes[1] = root;
        }
        TreeNode rightLastVisited = helper(root.right, swapNodes, root);
        
        return rightLastVisited == null ? root : rightLastVisited;
    }
}
