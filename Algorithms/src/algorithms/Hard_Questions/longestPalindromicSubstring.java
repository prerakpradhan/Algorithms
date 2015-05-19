/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Hard_Questions;

/**
 *
 * @author coolp_000
 */
public class longestPalindromicSubstring {
    
   public static void getPalindrome(String str)
   {
       int length = str.length();
       int start = -1;
       int max = 0;
       boolean[][] memory = new boolean[length][length];
       for(int i=0;i<length;i++)
       {
           for(int j=0; j < length; j++)
           {
               memory[i][j] = false;
           }
           
       }
       for(int i=0; i < length-1; i++)
       {
           if(str.charAt(i)==str.charAt(i+1))
           {
               memory[i][i+1]=true;
               start = i;
               max = 2;
           }
       }
       for(int k = 3; k <= length;k++)
       {
           for(int i=0;i<length-k+1;i++)
           {
               int j=i+k-1;
               if(memory[i+1][j-1] && str.charAt(i)==str.charAt(j))
               {
                   memory[i][j]=true;
                   if(k > max)
                   {
                     max = k;
                     start = i;  
                   }
               }
           }
       }
       System.out.println(max);
       System.out.println(str.substring(start, start+max));
       
   }
   public static void main(String[] args)
   {
       getPalindrome("forgeeksskeegfor");
   }
    
}
