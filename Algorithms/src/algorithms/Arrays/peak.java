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
public class peak {
    
    public static int getPeak(int[] array, int start, int end)
    {
        int middle = start+(end-start)/2;
        if((middle == 0 && array[middle] > array[middle+1])||
           (middle==array.length-1 && array[middle] > array[middle-1])||
            (array[middle]>array[middle+1] && array[middle]>array[middle-1]))
        {
            return array[middle];
        }
        if(middle > 0 && array[middle]<array[middle-1])
        {
            return getPeak(array,start,middle-1);
        }
        else
            return getPeak(array,middle+1,start);
    }
    
    public static void main(String[] args)
    {
        int[] arr =  {5, 10, 20, 15};
        System.out.println(getPeak(arr, 0, arr.length-1));
    }
    
}
