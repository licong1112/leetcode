/**
 * Practiced on 11/28/2012
 * 
 * Inorder traverse a tree using iterative method.
 * 
 * =========================================
 * The first function is written by myself, which is way more complicated than the second one.
 *
 */

package com.congli.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class BinaryTreeInorderTraverse {
	public ArrayList<Integer> inorderTraversal(TreeNode root) 
	{
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> list = new Stack<TreeNode>();
        HashSet<TreeNode> set = new HashSet<TreeNode>();
       
        if(root == null) return result;
        
        list.add(root);
        
        while(!list.isEmpty())
        {
            TreeNode node = list.peek();
            if(node.left == null && node.right == null)
            {
                result.add(node.val);
                list.pop();
            }
            else if(node.left != null && !set.contains(node.left))
            {
                list.add(node.left);
                set.add(node.left);
            }
            else
            {
                if(node.right != null && !set.contains(node.right))
                {
                    result.add(node.val);
                    list.add(node.right);
                    set.add(node.right);
                }
                else
                {
                    list.pop();
                    if(node.right == null)
                    {
                        result.add(node.val);
                    }
                }
            }
        }
        return result;
    }

	public static void inOrderIterate(TreeNode node)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        boolean stop = false;
        
        while(!stop)
        {
            if(node != null)
            {
                stack.push(node);
                node = node.left;
            }
            else
            {
                if(stack.isEmpty())
                {
                    stop = true;
                }
                else
                {
                    node = stack.pop();
                    System.out.print(node.val + " ");
                    node = node.right;
                }
            }
        }
    }
}
