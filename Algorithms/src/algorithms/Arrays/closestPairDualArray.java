/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Arrays;

import java.util.HashMap;

/**
 *
 * @author coolp_000
 */

//Given two sorted arrays and a number x, find the pair whose sum 
//is closest to x and the pair has an element from each array.
public class closestPairDualArray {
    
    public static int[] merge(int[] array1, int[] array2)
    {
        int i=0;
        int j=0;
        int[] new_array = new int[array1.length+array2.length];
        int count = 0;
        while(i<array1.length && j <array2.length)
        {
            if(array1[i]>array2[j])
            {
                new_array[count++]=array2[j++];
            }
            else
            {
                 new_array[count++]=array1[i++];
            }
        }
        
        while(i<array1.length)
        {
            new_array[count++]=array1[i++];
        }
        while(j<array2.length)
        {
            new_array[count++]=array2[j++];
        }
        return new_array;
    }
    
    public static void findClosest(int[] array, HashMap<Integer, Integer> h1, HashMap<Integer, Integer> h2,int k)
    {
        int i=0;
        int j = array.length-1;
        int min = Integer.MAX_VALUE;
        int resulti=0;
        int resultj=0;
        while(i<j)
        {
            int diff = Math.abs(k-(array[i]+array[j]));
            if(diff < min)
            {
                if(h1.containsKey(array[i]) && h2.containsKey(array[j]))
                {
                    min = diff;
                    resulti=i;
                    resultj=j;
                }
                
            }
            if(array[i] + array[j] <  k)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        System.out.println(array[resulti]);
        System.out.println(array[resultj]);
        
    }
    public static void printClosestPair(int[] array1, int[] array2, int k)
    {
        HashMap<Integer, Integer> h1 = new HashMap<>();
        HashMap<Integer, Integer> h2 = new HashMap<>();
        for(int o:array1)
        {
            h1.put(o, o);
        }
        for(int p: array2)
        {
            h2.put(p,p);
        }
        int[] new_array = merge(array1,array2);
        findClosest(new_array,h1,h2,k);  
    }
    
    public static void main(String[] args)
    {
        int[] ar1 = {1, 4, 5, 7};
        int[] ar2 = {10, 20, 30, 40};
        printClosestPair(ar1, ar2, 40);
    }
               
}
