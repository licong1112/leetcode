/**
 * Practiced on 12/3/2013
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * =================================================
 * 1. Use an additional stack to track if the node is visited or not: A node
 *    is called ``visited'' if its left subtree has been traversed.
 * 2. Another way to do it is to build a class with member TreeNode node
 *    and boolean visited.
 * 
 * Leetcode website has another solution, which keeps track the previously
 * visited node. See here: 
 * http://leetcode.com/2010/10/binary-tree-post-order-traversal.html
 */

package com.congli.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) return result;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Boolean> visited = new Stack<Boolean>();
		stack.push(root);
		visited.push(false);
		TreeNode curr_node = root.left;
		while (!stack.isEmpty()) {
			if (curr_node == null) {
				while (!stack.isEmpty() && (stack.peek().right == null || visited.peek())) {
					result.add(stack.peek().val);
					stack.pop();
					visited.pop();
				}
				if (stack.isEmpty()) return result;
				visited.pop();
				visited.push(true);
				curr_node = stack.peek().right;
			} else {
				stack.push(curr_node);
				visited.push(false);
				curr_node = curr_node.left;
			}
		}
		return result;
    }
}
