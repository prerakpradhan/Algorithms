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
public class maxValGifts {
    
    public static int getMaxGift(int[][] matrix)
    {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] result= new int[col];
        for(int i=0; i < row; i++)
        {
            for(int j=0; j < col; j++)
            {
                int up=0;
                int left = 0;
                if (i > 0) {
                    up = result[j];
                }

                if (j > 0) {
                    left = result[j - 1];
                }
                result[j] = Math.max(left, up) + matrix[i][j];
            }
        }
        return result[col-1];
    }
    
    
    public static void main(String[] args)
    {
        int[][] matrix = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(getMaxGift(matrix));
                
    }
    
}
