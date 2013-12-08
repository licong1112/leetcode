/**
 * Practiced on 12/08/2013
 * 
 * A linked list is given such that each node contains an additional random 
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * ================================================
 * An O(1) space complexity solution.
 * 1. Call original list L1, new list L2
 * 2. Key step: for any node in L1 (call it node_l1) and the corresponding node
 *    in L2 (call it node_l2), let 
 *    
 *    node_l2.next = node_l1.next, then
 *    node_l1.next = node_l2
 *
 * Other solutions:
 * 1. http://tech-wonderland.net/blog/interview-questions-copy-list-with-random-pointers.html
 * 2. Use HashMap: node in original list ---mapsto---> corresponding node in new list
 */

package com.congli.leetcode;

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		RandomListNode result_head = new RandomListNode(head.label);
		RandomListNode curr_node = head;
		RandomListNode curr_result_node = result_head;
		
		// Initialize nodes in new lists
		while (curr_node != null) {
			curr_result_node.next = curr_node.next;
			RandomListNode temp = curr_node.next;
			curr_node.next = curr_result_node;
			curr_node = temp;
			if (curr_node != null) {
				RandomListNode new_node = new RandomListNode(curr_node.label);
				curr_result_node = new_node;
			}
		}
		
		// Set random pointer
		curr_result_node = result_head;
		curr_node = head;
		while (curr_result_node != null) {
			curr_result_node.random = curr_node.random != null ? curr_node.random.next : null;
			curr_node = curr_result_node.next;
			curr_result_node = curr_result_node.next != null ? curr_result_node.next.next : null;
		}
		
		// Set next pointer
		curr_result_node = result_head;
		curr_node = head;
		while (curr_node != null) {
			curr_node.next = curr_result_node.next;
			curr_result_node.next = curr_node.next != null ? curr_node.next.next : null;
			curr_node = curr_node.next;
			curr_result_node = curr_result_node.next;
		}
		
		return result_head;
	}
	
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x){
			this.label = x; 
		}
	};
}
