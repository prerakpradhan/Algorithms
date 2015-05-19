/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Arrays;

import java.util.Random;

/**
 *
 * @author coolp_000
 */
public class quickSort {
    public void swap(int array[], int i , int j)
    {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
        
    }
    
    public int partitionHelper(int[] arr, int left, int right)
    {
        int x = arr[right];
        int i= left;
        for(int j=left; j<=right-1; j++)
        {
           if(arr[j]<=x)
           {
               swap(arr, i,j);
               i++;
           }
        }
        
        swap(arr,i,right);
        return i;
    }
    
    public int parition(int[] arr, int left, int right)
    {
        Random rand = new Random();
        int pivot = rand.nextInt(right-left+1)+left;
        swap(arr, pivot,right);
        return partitionHelper(arr,left,right);       
    }
    
    public void quickSort(int[] arr, int left, int right)
    {
       if(left >= right)
           return;
        int pivot = parition(arr, left, right);
        quickSort(arr,left,pivot-1);
        quickSort(arr,pivot+1, right);
       
    }
    
    public void print(int[] arr)
    {
        for(int num:arr)
        {
            System.out.println(num);
        }
    }
    
    public static void main(String[] args)
    {
        int[] num = {5,3,4,8,45,23,12,63,78,3};
        quickSort q = new quickSort();
        q.quickSort(num, 0, num.length-1);
        q.print(num);
    }
    
    
    
}
