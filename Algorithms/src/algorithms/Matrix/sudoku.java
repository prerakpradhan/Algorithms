/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Matrix;

/**
 *
 * @author coolp_000
 */
public class sudoku {
    
    public int[][] board;
    public sudoku(int[][] board)
    {
        this.board = board;
    }
    public boardPosition isSolved()
    {
        for(int i=0; i < board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(board[i][j]==0)
                {
                    boardPosition b = new boardPosition();
                    b.x = i;
                    b.y= j;
                    return b ;
                }
            }
        }
        
        return new boardPosition();
    }
    
    public boolean rowSafe(int row, int num)
    {
        for(int i=0; i <board[0].length; i++)
        {
            if(board[row][i] == num)
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean columnSafe(int column, int num)
    {
        for(int i=0; i < board.length; i++)
        {
            if(board[i][column]==num)
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean boxSafe(int boxStarti, int boxStartj, int num)
    {
        for(int i = 0; i < 3;i++ )
        {
            for(int j =0; j < 3; j++)
            {
                if(board[boxStarti+i][boxStartj+j]== num)
                {
                    return false;
                }
                
            }
        }
            
        return true;
    }
    
    public boolean isSafe(int row, int col, int num)
    {
        return boxSafe(row-(row%3), col-(col%3), num) &&
                columnSafe(col, num) &&
                rowSafe(row, num);
    }
    
    public boolean solve(int[][] board)
    {
        boardPosition b = isSolved();
        int row = b.x;
        int column = b.y;
        if(row ==-1)
        {
            return true;
        }
        for(int i=1; i <=9; i++)
        {
            if(isSafe(row, column, i))
            {
                board[row][column] = i;
                if(solve(board))
                {
                    return true;
                }
                board[row][column] = 0;
            }
        }
        return false;
    }
    
    public void print()
    {
        for(int i=0; i < board.length; i++)
        {
            for(int j = 0; j<board[0].length; j++)
            {
                System.out.print(board[i][j] + " , ");
            }
            System.out.println("");
        }
    }
   
    
    public static void main(String[] args)
    {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                      {5, 2, 0, 0, 0, 0, 0, 0, 0},
                      {0, 8, 7, 0, 0, 0, 0, 3, 1},
                      {0, 0, 3, 0, 1, 0, 0, 8, 0},
                      {9, 0, 0, 8, 6, 3, 0, 0, 5},
                      {0, 5, 0, 0, 9, 0, 6, 0, 0},
                      {1, 3, 0, 0, 0, 0, 2, 5, 0},
                      {0, 0, 0, 0, 0, 0, 0, 7, 4},
                      {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        sudoku s = new sudoku(grid);
        if(s.solve(grid))
        {
            s.print();
        }
        else
        {
            System.out.println("false");
        }
    }
    
    
}
