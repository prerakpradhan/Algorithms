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
public class transpose {
    
    public static int[][] transpose(int[][] matrix)
    {
        int i=0;
        int j=0;
        while(i<matrix.length && j<matrix[0].length)
        {
            int rowi=i;
            int rowj = j;
            int columni=i;
            int columnj =j;
            while(rowj<matrix.length && columni < matrix[0].length )
            {
                int temp = matrix[rowi][rowj];
                matrix[rowi][rowj]=matrix[columni][columnj];
                matrix[columni][columnj] = temp;
                rowj++;
                columni++;
            }
            i++;
            j++;
                    
        }
        return matrix;
    }
    
    public static void print(int[][] matrix)
    {
        for(int i=0; i <matrix.length;i++)
        {
            for(int j=0; j <matrix[0].length;j++)
            {
                System.out.println(matrix[i][j]);
            }
        }
    }
    
    public static void main(String[] args)
    {
        int[][] matrix = new int[3][3];
        matrix[0][0]=4;
        matrix[0][1]=5;
        matrix[0][2]=9;
        matrix[1][0]=3;
        matrix[1][1]=10;
        matrix[1][2]=11;
        matrix = transpose(matrix);
        print(matrix);
    }
    
}
