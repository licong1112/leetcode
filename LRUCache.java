/**
 * Practiced on 12/3/2013
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key 
 * exists in the cache, otherwise return -1.
 * 
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently 
 * used item before inserting a new item.
 * 
 * ======================================================
 * 1. Create doubly-linked list, where each node stores one (key, value) pair.
 * 2. HashMap<Integer, Node> maps key to the corresponding Node.
 * 3. Get() and Set() can be achieved in O(1), by indexing the wanted node via 
 *    the HashMap.
 * 4. Every operation need to move the corresponding node to the head of the list,
 *    therefore the tail of the list is always the LRU node.
 */
package com.congli.leetcode;

import java.util.HashMap;

public class LRUCache {	
	private int capacity;
	private HashMap<Integer, Node> map;
	private Node head;
	private Node tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
        map = new HashMap<Integer, Node>(capacity, 1.0f);
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
        	moveToHead(map.get(key));
        	return head.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
    	if (map.containsKey(key)) {
    		moveToHead(map.get(key));
    		map.get(key).val = value;
    	} else {
    		if (map.size() == capacity) {
    			int key_to_remove = tail.key;
    			map.remove(key_to_remove);
    			moveToHead(tail);
    			head.val = value;
    			head.key = key;
    		} else {
    			Node new_node = new Node(key, value);
    			if (map.size() != 0) {
    				new_node.next = head;
        			head.pre = new_node;
    			} else {
    				tail = new_node;
    			}
    			head = new_node;
    		}
    		map.put(key, head);
    	}
    }
    
    // Move curr to the head of the list, and at the same time maintain 
    // the head and tail pointers.
    void moveToHead(Node curr) {
    	if (curr == head) return;
    	Node pre = curr.pre;
    	Node next = curr.next;
    	pre.next = next;
    	if (next != null) {
    		next.pre = pre;
    	}            	
    	curr.next = head;
    	curr.pre = null;
    	head.pre = curr;
    	head = curr;
    	if (curr == tail) {
    		tail = pre;
    	}
    }
    
    class Node {
    	int key;
    	int val;
    	Node next;
    	Node pre;
    	Node(int key, int val) {
    		this.key = key;
    		this.val = val;
    		next = null;
    		pre = null;
    	}
    } 
}
