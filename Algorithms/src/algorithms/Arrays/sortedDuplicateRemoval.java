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
public class sortedDuplicateRemoval {
    
    public int[] remove(int[] arr)
    {
        int n = arr.length;
        if(n==1 || n==0)
        {
            return arr;
        }
        int i=0;
        for(int j = 1; j<n ; j++)
        {
            if(arr[i]!=arr[j])
            {
                i++;
                arr[i]=arr[j];   
            }
        }
        for(int m=i+1; m < n; m++)
        {
            arr[m]=-1;
        }
        return arr;
    }
    
    public static void main(String[] args)
    {
        int[] arr = {3,3,3,4,4,5,6,7};
        sortedDuplicateRemoval m = new sortedDuplicateRemoval();
        arr = m.remove(arr);
        for(int i: arr)
        {
            System.out.println(i);
        }
    }
    
}
