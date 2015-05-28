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
public class mnmerge {
    
    public static int[] shift(int[] array)
    {
        int length = array.length-1;
        int i=length;
        int j = length;
        while(i >= 0)
        {
            if(array[i] !=-1)
            {
                array[j] = array[i];
                j--;
            }
            i--;
        }
        return array;
    }
    
    public static void print(int[] array)
    {
        for(int i: array)
        {
            System.out.println(i);
        }
    }
    
    public static int[] merge(int[] array1, int[] array2)
    {
        int length1 = array1.length;
        int length2 = array2.length;
        int i=0;
        int start= 0;
        array2 = shift(array2);
        //print(array2);
        int j = length1;
        //System.out.println(array2[j]);
        while(i < length1)
        {
            //System.out.println(i);
            //System.out.println(j);
            if(j<length2 &&array1[i]>array2[j])
            {
                array2[start]=array2[j];
                array2[j]=-1;
                j++;
                start++;
            }
            else
            {
                array2[start] = array1[i];
                start++;
                i++;
            }
        }
        return array2;
            
    }
    
    public static void main(String[] args)
    {
        int[] arr1 ={1,3,5,8};
        int[] arr2 = {-1,2,-1,4,-1,-1,6,7};
        arr2 = merge(arr1,arr2);
        print(arr2);
        
        
    }
}
