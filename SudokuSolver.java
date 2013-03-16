/**
 * Practiced on 1/20/2013
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * 
 * ==========================================
 * No easy method can be used. Only backtracking.
 * Be careful how to check if a board is valid sudoku solution: Each of the 3*3
 * small block should be checked also.
 * 
 * The following is a test case that I typed.
 * 
 *  char[][] board = {{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, 
					  {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, 
					  {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, 
					  {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
					  {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
					  {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
					  {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
					  {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
					  {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
 */

package com.congli.leetcode;

import java.util.HashSet;

public class SudokuSolver {
	public void solveSudoku(char[][] board) 
	{
		char[][] realBoard = new char[board.length][board.length];
		helper(board, 0, 0, realBoard);
		deepcopy(realBoard, board);
    }
	
	public void deepcopy (char[][] arr1, char[][] arr2){
		for(int i=0; i<arr1.length; i++)
			for(int j=0; j<arr1[0].length; j++)
				arr2[i][j] = arr1[i][j];
	}
	
	public boolean isValid(char[][] board, int x, int y, int t){
		char temp = (char)('0'+t);
		for(int i=0; i<board.length; i++)
			if(board[x][i] == temp || board[i][y] == temp)
				return false;
		
		// Check small block
		int bx = x/3;
		int by = y/3;
		for(int p=bx*3; p<bx*3+3; p++)
			for(int q=by*3; q<by*3+3; q++)
				if(board[p][q]== temp)
					return false;
		return true;	
	}
	
    private void helper(char[][] board, int r, int c, char[][] realBoard)
    {
        if(r == board.length) 
    	{
        	deepcopy(board, realBoard);
        	return;
    	}
        if(board[r][c] != '.')
        {
            if(c == board.length-1)
                helper(board, r+1, 0, realBoard);
            else
                helper(board, r, c+1, realBoard);
        }
        else
        {
            for(int i = 1; i <= board.length; ++i)
            {
                if(isValid(board, r, c, i))
                {
                    board[r][c] = (char)('0'+i);
                    if(c == board.length-1)
                        helper(board, r+1, 0, realBoard);
                    else
                        helper(board, r, c+1, realBoard);
                    board[r][c] = '.';
                }
            }
        }
    }
}
