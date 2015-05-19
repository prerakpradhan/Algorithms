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
public class oneNonDuplicate {
    
    public int detect(int[] arr)
    {
        int ans = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            ans= ans^arr[i];
        }
        return ans;
    }
    
    public static void main(String args[])
    {
        int[] arr={1,1,2};
        oneNonDuplicate a = new oneNonDuplicate();
        System.out.println(a.detect(arr));
    }
    
}
