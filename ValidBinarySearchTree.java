/**
 * Practiced on 2/5/2013
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * =======================================
 * The following is written by utilizing iterative version of in-order traversal.
 * The idea is that, every time the stack pops, the value of the popped node should
 * be increasing.
 * 
 * To write recursive version, we need to somehow pass-by-reference the maximum value
 * of a subtree, which is awkward to do in Java.
 */

package com.congli.leetcode;

import java.util.HashSet;
import java.util.Stack;

public class ValidBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
       
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        HashSet<TreeNode> set = new HashSet<TreeNode>();
        set.add(root);
        int max = Integer.MIN_VALUE;
       
        while(!stack.isEmpty())
        {
            if(root.left != null && !set.contains(root.left))
            {
                root = root.left;
                stack.push(root);
                set.add(root);
            }
            else
            {
                root = stack.pop();
                if(max >= root.val) return false;
                max = root.val;
               
                if(root.right != null && !set.contains(root.right))
                {
                    root = root.right;
                    stack.push(root);
                    set.add(root);
                }                   
            }
        }
        return true;
    }
}
