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
public class LargestSubArray {
    
    public void Largest01SubArray(int[] arr)
    {
        int beginIndex = 0;
        int endIndex =0;
        int maxSize=0;
        int n = arr.length;
        for(int i=0; i< n;i++)
        {
            int temp = arr[i];
            if(arr[i]==0)
            {
                temp=-1;
            }
            for (int j=i+1;j<n;j++)
            {
                if(arr[j]==0)
                {
                    temp=temp-1;
                }
                else
                {
                    temp=temp+1;
                }
                if(temp==0)
                {
                    int tempsize=j-i+1;
                    if(tempsize > maxSize)
                    {
                        maxSize = tempsize;
                        beginIndex = i;
                        endIndex =j;
                    }
                }
            }
        }
        System.out.println(beginIndex + "-->"+ endIndex+":"+maxSize);
    }
    
    public static void main(String args[])
    {
        int[] arr = {1, 0, 1, 1, 1, 0, 0,0,1};
        LargestSubArray m = new LargestSubArray();
        m.Largest01SubArray(arr);
    }
    
}
