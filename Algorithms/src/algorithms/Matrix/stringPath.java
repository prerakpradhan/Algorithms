/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Matrix;

import java.util.HashMap;

/**
 *
 * @author coolp_000
 */
public class stringPath {
    public static boolean findPath(char[][] matrix, String chars)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j =0; j <matrix[0].length; j++)
            {
                if(matrix[i][j]==chars.charAt(0))
                {
                    HashMap<String,String> seen = new HashMap<>();
                    String key = Integer.toString(i)+","+Integer.toString(j);
                    seen.put(key, key);
                    String remainingString = chars.substring(1);
                    boolean result= findRest(matrix, remainingString, seen, i-1, j) ||
                            findRest(matrix, remainingString, seen, i+1, j) ||
                            findRest(matrix, remainingString, seen, i, j-1) ||
                            findRest(matrix, remainingString, seen, i, j+1);
                    if(result)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
    
    public static boolean findRest(char[][] matrix, String chars, HashMap<String,String> seen,int i, int j)
    {
        if(i >= matrix.length || j >=matrix[0].length || i < 0 || j < 0)
        {
            return false;
        }
        if(matrix[i][j] != chars.charAt(0))
        {
            return false;
        }
        String key = Integer.toString(i)+","+Integer.toString(j);
        if(seen.containsKey(key))
        {
            return false;
        }
        if(matrix[i][j]== chars.charAt(0) && chars.length() == 1)
        {
            return true;
        }
        else
        {
            seen.put(key, key);
            String remainingString = chars.substring(1);
            return findRest(matrix, remainingString, seen, i-1, j) ||
                            findRest(matrix, remainingString, seen, i+1, j) ||
                            findRest(matrix, remainingString, seen, i, j-1) ||
                            findRest(matrix, remainingString, seen, i, j+1);
            
        }
    }
    
    public static void main(String[] args)
    {
        char[][] mat = { { 'p', 'u', 'n', 'e' }, { 'd', 'i', 'k', 's' } };
        String test = "pdip";
        System.out.println(findPath(mat, test));
    }
}
