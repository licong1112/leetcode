/**
 * Practiced on 1/22/2013
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 * ==================================
 * To write recursive solution, we just need to figure out the logic:
 * 
 * Let a node in the left branch called leftNode, and its counterpart in the right
 * branch called rightNode. Then we must have leftNode.val = rightNode.val for all
 * leftNode and its counterpart rightNode.
 * 
 * To right the iterative solution, we use two queues to store left branch and right branch.
 * However, when adding leftNode's children, we first add its left child then right child.
 * When adding rightNode's children, we first add its right child then left child.
 * Then every time when we dequeue a value from both queues, the elements must be the same.
 */

package com.congli.leetcode;

import java.util.LinkedList;

public class SymmetricTree {
	public boolean isSymmetricRecursive(TreeNode root) 
	{
        if(root == null) return true;
        return isSame(root.left, root.right);
    }
    
    public boolean isSame(TreeNode node1, TreeNode node2)
    {
        if(node1 == null && node2 == null) return true;
        if(node1 == null && node2 != null) return false;
        if(node1 != null && node2 == null) return false;
        
        return node1.val == node2.val && isSame(node1.left, node2.right) && isSame(node1.right, node2.left);
    }
    
    //LinkedList allows null element. This is very helpful in writing simple code!
    public boolean isSymmetricIterative(TreeNode root)
    {
    	if(root == null) return true;
    	LinkedList<TreeNode> listLeft = new LinkedList<TreeNode>();
    	LinkedList<TreeNode> listRight = new LinkedList<TreeNode>();
    	
    	listLeft.add(root.left);
    	listRight.add(root.right);
    	
    	while(listLeft != null && listRight != null)
    	{
    		TreeNode leftNode = listLeft.poll();
    		TreeNode rightNode = listRight.poll();
    		
    		if(leftNode == null && rightNode == null) continue;
    		if(leftNode != null && rightNode == null) return false;
    		if(leftNode == null && rightNode != null) return false;
    		if(leftNode.val != rightNode.val) return false;
    		
    		listLeft.add(leftNode.left);
    		listLeft.add(leftNode.right);
    		listRight.add(rightNode.right);
    		listRight.add(rightNode.left);
    	}
    	return true;
    }
}
