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
public class FixedPoint {
    
//    Given an array of n distinct integers sorted in ascending order, 
//    write a function that returns a Fixed Point in the array, if there 
//    is any Fixed Point present in array, else returns -1. Fixed Point in 
//    an array is an index i such that arr[i] is equal to i. 
//    Note that integers in array can be negative.
//    
    public static int getFixedPoint(int[] array, int start, int end)
    {
        if(end >= start)
        {
            int middle = start + (end-start)/2;
            if(middle==array[middle])
            {
                return middle;
            }
            else if(middle > array[middle])
            {
                return getFixedPoint(array, middle+1, end);
            }
            else
            {
                return getFixedPoint(array, start, middle-1);
            }
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        int[] arr = {-1,-2,1,3};
        System.out.println(getFixedPoint(arr, 0, arr.length-1));
    }
    
}
