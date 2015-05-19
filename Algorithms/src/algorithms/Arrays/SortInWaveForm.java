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
public class SortInWaveForm {
    
    public static int[] swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
        return array;
    }
    
    public static int[] waveSort(int[] array)
    {
        for(int i=0; i < array.length; i=i+2)
        {
            if(i>0 && array[i-1]>array[i])
            {
                swap(array,i-1,i);
            }
            if(i <array.length -1 && array[i] <array[i+1])
            {
                swap(array,i,i+1);
            }
        }
        return array;
    }
    
    public static void main(String[] args)
    {
        int[] array ={20, 10, 8, 6, 4, 2};
        int[] array2 ={2, 4, 6, 8, 10, 20};
        array = waveSort(array);
        array2 = waveSort(array2);
        for(int i : array)
        {
            System.out.println(i);
        }
        System.out.println("---");
        for(int i : array2)
        {
            System.out.println(i);
        }
    }
}
