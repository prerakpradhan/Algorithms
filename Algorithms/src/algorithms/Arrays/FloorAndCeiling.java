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

//Given a sorted array and a value x, the ceiling of x is the smallest element 
//in array greater than or equal to x, and the floor is the greatest
//element smaller than or equal to x. Assume than the array is sorted
//in non-decreasing order. Write efficient functions to find floor 
//and ceiling of x.
public class FloorAndCeiling {
    
    public static int ceil(int[] array, int start, int end, int k)
    {
        if(k > array[end])
        {
            return -1;
        }
        if(k <= array[start])
        {
            return array[start];
        }
        int middle = start + (end-start)/2;
        if(array[middle] > k)
        {
            if(middle-1 >=start && array[middle-1]<k )
            {
                return array[middle];
            }
            else
            {
                return ceil(array,start,middle-1,k);
            }
        }
        else
        {
            if(middle+1 <= end && array[middle+1] > k)
            {
                return array[middle+1];
            }
            else
            {
                return ceil(array,middle+1, end,k);
            }
        }
    }
    
    public static int floor(int[] array, int start, int end, int k)
    {
        if( k < array[start])
        {
            return -1;
        }
        if(k >= array[end])
        {
            return array[end];
        }
        int middle = start + (end-start)/2;
        if (array[middle] == k)
        {
            return array[middle];
        }
        if(array[middle] > k)
        {
            if(middle-1 >= start && array[middle-1] < k)
            {
                return array[middle-1];
            }
            else
            {
                return floor(array,start,middle-1,k);
            }
        }
        else
        {
            if(middle+1 <= end && array[middle +1] > k)
            {
                return array[middle];
            }
            else
            {
                return floor(array,middle+1,end,k);
            }
        }
    }
    
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        System.out.println(floor(arr, 0, arr.length-1, 5));
        System.out.println(ceil(arr,0,arr.length-1,5));
    }
    
    
    
}
