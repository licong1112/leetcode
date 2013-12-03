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
		Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr_node = root;
        do {
        	if (curr_node == null) {
        		while (!stack.isEmpty() && stack.peek().right == null) {
        			stack.pop();
        		}
        		if (stack.isEmpty()) {
        			return result;
        		} else {
        			curr_node = stack.pop().right;
        		}
        	} 
        	result.add(curr_node.val);
			stack.push(curr_node);
			curr_node = curr_node.left;
        } while (!stack.isEmpty());
        
        return result;
    }
}
