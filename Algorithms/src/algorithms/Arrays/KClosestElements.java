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
public class KClosestElements {
    
    public static int CrossOver(int[] array, int start, int end,int k)
    {
        if(k > array[end])
        {
            return end;
        }
        if(k < array[start] )
        {
            return start;
        }
        int middle = start + (end-start)/2;
        if(array[middle]<=k && array[middle+1]>k)
        {
            return middle;
        }
        if(array[middle] < k)
        {
            return CrossOver(array, middle+1, end, k);
        }
        
        else
        {
            return CrossOver(array, start, middle-1, k);
        }
  
    }
    
    public static void KClosest(int[] array, int k, int n)
    {
        int crossOver = CrossOver(array, 0, array.length-1, n);
        int left = crossOver-1;
        int right = crossOver +1;
        System.out.println(array[crossOver]);
        int count =1;
        while(left >=0 && right <= array.length-1 && count <= k)
        {
            int leftDiff = n-array[left];
            int rightDiff = array[right]-n;
            if(rightDiff >= leftDiff)
            {
                System.out.println(array[left]);
                left--;
            }
            else
            {
                System.out.println(array[right]);
                right++;
            }
            count++;
        }
        while(left >=0 && count <=k)
        {
            System.out.println(array[left]);
            left--;
            count++;
        }
        while(right <= array.length-1 && count <= k)
        {
            System.out.println(array[right]);
            right++;
            count++;
        }
    }
    
    public static void main(String[] args)
    {
        int [] arr = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        KClosest(arr, 5, 16);
    }
    
}
