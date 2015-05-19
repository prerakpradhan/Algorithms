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
public class QuickSelection {
    
    public int kthSmallest(int array[],int  left, int right, int k)
    {
        if( k> 0 && k <= right-left+1)
        {
            int pos = partition(array, left, right);
            if(pos-left == k-1)
            {
                return array[pos];
            }
            else if (pos-left > k-1)
            {
                return kthSmallest(array, left, pos-1, k);
            }
            else
            {
                
              return kthSmallest(array, pos+1, right, k-pos+left-1);  
            }
               
        }
        return Integer.MAX_VALUE;
    }
    
    public void swap(int array[], int i , int j)
    {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
        
    }
    
    public int completePartition(int array[], int left, int right)
    {
        int x = array[right];
        int i = left;
        for(int j = left; j<= right-1;j++)
        {
            if( array[j]<=x)
            {
                swap(array, i, j);
                i++;
            }
        }
        swap(array,i, right);
        return i;
                
    }
    
    public int partition(int array[], int left, int right)
    {
        Random rand = new Random();
        int pivot = rand.nextInt((right - left) + 1) + left;
        swap(array, pivot, right);
        return completePartition(array, left, right);        
        
    }
    
    public static void main(String[] args)
    {
        int[] arr = {10,5,3,12,11};
        QuickSelection m = new QuickSelection();
        System.out.println(m.kthSmallest(arr, 0, arr.length-1, 5));
    }
}
