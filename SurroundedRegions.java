/**
 * Practiced on 2/25/2013
 * 
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region .
 * 
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * ==============================================
 * This problem can be solved more wisely and concisely by using recursion. Check this out:
 * http://blog.sina.com.cn/s/blog_b9285de20101j1dt.html
 * 
 * My solution didn't use recursion. So the code is longer. Also my algorithm is not very smart.
 * 
 */

package com.congli.leetcode;

import java.util.LinkedList;

public class SurroundedRegions {
	public void solve(char[][] board) 
	{
        if(board.length == 0) return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        LinkedList<Integer> queue1 = new LinkedList<Integer>();
        LinkedList<Integer> queue2 = new LinkedList<Integer>();
       
        for(int i = 1; i < board.length-1; ++i)
            for(int j = 1; j < board[0].length-1; ++j)
                if(board[i][j] == 'O' && !visited[i][j])
                    helper(board, i, j, visited, queue1, queue2);
    }
   
    private void helper(char[][] board, int i, int j, boolean[][] visited, LinkedList<Integer> queue1, LinkedList<Integer> queue2)
    {       
        add(queue1, i, j);
        add(queue2, i, j);
        visited[i][j] = true;
        boolean on_boarder = false;
        while(!queue1.isEmpty())
        {
            int x = queue1.pollFirst();
            int y = queue1.pollFirst();
           
            if(x == 0 || x == board.length-1 || y == 0 || y == board[0].length-1)
                on_boarder = true;

            if(y > 0 && !visited[x][y-1] && board[x][y-1] == 'O')
            {
                add(queue1, x, y-1);
                add(queue2, x, y-1);
                visited[x][y-1] = true;
            }
            if(x > 0 && !visited[x-1][y] && board[x-1][y] == 'O')
            {
                add(queue1, x-1, y);
                add(queue2, x-1, y);
                visited[x-1][y] = true;
            }
            if(y < board[0].length-1 && !visited[x][y+1] && board[x][y+1] == 'O')
            {
                add(queue1, x, y+1);
                add(queue2, x, y+1);
                visited[x][y+1] = true;
            }
            if(x < board.length-1 && !visited[x+1][y] && board[x+1][y] == 'O')
            {
                add(queue1, x+1, y);
                add(queue2, x+1, y);
                visited[x+1][y] = true;
            }
        }
        queue1.clear();
        if(on_boarder)
            queue2.clear();
        else
            while(!queue2.isEmpty())
                board[queue2.pollFirst()][queue2.pollFirst()] = 'X';
    }
   
    private void add(LinkedList<Integer> queue, int x, int y)
    {
        queue.add(x);
        queue.add(y);
    }
}
