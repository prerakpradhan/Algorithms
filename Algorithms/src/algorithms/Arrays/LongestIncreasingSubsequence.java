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
public class LongestIncreasingSubsequence {
    
    public int LIS(int[] arr)
    {
        int[] lis = new int[arr.length];
        String[] stringLIS = new String[arr.length];
        for(int i=0; i < arr.length; i++)
        {
            lis[i]= 1;
            stringLIS[i] = Integer.toString(arr[i]);
        }
        for(int i=1;i<arr.length;i++)
        {
            for(int j=0; j <i; j++)
            {
                if((arr[i] > arr[j])&&(lis[i] < lis[j]+1))
                {
                    lis[i] = lis[j]+1;
                    stringLIS[i]=stringLIS[j]+"-->"+Integer.toString(arr[i]);
                }
            }
        }
        int max=0;
        int maxIndex=0;
        for(int i = 0; i < arr.length; i++)
        {
            if(lis[i] > max)
            {
                max = lis[i];
                maxIndex = i;
            }
        }
        System.out.println(stringLIS[maxIndex]);
        return max;
    }
    
    
    
    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        LongestIncreasingSubsequence m  = new LongestIncreasingSubsequence();
        System.out.println(m.LIS(arr));
    }
    
}
