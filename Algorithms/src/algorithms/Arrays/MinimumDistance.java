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
public class MinimumDistance {
    
    public int minDist(int arr[], int n1, int n2)
    {
        int length = arr.length;
        int firstIndex = length;
        int secondIndex = length;
        int distance = length;
        for(int i=0; i < length; i++)
        {
            if(arr[i]==n1)
            {
                firstIndex = i;
            }
            if(arr[i]==n2)
            {
                secondIndex=i;
            }
            int diff = Math.abs(firstIndex-secondIndex);
            if(firstIndex < length && secondIndex < length && diff<distance)
            {
                distance = diff;
            }
        }
        return distance == length ? -1 :distance;
    }
    
    public static void main(String[] args)
    {
        int[] arr = {1, 5, 3, 7, 2, 8, 3, 4, 5, 9, 9, 3, 1, 3, 2, 9};
        MinimumDistance m = new MinimumDistance();
        System.out.println(m.minDist(arr, 4, 7));
                
    }
    
}
