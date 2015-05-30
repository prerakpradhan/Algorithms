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
public class minimumNumberOfPalindromes {
    
     public static boolean[][] getPalindromicArray(String str)
   {
       int length = str.length();
       int start = -1;
       int max = 0;
       boolean[][] memory = new boolean[length][length];
       for (int i = 0; i < length; ++i)
       {
          memory[i][i] = true; 
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
       return memory;
   }
    public static int getMinRemaining(boolean[][] memory, int i, int j)
    {
        int min = j-i+1;
        if(i< 0 || j < 0 || i > memory.length-1 || j > memory.length-1)
        {
            return 0;
        }
        if((i==0 && j==0) || (i ==memory.length-1 && j==memory.length-1))
        {
            return 1;
        }
        for(int m =i; m <=j; m++)
        {
            for(int n =i; n <=j; n++)
            {
                if(memory[m][n] == true)
                {
                    int temp = 1 + getMinRemaining(memory, i ,m-1) + getMinRemaining(memory,n+1,j);
                    if(temp < min)
                    {
                        min = temp;
                    }
                }
            }
        }
        
        return min;
    }
            
            
    public static int getMinNumber(String str)
    {
        boolean[][] memory = getPalindromicArray(str);
        int min = str.length();
        for(int i = 0; i < str.length(); i++)
        {
            for(int j =0; j < str.length(); j++)
            {
                if(memory[i][j] == true)
                {
                    int temp = 1 + getMinRemaining(memory, 0 ,i-1) + getMinRemaining(memory,j+1,str.length()-1);
                    if(temp < min)
                    {
                        min = temp;
                    }
                }
            }
        }
        return min;
    }
    
    public static void main(String[] args)
    {
        System.out.println(getMinNumber("dsosdeed"));
    }
    
}
