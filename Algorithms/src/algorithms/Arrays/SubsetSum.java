/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Arrays;

/**
 *
 * @author coolp_000
 */
public class SubsetSum {
    
    public static boolean isSubsetSum(int[] array,int sum)
    {
        int n = array.length-1;
        boolean[][] subset = new boolean[sum+1][n+1];
        for(int i=0; i<=n;i++)
        {
            subset[0][i]=true;
        }
        for(int i=1;i<=sum;i++)
        {
            subset[i][0]=false;
        }
        
        for(int i=1;i<=sum; i++)
        {
            for(int j=1;j<=n;j++)
            {
                subset[i][j]=subset[i][j-1];
                if (i >= array[j-1])
                {
                    subset[i][j] = subset[i][j] || subset[i - array[j-1]][j-1];
                }
                    
            }
        }
  
        return subset[sum][n];
    }
    
    public static boolean subSetSum(int[] arr, int key, int start)
    {
        if(key == 0)
        {
            return true;
        }
        if(start > arr.length-1)
        {
            return false;
        }
        if(key >= arr[start] && subSetSum(arr,key-arr[start], start+1))
        {
            System.out.println(arr[start]);
            return true;
        }
        return subSetSum(arr, key, start+1);
            
    }
    
    public static void main(String[] args)
    {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 8;
        System.out.println(isSubsetSum(set, sum));
        subSetSum(set, sum, 0);
    }
}
