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
public class intersectionOfThree {
    
    public static void printIntersection(int[] array1, int[] array2, int[] array3)
    {
        int i=0;
        int j=0;
        int k=0;
        while(i<array1.length && j <array2.length &&  k < array3.length)
        {
            if((array1[i] == array2[j]) &&(array2[j]==array3[k]))
            {      
                    System.out.println(array1[i]);
                    i++;
                    j++;
                    k++;
            }
            else
            {
                if((array1[i]<array2[j]) || array1[i] <array3[k])
                {
                    i++;
                }
                if((array2[j]<array1[i]) || array2[j] <array3[k])
                {
                    j++;
                }
                if((array3[k]<array2[j]) || array3[k] <array1[i])
                {
                    k++;
                }
            }
            
        }
    }
    
    public static void main(String[] args)
    {
        int[] ar1 = {1, 5, 10, 20, 40, 80};
        int[] ar2 = {6, 7, 20, 80, 100};
        int[] ar3 = {3, 4, 15, 20, 30, 70, 80, 120};
        printIntersection(ar1,ar2,ar3);
    }
    
}
