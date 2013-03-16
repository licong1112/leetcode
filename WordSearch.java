/**
 * Practiced on 2/6/2013
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
 * 
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * ========================================
 * DFS is the method. Be careful when writing the code.
 * 
 * It's not a good idea to use hashset to record if a specific node is
 * already visited. It will be slow.
 */

package com.congli.leetcode;

public class WordSearch {

	public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        int numRows = board.length;
        int numCols = board[0].length;
        char initChar = word.charAt(0);
        
        for(int i = 0; i < numRows; ++i)
        	for(int j = 0; j < numCols; ++j)
        		if(board[i][j] == initChar && helper(board, i, j, word, 0, used))
        			return true;
        return false;
    }
    
    public boolean helper(char[][] board, int x, int y, String word, int wordInd, boolean[][] used)
    {
        if(used[x][y]) return false;
        
        if(board[x][y] == word.charAt(wordInd))
        {
            if(wordInd+1 == word.length()) return true;
            used[x][y] = true;
            if(y+1 < board[0].length && helper(board, x, y+1, word, wordInd+1, used)) return true;
            if(y-1 >= 0 && helper(board, x, y-1, word, wordInd+1, used)) return true;
            if(x+1 < board.length && helper(board, x+1, y, word, wordInd+1, used)) return true;
            if(x-1 >= 0 && helper(board, x-1, y, word, wordInd+1, used)) return true;
        }
        used[x][y] = false;
        return false; 
    }
}
