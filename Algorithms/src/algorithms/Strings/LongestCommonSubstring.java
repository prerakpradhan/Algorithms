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
public class LongestCommonSubstring {
    
   public static int getLCS(String X, String Y)
   {
       int Xlength = X.length();
       int Ylength = Y.length();
       int maxLength=0;
       String maxString ="";
       int[][] result = new int[Xlength+1][Ylength+1];
       String[][] resultString = new String[Xlength+1][Ylength+1];
       for(int i=0; i<=Xlength; i++)
       {
           for(int j=0; j<=Ylength; j++)
           {
               if(i==0 || j==0)
               {
                   result[i][j]=0;
                   resultString[i][j]="";
               }
               else if(X.charAt(i-1)==Y.charAt(j-1))
               {
                   result[i][j]=result[i-1][j-1]+1;
                   resultString[i][j]=resultString[i-1][j-1]+String.valueOf(X.charAt(i-1));
                   if(maxLength < result[i][j])
                   {  
                       maxString = resultString[i][j];
                   }
                   maxLength = Math.max(maxLength, result[i][j]);
               }
               else
               {
                   result[i][j]=0;
               }
           }
       }
       System.out.println(maxString);
       return maxLength;        
   }
   
   public static void main(String[] args)
   {
       System.out.println(getLCS("Geek", "PowerGeek"));
   }
    
}
