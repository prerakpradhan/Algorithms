/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Strings;

/**
 *
 * @author coolp_000
 */
public class LongestCommonSubsequence {
    
    public int getLCS(String X, String Y)
    {
        
        int Xlength = X.length();
        int Ylength = Y.length();
        int[][] result = new int[Xlength+1][Ylength+1];
        for(int i=0; i <= Xlength; i++)
        {
            for(int j =0; j <= Ylength; j++)
            {
                if(i==0 || j ==0 )
                {
                    result[i][j]=0;
                }
                else if(X.charAt(i-1)==Y.charAt(j-1))
                {
                    result[i][j] = result[i-1][j-1]+1;
                }
                else
                {
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
                }
            }
        }
        return result[Xlength][Ylength];
    }
    
    public static void main(String[] args)
    {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String x = "ABCDGH";
        String y = "AEDFHR";
        System.out.println(lcs.getLCS(x, y));
    }
    
}
