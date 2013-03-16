/**
 * Practiced on 12/10/2012
 * 
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the root node 
 * down to the nearest leaf node.
 * 
 * ==================================
 * 
 * It is not right to only consider:
 * 
 * if(root == null) return 0;
 * return Math.min(minDepth(root.left), minDepth(root.right))+1;
 * 
 * For example:
 * 
 *           1
 *      2        3
 *   4              5
 *   
 * This tree has minimum depth 3. But the above code will give 2. This is because at node 2,
 * it does not have right child, thus Math.min(minDepth(root.left), minDepth(root.right)) = 0.
 * This means the minimum depth of the subtree rooted at 2 is 0. This is not true.
 * 
 * Thus we have to separately consider different situations as below.
 * We can make the code more clear by adding one more condition:
 * 
 * if(root.left == null && root.right == null) return 1;
 * 
 * But this condition is redundant. 
 */

package com.congli.leetcode;

public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) 
	{
        if(root == null) return 0;
        
        if(root.left == null) return minDepth(root.right)+1;
        
        if(root.right == null) return minDepth(root.left)+1;
        
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}
