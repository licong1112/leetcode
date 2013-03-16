/**
 * Practiced on 2/5/2013
 * 
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */

package com.congli.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> rowSet = new ArrayList<HashSet<Character>>();
        ArrayList<HashSet<Character>> colSet = new ArrayList<HashSet<Character>>();
       
        for(int i = 0; i < 9; ++i)
        {
            HashSet<Character> set1 = new HashSet<Character>();
            rowSet.add(set1);
            set1 = new HashSet<Character>();
            colSet.add(set1);
        }
       
        HashSet<Character> smallSet = new HashSet<Character>();
        for(int i = 0; i < 3; ++i)
        {
            for(int j = 0; j < 3; ++j)
            {
                for(int r = i*3; r < (i+1)*3; ++r)
                {
                    for(int c = j*3; c < (j+1)*3; ++c)
                    {
                        char currChar = board[r][c];
                        if(currChar != '.')
                        {
                            if(smallSet.contains(currChar)) return false;
                            else smallSet.add(currChar);
                           
                            if(rowSet.get(r).contains(currChar)) return false;
                            else rowSet.get(r).add(currChar);
                           
                            if(colSet.get(c).contains(currChar)) return false;
                            else colSet.get(c).add(currChar);
                        }
                    }
                }
                smallSet.clear();
            }
        }
        return true;
    }
}
