/**
 * Practiced on 12/2/2012
 * 
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * ==========================
 * This problem is difficult. See detailed discussion:
 * http://www.leetcode.com/2010/11/convert-sorted-list-to-balanced-binary.html
 * 
 * Since Java is pass by value, I have to create another class to mimic pass by reference.
 */

package com.congli.leetcode;

public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) 
	{
        int n = findLength(head);
        return helper(head, 0, n-1).root;
    }
    
    private CombinedReturn helper(ListNode head, int start, int end)
    {
        if(start > end) return new CombinedReturn(null, head);
        
        int mid = (end-start)%2 == 0 ? (start+(end-start)/2) : (start+(end-start)/2+1);
        
        CombinedReturn leftReturn = helper(head, start, mid-1);
        head = leftReturn.head;
        
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        
        CombinedReturn rightReturn = helper(head, mid+1, end);
        
        root.left = leftReturn.root;
        root.right = rightReturn.root;
        
        CombinedReturn rootReturn = new CombinedReturn(root, rightReturn.head);

        return rootReturn;
    }
    
    private int findLength(ListNode head)
    {
        int length = 0;
        while(head != null)
        {
            ++length;
            head = head.next;
        }
        return length;
    }
    
    class CombinedReturn
    {
        TreeNode root;
        ListNode head;
        
        public CombinedReturn(TreeNode root, ListNode head)
        {
            this.root = root;
            this.head = head;
        }
    }

}
