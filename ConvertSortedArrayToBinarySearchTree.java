/**
 * Practiced on 12/2/2012
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * =========================
 * One thing needs to be taken care of is that, the BST should be built from the left branch.
 * For example, if int[] num = {0, 1, 2, 3, 4, 5}, we should build a BST:
 * 
 *               3
 *         1           5
 *      0    2       4
 * 
 * instead of a BST
 * 
 *               2
 *         1           4
 *      0           3     5
 * This is because the first solution is what online judge wanted.
 */

package com.congli.leetcode;

public class ConvertSortedArrayToBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] num) {

        return helper(num, 0, num.length-1);
    }
    
    private TreeNode helper(int[] num, int start, int end)
    {
        if(start == end) return new TreeNode(num[start]);
        if(start > end) return null;
        
        int mid = (end-start)%2 == 0 ? (start+(end-start)/2) : (start+(end-start)/2+1);
        
        TreeNode leftRoot = helper(num, start, mid-1);
        TreeNode rightRoot = helper(num, mid+1, end);
        
        TreeNode root = new TreeNode(num[mid]);
        
        root.left = leftRoot;
        root.right = rightRoot;
        
        return root;
    }
}
