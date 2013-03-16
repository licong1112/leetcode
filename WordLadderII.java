/**
 * Practiced on 2/12/2013
 * 
 * Given two words (start and end), and a dictionary, find all shortest 
 * transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 *   
 * =======================================================
 * This problem is pretty hard, especially to pass the large test set.
 * Several tricks:
 * 
 * 1. Use BST (the same as the previous problem "Word Ladder") to build a map: child -> parent list
 * 2. For each node, which is a child, it maps to all parents which has distance 1 with itself
 * 3. After building the map, we can reconstruct the paths from the END to START
 * 4. By building the map from child to parent, we can reconstruct paths from end, which is much
 * 	  more efficient than building a map from parent to child list, and reconstruct paths from
 *    start to end. This is because to reconstruct the path, if we start from the end, there are
 *    many other ends that are not the same as the given end. For example, in the following graph
 *    
 *    			a
 *    		  /   \
 *          b       c
 *        /   \    /
 *       d     e   f
 *    
 *    If the given start is a, end is d, then if we reconstruct paths from a, then we have to examine
 *    paths that end at e and f. This is a waste of time. However, if we start from d and reconstruct
 *    up to a, we only consider path d->b->a. 
 */

package com.congli.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadderII {

	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) 
	{
        HashSet<String> visited = new HashSet<String>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        LinkedList<String> queue = new LinkedList<String>();
        if(dict.contains(start)) dict.remove(start);
        if(dict.contains(end)) dict.remove(end);
        
        // BST, build map: child -> parent list
        queue.addLast(start);
        int numNodesCurrentLevel = 1;
        int level = 1;
        boolean isStop = false;
        while(!queue.isEmpty() && !isStop)
        {
            int numNodesNextLevel = 0;
            for(int i = 0; i < numNodesCurrentLevel; ++i)
            {
            	String current = queue.pollFirst();
            	if(!visited.contains(current))
            	{
                    if(dist(current, end) == 1)
                    {
                        isStop = true;
                        addToMap(map, end, current);
                    }
                    numNodesNextLevel += getNextNode(current, queue, dict, visited, map);
                    visited.add(current);
            	}
            }
            numNodesCurrentLevel = numNodesNextLevel;
            ++level;
        }
        
        // Based on the map, reconstruct all paths
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();        
        ArrayList<String> list = new ArrayList<String>();
        list.add(end);

        buildPath(result, list, map, end, start, level, 1);
        return result;
    }
    
    private void buildPath(ArrayList<ArrayList<String>> result, ArrayList<String> list, HashMap<String, ArrayList<String>> map, String current, String start, int expectedLevel, int currLevel)
    {
    	if(currLevel == expectedLevel) return;
        if(!map.containsKey(current)) return;
        ArrayList<String> curList = map.get(current);
        for(String s : curList)
        {
    		list.add(s);
            if(s.equals(start))
            {
            	ArrayList<String> addToResult = (ArrayList<String>)list.clone();
            	reverseList(addToResult);
            	result.add(addToResult);
            	list.remove(list.size()-1); 
            	break;
            }
            else 
            {
            	buildPath(result, list, map, s, start, expectedLevel, currLevel+1);
            	list.remove(list.size()-1);    
            }
        }
    }
    
    private void reverseList(ArrayList<String> list)
    {
    	int i = 0, j = list.size()-1;
    	while(i < j)
    	{
    		String temp = list.get(i);
    		list.set(i, list.get(j));
    		list.set(j, temp);
    		++i;
    		--j;
    	}
	}
    
    private void addToMap(HashMap<String, ArrayList<String>> map, String key, String value)
    {
        if(map.containsKey(key))
            map.get(key).add(value);
        else
        {
            ArrayList<String> list = new ArrayList<String>();
            list.add(value);
            map.put(key, list);
        }
    }
    
    private int getNextNode(String str, LinkedList<String> queue, HashSet<String> dict, HashSet<String> visited, HashMap<String, ArrayList<String>> map)
    {
        int result = 0;
        
        for(int i = 0; i < str.length(); ++i)
        {
            char[] charArray = str.toCharArray();
            for(char j = 'a'; j <= 'z'; ++j)
            {
                charArray[i] = j;
                String temp = new String(charArray);
                if(dict.contains(temp) && !temp.equals(str) && !visited.contains(temp) && dist(str, temp)==1)
                {
                    queue.addLast(temp);
                    addToMap(map, temp, str);
                    ++result;
                }
            }
        }
        return result;
    }
    
    private int dist(String a, String b)
    {
        int result = 0;
        for(int i = 0; i < a.length(); ++i)
            if(a.charAt(i) != b.charAt(i))
                ++result;
        return result;
    }
}
