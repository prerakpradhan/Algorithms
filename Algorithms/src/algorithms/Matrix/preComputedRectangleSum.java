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
public class preComputedRectangleSum {
    
    public static int getSum(int[][] matrix, int rowLimit, int columnLimit)
    {
        int sum=0;
        
        for(int i=0; i <= rowLimit; i++)
        {
            for(int j=0; j<=columnLimit; j++)
            {
                sum = sum + matrix[i][j];
            }
        }
        return sum;
    }
    
    public static int[][] precompute(int[][] input_matrix)
    {
        int[][] output_matrix = new int[input_matrix.length][input_matrix[0].length];
        int rowLimit = input_matrix.length;
        int columnLimit = input_matrix[0].length;
        for(int i=0; i < rowLimit; i++)
        {
            for(int j=0; j< columnLimit; j++)
            {
                output_matrix[i][j] = getSum(input_matrix, i, j);
            }
        }
        return output_matrix;
    }
    
    public static int getResult(int[][] preComputedMatrix, int topi, int topj, int bottomi, int bottomj)
    {
        if(bottomi <= topi || bottomj <= topj )
        {
            return -1;
        }
        if(bottomi == 0 || bottomj ==0)
        {
            return -1;
        }
        if(bottomi > preComputedMatrix.length || bottomj > preComputedMatrix[0].length)
        {
            return -1;
        }
        if(topi <0 || topj<0)
        {
            return -1;
        }
        if(topj-1 >= 0)
        {
            return preComputedMatrix[bottomi][bottomj] - preComputedMatrix[bottomi][topj-1];
        }
        else
        {
            return preComputedMatrix[bottomi][bottomj];
        }
        
    }
    
    public static void main(String[] args)
    {
        int[][] matrix = {{1,3,5,1,8},{8,3,5,3,7},{6,3,9,6,0}};
        int[][] precomputed = precompute(matrix);
        System.out.println(getResult(precomputed, 0, 2, 2, 4));
    }
    
}
