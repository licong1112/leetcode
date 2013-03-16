/**
 * Practiced on 1/7/2013
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and 
 * the nodes have the same value.
 * 
 * ========================================
 * Can be solved by recursion or dps or bfs. Dps is much ore difficult to solve.
 */

package com.congli.leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class SameTree {
	
	public static void main(String[] args)
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(null);
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) 
	{
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
	
	public boolean isSameTreeDSP(TreeNode p, TreeNode q) 
	{
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(p);
        s2.push(q);
        while(!s1.isEmpty() && !s2.isEmpty())
        {
            if(p.val != q.val) return false;
            if((p.left == null && q.left != null) || (q.left == null && p.left != null)) return false;
            if((p.right == null && q.right != null) || (q.right == null && p.right != null)) return false;
            if(p.left != null && q.left != null)
            {
                s1.push(p.left);
                s2.push(q.left);
                p = p.left;
                q = q.left;
            }
            else
            {
                while(p.right == null && q.right == null && !s1.isEmpty() && !s2.isEmpty())
                {
                    p = s1.pop();
                    q = s2.pop();
                }
                if(p.right != null && q.right != null)
                {
                    s1.push(p.right);
                    s2.push(q.right);
                    p = p.right;
                    q = q.right;
                }
            }
        }
        return true;
    }
	
	public boolean isSameTreeBFS(TreeNode p, TreeNode q) 
	{
        LinkedList<TreeNode> s1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> s2 = new LinkedList<TreeNode>();
        s1.add(p);
        s2.add(q);
        while(!s1.isEmpty() && !s2.isEmpty())
        {
            p = s1.poll();
            q = s2.poll();
            
            if((p == null && q != null) || (q == null && p != null)) return false;
            if(p != null && q != null)
            {
                if(p.val != q.val) return false;
            
                s1.add(p.left);
                s1.add(p.right);
                s2.add(q.left);
                s2.add(q.right);
            }
        }
        return true;
    }
}
