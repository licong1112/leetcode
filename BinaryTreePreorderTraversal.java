/**
 * Practiced on 12/2/2013
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

package com.congli.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) return result;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr_node = null;
        stack.push(root);
        while (!stack.isEmpty()) {
        	curr_node = stack.peek();
        	result.add(curr_node.val);
        	stack.pop();
    		if (curr_node.right != null) {
    			stack.push(curr_node.right);
    		}
    		if (curr_node.left != null) {
    			stack.push(curr_node.left);
    		}
        }
        
        return result;
    }
}
