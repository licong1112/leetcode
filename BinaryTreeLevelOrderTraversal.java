/**
 * Practiced on 11/28/2012
 * 
 * Traverse binary tree in level order.
 * 
 * ======================================
 * 11/29/2012 update the method without using recursion.
 * It is also possible to use DFS. 
 * See http://www.leetcode.com/2010/09/binary-tree-level-order-traversal-using_17.html
 */

package com.congli.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {

	// 11/28/2012
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;        
          
        ArrayList<TreeNode> listNode = new ArrayList<TreeNode>();
        listNode.add(root);

        helper(listNode, result);
        return result;
    }
    
    private void helper(ArrayList<TreeNode> listNode, ArrayList<ArrayList<Integer>> result)
    {
        ArrayList<TreeNode> newListNode = new ArrayList<TreeNode>();
        ArrayList<Integer> resultLayer = new ArrayList<Integer>();
        
        for(TreeNode node : listNode)
        {
            resultLayer.add(node.val);
            if(node.left != null)
                newListNode.add(node.left);
            
            if(node.right!= null)
                newListNode.add(node.right);
        }
        result.add(resultLayer);
        if(newListNode.size() != 0)
        {
            helper(newListNode, result);
        }
    }
    
    //11/29/2012 implemented without using recursion.
    public ArrayList<ArrayList<Integer>> levelOrderIterative(TreeNode root) 
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        
        LinkedList<TreeNode> listUp = new LinkedList<TreeNode>();
        LinkedList<TreeNode> listDown = new LinkedList<TreeNode>();
        
        listUp.add(root);
        
        while(listUp.size() != 0)
        {
            ArrayList<Integer> layerList = new ArrayList<Integer>();
            while(listUp.size() != 0)
            {
                TreeNode temp = listUp.pollFirst();
                if(temp.left != null)
                    listDown.addLast(temp.left);
                if(temp.right != null)
                    listDown.addLast(temp.right);
                layerList.add(temp.val);
            }
            result.add(layerList);
            listUp = listDown;
            listDown = new LinkedList<TreeNode>();
        }
        return result;
    }
}
