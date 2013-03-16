/**
 * Practiced on 2/20/2013
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path 
 * could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 *     1
 *    / \
 *   2   3
 *   
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 */

package com.congli.leetcode;

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int[] sum = new int[1];
        helper(root, root.val, sum);
        return sum[0];
    }
    
    private void helper(TreeNode root, int currNum, int[] sum)
    {
        if(root.left == null && root.right == null)
        {
            sum[0] += currNum;
            return;
        }
        if(root.left != null)
            helper(root.left, currNum*10 + root.left.val, sum);
        if(root.right != null)
            helper(root.right, currNum*10 + root.right.val, sum);
    }
}
