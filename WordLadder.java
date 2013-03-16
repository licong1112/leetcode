/**
 * Practiced on 2/12/2013
 * 
 * Given two words (start and end), and a dictionary, find the length of shortest 
 * transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * 
 * ================================
 * BFS is the solution. One trick to pass the large test:
 * 
 * For a given word, instead of check all words in the dict to see if the distance is 1,
 * check all possible words and see if the word is in the dict. This is more efficient if
 * the dict is very large. 
 */

package com.congli.leetcode;

import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
        HashSet<String> visited = new HashSet<String>();
        LinkedList<String> queue = new LinkedList<String>();
        queue.addLast(start);
        int numNodesCurrentLevel = 1;
        int level = 1;
        while(!queue.isEmpty())
        {
            int numNodesNextLevel = 0;
            for(int i = 0; i < numNodesCurrentLevel; ++i)
            {
                String current = queue.pollFirst();
                if(dist(current, end) == 1)
                    return level+1;
                numNodesNextLevel += getNextNode(current, queue, dict, visited);
            }
            numNodesCurrentLevel = numNodesNextLevel;
            ++level;
        }
        return 0;
    }
    
    private int getNextNode(String str, LinkedList<String> queue, HashSet<String> dict, HashSet<String> visited)
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
                    visited.add(temp);
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
