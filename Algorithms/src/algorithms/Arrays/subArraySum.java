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
public class subArraySum {
    
    public boolean checkSum(int[] arr, int sum)
    {
        int currPointer = 0;
        int currSum=arr[currPointer];
        int n = arr.length;
        
        for(int i=1; i <=n; i++)
        {          
            if (currSum > sum)
            {
                while(currSum > sum && currPointer < i)
                {
                    currSum=currSum-arr[currPointer];
                    currPointer++;
                }
                
            }
            if(currSum == sum)
            {
                System.out.println(currPointer);
                System.out.println(i-1);
                return true;
            }
            if(i<n)
            {
                currSum=currSum + arr[i];
            }
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        int arr[] = {15, 2,4, 4, 8, 9, 5, 10, 23};
        subArraySum m = new subArraySum();
        System.out.println(m.checkSum(arr, 17));
    }
    
}
