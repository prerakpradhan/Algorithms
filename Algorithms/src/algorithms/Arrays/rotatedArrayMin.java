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
public class rotatedArrayMin {
    
    public static int findMin(int[] array, int front, int back)
    {
        if(front> back)
        {
            return array[0];
        }
        if (front==back)
        {
            return array[front];
        }
        int middle = front + ((back- front)/2);
        if((middle < back) && (array[middle] > array[middle+1]))
        {
            return array[middle+1];
        }
        if((middle > front) && (array[middle] < array[middle-1]))
        {
            return array[middle];
        }
        if(array[back] > array[middle])
        {
            return findMin(array, front, middle-1);
        }
        return findMin(array, middle+1, back);
    }
    
    public static void main(String[] args)
    {
        int[] arr = {2,3,5,7,1,2};
        System.out.println(findMin(arr, 0, arr.length-1));
    }
    
    
}
