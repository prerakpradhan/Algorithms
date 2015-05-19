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
public class LargestSubArraySum {
    
    public static void findMaxSum(int[] array)
    {
        int beginIndex =-1;
        int endIndex =-1;
        int maxEndingHere = 0;
        int maxSoFar=0;
        int count=0;
        int beginCounter =0;
        for (int i  : array)
        {
            maxEndingHere = maxEndingHere + i;
            if(maxEndingHere < 0)
            {
                maxEndingHere=0;
                beginCounter =0;
                
            }
            else
            {
                beginCounter++;
            }
            if (maxSoFar < maxEndingHere)
            {
                maxSoFar=maxEndingHere;
                endIndex=count;
                beginIndex=endIndex-beginCounter+1;
            }
            count++;
        }
        System.out.println("beginning index: " + beginIndex + "--" + "ending Index: "+ endIndex + " sum:"+maxSoFar );
    }
    
    public static void main(String[] args)
    {
        int[] arr= {1,100,-3,-1,4,9,5,-10,2};
        findMaxSum(arr);
    }
    
}
