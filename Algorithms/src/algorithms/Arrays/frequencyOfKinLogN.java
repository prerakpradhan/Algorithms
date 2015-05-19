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
public class frequencyOfKinLogN {
    
    public static int count(int[] array, int k)
    {
        int first = firstOcc(array, 0, array.length-1, k);
        if(first == -1)
        {
            return -1;
        }
        int second = lastOcc(array,first+1,array.length-1,k);
        return second-first+1;
    }
    
    public static int firstOcc(int[] array, int start, int end, int k)
    {
        if(end >= start)
        {
            int middle = start + (end-start)/2;
            if((middle == 0 || k  > array[middle-1] ) && array[middle]==k)
            {
                return middle;
            }
            else if (k > array[middle])
            {
                return firstOcc(array,middle+1,end,k);
            }
            else
            {
                return firstOcc(array,start, middle-1,k);
            }
            
        }
        return -1;
    }
    
    public static int lastOcc(int[] array, int start, int end, int k)
    {
        if(end >= start)
        {
            int middle = start + (end-start)/2;
            if((middle == array.length-1 || k  < array[middle+1] ) && array[middle]==k)
            {
                return middle;
            }
            else if (k < array[middle])
            {
              return lastOcc(array,start,middle-1,k);  
            }
            else
                return lastOcc(array,middle+1,end,k);
            
        }
        return -1;
    }
    
    public static int noOfOccurencesNotLogN(int[] array, int start, int end , int k)
    {
        if(start == end)
        {
           if(array[start] == k)
               return 1;
        }
        else if(end > start)
        {
            int count = 0;
            int middle =((end-start)/2)+start;
            if(array[middle] == k)
            {
                count++;
                count = count + noOfOccurencesNotLogN(array, middle+1, end, k);
                count = count + noOfOccurencesNotLogN(array, start, middle-1, k);
            }
            else if(array[middle]< k)
            {
                count = count + noOfOccurencesNotLogN(array, middle+1, end, k);
            }
            else
            {
                count = count + noOfOccurencesNotLogN(array, start, middle-1, k);
            }
            return count;         
        }
        return 0;
        
    }
    
   public static void main(String[] args)
   {
       int[] arr = {1,2,2,2,2,2,2};
       System.out.println(noOfOccurencesNotLogN(arr, 0, arr.length-1, 2));
       System.out.println(count(arr,2));
   }
    
}
