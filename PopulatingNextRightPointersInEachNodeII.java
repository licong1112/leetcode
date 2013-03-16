/**
 * Practiced on 12/18/2012
 * 
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 *     
 * =======================================
 * First wrote a tedious code, and then revised to the following code.
 */

package com.congli.leetcode;

public class PopulatingNextRightPointersInEachNodeII {

	public void connect(TreeLinkNode root) 
    {
        if(root == null) return;
        
        TreeLinkNode parentStart = root;
        TreeLinkNode childStart = root.left == null ? root.right : root.left;
        
        TreeLinkNode parent = parentStart;
        TreeLinkNode child = childStart;

        while(childStart != null)
        {
            while(parent != null)
            {
            	// Find the next node for child.
                TreeLinkNode nextChild = null;
                if(child == parent.left && parent.right != null)
                	nextChild = parent.right;
                else
                {
                    parent = parent.next;
                    while(parent != null && parent.left == null && parent.right == null)
                    	parent = parent.next;
                    
                    if(parent != null) 
                    	nextChild = parent.left != null ? parent.left : parent.right;
                }
                child.next = nextChild;
                child = child.next;
            }
            parentStart = childStart;
            childStart = findChildStart(childStart);
            parent = parentStart;
            child = childStart;
        }
    }
    
    private TreeLinkNode findChildStart(TreeLinkNode childStart)
    {        
        while(childStart != null && childStart.left == null && childStart.right == null)
            childStart = childStart.next;
            
        if(childStart == null) return null;
        return childStart.left != null ? childStart.left : childStart.right;
    }
}
