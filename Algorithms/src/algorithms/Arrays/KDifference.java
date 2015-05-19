/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.Arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author coolp_000
 */
public class KDifference {
    
    public int KDiffHash(int[] arr, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < arr.length;i++)
        {
            map.put(arr[i], i);
        }
        int count=0;
        for(int i=0; i < arr.length;i++)
        {
            if(map.containsKey(arr[i]+k))
            {
                count++;
                
            }
            
        }
        return count;
    }
    
    public int KDiffSort(int[] arr, int k)
    {
        Arrays.sort(arr);
        int length = arr.length;
        int left = 0;
        int right =0;
        int count=0;
        
        while(right < length)
        {
            int temp = arr[right]-arr[left];
            //System.out.println(temp);
            if(temp==k)
            {
                count++;
                left++;
                right++;
            }
            else if(temp > k)
            {
                left++;
            }
            else
            {
                right++;
            }
        }
        return count;
    }
    
    public static void main(String[] args)
    {
        KDifference m = new KDifference();
        int[] arr ={8, 12, 16, 4, 0, 20};
        //System.out.println(m.KDiffHash(arr, 4));
        System.out.println(m.KDiffSort(arr, 4));
    }
    
}
